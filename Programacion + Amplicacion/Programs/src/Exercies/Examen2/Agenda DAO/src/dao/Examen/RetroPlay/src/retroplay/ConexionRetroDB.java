package retroplay;

import java.sql.*;

public class ConexionRetroDB {
	// Propiedades 
	private static Connection conn = null; 
	
	// Constructor privado
	private ConexionRetroDB() {
		String url = "jdbc:mariadb://localhost:3333/retroplay_db?createDatabaseIfNotExist=true"; // RECUERDA CAMBIARLO EN EL OTRO PC A 3306
		String usuario = "root"; // en clase es root
		String contraseña = "1234"; // alumno
		
		try {
			conn = DriverManager.getConnection(url, usuario, contraseña);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Métodos
	public static Connection getInstance() {
		try {
			if (conn == null || conn.isClosed()) {
				new ConexionRetroDB();
				crearTablaSiNoExiste(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; 
	}

	private static void crearTablaSiNoExiste() {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE IF NOT EXISTS videojuegos(" 
		+"idJuego INT AUTO_INCREMENT PRIMARY KEY," 
				+ "titulo VARCHAR(50)," 
		+ "plataforma VARCHAR(50)," 
				+ "precio DECIMAL(6,2)," +
		"stock INT)";
		
		try(Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.err.println("Error a la hora de inicializar la tabla videojuegos");
		}
	}
	
	public static void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Error al cerrar conexión");				
			}
		}
	}
	
}
