package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p08 {
	public static void main(String[] args) {
		//  8. Encontrar el número mayor en una lista

		List<Integer> numeros = List.of(1,2,3,4,5,6);
		
		Optional<Integer> maximo = 	numeros.stream()
									.max(Integer::compare);
		
		System.out.println(maximo.get());
	}
}
