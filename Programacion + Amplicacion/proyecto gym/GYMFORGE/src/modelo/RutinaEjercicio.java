package modelo;

public class RutinaEjercicio {
	
	private Long id;
	private Long id_rutina;
	private Long id_ejercicio;
	private Long orden;
	
	private String nombreEjercicio;
    private String grupoMuscular;   
    private Long id_usuario;
	
	
	public RutinaEjercicio(Long id, Long id_rutina, Long id_ejercicio, Long orden, String nombreEjercicio, Long id_usuario) {
		super();
		this.id = id;
		this.id_rutina = id_rutina;
		this.id_ejercicio = id_ejercicio;
		this.orden = orden;
		this.nombreEjercicio = nombreEjercicio;
		this.id_usuario = id_usuario;
	}
	public Long getId_usuario() {
		return this.id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	public RutinaEjercicio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_rutina() {
		return id_rutina;
	}

	public void setId_rutina(Long id_rutina) {
		this.id_rutina = id_rutina;
	}

	public Long getId_ejercicio() {
		return id_ejercicio;
	}

	public void setId_ejercicio(Long id_ejercicio) {
		this.id_ejercicio = id_ejercicio;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public String getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(String grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
	

	public String getNombreEjercicio() {
		return nombreEjercicio;
	}

	public void setNombreEjercicio(String nombreEjercicio) {
		this.nombreEjercicio = nombreEjercicio;
	}

	@Override
	public String toString() {
		return "RutinaEjercicio [id=" + id + ", id_rutina=" + id_rutina + ", id_ejercicio=" + id_ejercicio + ", orden="
				+ orden + "]";
	}
	
	
}
