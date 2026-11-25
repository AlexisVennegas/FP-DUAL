package controlador;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelo.Departamento;
import modelo.Empleado;


public class EmpleadoController {

	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Empleado.class)
			.addAnnotatedClass(Departamento.class)
			.buildSessionFactory();

	
	public void selectEmpleadoMasivo() {
		Session session = sessionFactory.openSession();
		try {
			String ENAME = "JAMES";
			String JOB = "CLERK";
			//String ape2 = "Gonzalez";
					
			
			Query query = session.createQuery("SELECT E FROM emp E WHERE ENAME=:ENAME "
			           + "AND JOB=:JOB", Empleado.class);
			
			query.setParameter("ename", ENAME);
			query.setParameter("job", JOB);
			
			List<Empleado> empleados = query.list();
			for(Empleado empleado : empleados) {
				System.out.println(empleado.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertEmpleado(Empleado empleado) {
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();

            session.persist(empleado);

            session.getTransaction().commit();

            System.out.println("Empleado insertado correctamente");
		} catch (Exception e) {
			  e.printStackTrace();
			  session.getTransaction().rollback();
		}finally {
            session.close();
        }
		
	}

	
	public Empleado getEmpleado(int id) {
		Session session = sessionFactory.openSession();
		Empleado empleado = null;
		
		try {
			session.beginTransaction();
			empleado = session.find(Empleado.class, id);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return empleado;
	}
	
	public void udpateEmpleado(Empleado empleadoModificado) {
		Session session = sessionFactory.openSession();
		
		
		try {
			session.beginTransaction();
			session.merge(empleadoModificado);
			session.getTransaction().commit();
			System.out.println("Empleado actualizado correctamente");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void deleteEmpleado(int id) {
		Session session = sessionFactory.openSession();
	    try {
	    	session.beginTransaction();
		    Empleado empleado = 	session.find(Empleado.class, id);
		    if(empleado != null)	session.remove(empleado);
		    else 					System.out.println("empleado no encontrado");
		    session.getTransaction().commit();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
