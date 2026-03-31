package modelo;

public class Ejercicio {

	// ATRIBUTOS
	
	private Long id;
	private String nombre;
	private String grupo_muscular;
	private String descripcion;
	private String imagen;
	
	public Ejercicio() {
		super();
	}
	
	// CONSTRUCTOR
	public Ejercicio(String nombre, String grupo_muscular, String descripcion, String imagen) {
		super();
		this.nombre = nombre;
		this.grupo_muscular = grupo_muscular;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
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

	public String getGrupo_muscular() {
		return grupo_muscular;
	}

	public void setGrupo_muscular(String grupo_muscular) {
		this.grupo_muscular = grupo_muscular;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	// TO STRING
	
	@Override
	public String toString() {
		return "Ejercicio [id=" + id + ", nombre=" + nombre + ", grupo_muscular=" + grupo_muscular + ", descripcion="
				+ descripcion + ", imagen=" + imagen + "]";
	}
}
