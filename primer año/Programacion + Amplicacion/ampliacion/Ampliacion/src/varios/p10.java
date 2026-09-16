package varios;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class p10 {
	public static void main(String[] args) {
		// 10. Crear una función lambda que devuelva el mayor de dos números.
//		Function<Integer, String> comFunction = num -> (num == 0) ? "cero" : (num > 0) ? "positivo" : "negativo"; 
		BiFunction<Integer, Integer, Integer> comMayor = (a, b) -> a > b ? a : b;
		
		
		System.out.println(comMayor.apply(10, 20));
	}
}
