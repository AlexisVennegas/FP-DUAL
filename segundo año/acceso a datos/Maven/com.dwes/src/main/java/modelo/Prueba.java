package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Prueba {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Profesor.class)
				.addAnnotatedClass(Direccion.class)
				.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		try {
	        Direccion direccion=new Direccion(1, "C./Clara del Rey", 8, "Madrid", "Madrid");
	        Profesor profesor= new Profesor(1, "Luis", "Pérez", "Martín");
	        profesor.setDireccion(direccion);
	        
	        session.beginTransaction();
	        session.persist(profesor);
	        session.getTransaction().commit();
	        session.close();
		      
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


