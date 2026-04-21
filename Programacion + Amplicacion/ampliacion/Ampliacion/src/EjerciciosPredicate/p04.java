package EjerciciosPredicate;

import java.util.function.Predicate;

public class p04 {
	public static void main(String[] args) {
		// 9. Verificar si una cadena tiene más de 5 caracteres
		Predicate<String> verificarCadena = str -> str.length() > 5;
		
		System.out.println(verificarCadena.test("hola"));
	}
}
