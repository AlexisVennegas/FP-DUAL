package Ejercicios;

import java.util.List;

public class p10 {
	public static void main(String[] args) {	
		//  10. Contar el número de caracteres en una lista de palabras

		List<String> palabras = List.of("Hola", "como", "estas");
		
		int total  = 	palabras.stream()
						.mapToInt(String::length) // 
						.sum();
		
		System.out.println(total);
		
	}
}
