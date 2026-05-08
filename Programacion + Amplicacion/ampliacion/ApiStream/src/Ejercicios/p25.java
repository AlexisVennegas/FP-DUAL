package Ejercicios;

import java.util.List;

public class p25 {
	//  25. Calcular el factorial de un número usando reduce

	public static void main(String[] args) {
		List<Integer> numeros = List.of(1,2,3,4,5);
		Integer aux =	numeros.stream()
						.reduce(1, (a,b) -> a * b);

		System.out.println(aux);
		
	}
}
