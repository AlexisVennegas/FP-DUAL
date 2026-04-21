package PatronDAO;

import java.sql.ResultSet;

public interface VideojuegoDAO {
	
	void insertar(Videojuego v);
	void leer(Videojuego v);
	void modificar(Videojuego v);
	void borrar(Videojuego v);

}
