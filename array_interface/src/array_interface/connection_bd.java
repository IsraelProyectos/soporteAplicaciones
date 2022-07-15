package array_interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connection_bd {
	
	Connection  conexion;
	
	public Connection connection() {
		
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION =\r\n" + 
            		"    (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))\r\n" + 
            		"    (CONNECT_DATA =\r\n" + 
            		"      (SERVER = DEDICATED)\r\n" + 
            		"      (SERVICE_NAME = orcl)\r\n" + 
            		"    )\r\n" + 
            		"  )", "drugo", "321");
            System.out.println("Conectado");
            return conexion;
            
        } catch (SQLException ex) {
        	System.out.println("Fallo en la conexión");
        	System.out.println("Fallo: " + ex);
        	JOptionPane.showMessageDialog(null, "Error al conectar a BBDD: " + ex, "ERROR", 1);
            return null;
        }
    }
	
	public void endConnection() {
		try {
			conexion.close();
			System.out.println("Desconectado");
		}catch (SQLException ex) {
			System.out.println(ex);
		}
		
	}
	

}
