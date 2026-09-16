package varios;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class p02 {
	public static void main(String[] args) {
		// 2. Crear una función lambda que multiplique dos números.
		
		BiFunction<Integer, Integer, Integer> multBiFunction = (a, b) -> a * b;
		
		System.out.println(multBiFunction.apply(20, 20));
		
		
	}
}
