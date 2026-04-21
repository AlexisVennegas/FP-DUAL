package bbdd;

import java.sql.*;

import modelo.Juego;

public class ServicioDAO implements JuegoDAO {
	
	private Connection conn;
	
	public ServicioDAO(Connection conn) {
		this.conn = conn; 
	}
	

	@Override
	public void insertar(Juego juego) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO videojuegos (idJuego, nombre, plataforma, precio, stock) VALUES (?, ?, ?, ?, ?)";
		conn = ConexionGameHub.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.setString(2, juego.getNombre());
			ps.setString(3, juego.getPlataforma());
			ps.setDouble(4, juego.getPrecio());
			ps.setInt(5, juego.getStock());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las tablas");
		}
		
	}

	@Override
	public ResultSet listar(Juego juego) {
		// Corregido el FFROM a FROM
	    String sql = "SELECT * FROM videojuegos WHERE idJuego = ?";
	    ResultSet rs = null; // Declaramos el ResultSet fuera del try
	    
	    try {
	        // Quitamos el try-with-resources para que NO se cierren automáticamente
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, juego.getIdJuego());
	        
	        rs = ps.executeQuery();
	        
	        // NOTA: Si vas a retornar el ResultSet, no debes hacer rs.next() aquí
	        // porque si lo haces, "consumirás" la fila y el método que lo reciba 
	        // no podrá ver los datos.
	        
	    } catch (SQLException e) {
	        System.out.println("Error al consultar la tabla: " + e.getMessage());
	    }
	    
	    // Retornamos el ResultSet abierto para que otra clase lo procese
	    return rs;
	}

	@Override
	public void actualizar(Juego juego) {
		// TODO Auto-generated method stub
		String sql = "UPDATE videojuegos SET idJuego = ?, nombre = ?, plataforma = ?, precio = ? , stock = ? WHERE idJuego = ?";
		conn = ConexionGameHub.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.setString(2, juego.getNombre());
			ps.setString(3, juego.getPlataforma());
			ps.setDouble(4, juego.getPrecio());
			ps.setInt(5, juego.getStock());
			ps.setInt(6, juego.getIdJuego());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al actualizar las tablas");
		}
		
	}

	@Override
	public void eliminar(Juego juego) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM videojuegos WHERE idJuego= ?";
		conn = ConexionGameHub.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al borrar las tablas");
		}
	}

}
