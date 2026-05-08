package Ejercicios;

import java.util.List;

public class p14 {
	//  14. Contar cuántas palabras comienzan con una vocal

	public static void main(String[] args) {
		List<String> palabras = List.of("Alexis", "Erick", "Venegas", "Gonzalez");
		
		String vocales = "aeiouAEIOU";
		Long total =	palabras.stream()
					.filter(n -> n.toLowerCase().startsWith("a") || n.toLowerCase().startsWith("e") || n.toLowerCase().startsWith("i") || n.toLowerCase().startsWith("o") || n.toLowerCase().startsWith("u"))
					.count();
		
		System.out.println(total);
	}
}
