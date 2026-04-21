package EjerciciosUnaryOperator;

import java.util.Iterator;
import java.util.function.UnaryOperator;

public class p08 {
	// 8. Incrementar un número en 5 usando UnaryOperator<Integer>.

	
	public static void main(String[] args) {
		UnaryOperator<Integer> incrementar = x -> x + 5;
		for (int i = 0; i < 5; i++) {
			System.out.println(incrementar.apply(i));
		}
	}
}
