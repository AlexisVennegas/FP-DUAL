package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p36 {
	public static void main(String[] args) {
		//  36. Verificar si hay algún número mayor que 100 en una lista

		List<Integer> numeros = List.of(1,2,3,4,5,101, 200);
		
		Optional<Integer> numero = 	numeros.stream()
									.filter(n -> n > 100)
									.findAny();
		
		System.out.println(numero.get());
	}
}
