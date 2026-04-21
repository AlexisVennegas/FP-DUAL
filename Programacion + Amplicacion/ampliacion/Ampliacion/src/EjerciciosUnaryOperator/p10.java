package EjerciciosUnaryOperator;

import java.util.function.UnaryOperator;

public class p10 {
	public static void main(String[] args) {
		// 10. Invertir el signo de un número usando UnaryOperator<Double>.
		
		UnaryOperator<Double> invertir = x -> x * -1;
		System.out.println(invertir.apply((double) -10));
	}
}
