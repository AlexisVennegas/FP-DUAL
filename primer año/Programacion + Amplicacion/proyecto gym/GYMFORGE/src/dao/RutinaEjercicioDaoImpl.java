package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.Ejercicio;
import modelo.Rutina;
import modelo.RutinaEjercicio;
import modelo.Usuario;

public class RutinaEjercicioDaoImpl implements IDAO<Long, RutinaEjercicio>{

	private RutinaEjercicio mapearRutina(ResultSet rs) throws SQLException {
		RutinaEjercicio r = new RutinaEjercicio();
		r.setId(rs.getLong("id"));
		r.setId_rutina(rs.getLong("id_rutina"));
		r.setId_ejercicio(rs.getLong("id_ejercicio"));
		r.setOrden(rs.getLong("orden"));
		r.setNombreEjercicio(rs.getString("nombre_ejercicio"));
		
		return r;
	}
	
	@Override
	public List<RutinaEjercicio> findAll() throws DAOException {
		List<RutinaEjercicio> r = new ArrayList<>();
		String sql = "SELECT * FROM RUTINA_EJERCICIO";

	    try (Statement stm = Singleton.getInstance().createStatement();
	         ResultSet rs = stm.executeQuery(sql)) {
			
	    	while(rs.next()) {
	    		r.add(mapearRutina(rs));
	    	}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

	public Rutina findRutinaByUsuario(Long id_usuario) throws DAOException {
	  
	    String sql = "SELECT * FROM RUTINA WHERE ID_USUARIO = ?";
	    Rutina r = new Rutina();
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, id_usuario);
			
			try (ResultSet rs = pstm.executeQuery()){
				if(rs.next()) {
					r.setNombre(rs.getString("nombre"));
					r.setId_usuario(rs.getLong("id_usuario"));
					r.setObjetivo(rs.getString("objetivo"));
				}
				else 		  throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			} 
		      
			
		} catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
		
		return r;
	}


	
	
	@Override
	public RutinaEjercicio findOne(Long key) throws DAOException {
		return null;
	}

	public List<Ejercicio> mostrarEjerciciosDeUnaRutina(Usuario usuario, Rutina rutina){
		List<Ejercicio> lista = new java.util.ArrayList<>();
		
	    String sql = "SELECT e.* FROM ejercicio e " +
	                 "INNER JOIN rutina_ejercicio re ON e.id = re.id_ejercicio " +
	                 "WHERE re.id_rutina = ? AND re.id_usuario = ?";
	    
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	           
	    		pstm.setLong(1, rutina.getId());
	    		pstm.setLong(2, usuario.getId());
	           
	    		ResultSet rs = pstm.executeQuery();
	           
	           while (rs.next()) {
	               Ejercicio ej = new Ejercicio();
	               ej.setId(rs.getLong("id"));
	               ej.setNombre(rs.getString("nombre"));
	               ej.setGrupo_muscular(rs.getString("grupo_muscular"));
	               ej.setDescripcion(rs.getString("descripcion"));
	               ej.setImagen(rs.getString("imagen"));
	               lista.add(ej);
	           }
	           
	       }  catch (SQLException sqle) {
				throw new DAOException(TipoException.EXCEPCION_SQL);
	       }
	       
	       return lista;
	}
	

	@Override
	public void create(RutinaEjercicio item) throws DAOException {
		System.out.println("aqui estamos en el dao" + item);
		String sql = "INSERT INTO RUTINA_EJERCICIO (ID_RUTINA,ID_EJERCICIO,ORDEN, ID_USUARIO) VALUES (?,?,?,?)";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, item.getId_rutina());
			pstm.setLong(2, item.getId_ejercicio());
			pstm.setFloat(3, item.getOrden());
			pstm.setLong(4, item.getId_usuario());
			
			int i = pstm.executeUpdate();
			
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
		} catch (SQLException sqle) {
			throw new DAOException(TipoException.EXCEPCION_SQL);
			} 
		
	}

	
	
	@Override
	public void update(RutinaEjercicio item) throws DAOException {
	   
	    String sql = "UPDATE RUTINA_EJERCICIO SET ID_EJERCICIO = ?, ORDEN = ? WHERE ID = ?";
	    
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        
	        pstm.setLong(1, item.getId_ejercicio()); 
	        pstm.setLong(2, item.getOrden());        
	        pstm.setLong(3, item.getId());          
	        
	        int i = pstm.executeUpdate();
	        
	        if (i == 0) throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
	        
	    } catch (SQLException e) {
	    	throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	}

	@Override
	public void delete(Long key) throws DAOException {
		String sql = "DELETE FROM RUTINA_EJERCICIO WHERE ID = ?";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			else if(i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			
		}  catch (SQLException  e) {
			throw new DAOException(TipoException.EXCEPCION_SQL);
		}
		
		
	}

	@Override
	public Long createReturnId(RutinaEjercicio item) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
