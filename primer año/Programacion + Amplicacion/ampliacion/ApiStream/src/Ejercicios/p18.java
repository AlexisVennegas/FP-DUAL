package Ejercicios;

import java.util.HashMap;
import java.util.Map;

public class p18 {
	static int total = 0;
	public static void main(String[] args) {
		//  18. Sumar los valores de un Map y almacenarlos en una variable externa
		  Map<String, Integer> edades = new HashMap<>();
	        edades.put("Ana", 12);
	        edades.put("Juan", 12);
	        
	      edades.values().stream()
	      .forEach(n -> total += n);
	      
	      System.out.println(total);
	}
}
