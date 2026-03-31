package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
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

	public List<RutinaEjercicio> findByRutina(Long idRutina) throws DAOException {
	  
	    String sql = "SELECT re.*, e.nombre AS nombre_ejercicio " +
	                 "FROM RUTINA_EJERCICIO re " +
	                 "JOIN EJERCICIO e ON re.id_ejercicio = e.id " +
	                 "WHERE re.id_rutina = ? " +
	                 "ORDER BY re.orden ASC";

	    List<RutinaEjercicio> lista = new ArrayList<>();

	
	    try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
	        
	        pstm.setLong(1, idRutina);

	        try (ResultSet rs = pstm.executeQuery()) {
	            while (rs.next()) {
	          
	                RutinaEjercicio re = mapearRutina(rs);
	                lista.add(re);
	            }
	        }
	    } catch (SQLException e) {
	    	throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
	    return lista;
	}

	
	
	@Override
	public RutinaEjercicio findOne(Long key) throws DAOException {
		return null;
	}
	

	

	@Override
	public void create(RutinaEjercicio item) throws DAOException {
		String sql = "INSERT INTO RUTINA_EJERCICIO (ID_RUTINA,ID_EJERCICIO,ORDEN) VALUES (?,?,?)";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, item.getId_rutina());
			pstm.setLong(2, item.getId_ejercicio());
			pstm.setFloat(3, item.getOrden());
			
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

}
