package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;

public class p22 {
	//  22. Determinar si todos los elementos de una lista son positivos
	public static void main(String[] args) {

		List<Integer> numeros = List.of(6,5,4,3,2,1,-1-2);
		
		boolean bool = numeros.stream().allMatch(n -> n > 0);
		
		System.out.println("son todos positivos" + bool);
	}
}
