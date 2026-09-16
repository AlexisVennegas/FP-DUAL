package EjerciciosUnaryOperator;

import java.util.function.UnaryOperator;

public class p09 {
	//9. Reemplazar comas en una cadena por comillas dobles usando UnaryOperator<String>.

	public static void main(String[] args) {
		
		UnaryOperator<String> remplazarComas = x -> x.replace(',' , '"');
		
		System.out.println(remplazarComas.apply("hola,como,estamos"));
	}
}
