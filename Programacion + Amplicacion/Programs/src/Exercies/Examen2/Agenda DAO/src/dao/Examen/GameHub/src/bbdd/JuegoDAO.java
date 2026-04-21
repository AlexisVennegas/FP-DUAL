package bbdd;

import java.sql.ResultSet;

import modelo.Juego;

public interface JuegoDAO {
	void insertar(Juego juego);
	ResultSet listar(Juego juego);
	void actualizar(Juego juego);
	void eliminar(Juego juego);

}
