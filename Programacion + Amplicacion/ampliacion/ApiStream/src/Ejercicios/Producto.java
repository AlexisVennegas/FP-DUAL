package Ejercicios;

public class Producto {
	private String nombre;
	private int stock;
	private double precio;
	private String categoria;
	
	public Producto(String nombre, int stock, double precio, String categoria) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.categoria=categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + ", categoria=" + categoria
				+ "]";
	}
	
}