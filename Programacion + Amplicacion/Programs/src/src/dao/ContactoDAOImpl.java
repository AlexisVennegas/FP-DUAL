package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.conexion.Singleton;
import src.modelo.Contacto;

public class ContactoDAOImpl implements ContactoDAO {
    private Connection conn; 

    public ContactoDAOImpl(Connection conn) { this.conn = conn; }

    @Override
    public void guardar(Contacto c) {
        String sql = "INSERT INTO contactos (nombre, telefono) VALUES (?, ?)";
        conn=Singleton.getInstance();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al insertar contacto", e);
        }
    }

	@Override
	public Contacto buscar(String nombre) {
		String sql = "Select * from contactos where nombre = ?";
		conn = Singleton.getInstance();
		  try (PreparedStatement ps = conn.prepareStatement(sql)) {
			  ps.setString(1, nombre);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
		            
		            Contacto contacto = new Contacto(
		                rs.getString("nombre"),
		                rs.getString("telefono")
		            );

		            return contacto;
		        }
	        } catch (SQLException e) {
	            throw new DAOException("Error al insertar contacto", e);
	        }
		return null;
		
	}

	@Override
	public List<Contacto> mostrarTodo() throws DAOException {
		String sql = "select * from contactos limit 10	";
		conn = Singleton.getInstance();
	    List<Contacto> contactos = new ArrayList<>();

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Contacto contacto = new Contacto(
	                rs.getString("nombre"),
	                rs.getString("telefono")
	            );

	            contactos.add(contacto);
	        }

	    } catch (SQLException e) {
	        throw new DAOException("Error al listar contactos", e);
	    }

	    return contactos;
	}

	@Override
	public int eliminar(String nombre) {
		String sql = "delete  from contactos where nombre = ?";
		conn = Singleton.getInstance();
		int cambios = 0;
		  try (PreparedStatement ps = conn.prepareStatement(sql)) {
			  ps.setString(1, nombre);
	      
	            
	            cambios =ps.executeUpdate(); 
	            System.out.println(cambios);
	            
	        } catch (SQLException e) {
	            throw new DAOException("Error al insertar contacto", e);
	        }
		return cambios;
	}

	@Override
	public int editar(String nombre, String telefono) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE contactos SET telefono = ? WHERE nombre = ?";
		    conn = Singleton.getInstance();

		    try (PreparedStatement ps = conn.prepareStatement(sql)) {

		        ps.setString(1, telefono);
		        ps.setString(2, nombre);

		        int filas = ps.executeUpdate();
		        return filas;
		        

		    } catch (SQLException e) {
		        throw new DAOException("Error al actualizar contacto", e);
		    }
	}


}
