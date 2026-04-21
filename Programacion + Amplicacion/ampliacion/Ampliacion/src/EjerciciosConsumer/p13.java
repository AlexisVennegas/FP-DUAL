package EjerciciosConsumer;

import java.util.function.Consumer;

public class p13 {
	public static void main(String[] args) {
		// 13. Imprimir la longitud de una cadena

		
		Consumer<String> imprimirLong = str -> System.out.println(str.length());
		
		
		imprimirLong.accept("123123123123");
				
				
	}
}
