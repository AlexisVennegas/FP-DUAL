package Ejercicios;

import java.util.List;

public class p37 {
	public static void main(String[] args) {
		//  37. Comprobar si todos los elementos de una lista son pares	

		List<Integer> numeros = List.of(2,4,6,8,10, 11);
		
		boolean probar =	numeros.stream()
							.allMatch(n -> n % 2 == 0);
	
		System.out.println("todos los numeros son par? " + probar);
 	}
}
