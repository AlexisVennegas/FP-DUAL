package Ejercicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class p23 {
	public static void main(String[] args) {
		//  23. Encontrar la palabra más larga en una lista de strings
			
		List<String> palabras = List.of("parangakutirimicuario", "hola233", "ADIOS");
		
		Optional<String> masLarga =	palabras.stream()
							.sorted(Comparator.reverseOrder())
							.findFirst();
							
							
		
		System.out.println(masLarga.toString());
		
	}
}
