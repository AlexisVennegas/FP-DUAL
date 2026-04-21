package Comparable;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Libro> Libros = new ArrayList<>();

		Libros.add(new Libro("Libro1", "Autor1"));
		Libros.add(new Libro("Libro2", "Autor2"));
		Libros.add(new Libro("Libro3", "Autor3"));
		Libros.add(new Libro("Libro4", "Autor4"));

		Collections.sort(Libros);

		System.out.println("---Con esta línea obtengo un solo libro---");
		System.out.println(Libros.get(0));

		System.out.println("---Y con este bucle veo todos los libros---");
		// los dos puntos son "mirar dentro de (la lista)"
		// libritos funciona como variable temp de cada uno de los libros de la lista
		for (Libro libritos : Libros) {
			System.out.println(libritos);
		}
	}

}
