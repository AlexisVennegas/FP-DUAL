package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class p19 {
	//  19. Reemplazar cada valor de una lista de enteros según una condición

	public static void main(String[] args) {
		List<Integer> numeros = List.of(1,2,3,4,5,6,7);
		
		List<Integer> result =	numeros.stream()
								.map(n -> n % 2 == 0 ? 999 : 0)
								.collect(Collectors.toList());
								
									
		System.out.println(result);
	}
}
