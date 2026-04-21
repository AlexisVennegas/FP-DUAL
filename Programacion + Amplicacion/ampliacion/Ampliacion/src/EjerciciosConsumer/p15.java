package EjerciciosConsumer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class p15 {
	public static void main(String[] args) {
		// 15. Recorrer e imprimir una lista de números
		Consumer<List<Integer>> imprimirLista = numeros -> numeros.forEach(num -> System.out.println(num));
		
		List<Integer> numeros = new ArrayList<>();
		
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		
		imprimirLista.accept(numeros);
	}
}
