package varios;

import java.util.function.Function;
import java.util.function.Predicate;

public class p15 {
	public static void main(String[] args) {
		// 15. Crear una función lambda que retorne true si un número es múltiplo de 3.

		Predicate<Integer> multiplo3 = num -> num % 3 == 0;
		
		Function<Integer, String> multiplo3Function = num -> num % 3 == 0 ? "multiplo 3" : "no es mulitplo";
		System.out.println(multiplo3.test(9));
		System.out.println(multiplo3Function.apply(15));
	}
}
