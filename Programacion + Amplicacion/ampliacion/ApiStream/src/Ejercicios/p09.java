package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class p09 {
	public static void main(String[] args) {
		//  9. Concatenar una lista de palabras en una sola cadena

		List<Character> caracteres = List.of('a', 'l', 'e', 'x', 'i', 'z');
	
		
		String resultado = 	caracteres.stream()
							.map(String::valueOf) // intermedia 
							.collect(Collectors.joining(",")); 
		
		System.out.println(resultado);
		
			
	}
}
