package Ejercicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class p24 {
	public static void main(String[] args) {
		//  24. Concatenar solo las palabras que tengan más de 4 letras
		
		List<String> palabras = List.of("Erick", "Ana", "Alexis", "Venegas", "Gonzalez");
		
		String palabrasCon =	palabras.stream()
									.filter(n -> n.length() > 4)
									.collect(Collectors.joining(" "));
									
		System.out.println(palabrasCon);			
	}
}
