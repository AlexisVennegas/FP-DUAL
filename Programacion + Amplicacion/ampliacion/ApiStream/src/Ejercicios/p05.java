package Ejercicios;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class p05 {
	//  5. Agregar un sufijo a cada nombre en una lista
	public static void main(String[] args) {
		List<String> nombres = List.of("Alexis1", "Alexis2", "Alexis3");
		
		nombres.stream()
		.map(s -> "hola " + s)
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}
	
	
	
}
