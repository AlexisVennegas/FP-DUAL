package Ejercicios;

import java.util.List;

public class p15 {
	public static void main(String[] args) {
		//  15. Contar cuántos números son pares en una lista
		List<Integer> numeros = List.of(1,2,3, 4, 5,6,7,8);
		
		Long total = numeros.stream()
					.filter(n -> n % 2 == 0)
					.count();
		
		System.out.println(total);
		
	}
}
