package zBases;

import java.sql.*;

public class MainConexionSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 try {
	            // Obtener la conexión desde el Singleton
	            Connection con = ConexionSingleton.getInstance().getConnection();

	            // Statement
	            Statement st = con.createStatement();
	            
	            	// No consulta
	            String sql = "INSERT INTO videojuegos (nombre) VALUES ('Mario')";
	            st.executeUpdate(sql);
	            
	            	// Consulta
	            ResultSet rs = st.executeQuery("SELECT * FROM libros");
	            
	            // Prepared Statement
	            
	            String sql2 = "INSERT INTO videojuegos (nombre,precio) VALUES (?,?)";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, "Mario");
	            ps.setInt(2, 100);
	            ps.executeUpdate();
	            ps.setString(1, "Juan");
	            ps.setInt(2, 200);

	            ps.executeUpdate();
	            
	            // Recorrer resultados
	            while (rs.next()) {
	                System.out.println(rs.getString("titulo"));
	                //GUI   textNombre.setText(rs.getString(1));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
