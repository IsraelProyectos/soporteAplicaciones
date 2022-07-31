package cat.israel.spring.servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import cat.israel.spring.configuracion.ConfiguradorPropiedades;

@Service
public class AgregarBorrarDescriptor {

	public String guardar (String descriptor, String diaCarga, ConfiguradorPropiedades cp) throws StreamReadException, DatabindException, IOException {
		String mensaje = null;
		Boolean existeDescriptor = false;
		String antiguosDescriptores = "";
		String nuevosDescriptores = "";
		Properties p = new Properties();
		p.load(new FileReader("C://Users/israe/Desktop/descriptores.properties"));
		
		switch (diaCarga) {
		case "Cotiz D+1 Diarios":
			antiguosDescriptores = p.getProperty("COTIZ_D_MAS_1_DIARIOS");
			String [] des_D1_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_D1_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				p.setProperty("COTIZ_D_MAS_1_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a fundamenta d-2");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido1 = cp.getCOTIZ_D_MAS_1_DIARIOS();
				descriptoresConAnadido1.add(Integer.parseInt(descriptor));
				cp.setCOTIZ_D_MAS_1_DIARIOS(descriptoresConAnadido1);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Cotiz D-2 Diarios":
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_2_DIARIOS");
			String [] des_D_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_D_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				p.setProperty("COTIZ_D_MENOS_2_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a cotiz D-2 diarios");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido2 = cp.getCOTIZ_D_MENOS_2_DIARIOS();
				descriptoresConAnadido2.add(Integer.parseInt(descriptor));
				cp.setCOTIZ_D_MENOS_2_DIARIOS(descriptoresConAnadido2);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Fundamenta D-2":
			antiguosDescriptores = p.getProperty("FUNDAMENTA_D_2");
			String [] fundaD2 = antiguosDescriptores.split(",");
			
			for (String d : fundaD2) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				System.out.println(nuevosDescriptores);
				p.setProperty("FUNDAMENTA_D_2", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a fundamenta d-2");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido3 = cp.getFUNDAMENTA_D_2();
				descriptoresConAnadido3.add(Integer.parseInt(descriptor));
				cp.setFUNDAMENTA_D_2(descriptoresConAnadido3);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Cotiz D-1 Diarios":
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_1_DIARIOS");
			String [] cotD1D = antiguosDescriptores.split(",");
			
			for (String d : cotD1D) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				System.out.println(nuevosDescriptores);
				p.setProperty("COTIZ_D_MENOS_1_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a cotiz D-1 diarios");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido4 = cp.getCOTIZ_D_MENOS_1_DIARIOS();
				descriptoresConAnadido4.add(Integer.parseInt(descriptor));
				cp.setCOTIZ_D_MENOS_1_DIARIOS(descriptoresConAnadido4);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Fundamenta D-1":
			antiguosDescriptores = p.getProperty("FUNDAMENTA_D_1");
			String [] fundaD1 = antiguosDescriptores.split(",");
			
			for (String d : fundaD1) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				System.out.println(nuevosDescriptores);
				p.setProperty("FUNDAMENTA_D_1", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a fundamenta D-1");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido5 = cp.getFUNDAMENTA_D_1();
				descriptoresConAnadido5.add(Integer.parseInt(descriptor));
				cp.setFUNDAMENTA_D_1(descriptoresConAnadido5);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Cotiz D-1 Laborables":
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_1_LABORABLES");
			String [] cotizD1L = antiguosDescriptores.split(",");
			
			for (String d : cotizD1L) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				System.out.println(nuevosDescriptores);
				p.setProperty("COTIZ_D_MENOS_1_LABORABLES", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a cotiz D-1 laborables");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido6 = cp.getCOTIZ_D_MENOS_1_LABORABLES();
				descriptoresConAnadido6.add(Integer.parseInt(descriptor));
				cp.setCOTIZ_D_MENOS_1_LABORABLES(descriptoresConAnadido6);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		case "Cotiz mensual":
			antiguosDescriptores = p.getProperty("COTIZ_MENSUAL");
			String [] cotizMensual = antiguosDescriptores.split(",");
			
			for (String d : cotizMensual) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (!existeDescriptor) {
				nuevosDescriptores = antiguosDescriptores+","+descriptor;
				System.out.println(nuevosDescriptores);
				p.setProperty("COTIZ_MENSUAL", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Añadido el descriptor "+descriptor+" a cotiz mensual");
				
				//Añadimos el descriptor tambien a la clase para poder sacarlo en caliente
				List<Integer> descriptoresConAnadido7 = cp.getCOTIZ_MENSUAL();
				descriptoresConAnadido7.add(Integer.parseInt(descriptor));
				cp.setCOTIZ_MENSUAL(descriptoresConAnadido7);
				mensaje = "Descriptor introducido correctamente;green";
			}else {
				mensaje = "El descriptor ya existe para ese periodo;red";
			}
			
			break;
		default:
			mensaje = "Error de conexion o no existe esos periodos;red";
			break;
		}

		return mensaje;
	}
	
	public String borrar (String descriptor, String diaCarga, ConfiguradorPropiedades cp) throws FileNotFoundException, IOException {
		String mensaje = null;
		Boolean existeDescriptor = false;
		String antiguosDescriptores = "";
		String nuevosDescriptores = "";
		Properties p = new Properties();
		p.load(new FileReader("C://Users/israe/Desktop/descriptores.properties"));
		
		switch (diaCarga) {
		case "Cotiz D+1 Diarios":
			antiguosDescriptores = p.getProperty("COTIZ_D_MAS_1_DIARIOS");
			String [] des_D1_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_D1_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getCOTIZ_D_MAS_1_DIARIOS();
				//System.out.println("antes de borrar: "+descriptoresConAnadido1);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				//System.out.println("despues de borrar"+descriptoresConAnadido1);
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
					
				System.out.println(nuevosDescriptores);
				
				p.setProperty("COTIZ_D_MAS_1_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en cotiz D+1 diario");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setCOTIZ_D_MAS_1_DIARIOS(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			
			break;
		case "Cotiz D-2 Diarios":
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_2_DIARIOS");
			String [] des_D2_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_D2_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getCOTIZ_D_MENOS_2_DIARIOS();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("COTIZ_D_MENOS_2_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en cotiz D-2 diario");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setCOTIZ_D_MENOS_2_DIARIOS(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		case "Fundamenta D-2":
			
			antiguosDescriptores = p.getProperty("FUNDAMENTA_D_2");
			String [] des_FD2_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_FD2_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getFUNDAMENTA_D_2();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("FUNDAMENTA_D_2", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en funda D-2");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setFUNDAMENTA_D_2(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		case "Cotiz D-1 Diarios":
			
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_1_DIARIOS");
			String [] des_CD1_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_CD1_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getCOTIZ_D_MENOS_1_DIARIOS();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("COTIZ_D_MENOS_1_DIARIOS", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en cotiz D-1 diarios");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setCOTIZ_D_MENOS_1_DIARIOS(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		case "Fundamenta D-1":
			
			antiguosDescriptores = p.getProperty("FUNDAMENTA_D_1");
			String [] des_FD1_diarios = antiguosDescriptores.split(",");
			
			for (String d : des_FD1_diarios) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getFUNDAMENTA_D_1();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("FUNDAMENTA_D_1", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en funda D-1");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setFUNDAMENTA_D_1(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		case "Cotiz D-1 Laborables":
			
			antiguosDescriptores = p.getProperty("COTIZ_D_MENOS_1_LABORABLES");
			String [] des_CD1_laborables = antiguosDescriptores.split(",");
			
			for (String d : des_CD1_laborables) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getCOTIZ_D_MENOS_1_LABORABLES();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("COTIZ_D_MENOS_1_LABORABLES", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en cotiz D-1 laborables");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setCOTIZ_D_MENOS_1_LABORABLES(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		case "Cotiz mensual":
			
			antiguosDescriptores = p.getProperty("COTIZ_MENSUAL");
			String [] des_mensuales = antiguosDescriptores.split(",");
			
			for (String d : des_mensuales) {
				if (d.equals(descriptor)) {
					existeDescriptor = true;
				}
			}
			
			if (existeDescriptor) {
				
				List<Integer> descriptoresConBorrado = cp.getCOTIZ_MENSUAL();
				System.out.println("antes de borrar: "+descriptoresConBorrado);
				descriptoresConBorrado.remove(Integer.valueOf(descriptor));
				for (int i = 0; i < descriptoresConBorrado.size(); i++) {
					
					if (i==0) {
						nuevosDescriptores += descriptoresConBorrado.get(i).toString();
					} else {
						nuevosDescriptores += ","+descriptoresConBorrado.get(i).toString();
					}
					
				}
				//System.out.println("despues de borrar"+descriptoresConBorrado);	
				//System.out.println(nuevosDescriptores);
				
				p.setProperty("COTIZ_MENSUAL", nuevosDescriptores);
				p.store(new FileWriter("C://Users/israe/Desktop/descriptores.properties"),"Borrado el descriptor "+descriptor+" en cotiz mensual");
				
				//Borramos el descriptor tambien de la clase para no incluir en la busqueda, en caliente
				cp.setCOTIZ_MENSUAL(descriptoresConBorrado);
				mensaje = "Descriptor borrado correctamente;green";
			}else {
				mensaje = "El descriptor no existe para ese periodo;red";
			}
			break;
		default:
			mensaje = "Error de conexion o no existe esos periodos;red";
			break;
		}

		return mensaje;
	}
}
