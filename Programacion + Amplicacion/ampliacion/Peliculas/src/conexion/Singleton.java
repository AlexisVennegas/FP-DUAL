package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Connection conn = null;
	private Singleton(){
    	String url = "jdbc:mariadb://localhost:3307/peliculas";
    	String usuario = "root";
    	String password = "root";
  
    	try {
    		conn = DriverManager.getConnection(url, usuario, password);
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }
	
	public static Connection getConnection(){
    	if (conn == null){
    		new Singleton();
    	}
    	return conn;
    }
}
