package Escuela;

public class Profesor {

	public static void ponerNota(Alumno alumno) {
		alumno.getPrimera().setCalificacion(Math.round(Math.random() * 100) / 100.0);
		alumno.getSegunda().setCalificacion(Math.round(Math.random() * 100) / 100.0);
		alumno.getTercera().setCalificacion(Math.round(Math.random() * 100) / 100.0);		
	}
	
	public static double calcularMedia(Alumno alumno) {
		return (alumno.getPrimera().getCalificacion() +
		        alumno.getSegunda().getCalificacion() +
		        alumno.getTercera().getCalificacion()) / 3;
	}
}
