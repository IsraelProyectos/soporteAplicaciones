package cat.israel.spring.servicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import cat.israel.spring.model.CriticosCotiz;
import cat.israel.spring.model.CriticosFundamenta;

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
						mapaDescriptores.get(key).add(cf.getCddescriptor());
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
					bw.write(" -" + filaDescriptor + ";");
				}
			} else {
				bw.write("Fundamenta:;");
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
						mapaDescriptores.get(key).add(cc.getCddescriptor());
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
				bw.write("Buenos días, aquí los descriptores que no han cargado para el día " + fechaHoyFormateada
						+ ":;");
				bw.write("Cotiz:;");
				for (String filaDescriptor : datosTXT) {
					bw.write(" -" + filaDescriptor + ";");
				}
			} else {
				bw.write("Buenos días, aquí los descriptores que no han cargado para el día " + fechaHoyFormateada
						+ ":;");
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
		
		String[] cotiz = null;
		String[] funda = null;
		String txtCotiz = null;
		String txtFunda = null;
		File filesCotiz;
		File filesFunda;
		try {
			filesCotiz = new ClassPathResource("static/txt_criticos/criticos_cotiz.txt").getFile();
			filesFunda = new ClassPathResource("static/txt_criticos/criticos_funda.txt").getFile();
			txtCotiz = new String(Files.readAllBytes(filesCotiz.toPath()));
			txtFunda = new String(Files.readAllBytes(filesFunda.toPath()));
			cotiz = txtCotiz.split(";");
			funda = txtFunda.split(";");
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

	public void reiniciarTXT() throws IOException {

		File fileFunda;
		File fileCotiz;
		LocalDate fechaHoy = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaHoyFormateada = fechaHoy.format(formatter);

		fileCotiz = new ClassPathResource("static/txt_criticos/criticos_cotiz.txt").getFile();
		FileWriter fwCotiz = new FileWriter(fileCotiz);
		BufferedWriter bwCotiz = new BufferedWriter(fwCotiz);
		bwCotiz.write("Buenos días, aquí los descriptores que no han cargado para el día " + fechaHoyFormateada
				+ ":;");
		bwCotiz.write("Cotiz:;");
		bwCotiz.write("No se ha ejecutado ninguna búsqueda aún");
		bwCotiz.close();
		
		fileFunda = new ClassPathResource("static/txt_criticos/criticos_funda.txt").getFile();
		FileWriter fwFunda = new FileWriter(fileFunda);
		BufferedWriter bwFunda = new BufferedWriter(fwFunda);
		
		
		bwFunda.write("Fundamenta:;");
		bwFunda.write("No se ha ejecutado ninguna búsqueda aún");
		bwFunda.close();


	}
}
