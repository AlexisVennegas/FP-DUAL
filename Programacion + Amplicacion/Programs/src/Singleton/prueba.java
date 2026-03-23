package Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {

    public static Connection conexion = null;

    public static void seedAgenda() {

        if (conexion == null) {
            conexion = app.getConecction();
        }

        String[] sqls = {
        		  "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('Alexis', '600123456', '2026-03-20', 'alexis@gmail.com')",
        	       "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('Laura', '611234567', '2026-02-15', 'laura@gmail.com')",
        	       "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('Carlos', '622345678', '2026-01-10', 'carlos@gmail.com')",
        	       "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('Marta', '633456789', '2025-12-05', 'marta@gmail.com')",
        	       "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('David', '644567890', '2025-11-25', 'david@gmail.com')",
        	       "INSERT INTO agenda (nombre, telefono, fecha, email) VALUES ('Sofia', '655678901', '2025-10-30', 'sofia@gmail.com')"
        };

        try (Statement stmt = conexion.createStatement()) {
            for (String sql : sqls) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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
    
   public static int deleteData(String id) {
	   
	   int filasAfectadas = 0;
	   conexion = app.getConecction();
	    String sql = "DELETE FROM agenda WHERE id = " + id;
	    try (Statement stmt = conexion.createStatement()) {
	        filasAfectadas = stmt.executeUpdate(sql);
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