package EjerciciosFunction;


import java.util.function.Function;

public class p05 {
	public static void main(String[] args) {
		// 5. Multiplicar un número por 2 y convertirlo en String
		Function<Integer, Integer> multiplicar = x -> x * 2;
		
		Function<Integer, String> convertirNumero2  = x -> x.toString();
		
		Function<Integer, String> unionFunciones = multiplicar.andThen(convertirNumero2);
		
		System.out.println(unionFunciones.apply(22));
		
		

	}
}
