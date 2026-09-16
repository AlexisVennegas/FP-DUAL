package Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.PeliculaDaoImp;
import conexion.Singleton;
import modelo.Pelicula;

public class Util {
	
	PeliculaDaoImp peliculaDaoImp = new PeliculaDaoImp();

	public void conexionAndBBDD() {
		String sql = "";
		Connection conexion;
		Statement sentencia;
		
		conexion = Singleton.getConnection();
	
		
		
		try {
			 sentencia = conexion.createStatement();
			 sql = "DROP DATABASE IF EXISTS peliculas;";
			 sentencia.executeUpdate(sql);
			 sql="CREATE DATABASE peliculas;";
				sentencia.executeUpdate(sql);
				sql="USE peliculas;";
				sentencia.executeUpdate(sql);
				sql="CREATE TABLE pelicula ("
						+ "id INT PRIMARY KEY AUTO_INCREMENT,"
						+ "titulo VARCHAR(200) NOT NULL,"
						+ "ano INT NOT NULL"
						+ ");";
				sentencia.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void crearElementos(String titulo, int ano) {
	
		Pelicula peli = new Pelicula((long) 2, titulo, ano);
		peliculaDaoImp.create(peli);
		
	}
	public void eliminarPorAno(int antes, int despues) {
		
		List<Pelicula> peliculas = new ArrayList<>();
	
		peliculas = peliculaDaoImp.findAll();
		
		for (Pelicula p : peliculas) {
			if(p.getAno() > antes && p.getAno() < despues) {
				peliculaDaoImp.delete(p.getId());
			}
		}
	}
	public void mostrarPeliculas() {
		List<Pelicula> peliculas = new ArrayList<>();
		
		peliculas = peliculaDaoImp.findAll();
		
		for (Pelicula p : peliculas) {
			System.out.println(p);
		}
	}
	public void modificarPelicula(String titulo) {
		peliculaDaoImp.update(peliculaDaoImp.findOneByTitle(titulo));
	}
}
