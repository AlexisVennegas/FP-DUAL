package EjerciciosPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class p05 {
	public static void main(String[] args) {
		// 10. Verificar si una lista está vacía
		
		Predicate<List<String>> vertificarLista = lista -> lista.isEmpty();
		
		List<String> lista = new ArrayList<>();
		

		System.out.println(lista.size());

		System.out.println(vertificarLista.test(lista));
	}
}
