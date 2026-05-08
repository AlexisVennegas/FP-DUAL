package Ejercicios;

public class Empleado {
	private int id;
	private String nombre;
	private double sueldo;
	private String departamento;
	private int antiguedad;
	
	public Empleado(int id, String nombre, double sueldo, String departamento, int antiguedad) {
		this.id= id;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
		this.antiguedad = antiguedad;
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

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + ", departamento=" + departamento
				+ ", antiguedad=" + antiguedad + "]";
	}
	
}
