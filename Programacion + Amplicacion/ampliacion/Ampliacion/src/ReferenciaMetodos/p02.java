package ReferenciaMetodos;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class p02 {
	public static void main(String[] args) {
		// 2. Definir una referencia a un método de instancia para convertir una cadena a mayúsculas.
		
		Function<String, String> converMayus = String::toUpperCase;
		UnaryOperator<String> convertirMayus2 = String::toUpperCase;
		
		System.out.println(converMayus.apply("hola"));
		String holaString = convertirMayus2.apply("hola");
		System.out.println(holaString);
	}
}
