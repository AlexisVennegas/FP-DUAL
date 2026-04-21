package EjerciciosUnaryOperator;

import java.util.function.UnaryOperator;

public class p07 {
	// 7. Duplicar una cadena usando UnaryOperator<String>.

	public static void main(String[] args) {
		UnaryOperator<String> duplicar = x -> x.repeat(2);
		
		System.out.println(duplicar.apply("hola"));
	}
}
