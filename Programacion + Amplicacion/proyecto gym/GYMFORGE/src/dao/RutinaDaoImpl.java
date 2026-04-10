package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.Rutina;
import modelo.Usuario;

public class RutinaDaoImpl implements IDAO<Long, Rutina> {

	private Rutina mapearRutinas(ResultSet rs) throws SQLException {
		
		Rutina r = new Rutina();
		r.setId(rs.getLong("id"));
		r.setNombre(rs.getString("nombre"));
		r.setObjetivo(rs.getString("objetivo"));
		r.setId_usuario(rs.getLong("id_usuario"));
		
		return r;
	}
	
	@Override
	public List<Rutina> findAll() throws DAOException {
		List<Rutina> r = new ArrayList<Rutina>();
		String sql = "SELECT * FROM RUTINA";
		
		try (Statement stm = Singleton.getInstance().createStatement();
			 ResultSet rs = stm.executeQuery(sql)) {

			while(rs.next()) {
				r.add(mapearRutinas(rs));
			}
			
		} catch (SQLException e) {
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    } catch (Exception e) {
	        throw new DAOException(TipoException.EXCEPCION_GENERAL);
	    }
		return r;
	}
	

	public List<Rutina> findAllByIdUsuario() throws DAOException {
		List<Rutina> r = new ArrayList<Rutina>();
		String sql = "SELECT * FROM RUTINA";
		
		try (Statement stm = Singleton.getInstance().createStatement();
			 ResultSet rs = stm.executeQuery(sql)) {

			while(rs.next()) {
				r.add(mapearRutinas(rs));
			}
			
		} catch (SQLException e) {
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    } catch (Exception e) {
	        throw new DAOException(TipoException.EXCEPCION_GENERAL);
	    }
		return r;
	}
	
	public List<Rutina> findAllByUsuario(Usuario usuario) {
	    String sql = "SELECT * FROM RUTINA WHERE ID_USUARIO = ?";
	    // Inicializamos la lista para evitar NullPointerException
	    List<Rutina> rutinas = new ArrayList<>(); 
	    
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        pstm.setLong(1, usuario.getId());
	        
	        try (ResultSet rs = pstm.executeQuery()) {
	            // Usamos while para recorrer TODAS las filas, no solo la primera
	            while (rs.next()) {
	                rutinas.add(mapearRutinas(rs));
	            }
	        }
	    } catch (SQLException sqle) {
	        // Importante imprimir el error para saber qué falló en la DB
	        sqle.printStackTrace(); 
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	    return rutinas;
	}

	public Rutina findOnebyUsuario(Long key) throws DAOException {
		String sql = "SELECT * FROM RUTINA WHERE ID_USUARIO = ?";
		Rutina r = null;
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			 try (ResultSet rs = pstm.executeQuery()) {
		        	
		            if (rs.next()) 	r = mapearRutinas(rs);
		            else 			throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
		        }
		}  catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
		return r;
	}

	@Override
	public Rutina findOne(Long key) throws DAOException {
		String sql = "SELECT * FROM RUTINA WHERE ID_USUARIO = ?";
		Rutina r = null;
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			 try (ResultSet rs = pstm.executeQuery()) {
		        	
		            if (rs.next()) 	r = mapearRutinas(rs);
		            else 			throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
		        }
		}  catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
		return r;
	}


	public void create(Rutina rutina) throws DAOException {
	    // 1. Preparamos el SQL
	    String sql = "INSERT INTO RUTINA (NOMBRE, OBJETIVO, ID_USUARIO) VALUES (?, ?, ?)";
	    
	    // 2. IMPORTANTE: Pedimos que nos devuelva las llaves generadas (RETURN_GENERATED_KEYS)
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        
	        pstm.setString(1, rutina.getNombre());
	        pstm.setString(2, rutina.getObjetivo());
	        pstm.setLong(3, rutina.getId_usuario());
	        
	        pstm.executeUpdate();
	        
	        try (ResultSet rs = pstm.getGeneratedKeys()) {
	            if (rs.next()) {
	           
	                rutina.setId(rs.getLong(1)); 
	                System.out.println("ID recuperado de la BD: " + rutina.getId());
	            }
	        }
	    } catch (SQLException sqle) {
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	}

	@Override
	public void update(Rutina item) throws DAOException {
		String sql = "UPDATE RUTINA SET NOMBRE = ?, OBJETIVO = ?";
		
		try(PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)){
			pstm.setString(1, item.getNombre());
			pstm.setString(2, item.getObjetivo());
			int i = pstm.executeUpdate();
			if(i == 0 ) throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			else if (i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException sqle) {
			 new DAOException(TipoException.EXCEPCION_SQL);
		} 
	}


	public void deleteByData(Usuario usuario, Rutina rutina) throws DAOException {
	    String sql = "DELETE FROM RUTINA WHERE ID = ? AND ID_USUARIO = ?";
	    
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        pstm.setLong(1, rutina.getId());
	        pstm.setLong(2, usuario.getId());
	        
	        int filasAfectadas = pstm.executeUpdate();
	        
	     
	        if (filasAfectadas == 0) {
	            throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	}

	@Override
	public Long createReturnId(Rutina item) throws DAOException {
		String sql = "INSERT INTO RUTINA (NOMBRE, OBJETIVO, ID_USUARIO) VALUES (?,?,?)"; 

		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setString(1, item.getNombre());
			pstm.setString(2, item.getObjetivo());
			pstm.setLong(3, item.getId_usuario());
			int i = pstm.executeUpdate();
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_CREADO);

		} catch (SQLException sqle) {
			 new DAOException(TipoException.EXCEPCION_SQL);
			} 
		return (long) Statement.RETURN_GENERATED_KEYS;
	}

	@Override
	public void delete(Long key) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
