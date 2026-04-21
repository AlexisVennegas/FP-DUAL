package modelo;

public class Pelicula {
	private Long id;
	private String titulo;
	private int ano;

	public Pelicula() {
		super();
		
	}
	public Pelicula(Long id, String titulo, int ano) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", ano=" + ano + "]";
	}
	
	
}
