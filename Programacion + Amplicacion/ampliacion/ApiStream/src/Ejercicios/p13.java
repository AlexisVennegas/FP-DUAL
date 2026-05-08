package Ejercicios;

import java.util.List;

public class p13 {
	public static void main(String[] args) {
		//  13. Contar cuántos números son mayores que 10
		List<Integer> numeros = List.of(11, 10,9,8,7,6,5, 10, 11, 12);
		
		Long total =	numeros.stream()
					.filter(n -> n > 10)
					.count();
		System.out.println(total);
		
	}
}
