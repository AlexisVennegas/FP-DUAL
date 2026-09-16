package EjerciciosUnaryOperator;

import java.util.function.UnaryOperator;

public class p06 {
	
	// 6. Multiplicar por 7 un número usando UnaryOperator<Integer>.
		
	public static void main(String[] args) {
		UnaryOperator<Integer> multi = x -> x * 7;
		
		System.out.println(multi.apply(5));
	}
}
