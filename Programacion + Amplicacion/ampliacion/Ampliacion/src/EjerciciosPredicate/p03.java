package EjerciciosPredicate;

import java.util.function.Predicate;

public class p03 {
	public static void main(String[] args) {
			// 8. Verificar si un número es par
			
			Predicate<Integer> verificiarPar = num -> num % 2 == 0;
			
			System.out.println(verificiarPar.test(2));
			
			
				
	}
}
