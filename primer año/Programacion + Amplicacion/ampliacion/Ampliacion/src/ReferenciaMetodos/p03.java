package ReferenciaMetodos;

import java.util.function.Function;

public class p03 {
	public static void main(String[] args) {
		// 3. Crear una referencia a un método de instancia para obtener la longitud de una cadena.

		Function<String, Integer> tamanoCadena = String::length;
		
		System.out.println(tamanoCadena.apply("hola como estamos"));
	}
}
