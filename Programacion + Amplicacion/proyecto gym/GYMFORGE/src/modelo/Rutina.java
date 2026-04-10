package modelo;

public class Rutina  {
	
	
	// ATRIBUTOS
	
	private Long id;
	private String nombre;
	private String objetivo;
	private Long id_usuario;
	
	
	
	public Rutina() {
		super();
	}



	public Rutina(Long id, String nombre, String objetivo, Long id_usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.objetivo = objetivo;
		this.id_usuario = id_usuario;
	}



	public Long getId() {
		return this.id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getObjetivo() {
		return objetivo;
	}



	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}



	public Long getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}



	@Override
	public String toString() {
		return "Rutina [id=" + id + ", nombre=" + nombre + ", objetivo=" + objetivo + ", id_usuario=" + id_usuario
				+ "]";
	}
	
	
	
}
