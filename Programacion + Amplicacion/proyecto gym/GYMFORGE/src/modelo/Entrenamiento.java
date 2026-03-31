package modelo;

import java.util.Date;

public class Entrenamiento {
	
	private Long id;
	private Long id_usuario;
	private Long id_rutina;
	private Date fecha_inicio;
	private Date fecha_fin;
	
	
	public Entrenamiento(Long id, Long id_usuario, Long id_rutina, Date fecha_inicio, Date fecha_fin) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.id_rutina = id_rutina;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getIdrutina() {
		return id_rutina;
	}

	public void setIdrutina(Long idrutina) {
		this.id_rutina = idrutina;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	@Override
	public String toString() {
		return "Entrenamiento [id=" + id + ", id_usuario=" + id_usuario + ", idrutina=" + id_rutina + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + "]";
	}
	
	
}
