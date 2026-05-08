package Ejercicios;

import java.util.List;

public class p40 {
	public static void main(String[] args) {
		//  40. Comprobar si todas las cadenas de una lista tienen al menos 3 caracteres

		List<String> palabras = List.of("Alexis", "Erick", "as");
		
		boolean prueba =	palabras.stream()
							.allMatch(n -> n.length() >= 3);
		
		
		System.out.println("todas las palabras son >= 3 ? " + prueba);
	}
}
