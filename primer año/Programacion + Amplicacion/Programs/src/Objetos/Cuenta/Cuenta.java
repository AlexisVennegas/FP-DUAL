package Objetos.Cuenta;

public class Cuenta {
	
	// ATRIBUTOS
	private int id;
	private double cantidad;

	// CONSTRUCTOR
	public Cuenta(int id) {
		this.id = id;
		this.cantidad = 0.0;
	}

	// METODOS PROPIOS	
	public void mostrar() {
		System.out.println("datos:");
		System.out.println("id: " + id);
		System.out.println("cantidad: " + cantidad );
	}
	public void ingresar(double cantidad) {
		if(cantidad > 0) this.cantidad += cantidad;
	}
	public void retirar(int cantidad) {
		this.cantidad -= cantidad;
	}
	
	
	// GETTER AND SETTER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCantidad() {
		return cantidad;
	}
	
	
}
