package modelo;

public class EntrenamientoEjercicio {
	
	private Long id;
	private Long id_entrenamiento;
	private Long id_ejercicio;
	private Double peso;
	private int repeticiones;
	
	public EntrenamientoEjercicio(Long id, Long id_entrenamiento, Long id_ejercicio, Double peso, int repeticiones) {
		super();
		this.id = id;
		this.id_entrenamiento = id_entrenamiento;
		this.id_ejercicio = id_ejercicio;
		this.peso = peso;
		this.repeticiones = repeticiones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_entrenamiento() {
		return id_entrenamiento;
	}

	public void setId_entrenamiento(Long id_entrenamiento) {
		this.id_entrenamiento = id_entrenamiento;
	}

	public Long getId_ejercicio() {
		return id_ejercicio;
	}

	public void setId_ejercicio(Long id_ejercicio) {
		this.id_ejercicio = id_ejercicio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	@Override
	public String toString() {
		return "entrenamientoEjercicio [id=" + id + ", id_entrenamiento=" + id_entrenamiento + ", id_ejercicio="
				+ id_ejercicio + ", peso=" + peso + ", repeticiones=" + repeticiones + "]";
	}
	
	
}
