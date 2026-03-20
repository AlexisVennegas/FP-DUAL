package Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {

    public static Connection conexion = null;



    public static int insertData(String nombre, String telefono, String email, String fecha) {
        int filasAfectadas = 0;
        conexion = app.getConecction();
        String sql = "INSERT INTO agenda (nombre, telefono, email, fecha) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
 
            filasAfectadas = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return filasAfectadas;
    }
    public static int actualizarData(String id, String nombre, String telefono, String email, String fecha) {
    	int filasAfectadas = 0;
    	  conexion = app.getConecction();
    	  String sql = "UPDATE agenda SET " +
                  "nombre = '" + nombre + "', " +
                  "telefono = '" + telefono + "', " +
                  "email = '" + email + "', " +
                  "fecha = '" + fecha + "' " +
                  "WHERE id = " + id;
    	  try (Statement stmt = conexion.createStatement()) {
    	        filasAfectadas = stmt.executeUpdate(sql);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }

    	    return filasAfectadas;
    }
    
    
}