package Ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

public class p39 {
	public static void main(String[] args) {
		//  39. Verificar si alguna persona en una lista tiene más de 30 años
		
	HashMap<String, Integer> personas = new HashMap<>();
	
		personas.put("Alexis", 30);
		personas.put("Erick", 50);
		personas.put("Alina", 15);
		
		boolean persona =  personas.values().stream()
		.anyMatch(n -> n > 30);
	}
}
