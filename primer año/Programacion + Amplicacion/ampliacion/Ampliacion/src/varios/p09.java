package varios;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import p09.SumarDigitos;

public class p09 {
	public static void main(String[] args) {
		// 9. Crear una función lambda que determine si un número es positivo, negativo o cero.
		
		Predicate<Integer> comPredicate = num -> num >= 0;
		Function<Integer, String> comFunction = num -> (num == 0) ? "cero" : (num > 0) ? "positivo" : "negativo"; 
		

		
		System.out.println(comFunction.apply(-202));
	}	
}
