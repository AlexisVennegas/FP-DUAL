package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p34 {
	public static void main(String[] args) {
		//  34. Buscar cualquier número negativo en una lista
		
		List<Integer> numeros = List.of(1,2,3,-4,5,6,-1,7,8,9);
		
		Optional<Integer> numerOptional =  numeros.stream()
		.filter(n -> n < 0)
		.findAny();
		
		System.out.println(numerOptional.get());
	}
}
