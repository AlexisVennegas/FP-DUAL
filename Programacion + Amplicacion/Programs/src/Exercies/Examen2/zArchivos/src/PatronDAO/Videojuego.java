package PatronDAO;

public class Videojuego {

	private int id;
	private String titulo;
	private String plataforma;
	private Double precio;
	private int stock;
	
	public Videojuego(int id, String titulo, String plataforma, Double precio, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
