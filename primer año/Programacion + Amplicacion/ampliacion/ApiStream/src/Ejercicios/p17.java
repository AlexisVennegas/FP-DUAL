package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class p17 {
	//  17. Convertir una lista de nombres en sus iniciales y almacenarlas en otra lista

	public static void main(String[] args) {
		
		List<String> nombres = List.of("Alexis", "Erick", "Ian", "Oscar", "Ulises");
		
		List<Character> resultado =	nombres.stream()
									.map(n -> n.charAt(0))
									.collect(Collectors.toList());
		System.out.println(resultado);
	}
}
