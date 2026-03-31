package src.servicio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import src.dao.ContactoDAO;
import src.modelo.Contacto;

public class ContactoServicio {
    private ContactoDAO dao;

    public ContactoServicio(ContactoDAO dao) { this.dao = dao; }

    public void registrarContacto(String nombre, String tel) {
        if (nombre.isEmpty() || tel.isEmpty()) throw new IllegalArgumentException("Todos los campos son obligatorios");
        if(!tel.matches("\\d{9}")) throw new IllegalArgumentException("Error campo numero");
    
        
        dao.guardar(new Contacto(nombre, tel));
    }

    public Contacto BuscarContacto(String nombre) {
    	if(nombre.isEmpty()) throw new IllegalArgumentException("Error nombre incorrecto o vacio");
    	Contacto contacto = dao.buscar(nombre);
    	return contacto;
    }
    public List<Contacto> MostrarTodo() {
    	return dao.mostrarTodo();
    }
    public int EliminarContacto(String nombre) {
    	 if (nombre.isEmpty()) {
             throw new IllegalArgumentException("Todos los campos son obligatorios");
         }
    	 int cambios = dao.eliminar(nombre);
    	 System.out.println(cambios);
         return cambios;
        
    }
    public int editarContacto(String nombre, String telefono) {
    	return dao.editar(nombre, telefono);
    }
   
}