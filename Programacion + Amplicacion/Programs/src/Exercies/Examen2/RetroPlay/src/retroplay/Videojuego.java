package retroplay;

public class Videojuego {
	private int idJuego;
	private String titulo;
	private String plataforma;
	private double precio;
	private int stock;
	
	public Videojuego(int idJuego, String titulo, String plataforma, double precio, int stock) {
		this.idJuego = idJuego;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
