package servicio;

import java.util.List;

import dao.EjercicioDaoImpl;
import modelo.Ejercicio;

public class ServicioEjercicio {
	
	EjercicioDaoImpl ejercicioDaoImpl = new EjercicioDaoImpl();
	
	public  List<Ejercicio> mostrarEjercicios() {
		return ejercicioDaoImpl.findAll();
		
	}

	public Object guardar() {
		// TODO Auto-generated method stub
		return null;
	}
}
