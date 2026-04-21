package PatronDAO;

import java.sql.*;

public class ServicioDAO implements VideojuegoDAO{

	private Connection con;
	
	
	
	public ServicioDAO(Connection con) {
		this.con = con;
	}

	@Override
	public void insertar(Videojuego v) {
		String sql = "INSERT INTO videojuegos (titulo,plataforma, precio,stock) "
				+ "VALUES (?,?,?,?)";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, v.getTitulo());
			ps.setString(2, v.getPlataforma());
			ps.setDouble(3, v.getPrecio());
			ps.setInt(4, v.getStock());
			ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Error al meter datos");
		}
		
		
	}

	@Override
	public void leer(Videojuego v) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM videojuegos WHERE idjuego=?";
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, v.getId());
			ResultSet rs= ps.executeQuery();
			
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getDouble(4));
				System.out.println(rs.getInt(5));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificar(Videojuego v) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE videojuegos SET stock=? WHERE idjuego="+v.getId();
		
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, v.getStock());
			ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Error al meter datos");
			
		}
		
	}

	@Override
	public void borrar(Videojuego v) {
		// TODO Auto-generated method stub
		
		String sql="DELETE FROM videojuegos WHERE idjuego="+v.getId();
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println("Error al meter datos");
			
		}
	}

}
