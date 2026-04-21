package varios;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class p14 {
	public static void main(String[] args) {
		// 14. Crear una función lambda que devuelva true si la suma de dos números es mayor que 100.
		BiPredicate<Integer, Integer> sumaBiPredicate = (a,b) -> a + b >= 100;
		
		System.out.println(sumaBiPredicate.test(20, 80));
	}
}	
