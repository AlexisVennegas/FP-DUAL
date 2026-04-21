package varios;

import java.lang.classfile.ClassTransform;
import java.util.function.Function;

public class p07 {
	public static void main(String[] args) {
		
		// 7. Crear una función lambda que devuelva el último caracter de una cadena.
		Function<String, Character> ultimoDigito = str -> str.charAt(str.length() - 1 );
		
		System.out.println(ultimoDigito.apply("probando"));
	}
}
