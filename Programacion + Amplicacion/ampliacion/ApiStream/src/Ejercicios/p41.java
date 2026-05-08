package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;



public class p41 {
		//  41. Convertir una lista de strings en una sola cadena separada por comas (usar Collectors)
		public static void main(String[] args) {
			List<String> palabras = List.of("Erick", "Alexis", "Venegas", "Gonzalez");
			
			String palabraCOmpleta =	palabras.stream()
										.collect(Collectors.joining(","));
			
			System.out.println(palabraCOmpleta);
		}
}
