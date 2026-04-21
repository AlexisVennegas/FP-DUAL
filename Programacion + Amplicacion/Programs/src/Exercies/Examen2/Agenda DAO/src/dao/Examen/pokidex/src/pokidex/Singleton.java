package pokidex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Connection conn = null;
	
	private Singleton(){
    	String url = "jdbc:mariadb://localhost:3306/pokidexdb";
    	String usuario = "root";
    	String password = "alumno";
  
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
