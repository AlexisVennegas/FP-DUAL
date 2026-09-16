package varios;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class p06 {
	public static void main(String[] args) {
		// 6. Crear una función lambda que concatene dos cadenas.

			BiFunction<String, String, String> unircadenas = (String cadena1, String cadena2) -> cadena1.concat(cadena2);
		
			
			System.out.println(unircadenas.apply("hola " , "como estas"));
	}
}
