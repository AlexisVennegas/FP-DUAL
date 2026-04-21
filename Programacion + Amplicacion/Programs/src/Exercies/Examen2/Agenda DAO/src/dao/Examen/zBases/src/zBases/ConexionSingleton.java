package zBases;

import java.sql.*;

public class ConexionSingleton {

    private static ConexionSingleton instancia;
    private Connection conexion;

    private final String URL = "jdbc:mysql://localhost:3306/miBD";
    private final String USER = "root";
    private final String PASS = "alumno";

    // Constructor privado (CLAVE del Singleton)
    private ConexionSingleton() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la única instancia
    public static ConexionSingleton getInstance() {
        if (instancia == null) {
            instancia = new ConexionSingleton();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return conexion;
    }
}