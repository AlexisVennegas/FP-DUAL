package EjerciciosConsumer;

import java.util.function.Consumer;

public class p14 {
	public static void main(String[] args) {
		
			// 14. Convertir una cadena a mayúsculas e imprimirla
			Consumer<String> convertirCadena = str -> System.out.println(str.toUpperCase());
			
			convertirCadena.accept("hola como estamos");
	}
}
