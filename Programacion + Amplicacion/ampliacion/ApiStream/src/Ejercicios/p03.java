package Ejercicios;

import java.util.List;

public class p03 {
	static int total = 0;
	
	public static void main(String[] args) {
		 // 3. Sumar todos los elementos de una lista dentro del forEach

		List<Integer> numeros = List.of(1,2,3,4,5,6);
		int[] suma = { 0 }; 
 
		
		
		 numeros.stream()
	
		 .forEach(n -> { // intermedias 
			 total += n;
			suma[0] = suma[0] + n; 
		});
		
		
		 System.out.println(total);
		 System.out.println(suma[0]);
	
				 		
	}
	
}
