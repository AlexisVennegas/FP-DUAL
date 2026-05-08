package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p21 {
	public static void main(String[] args) {
		//  21. Calcular el máximo número par de una lista
		
		List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9);
		
		Optional<Integer> total =	numeros.stream()
					.filter(n -> n % 2 == 0)
					.max(Integer::compare);
		System.out.println(total);
	}
}
