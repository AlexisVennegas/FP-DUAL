package EjerciciosSupplier;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;

public class p02 {
	// 2. Obtener la fecha actual en formato LocalDate usando Supplier<LocalDate>.

	public static void main(String[] args) {
		Supplier<LocalDate> obtenerFecha = LocalDate::now;
		
		System.out.println(obtenerFecha.get());
	}
	
	
}
