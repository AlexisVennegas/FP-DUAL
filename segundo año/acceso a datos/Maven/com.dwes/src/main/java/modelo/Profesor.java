package modelo;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="Profesor")
public class Profesor implements Serializable  {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="Id")
    private int id;
 
    @Column(name="nombre")
    private String nombre;
 
    @Column(name="ape1")
    private String ape1;
 
    @Column(name="ape2")    
    private String ape2;
 
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;
    
    public Profesor() {
	}

	public Profesor(int id, String nombre, String ape1, String ape2) {
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", direccion="
				+ direccion + "]";
	}
	
	
 } 
  
