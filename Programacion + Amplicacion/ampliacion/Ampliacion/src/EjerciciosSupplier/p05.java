package EjerciciosSupplier;

import java.util.UUID;
import java.util.function.Supplier;

public class p05 {
	// 5. Producir un identificador único usando Supplier<UUID>.

	
		public static void main(String[] args) {
			
			Supplier<UUID> obtenerId = UUID::randomUUID;
			
			System.out.println(obtenerId.get());
		}
		
		
		
		
}
