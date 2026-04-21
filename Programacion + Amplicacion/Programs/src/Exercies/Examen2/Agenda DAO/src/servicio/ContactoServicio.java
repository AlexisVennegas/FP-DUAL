package servicio;

import dao.ContactoDAO;
import modelo.Contacto;

public class ContactoServicio {
    private ContactoDAO dao;

    public ContactoServicio(ContactoDAO dao) { this.dao = dao; }

    public void registrarContacto(String nombre, String tel) {
        if (nombre.isEmpty() || tel.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        dao.guardar(new Contacto(nombre, tel));
    }

   
}