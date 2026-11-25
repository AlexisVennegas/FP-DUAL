package vista;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controlador.UsuarioController;
import org.hibernate.query.*;
import modelo.Direccion;
import modelo.Profesor;
import modelo.Usuario;

public class Operaciones {
	
	
	public static void prueba2() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
			
		
		Session session = sessionFactory.openSession();
		
		
		try {
			Query query = session.createQuery("SELECT p FROM Profesor p", Profesor.class);
			List<Profesor> resultado = query.list();
			for(Profesor profesor : resultado) {
				System.out.println(profesor.toString());
			}
			
			
			Query query2 = session.createQuery("SELECT p.id , p.nombre FROM Profesor p", Object[].class);
			List<Object[]> listaDatos = query2.list();
			for(Object[] datos : listaDatos) {
				System.out.println(datos[0] + " || " + datos[1]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void prueba1() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
			
		
		Session session = sessionFactory.openSession();
		
		
		try {
			Query query = session.createQuery("SELECT p FROM Profesor p", Profesor.class);
			List<Profesor> resultado = query.list();
			for(Profesor profesor : resultado) {
				System.out.println(profesor.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void prueba3() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
			
		
		Session session = sessionFactory.openSession();
		try {
			SelectionQuery<Object[]> query = session.createSelectionQuery("SELECT p.id, p.nombre FROM Profesor p", Object[].class);
			List<Object[]> listadosList = query.getResultList();
			
			for(Object[] fila : listadosList){
				Integer id = (Integer) fila[0];
				String nombre = (String) fila[1];
				System.out.println(id + "--" + nombre);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public static void prueba4() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
			
		
		Session session = sessionFactory.openSession();
		try {
			Profesor profesor = (Profesor) session.createQuery("SELECT p FROM Profesor p WHERE id = 7", Profesor.class).uniqueResult();
			if(profesor != null) System.out.println(profesor.toString());
			else System.out.println("no hay profes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void anotherPrueba() {
		//System.out.println(new UsuarioController().createUsuario("Erick", "Gonzalez", "España"));
		//System.out.println(new UsuarioController().getUsuario(5));
	//	System.out.println(new UsuarioController().updateUsuario(4, "Erick", "Gonzalez"));
	//	System.out.println(new UsuarioController().deleteUsuario(4));
		
	}
	public static void prueba5() {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
	            .addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Query<Profesor> query = session.createNamedQuery("mostrarTodosProfesores", Profesor.class);
			List<Profesor> profesores = query.list();
			for (Profesor profesor : profesores) {
				System.out.println(profesor.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
				
	}
	
	public static void main(String[] args) {
	
		prueba5();
	}
	
	
}	
