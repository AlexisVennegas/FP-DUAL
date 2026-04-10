package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Singleton;
import modelo.HistorialPeso;
import modelo.Usuario;

public class HistorialPesoDaoImpl implements IDAO<Long, HistorialPeso> {

	private static final Date Date = null;

	@Override
	public List<HistorialPeso> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public List<HistorialPeso> findUltimosPesos(Long idUsuario) throws DAOException {
	    List<HistorialPeso> lista = new ArrayList<>();
	   
	    String sql = "SELECT * FROM historialPeso WHERE id_usuario = ? ORDER BY fecha ASC LIMIT 7";
	    
	
	    return lista;
	}

	@Override
	public HistorialPeso findOne(Long key) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	public void insert(Usuario item) throws DAOException {
	    String sql = "INSERT INTO historialpeso (id_usuario, peso, fecha) VALUES (?, ?, ?)";
		try (PreparedStatement pstm = Singleton.getInstance().prepareStatement(sql)) {
			pstm.setLong(1, item.getId());
			pstm.setDouble(2, item.getPeso());
			pstm.setDate(3, Date);
			
			int i = pstm.executeUpdate();
			if (i == 0) throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
		} catch (SQLException e) {
			new DAOException(TipoException.EXCEPCION_SQL);
		}
	    
	}

	@Override
	public void update(HistorialPeso item) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long key) throws DAOException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void create(HistorialPeso item) throws DAOException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Long createReturnId(HistorialPeso item) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
