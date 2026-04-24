package ejercicios;

import java.util.Arrays;
import java.util.List;

import files.Empleado;

public class p01 {
	
	
		//  1. Imprimir cada elemento de una lista de enteros
		public static void main(String[] args) {
		
			List<Empleado> empleados =Arrays.asList(
					new Empleado("SpongeBob","Krusty Krab","Bikini Bottom"),
					new Empleado("Michael Knight","Knight Industries","Stanford"),
					new Empleado("Clark Kent","Daily Planet","Metropolis"),
					new Empleado("Neil Peart","Music","Hamilton")
					);

			empleados.stream().distinct().forEach();
			
		}
}
