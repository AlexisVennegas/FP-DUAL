package Ejercicios;

import java.util.List;

public class p06 {
	
	static int total = 0;
	
	public static void main(String[] args) {
	
		//  6. Sumar todos los números de una lista
		List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9);
		int[] suma = { 0 }; 
		numeros.stream()
		.forEach(n -> { // intermedias 
			 total += n;
			suma[0] = suma[0] + n; 
		});
		
		System.out.println(total);
	}
}
