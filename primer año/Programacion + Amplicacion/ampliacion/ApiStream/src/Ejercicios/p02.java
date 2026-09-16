package Ejercicios;

import java.util.List;

public class p02 {
	public static void main(String[] args) {
		//  2. Imprimir cada nombre en mayúsculas en una lista de nombres
		
		List<String> nombres = List.of("Alexis", "Erick", "Kevin");
		
		
		// intermedias y terminal 
		
//		 Operaciones Intermedias
//		 ¿Qué hacen? Transforman el stream en otro stream (lo filtran, lo mapean, etc.) [2, 3].
//		 Regla de oro: Siempre devuelven un nuevo Stream y no ejecutan nada hasta que no llega una operación terminal (son perezosas) [2, 3].
//		 Ejemplos: .filter(), .map(), .sorted() [2, 3].
		
		
//		Operaciones Terminales
//		¿Qué hacen? Consumen el stream, cierran el flujo y producen un resultado final o un efecto secundario [2, 3].
//		Regla de oro: Devuelven un tipo concreto (como un int, un List, un Optional) o absolutamente nada (void) [2, 3]. Después de ellas, el stream muere y no se puede volver a usar [2].
//		Ejemplos: .forEach() (devuelve void), .collect(), .count(), .reduce() [2, 3].
		
//		
//		Un pipeline se compone de tres partes:
//			1.Fuente: lista.stream()
//			2.Operaciones intermedias: Devuelven un nuevo Stream (son "lazy", no se ejecutan hasta el
//			final).
//			3.Operación terminal: Cierra el stream y produce un resultado o efecto.
		
		
		nombres.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
	}
}
