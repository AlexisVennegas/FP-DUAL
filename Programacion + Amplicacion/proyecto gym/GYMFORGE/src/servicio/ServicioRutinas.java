package servicio;

import java.util.List;

import dao.EjercicioDaoImpl;
import dao.RutinaDaoImpl;
import dao.RutinaEjercicioDaoImpl;
import modelo.Ejercicio;
import modelo.Rutina;
import modelo.RutinaEjercicio;
import modelo.Usuario;

public class ServicioRutinas {
	RutinaDaoImpl r = new RutinaDaoImpl();
	RutinaEjercicioDaoImpl rj = new RutinaEjercicioDaoImpl();
	EjercicioDaoImpl ejercicioDaoImpl = new EjercicioDaoImpl();
	
	public Rutina rutinasTiene(Usuario u) {
		return r.findOne(u.getId());
	}
	
	public Rutina guardarRutina(String nameRutina, Usuario usuario) {
		
		Rutina rutina = new Rutina();
		rutina.setId_usuario(usuario.getId());
		rutina.setNombre(nameRutina);
		rutina.setObjetivo("");
		try {
			r.create(rutina);
			return rutina;
		} catch (Exception e) {
			return null;
		}
		
	}
	public List<Ejercicio> ejerciciosDeUnaRutina(Usuario usuario, Rutina rutina){
		System.out.println("lo mismo servicio pero de ejercicios de uan rutina " + usuario + rutina);
		return rj.mostrarEjerciciosDeUnaRutina(usuario, rutina);
	}
	
	
	
	public boolean GuardarEjerciosEnRutina(List<Ejercicio> listado, Usuario usuario, Rutina rutina) {
		
	
		for (Ejercicio ejercicio : listado) {
			RutinaEjercicio rutEjer = new RutinaEjercicio();
			rutEjer.setId_rutina(rutina.getId());
			rutEjer.setId_ejercicio(ejercicioDaoImpl.findByName(ejercicio.getNombre().toString()).getId());
			rutEjer.setOrden((long) 1);
			rutEjer.setId_usuario(usuario.getId());
			rj.create(rutEjer);
		}
		
		return false;
	}
	
	public List<Rutina> mostrarRutinas() {
		return r.findAll();
	}
	
	public List<Rutina> mostrarAllRutinasByUsuario(Usuario usuario){
		System.out.println("estoy en servicio" + usuario);
		return r.findAllByUsuario(usuario);
	}
	public void eliminarRutina(Usuario usuario, Rutina rutina) {
		r.deleteByData(usuario, rutina);
	}
}
