package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.Ejercicio;

public class EjercicioDaoImpl implements IDAO<Long, Ejercicio> {

	private Ejercicio mapearEjercicio(ResultSet rs) throws SQLException{
		Ejercicio j = new Ejercicio();
		j.setId(rs.getLong("id"));
		j.setNombre(rs.getString("nombre"));
		j.setGrupo_muscular(rs.getString("grupo_muscular"));
		j.setDescripcion(rs.getString("descripcion"));
		j.setImagen(rs.getString("imagen"));
		return j;
	}
	
	@Override
	public List<Ejercicio> findAll() throws DAOException {
		List<Ejercicio> ejercicios = new ArrayList<>();
		String sql = "SELECT * FROM EJERCICIO";
		
		try (Statement stm = Singleton.getInstance().createStatement();
				ResultSet rs = stm.executeQuery(sql)) {
		
				while(rs.next()) {
					ejercicios.add(mapearEjercicio(rs));
				}
			
		} catch (SQLException e) {
	        throw new DAOException(TipoException.EXCEPCION_SQL);
	    } catch (Exception e) {
	        throw new DAOException(TipoException.EXCEPCION_GENERAL);
	    }
		return ejercicios;
	}


	@Override
	public Ejercicio findOne(Long key) throws DAOException {
		String sql = "SELECT * FROM EJERCICIO WHERE ID = ?";
		Ejercicio j = null;
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, key);
			
			try (ResultSet rs = pstm.executeQuery()){
				if(rs.next()) j = mapearEjercicio(rs);
				else 		  throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			} 
		      
			
		} catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
		
		return j;
	}

	@Override
	public void create(Ejercicio item) throws DAOException {
		String sql = "INSERT INTO EJERCICIO (NOMBRE, GRUPO_MUSCULAR, DESCRIPCION, IMAGEN) VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setString(1, item.getNombre());
			pstm.setString(2, item.getGrupo_muscular());
			pstm.setString(3, item.getDescripcion());
			pstm.setString(4, item.getImagen());
			
			int i = pstm.executeUpdate();
			
			if (i == 0) throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
		} catch (SQLException sqle) {
			 new DAOException(TipoException.EXCEPCION_SQL);
		} 
		
	}

	@Override
	public void update(Ejercicio item) throws DAOException {
			String sql = "UPDATE EJERCICIO SET NOMBRE = ?, GRUPO_MUSCULAR = ?, DESCRIPCION = ?, IMAGEN = ?";
			try(PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)){
				pstm.setString(1, item.getNombre());
				pstm.setString(2, item.getGrupo_muscular());
				pstm.setString(3, item.getDescripcion());
				pstm.setString(4, item.getImagen());
				
				int i = pstm.executeUpdate();
				
				if (i == 0) 	throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
				else if(i > 1)	throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			} catch (SQLException sqle) {
				 new DAOException(TipoException.EXCEPCION_SQL);
			} 
			
		
	}

	@Override
	public void delete(Long key) throws DAOException {
		String sql = "DELETE FROM EJERCICIO WHERE ID = ?";
		
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
