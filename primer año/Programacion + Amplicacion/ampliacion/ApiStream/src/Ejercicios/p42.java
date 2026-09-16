package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class p42 {
	//  42. Filtrar los números mayores de 10 y almacenarlos en una nueva lista
	public static void main(String[] args) {
		List<Integer> numerosIntegers = List.of(8,9,10,11,12,13);
		
		List<Integer> nuevaLista =	numerosIntegers.stream()
									.filter(n -> n > 10)
									.collect(Collectors.toList());
		
		System.out.println(nuevaLista);
	}
}
