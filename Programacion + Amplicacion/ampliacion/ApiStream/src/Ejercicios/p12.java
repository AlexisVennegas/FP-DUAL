package Ejercicios;

import java.util.List;

public class p12 {
	public static void main(String[] args) {
		//  12. Contar cuántos nombres tienen más de 4 letras
			
		List<String> nombres = List.of("Alexis", "Ana", "Alexis");
		
		Long total =	nombres.stream()
					.filter(n -> n.length() > 5)
					.mapToInt(String::length)
					.count();
		
		System.out.println(total);
	}
}
