package modelo;

import java.sql.Date;

public class HistorialPeso {
	private Long id;
	private Long id_usuario;
	private Double peso;
	private Date fecha;
	
	public HistorialPeso(Long id, Long id_usuario, Double peso, Date fecha) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.peso = peso;
		this.fecha = fecha;
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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
