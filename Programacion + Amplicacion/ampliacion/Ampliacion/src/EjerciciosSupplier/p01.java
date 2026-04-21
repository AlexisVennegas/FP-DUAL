package EjerciciosSupplier;

import java.util.function.Supplier;

public class p01 {
	// 1. Generar un número aleatorio usando Supplier<Double>.

	public static void main(String[] args) {
		
		Supplier<Double> numeroRandom = () -> (Math.random() * 100);
		
		
	
		System.out.println(numeroRandom.get());
	}
}