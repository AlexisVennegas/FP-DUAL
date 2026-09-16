package files;

public class Proveedor {
	private String ciudad;

	public Proveedor(String ciudad) {
		super();
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Proveedor [ciudad=" + ciudad + "]";
	}

}
