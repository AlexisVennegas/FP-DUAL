package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexion.Singleton;
import modelo.Pelicula;

public class PeliculaDaoImp implements IDAO<Long, Pelicula> {

	@Override
	public List<Pelicula> findAll() throws DAOException {
		List<Pelicula> r = new ArrayList<>();
		String sql = "SELECT * FROM PELICULA";
		
		try (Statement stm = Singleton.getConnection().createStatement();
				 ResultSet rs = stm.executeQuery(sql)) {

				while(rs.next()) {
					Pelicula pelicula = new Pelicula();
					pelicula.setId(rs.getLong("id"));
					pelicula.setTitulo(rs.getString("titulo"));
					pelicula.setAno(rs.getInt("ano"));
					r.add(pelicula);
				}
				
			} catch (SQLException e) {
		        throw new DAOException(TipoException.EXCEPCION_SQL);
		    } catch (Exception e) {
		        throw new DAOException(TipoException.EXCEPCION_GENERAL);
		    }
			return r;
	}

	@Override
	public Pelicula findOne(Long key) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	public Pelicula findOneByTitle(String title) throws DAOException{
		
	System.out.println(title);
		String sql = "SELECT * FROM PELICULA WHERE TITULO = ?";
	
		Pelicula j = new Pelicula();
		try (PreparedStatement pstm = Singleton.getConnection().prepareStatement(sql)) {
			pstm.setString(1, title);
			
			try (ResultSet rs = pstm.executeQuery()){
				if(rs.next()) {
					
					j.setId(rs.getLong("id"));
					j.setTitulo(rs.getString("titulo"));
					j.setAno(rs.getInt("ano"));
				}
				else  throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			
			}
		} catch (SQLException e) {
	    	  throw new DAOException(TipoException.EXCEPCION_SQL);
	    }
		System.out.println("j: " + j);
		return j;
	
	}
	
	@Override
	public void create(Pelicula item) throws DAOException {
		
		String sql = "INSERT INTO PELICULA (TITULO, ANO) VALUES (?,?)";
	    try (PreparedStatement pstm = Singleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	    	pstm.setString(1, item.getTitulo());
	    	pstm.setInt(2, item.getAno());
	    	
	        pstm.executeUpdate();
			
		} catch (SQLException e) {
			 throw new DAOException(TipoException.EXCEPCION_SQL);
		}
		
	}

	@Override
	public void update(Pelicula item) throws DAOException {
		LocalDate hoy = LocalDate.now();
		String tituloModificado = item.getTitulo() + hoy; 
		String sql = "UPDATE PELICULA SET TITULO = ? WHERE TITULO = ?";
		try(PreparedStatement pstm = Singleton.getConnection().prepareStatement(sql)){
			pstm.setString(1, tituloModificado);
			pstm.setString(2, item.getTitulo());
			int i = pstm.executeUpdate();
			if(i == 0 ) throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			else if (i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException sqle) {
			 new DAOException(TipoException.EXCEPCION_SQL);
		} 
	}

	@Override
	public void delete(Long key) throws DAOException {
		String sql = "DELETE FROM PELICULA WHERE ID = ?";
		
		try (PreparedStatement pstm = Singleton.getConnection().prepareStatement(sql)) {
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();
			if(i == 0) throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			else if(i > 1) throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
		} catch (SQLException  e) {
			throw new DAOException(TipoException.EXCEPCION_SQL);
		}
		
	}

}
