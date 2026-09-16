package Ejercicios;

import java.util.List;

public class p07 {
	static int total = 1;
	public static void main(String[] args) {
		//  7. Multiplicar todos los números de una lista y guardar el resultado en una variable
		List<Integer> numeros = List.of(2, 2, 2, 2);
		
		numeros.stream()
		.forEach(
		n -> {
			total *= n;
			System.out.println(n);
		});
		
		System.out.println(total);
	}
}
