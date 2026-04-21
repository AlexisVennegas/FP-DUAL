package EjerciciosSupplier;

import java.util.function.Supplier;

public class p04 {
	// 4. Devolver un nombre por defecto usando Supplier<String>.
		
	public static void main(String[] args) {
		
		Supplier<String> obtenerNombre = () -> "Invitado";
		
		
		System.out.println(obtenerNombre.get());
	}
}
