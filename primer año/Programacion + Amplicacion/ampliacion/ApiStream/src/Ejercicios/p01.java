package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class p01 {

	public static void main(String[] args) {
		
		
		 // 1. Imprimir cada elemento de una lista de enteros

		List<Integer> numeros = new ArrayList<>();		
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		
		numeros.stream()
		.forEach(System.out::println);
		
	}
}
