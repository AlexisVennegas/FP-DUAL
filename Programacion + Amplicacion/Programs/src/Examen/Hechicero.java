package Examen;

public class Hechicero {

	private String id;
	private String nombre;
	private Pergamino pergamino;
	
	
	
	
	// CONST
	public Hechicero(String id, String nombre, Pergamino pergamino) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pergamino = pergamino;
	}
	
	
	// GETTERS AND SETTEERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pergamino getPergamino() {
		return pergamino;
	}
	public void setPergamino(Pergamino pergamino) {
		this.pergamino = pergamino;
	}
	
	
}
