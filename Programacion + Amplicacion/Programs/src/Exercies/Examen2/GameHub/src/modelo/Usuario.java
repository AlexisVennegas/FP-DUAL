package modelo;

import java.io.*;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private boolean activo;
	private int alquileres;

	public Usuario(String dni, String nombre, boolean activo, int alquileres) {
		this.dni = dni;
		this.nombre = nombre;
		this.activo = activo;
		this.alquileres = alquileres;
	}

	public Usuario() {
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(int alquileres) {
		this.alquileres = alquileres;
	}

}
