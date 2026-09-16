package Ejercicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class p43 {
	//  43. Convertir una lista de palabras a un conjunto eliminando duplicados
	public static void main(String[] args) {
		List<String> palabrasList = List.of("Alexis", "Venegas", "Venegas", "Erick");
		
		
        Set<String> palanbrasSet = new HashSet<>();
        
        palanbrasSet = palabrasList.stream()
        			.collect(Collectors.toSet());
        
        System.out.println(palanbrasSet);
        
        

	}
}
