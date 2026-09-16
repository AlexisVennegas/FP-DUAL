package Ficheros;

import java.util.ArrayList;
import java.util.Iterator;

public class Expedientes implements Comparable<Expedientes>{
	
	private int numExpediente;
	private String nombre;
	private String apellidos;
	
	
	public Expedientes(int numExpediente, String nombre, String apellidos) {
		this.numExpediente = numExpediente;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}


	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		syso
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return "Expedientes [numExpediente=" + numExpediente + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	@Override
	public int compareTo(Expedientes numExpedienteAjeno) {
		return Integer.compare(this.numExpediente, numExpedienteAjeno.numExpediente);
		
	}
	

}
