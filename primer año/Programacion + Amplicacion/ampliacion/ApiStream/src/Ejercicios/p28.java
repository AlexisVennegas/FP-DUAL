	package Ejercicios;
	
	import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
	
	public class p28 {
		public static void main(String[] args) {
			List<Integer> numero = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
			// Usamos count() para contar cuántos cumplen la "función" de primo
	        long totalPrimos = numero.stream()
	                .filter(p28::esPrimo) // Llamamos a nuestra función
	                .count();

	        System.out.println("Total de primos: " + totalPrimos);
	    }

	    // Esta es la "función" usando rangeClosed
	    public static boolean esPrimo(int n) {
	        if (n < 2) return false;
	        
	        // rangeClosed crea los divisores y noneMatch verifica la condición
	        return IntStream.rangeClosed(2, (int) Math.sqrt(n))
	                        .noneMatch(d -> n % d == 0);
	 					
											
	 	}
	}
