package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class p16 {

	public static void main(String[] args) {
	//  16. Modificar los valores de una lista de enteros (multiplicar por 3 cada valor)
		List<Integer> numeros = List.of(1,2,3,4,5,6,7);
		
		List<Integer> resultados = numeros.stream()
		.map(n -> n * 3)
		.collect(Collectors.toList());
		
		System.out.println(resultados);
	
	}
}
