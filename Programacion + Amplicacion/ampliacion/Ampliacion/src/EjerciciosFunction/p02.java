package EjerciciosFunction;

import java.util.function.Function;

public class p02 {
	public static void main(String[] args) {
		// 2. Obtener la longitud de una cadena
			
		Function<String, Integer> obtenerLenght2 = String::length;
		
		System.out.println(obtenerLenght2.apply("hola"));
	}
}
