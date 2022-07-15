package array_interface;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;





public class Init {

	public static void main(String[] args) throws IOException, SQLException {
		/*
		 * CSVReader csvReader = new CSVReader(new
		 * FileReader("C:\\Users\\israe\\Desktop\\TMA_PRUEBA_local.csv")); ListaLocal ll
		 * = new ListaLocal();
		 * 
		 * ll.listaLocal = csvReader.readAll();
		 * 
		 * Iterator<String[]> itr = ll.listaLocal.iterator();
		 * 
		 * String[] c = new String[ll.listaLocal.size()]; ll.a = new String[1][1];
		 * 
		 * while (itr.hasNext()) { c = itr.next(); for (int i = 0; i<c.length; i++) {
		 * System.out.println(c[i]); }
		 * 
		 * }
		 */
		
		connection_bd cb = new connection_bd();
		Connection conOracle = cb.connection();
		Statement stmt = conOracle.createStatement();
		File archivo = null;
		FileReader fr = null;
		archivo = new File ("C:\\Users\\israe\\Desktop/archivo.txt");
		String linea;
		String m = "";
		
		fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		while((linea=br.readLine())!=null) {
			String result = linea.substring(0, linea.length() - 1); 
			String [] datos = result.split(";",-1);
			m +=("INTO TMA_TMP_BP_X (IDEVENTO, UUID00001, M_APP, USUARIO, TIPO_USUARIO) VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[4]+"')\n");
			
		}
		//String queryFinal = query;
		br.close();
		m = "INSERT ALL\n" + m +  "select * from dual" ;
		System.out.println(m);
		stmt.executeUpdate(m);
		conOracle.setAutoCommit(false);
		conOracle.commit();
		conOracle.close();
		//stmt.executeUpdate(query);
	}
	

}
