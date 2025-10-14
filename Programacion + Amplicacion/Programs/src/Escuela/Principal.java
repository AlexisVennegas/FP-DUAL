package Escuela;

public class Principal {
	public static void main(String[] args) {
		Asignatura 	primerAsignatura = new Asignatura(1);
		Asignatura 	segundaAsignatura = new Asignatura(2);
		Asignatura	terceraAsignatura = new Asignatura(3);	
		
		Alumno alexis = new Alumno(32, 23, 32);
		
		
		Profesor profe = new Profesor();
		
		profe.ponerNota(alexis);
		
		System.out.println("nota 1: " + alexis.getPrimera().getCalificacion());
		System.out.println("nota 2: " + alexis.getSegunda().getCalificacion());
		System.out.println("nota 3: " + alexis.getTercera().getCalificacion());
		
		System.out.println("media: " + profe.calcularMedia(alexis));
		
	}
}
