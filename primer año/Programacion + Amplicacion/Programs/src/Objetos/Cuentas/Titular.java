package Objetos.Cuentas;



public class Titular {
	private String nif;
	private String nombre;
	private String apellidos;
	private Fecha fechaNacimiento;

	

	public Titular(String nif, String nombre, String apellidos, Fecha fechaNacimiento) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String mostrar() {
		fechaNacimiento.mostrar();
		return "Titular [nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
}
