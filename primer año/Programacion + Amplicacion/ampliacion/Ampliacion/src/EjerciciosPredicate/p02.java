package EjerciciosPredicate;

import java.util.function.Predicate;

public class p02 {
	public static void main(String[] args) {
		// 7. Verificar si una cadena está vacía
		Predicate<String> verificarTamano = str -> str.length() <= 0;
		
		System.out.println(verificarTamano.test("   "));
	}
}
