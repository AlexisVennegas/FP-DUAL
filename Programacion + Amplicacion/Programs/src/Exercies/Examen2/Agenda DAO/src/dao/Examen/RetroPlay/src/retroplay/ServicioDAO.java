package retroplay;

import java.sql.*;

public class ServicioDAO implements VideojuegoDAO {

	private Connection conn;

	public ServicioDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Videojuego juego) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO videojuegos (idJuego, titulo, plataforma, precio, stock) VALUES (?, ?, ?, ?, ?)";
		conn = ConexionRetroDB.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.setString(2, juego.getTitulo());
			ps.setString(3, juego.getPlataforma());
			ps.setDouble(4, juego.getPrecio());
			ps.setInt(5, juego.getStock());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las tablas");
		}
	}

	@Override
	public ResultSet leer(Videojuego juego) {
		// TODO Auto-generated method stub
		String sql = "SELECT titulo, plataforma, precio, stock FROM videojuegos WHERE idJuego =? ";
		
		conn = ConexionRetroDB.getInstance();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, juego.getIdJuego());
			
			return ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Error al leer");
			return null;
		}
		

	}

	@Override
	public void actualizar(Videojuego juego) {
		// TODO Auto-generated method stub
		String sql = "UPDATE videojuegos SET idJuego = ?, titulo = ?, plataforma = ?, precio = ? , stock = ? WHERE idJuego = ?";
		conn = ConexionRetroDB.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.setString(2, juego.getTitulo());
			ps.setString(3, juego.getPlataforma());
			ps.setDouble(4, juego.getPrecio());
			ps.setInt(5, juego.getStock());
			ps.setInt(6, juego.getIdJuego());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las tablas");
		}

	}

	@Override
	public void borrar(Videojuego juego) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM videojuegos WHERE idJuego= ?";
		conn = ConexionRetroDB.getInstance();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, juego.getIdJuego());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las tablas");
		}

	}

}
