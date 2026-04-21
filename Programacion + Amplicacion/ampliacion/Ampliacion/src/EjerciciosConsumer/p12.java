package EjerciciosConsumer;

import java.util.function.Consumer;

public class p12 {
	public static void main(String[] args) {
		//12. Multiplicar un número por 2 e imprimirlo
		Consumer<Integer> numeroConsumer = num -> System.out.println(num * 2);
		
		numeroConsumer.accept(2);
	}
	
}
