package modelo;

public class Juego {
	private int idJuego;
	private String nombre;
	private String plataforma;
	private double precio;
	private int stock;

	public Juego(int idJuego, String nombre, String plataforma, double precio, int stock) {
		this.idJuego = idJuego;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
	}

	public Juego() {
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
