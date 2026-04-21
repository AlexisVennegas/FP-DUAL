package ReferenciaMetodos;

import java.util.function.Function;

public class p02 {
	public static void main(String[] args) {
		// 2. Definir una referencia a un método de instancia para convertir una cadena a mayúsculas.
		
		Function<String, String> converMayus = String::toUpperCase;
		
		System.out.println(converMayus.apply("hola"));
	}
}
