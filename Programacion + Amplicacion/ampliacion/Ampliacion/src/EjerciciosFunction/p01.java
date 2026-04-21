package EjerciciosFunction;

import java.util.function.Function;

public class p01 {
	public static void main(String[] args) {
		
		// 1. Convertir un número a su representación en cadena
		Function<Integer, String> convertir = Object::toString;
		
		System.out.println(convertir.apply(12));
	}
}	
