package EjerciciosFunction;

import java.util.function.Function;

public class p03 {
	public static void main(String[] args) {
		// 3. Obtener la raíz cuadrada de un número
		Function<Integer, Double> raiz = Math::sqrt;
		
		System.out.println(raiz.apply(25));
		
	}
}
