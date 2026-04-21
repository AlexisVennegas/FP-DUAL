package varios;


import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class p01 {
	public static void main(String[] args) {
		// 1. Crear una función lambda que sume dos números enteros.
		
		BiFunction<Integer, Integer, Integer> sumarEnteros = (a,b) -> a + b;
		System.out.println(sumarEnteros.apply(10, 10));
		
		
		
	}
}
