package varios;

import java.util.function.Function;

public class p03 {
	public static void main(String[] args) {
		// 3. Crear una función lambda que devuelva el cuadrado de un número.

		Function<Integer, Integer> cuadradoFunction = x -> x * x;
		
		
		System.out.println(cuadradoFunction.apply(10));
		
	}
}
