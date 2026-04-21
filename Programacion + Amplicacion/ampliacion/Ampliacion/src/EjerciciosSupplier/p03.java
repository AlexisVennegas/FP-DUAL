package EjerciciosSupplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class p03 {
	// 3. Generar un saludo aleatorio de una lista usando Supplier<String>.

		
	public static void main(String[] args) {
		List<String> listaSaludos = List.of("Hola", "Bienvenido", "Como estamos", "que tal");
		
		
	
		Supplier<String> generarSaludos = () -> listaSaludos.get((int) (Math.random() * listaSaludos.size()));
		
		System.out.println(generarSaludos.get());
		
		
		
	}
	
}
