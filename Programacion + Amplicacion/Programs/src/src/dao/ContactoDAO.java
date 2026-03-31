package src.dao;

import java.util.List;

import src.modelo.*;

public interface ContactoDAO {
    void guardar(Contacto c);    
    Contacto buscar(String nombre);
	List<Contacto> mostrarTodo() throws DAOException;
    int eliminar(String nombre);
    int editar(String nombre, String telefono);
}
