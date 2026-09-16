package src.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import src.dao.DAOException;

public class Singleton {

	// Propiedades
	private static Connection conn = null;

	// Constructor
	private Singleton() {

		//String url = System.getenv("DB_URL");
		//String user = System.getenv("DB_USER");
	//	String pass = System.getenv("DB_PASS");
		
		String url = "jdbc:mariadb://localhost:3306/programacion";

		String usuario = "erick";
		String password = "erick";

		try {
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // Fin constructor

	// Métodos
	public static Connection getInstance() {
		try {
			if (conn == null || conn.isClosed()) {
				{
					new Singleton();
					crearTablaSiNoExiste();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	private static void crearTablaSiNoExiste() {
		String sql = "CREATE TABLE IF NOT EXISTS contactos (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nombre VARCHAR(50) NOT NULL," + "telefono VARCHAR(50) NOT NULL)";
		try (Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		} catch (SQLException e) {
			throw new DAOException("Error al inicializar la tabla de contactos", e);
		}
	}

	public static void close() {
	
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// Habría que hacerlo con DAOException
				System.err.println("Error al cerrar conexión");
			}
		}
		
	}
}