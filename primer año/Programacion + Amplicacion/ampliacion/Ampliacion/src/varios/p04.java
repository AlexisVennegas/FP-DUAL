package varios;

import java.util.function.Predicate;

public class p04 {
	public static void main(String[] args) {
		// 4. Crear una función lambda que determine si un número es impar.
		
		Predicate<Integer> isPar = a -> a % 2 == 0;
		System.out.println(isPar.test(10));
	}
}
