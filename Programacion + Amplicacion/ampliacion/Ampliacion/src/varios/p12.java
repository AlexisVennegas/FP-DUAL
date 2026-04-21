package varios;

import java.util.function.Function;

public class p12 {
	public static void main(String[] args) {
		// 12. Crear una función lambda que reemplace espacios en una cadena con guiones.
		Function<String, String> remplazarFunction = str -> str.replace(" ","-");
		
		System.out.println(remplazarFunction.apply("hola como estamos"));
	}
}
