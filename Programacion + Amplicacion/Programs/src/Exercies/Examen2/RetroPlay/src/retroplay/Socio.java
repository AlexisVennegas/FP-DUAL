package retroplay;

import java.io.*;

public class Socio implements Serializable {
	private String dni;
	private String nombreCompleto;
	private boolean suscripcionActiva;
	private int juegosAlquilados;
	
	public Socio(String dni, String nombreCompleto, boolean suscripcionActiva, int juegosAlquilados) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.suscripcionActiva = suscripcionActiva;
		this.juegosAlquilados = juegosAlquilados;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public boolean isSuscripcionActiva() {
		return suscripcionActiva;
	}

	public void setSuscripcionActiva(boolean suscripcionActiva) {
		this.suscripcionActiva = suscripcionActiva;
	}

	public int getJuegosAlquilados() {
		return juegosAlquilados;
	}

	public void setJuegosAlquilados(int juegosAlquilados) {
		this.juegosAlquilados = juegosAlquilados;
	}  
}
