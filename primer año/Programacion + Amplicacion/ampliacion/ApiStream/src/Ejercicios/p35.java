package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p35 {
	public static void main(String[] args) {
		//  35. Encontrar el primer string con más de 5 caracteres
		
		List<String> palabras = List.of("Alex", "Alexis", "paranguacutirimicuaro");
		
		Optional<String> palabra =	palabras.stream()
									.filter(n -> n.length() > 5)
									.findFirst();
		
		palabra.ifPresent(System.out::println);
	}
}
