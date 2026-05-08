package Ejercicios;

import java.util.Arrays;
import java.util.List;

public class p30 {
	public static void main(String[] args) {
		// 30. Contar cuántos números en un array cumplen una condición específica (múltiplos de 5 y
		// mayores que 10)
		
		List<Integer> numeros = Arrays.asList(1,2,3,4, 15, 20);
		
		long total =	numeros.stream()
						.filter(n -> n > 10 && n % 5 == 0)
						.count();
						
		System.out.println(total);
						
		
	}
}
