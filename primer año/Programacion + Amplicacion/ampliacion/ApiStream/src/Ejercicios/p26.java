package Ejercicios;

import java.util.List;

public class p26 {
	public static void main(String[] args) {
		//  26. Contar cuántas cadenas contienen al menos un dígito

		List<String> palabras = List.of("Erick1", "Alexis2", "Venegas", "Gonzalez3");
		
		long total =	palabras.stream()
						.filter(n -> n.chars().anyMatch(Character::isDigit))
						.count();
		
		System.out.println(total);
	}
}
