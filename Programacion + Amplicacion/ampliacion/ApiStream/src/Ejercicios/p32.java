package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p32 {
	//  32. Encontrar cualquier número mayor que 50 en una lista
	public static void main(String[] args) {
		List<Integer> numeros = List.of(1,2,3,4,5,6,7,51,100);
		
		Optional<Integer> numero = 	numeros.stream()
									.filter(n -> n > 50)
									.findAny();
									
		numero.ifPresent(n -> System.out.println(n));
		System.out.println(numero.get());
	}
}
