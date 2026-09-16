package testLmbda;


import java.util.function.Function;
import java.util.function.Consumer;


public class Multiplo7 {
 public static void main(String[] args) {
	 
	 Consumer<String> imprimir = mensaje -> System.out.println("Mensaje: " + mensaje);
	 
	 imprimir.accept("Hola"); // Hola, mundo
 }
}