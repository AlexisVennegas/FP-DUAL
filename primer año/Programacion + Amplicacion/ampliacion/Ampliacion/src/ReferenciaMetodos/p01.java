package ReferenciaMetodos;

import java.util.function.Function;

public class p01 {
	public static void main(String[] args) {
		// 1. Crear una referencia a un método estático para obtener el valor absoluto de un número entero.
		
		Function<Integer, Integer> valorAbso =  Math::abs;
		
		System.out.println(valorAbso.apply(-5));
	}
}
