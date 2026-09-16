package Ejercicios;

import java.util.List;

public class p38 {
	public static void main(String[] args) {
		//  38. Determinar si ninguna palabra en una lista empieza con "Z"
		
		List<String> nombres = List.of("Alexis", "zoologico", "sooropa");
		
		boolean probar =  	nombres.stream()
							.noneMatch(n -> (n.toLowerCase().startsWith("z")));
		
		
		System.out.println(probar);
	}
}
