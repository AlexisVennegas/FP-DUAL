package Ejercicios;

import java.util.List;
import java.util.Optional;

public class p33 {
	public static void main(String[] args) {
		//  33. Obtener el primer nombre que empiece con "M" en una lista
		
		List<String> nombres = List.of("Pedro", "Maria", "Martha");
		
		Optional<String> nombre = nombres.stream()
		.filter(n -> n.startsWith("M"))
		.findFirst();
		
		
		System.out.println(nombre.get());
		nombre.ifPresent(System.out::println);
	}
}
