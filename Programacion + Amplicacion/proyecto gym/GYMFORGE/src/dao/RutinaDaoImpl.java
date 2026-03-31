package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.Rutina;

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

	

	@Override
	public Rutina findOne(Long key) throws DAOException {
		String sql = "SELECT * FROM RUTINA WHERE ID = ?";
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
	public void create(Rutina item) throws DAOException {
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

	@Override
	public void delete(Long key) throws DAOException {
		
		String sql = "DELETE FROM RUTINA WHERE ID = ?";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			else if(i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException  e) {
			throw new DAOException(TipoException.EXCEPCION_SQL);
		}
		
	}

}
