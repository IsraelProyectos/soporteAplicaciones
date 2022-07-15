package cat.israel.spring.servicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import cat.israel.spring.model.CriticosCotiz;
import cat.israel.spring.model.CriticosFundamenta;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class LlenarTXT {

	public void llenarTXTfunda(List<CriticosFundamenta> criticosFunda) {
		File file;
		try {

			file = new ClassPathResource("static/txt_criticos/criticos_funda.txt").getFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (!criticosFunda.isEmpty()) {
				Map<String, List<Integer>> mapaDescriptores = new HashMap<>();
				List<Integer> descriptores = new ArrayList<Integer>();
				for (CriticosFundamenta cf : criticosFunda) {
					DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy"); 
					String fechaFormateada = fecha.format(cf.getFechaInicio()); 
					String key = cf.getNomOrigen() + ";" + fechaFormateada + ";" + cf.getNomPais();
					if (mapaDescriptores.containsKey(key)) {
						descriptores.add(cf.getCddescriptor());
					} else {
						descriptores = new ArrayList<>();
						descriptores.add(cf.getCddescriptor());
						mapaDescriptores.put(key, descriptores);
					}
				}

				List<String> datosTXT = new ArrayList<String>();
				for (Map.Entry<String, List<Integer>> entry : mapaDescriptores.entrySet()) {
					String key = entry.getKey();
					List<Integer> val = entry.getValue();
					String des = String.valueOf(val);
					des = des.substring(1, des.length() - 1);
					String[] valoresKey = key.split(";");
					datosTXT.add("De " + valoresKey[0] + " de " + valoresKey[2] + ", no han publicado nada desde el "
							+ valoresKey[1] + " los siguientes descriptores: " + des);

				}
				bw.write("Fundamenta:;");
				for (String filaDescriptor : datosTXT) {
					bw.write(" -"+filaDescriptor + ";");
				}
			} else {
				bw.write("Todo OK");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void llenarTXTcotiz(List<CriticosCotiz> criticosCotiz) {

		File file;
		try {

			LocalDate fechaHoy = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String fechaHoyFormateada = fechaHoy.format(formatter);
			
			file = new ClassPathResource("static/txt_criticos/criticos_cotiz.txt").getFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if (!criticosCotiz.isEmpty()) {
				Map<String, List<Integer>> mapaDescriptores = new HashMap<>();
				List<Integer> descriptores = new ArrayList<Integer>();
				for (CriticosCotiz cc : criticosCotiz) {
					DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy"); 
					String fechaFormateada = fecha.format(cc.getFechaInicio());
					String key = cc.getNomOrigen() + ";" + fechaFormateada + ";" + cc.getNomPais();
					if (mapaDescriptores.containsKey(key)) {
						descriptores.add(cc.getCddescriptor());
					} else {
						descriptores = new ArrayList<>();
						descriptores.add(cc.getCddescriptor());
						mapaDescriptores.put(key, descriptores);
					}
				}

				List<String> datosTXT = new ArrayList<String>();
				for (Map.Entry<String, List<Integer>> entry : mapaDescriptores.entrySet()) {
					String key = entry.getKey();
					List<Integer> val = entry.getValue();
					String des = String.valueOf(val);
					des = des.substring(1, des.length() - 1);
					String[] valoresKey = key.split(";");
					datosTXT.add("De " + valoresKey[0] + " de " + valoresKey[2] + ", no han publicado nada desde el "
							+ valoresKey[1] + " los siguientes descriptores: " + des);

				}
				bw.write("Buenos días, aquí los descriptores que no han cargado para el día "+fechaHoyFormateada+":;");
				bw.write("Cotiz:;");
				for (String filaDescriptor : datosTXT) {
					bw.write(" -"+filaDescriptor + ";");
				}
			} else {
				bw.write("Buenos días, aquí los descriptores que no han cargado para el día "+fechaHoyFormateada+":;");
				bw.write("Cotiz:;");
				bw.write("Todo OK");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> mostrarTXT() {
		
		File filesCotiz;
		File filesFunda;
		try {
			filesCotiz = new ClassPathResource("static/txt_criticos/criticos_cotiz.txt").getFile();
			filesFunda = new ClassPathResource("static/txt_criticos/criticos_funda.txt").getFile();
			String txtCotiz = new String(Files.readAllBytes(filesCotiz.toPath()));
			String txtFunda = new String(Files.readAllBytes(filesFunda.toPath()));
			String [] cotiz = txtCotiz.split(";");
			String [] funda = txtFunda.split(";");
			List<String> txtFinal = new ArrayList<>();
			for (String fraseCotiz : cotiz) {
				txtFinal.add(fraseCotiz);	
			}
			
			for (String fraseFunda : funda) {
				txtFinal.add(fraseFunda);	
			}
			return txtFinal;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
