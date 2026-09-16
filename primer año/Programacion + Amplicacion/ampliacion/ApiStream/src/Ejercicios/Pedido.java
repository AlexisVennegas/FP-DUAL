package Ejercicios;

import java.util.List;

public class Pedido {
	private List<Producto> productos;
	
	public Pedido(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Pedido [productos=" + productos + "]";
	}
	
}
	
	
