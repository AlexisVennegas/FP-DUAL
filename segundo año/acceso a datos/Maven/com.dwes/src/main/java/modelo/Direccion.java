package modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion implements Serializable {

	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="poblacion")
	private String poblacion;
	
	@Column(name="provincia")
	private String provincia;

	
	public Direccion() {
	}
	public Direccion(int id, String calle, int numero, String poblacion, String provincia) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion
				+ ", provincia=" + provincia + "]";
	}
	
	
	
	
}
