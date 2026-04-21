package bbdd;

import java.sql.*;

public class ConexionGameHub {
	
	// Propiedades:
	private static Connection conn = null; 
	
	// Constructor privado:
	private ConexionGameHub() {
		String url = "jdbc:mariadb://localhost:3333/gameHub"; // 3306 || CREATE DATABASE gameHub;
		String usuario = "root"; // root
		String password = "1234"; // alumno
		
		try {
			conn = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			throw new ConexionGameHubException ("Error de conexión", e);
		}
	}
	
	// Métodos
	public static Connection getInstance() {
		try {
			if (conn == null || conn.isClosed()) {
				new ConexionGameHub();
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
				+ "nombre VARCHAR(50)," 
		+ "plataforma VARCHAR(50)," 
				+ "precio DECIMAL(6,2)," +
		"stock INT)";
		
		try(Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.err.println("Error a la hora de inicializar la tabla juegos");
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
