package retroplay;

import java.sql.ResultSet;

public interface VideojuegoDAO {
	void insertar(Videojuego juego);
	ResultSet leer(Videojuego juego);
	void actualizar(Videojuego juego);
	void borrar(Videojuego juego); 

}
