package Singleton;
import java.sql.*;


public class app {

	private static Connection conn= null;

	
	private  static Connection conectate() {
		
		String url ="jdbc:mariadb://localhost:3306/programacion";
		 String usuario="erick";
		 String contraseña="erick";		 
		try {
			conn= DriverManager.getConnection(url,usuario,contraseña);	
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return conn;

	}
	public static Connection getConecction() {
		
		if (conn==null) {
			conn=conectate();
		}
		return conn;
		
	}
}