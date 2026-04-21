package varios;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class p05 {
	public static void main(String[] args) {
		// 5.- Crear una función lambda que convierta una cadena a mayúsculas.
		UnaryOperator<String> uppercadena = str -> str.toUpperCase();
		
		System.out.println(uppercadena.apply("hola"));
	}	
}		
