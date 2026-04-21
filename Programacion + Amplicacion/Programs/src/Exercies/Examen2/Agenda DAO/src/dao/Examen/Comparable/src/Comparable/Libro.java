package Comparable;

public class Libro implements Comparable<Libro> {
	// comparable es para ordenar

	private String titulo;
	private String autor;

	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	@Override
	public int compareTo(Libro otroLibro) {
		return this.titulo.compareTo(otroLibro.titulo);
	}

	@Override
	// esto es lo que haciamos de metodo generar datos
	public String toString() {
		return "Titulo --> " + titulo + ", autor --> " + autor;
	}
}