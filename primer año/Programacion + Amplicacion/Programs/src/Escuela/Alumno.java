package Escuela;

public class Alumno {
	
	private Asignatura primera;
	private Asignatura segunda;
	private Asignatura tercera;
	
	public Alumno(Asignatura primera, Asignatura segunda, Asignatura tercera) {
		this.primera = primera;
		this.segunda = segunda;
		this.tercera = tercera;
	}
	
	public Alumno(int primera, int segunda, int tercera) {
		super();
		this.primera = new Asignatura(primera);
		this.segunda = new Asignatura(segunda);
		this.tercera = new Asignatura(tercera);
		
	}

	
	
	
	
	
	
	// GETTER AND SETTER
	public Asignatura getPrimera() {
		return primera;
	}
	public void setPrimera(Asignatura primera) {
		this.primera = primera;
	}
	public Asignatura getSegunda() {
		return segunda;
	}
	public void setSegunda(Asignatura segunda) {
		this.segunda = segunda;
	}
	public Asignatura getTercera() {
		return tercera;
	}
	public void setTercera(Asignatura tercera) {
		this.tercera = tercera;
	}
}
