package Ejercicios;

import java.util.List;

public class p29 {
	public static void main(String[] args) {
		// 29. Contar cuántos strings en una lista son palíndromos

		List<String> palabras = List.of("ana", "reconocer", "hola");

		long total = palabras.stream().filter(i -> {
			String rev = new StringBuilder(i).reverse().toString();
			return i.equalsIgnoreCase(rev);
		}).count();
		System.out.println(total);

	}
}
