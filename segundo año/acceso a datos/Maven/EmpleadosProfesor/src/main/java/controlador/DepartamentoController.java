package controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Departamento;
import modelo.Empleado;

public class DepartamentoController {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Empleado.class)
			.addAnnotatedClass(Departamento.class)
			.buildSessionFactory();

	
	
	public void insertDepartamento(Departamento
			departamento) {
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();

            session.persist(departamento);

            session.getTransaction().commit();

            System.out.println("Departamento insertado correctamente");
		} catch (Exception e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}finally {
            session.close();
        }
		
	}

	
	public Departamento getDepartamento(int id) {
		Session session = sessionFactory.openSession();
		Departamento departamento = null;
		
		try {
			session.beginTransaction();
			departamento = session.find(Departamento.class, id);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departamento;
	}
	
	public void updateDepartamento(Departamento departamentoModificado) {
		Session session = sessionFactory.openSession();
		
		
		try {
			session.beginTransaction();
			session.merge(departamentoModificado);
			session.getTransaction().commit();
			System.out.println("Departamento actualizado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteDepartamento(int id) {
		Session session = sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
		    Departamento departamento= 	session.find(Departamento.class, id);
		    if(departamento != null)	session.remove(departamento);
		    else 					System.out.println("Departamento no encontrado");
		    session.getTransaction().commit();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
