package EjerciciosConsumer;

import java.util.function.Consumer;

public class p11 {
	public static void main(String[] args) {
		// 11. Imprimir un mensaje en la consola
		Consumer<String> mostrarMensaje =  mensaje -> System.out.println(mensaje);
		
		mostrarMensaje.accept("hola");
	}
}
