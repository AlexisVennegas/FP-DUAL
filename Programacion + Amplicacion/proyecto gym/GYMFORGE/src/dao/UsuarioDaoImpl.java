package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.Usuario;

public class UsuarioDaoImpl implements IDAO<Long, Usuario>{

	private Usuario mapearUsuario(ResultSet rs) throws SQLException {
	    Usuario u = new Usuario();
	    u.setId(rs.getLong("id"));
	    u.setNombre(rs.getString("nombre"));
	    u.setCorreo(rs.getString("correo"));
	    u.setPassword(rs.getString("password"));
	    u.setPeso(rs.getDouble("peso"));
	    u.setAltura(rs.getDouble("altura"));
	    u.setDeporte(rs.getString("deporte"));
	    return u;
	}
	
	@Override
	public List<Usuario> findAll() throws DAOException {
	    List<Usuario> usuarios = new ArrayList<>();
	    String sql = "SELECT id, nombre, correo, password, peso, altura, deporte FROM USUARIOS";

	 
	    try (Statement stm = Singleton.getInstance().createStatement();
	         ResultSet rs = stm.executeQuery(sql)) {

	        while (rs.next()) {
	            usuarios.add(mapearUsuario(rs));
	        }
	        
	    } catch (SQLException e) {
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    } catch (Exception e) {
	        throw new DAOException(TipoException.EXCEPCION_GENERAL);
	    }
	    
	    return usuarios;
	}
	
	@Override
	public Usuario findOne(Long key) throws DAOException {
	    String sql = "SELECT id, nombre, correo, password, peso, altura, deporte FROM USUARIOS WHERE ID = ?";
	    Usuario usuario = null;

	
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        
	        pstm.setLong(1, key);
	        
	        try (ResultSet rs = pstm.executeQuery()) {
	        	
	            if (rs.next()) 	usuario = mapearUsuario(rs);
	            else 			throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
	        }
	        
	    } catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	      
	    return usuario;
	}
	
	public Usuario findOneByEmail(String email, String password) throws DAOException{
		String sql = "SELECT * FROM USUARIOS WHERE CORREO = ? AND PASSWORD = ?";
		Usuario u = null;
		
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        
	        pstm.setString(1, email);
	        pstm.setString(2, password);
	        
	        try (ResultSet rs = pstm.executeQuery()) {
	        	
	            if (rs.next()) 	u = mapearUsuario(rs);
	            else 			throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
	        }
	        
	    } catch (SQLException e) {
	    	  //throw new DAOException(TipoException.EXCEPCION_SQL);
	    	  return null;
	    }
	      
	    return u;
	}

	@Override
	public void create(Usuario item) throws DAOException {
		
		String sql = "INSERT INTO USUARIOS (NOMBRE, CORREO, PASSWORD,PESO, ALTURA, DEPORTE) VALUES (?,?,?,?,?,?)";		
		
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			
			pstm.setString(1, item.getNombre());
			pstm.setString(2, item.getCorreo());
			pstm.setString(3, item.getPassword());
			pstm.setDouble(4, item.getPeso());
			pstm.setDouble(5, item.getAltura());
			pstm.setString(6, item.getDeporte());
		
			
			int i = pstm.executeUpdate();
		
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
			
		} catch (SQLException sqle) {
		 new DAOException(TipoException.EXCEPCION_SQL);
		} 
	}

	
	
	@Override
	public void update(Usuario item) throws DAOException {
		String sql = "UPDATE USUARIOS SET NOMBRE = ?, CORREO = ?, PASSWORD = ?, PESO = ?, ALTURA = ?, DEPORTE = ?";
		try(PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)){
			pstm.setString(1, item.getNombre());
			pstm.setString(2, item.getCorreo());
			pstm.setString(3, item.getPassword());
			pstm.setDouble(4, item.getPeso());
			pstm.setDouble(5, item.getAltura());
			pstm.setString(6, item.getDeporte());
			
			int i = pstm.executeUpdate();
			
			if(i == 0 ) throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			else if (i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException sqle) {
			 new DAOException(TipoException.EXCEPCION_SQL);
		} 
		
	}

	@Override
	public void delete(Long key) throws DAOException {
		String sql = "DELETE FROM USUARIOS WHERE ID = ?";
		
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			else if(i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException  e) {
			throw new DAOException(TipoException.EXCEPCION_SQL);
		}
		
	}

	@Override
	public Long createReturnId(Usuario item) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
