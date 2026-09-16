package Ejercicios;

import java.util.List;

public class p04 {
	public static void main(String[] args) {
		//  4. Multiplicar cada número de una lista por 2 y mostrarlo

		List<Integer> numeros = List.of(1,2,3,4,5,6);
		
		numeros.stream()
		.forEach(n -> System.out.println(n * 2)); // terminal
	}
}
