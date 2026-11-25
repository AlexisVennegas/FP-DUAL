package controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Usuario;

public class UsuarioController {

	public String getUsuario(int id ) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session sesion = sessionFactory.openSession();
		Usuario usuario = null;
		try {
			sesion.beginTransaction();
			usuario = sesion.find(Usuario.class, id);
			
			sesion.getTransaction().commit();
			sesion.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario.toString();
	}
	
	
	public String updateUsuario(int id, String nombre, String apellido) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session sesion = sessionFactory.openSession();
		
		
		try {
			sesion.beginTransaction();
			Usuario usuario = sesion.find(Usuario.class, id);
			usuario.setNombre(nombre);
			usuario.setApellidos(apellido);
			sesion.merge(usuario);
			sesion.getTransaction().commit();
			sesion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Usuario modificado correctamente";
	}
	
	
	public String deleteUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session sesion = sessionFactory.openSession();
		
		
		try {
			sesion.beginTransaction();
			Usuario usuario = sesion.find(Usuario.class, id);
			if(usuario != null) {
				sesion.remove(usuario);
				sesion.getTransaction().commit();
				sesion.close();
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	
		return "Usuario eliminado correctamente";
	}
	
	
	public String createUsuario(String nombre, String apellidos, String ciudad) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Usuario.class).buildSessionFactory();
		
		Session sesion = sessionFactory.openSession();
		
		try {
			Usuario usuario = new Usuario(nombre, apellidos, ciudad);
			sesion.beginTransaction();
			sesion.persist(usuario);
			sesion.getTransaction().commit();
			sesion.close();
			
			//sesion.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "se ha creado el Usuario";
	}
	
}
