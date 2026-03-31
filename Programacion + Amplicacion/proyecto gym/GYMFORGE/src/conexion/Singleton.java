package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	// SQL
	private static Connection  conn = null;
	
	// constructor
	private Singleton() {
		//String url = System.getenv("DB_URL");
		//String user = System.getenv("DB_USER");
		//String pass = System.getenv("DB_PASS");
		
		String url = "jdbc:mariadb://localhost:3306/gymforge";
		String user = "erick";
		String pass = "erick";
		
		try {
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//metodo para acceder
	public static Connection getInstance() {
		try {
			if(conn == null || conn.isClosed()) new Singleton();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close() {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("error al cerrar la conexion");
			}
		}
	}
}
