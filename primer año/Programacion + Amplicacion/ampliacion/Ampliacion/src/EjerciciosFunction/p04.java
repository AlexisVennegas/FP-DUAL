package EjerciciosFunction;

import java.util.function.Function;

public class p04 {
	public static void main(String[] args) {		
		// 4. Reemplazar espacios por guiones en una cadena
		Function<String, String> remplazar = str -> str.replace(" ", "-");
		
		
		System.out.println(remplazar.apply("hola como estamos"));
	}
}
