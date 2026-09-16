package varios;

import java.util.function.Consumer;
import java.util.function.Function;

public class p11 {
	public static void main(String[] args) {
		// 11. Crear una función lambda que invierta una cadena.

			Function<String, String> inverFunction = str -> new StringBuilder(str).reverse().toString();
			
			System.out.println(inverFunction.apply("hola como estamos"));
	}
}
