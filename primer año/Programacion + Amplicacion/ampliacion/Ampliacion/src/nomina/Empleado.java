package nomina;

public class Empleado {
	private String nombre;
	private String departamento;
	private String ciudad;

	public Empleado(String nombre, String departamento, String ciudad) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", departamento=" + departamento + ", ciudad=" + ciudad + "]";
	}

}
