package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p31 {
	public static void main(String[] args) {
		//  31. Encontrar el primer número par en una lista de enteros
		List<Integer> numeros = List.of(1,2,3,4,5,6,7);
		
		Optional<Integer> numero = numeros.stream()
		.filter(n -> n % 2 == 0)
		.findFirst();
		System.out.println(numero.get());
	}
}	
