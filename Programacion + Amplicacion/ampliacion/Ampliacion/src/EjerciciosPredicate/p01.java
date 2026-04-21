package EjerciciosPredicate;


import java.util.function.Predicate;

public class p01 {
	public static void main(String[] args) {
		// 6. Verificar si un número es positivo
		
		Predicate<Integer> positivo = num -> num > 0;
		
		System.out.println(positivo.test(123));
	}
}
