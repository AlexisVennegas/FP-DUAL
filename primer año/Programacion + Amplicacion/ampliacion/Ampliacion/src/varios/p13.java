package varios;

import java.util.function.Function;
import java.util.function.Predicate;

public class p13 {
	public static void main(String[] args) {
		// 13. Crear una función lambda que verifique si una cadena contiene la palabra "Java".

		Predicate<String> verifiPredicate = str -> str.contains("Java");
		
		Function<String, String> veriFunction = str -> str.contains("Java") ? "si, si tiene" : "no, no tiene";
		
		System.out.println(verifiPredicate.test("hola bienvenudo a Java"));
		System.out.println(veriFunction.apply("hola bienvenudo a Java"));
	}
}
