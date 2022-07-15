package cat.israel.servicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

public class ConstantesQuerys {

	private String valorQuery = "";
	private String query = "";

	public ConstantesQuerys() {
		
	}

	@Override
	public String toString() {
		try {

			switch (valorQuery) {

			case "uno":
				query = "SELECT cddescriptor, fechainicio, count(*) cdperiodo FROM US_FUN.V_FUNDAMENTAL_LASTVERSION \r\n"
						+ "WHERE FECHAINICIO BETWEEN TRUNC(SYSDATE -31) AND TRUNC(SYSDATE-1)\r\n"
						+ "AND CDDESCRIPTOR in("+properties("periodosDescriptoresFunda.properties")+")\r\n"
						+ "group by fechainicio, cddescriptor\r\n" 
						+ "order by cddescriptor";
				break;
			case "dos":
				query = "SELECT cddescriptor, fecha, count(*) cdperiodo FROM US_COT.COTIZ \r\n"
						+ "WHERE FECHA BETWEEN TRUNC(SYSDATE -31) AND TRUNC(SYSDATE-1)\r\n"
						+ "AND CDDESCRIPTOR in("+properties("periodosDescriptoresCotiz.properties")+")\r\n"
						+ "group by fecha, cddescriptor\r\n" 
						+ "order by cddescriptor";
				break;
			default:
				query = null;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return query;
	}

	public String properties(String esquema) throws IOException {
		final String FICHERO_DESCRIPTORES = "/workspace_maven/VisorHuecos/propiedades/" + esquema;
		String descriptoresProperties = "";
		Properties periodosDescriptores = new Properties();
		FileInputStream rutaFicheroDescriptores = new FileInputStream(FICHERO_DESCRIPTORES);
		periodosDescriptores.load(rutaFicheroDescriptores);
		Enumeration<Object> periodosProperties = periodosDescriptores.keys();

		rutaFicheroDescriptores.close();
		while (periodosProperties.hasMoreElements()) {
			String clave = periodosProperties.nextElement().toString();
			if (descriptoresProperties.equals("")) {
				descriptoresProperties += clave;
			} else {
				descriptoresProperties += "," + clave;
			}
			

		}
		rutaFicheroDescriptores.close();
		return descriptoresProperties;
	}

}
