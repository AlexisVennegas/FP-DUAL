package Ejercicios;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class p27 {
	public static void main(String[] args) {
		//  27. Contar cuántos empleados ganan más de 3000 y almacenarlos en un Map
		
		 Map<String, Integer> empleados = new HashMap<>();

		 Map<Integer, Integer> empleadosCondicion = new HashMap<>();
		
		empleados.put("Alexis", 1000);
		empleados.put("Erick", 2000);
		empleados.put("Ana", 3500);
		
		empleados.values().stream()
		.filter(n -> n > 3000)
		.forEach(n -> empleadosCondicion.put(0, n)); 

		System.out.println(empleadosCondicion);
		
	}
}
