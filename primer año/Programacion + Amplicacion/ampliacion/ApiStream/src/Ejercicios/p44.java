	package Ejercicios;
	
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	import java.util.TreeMap;
	import java.util.TreeSet;
	import java.util.stream.Collectors;
	
	public class p44 {
		public static void main(String[] args) {
			//  44. Agrupar una lista de personas por edad (usar groupingBy)
			
			Map<Integer, List<Persona>> mapaPersonas;
	
			
	
			 
			 List<Persona> listaPersonas = List.of(new Persona("Mateo", 24), new Persona("Clara", 40), new Persona("Adrian", 29), new Persona("Diego", 67));

	
			 mapaPersonas = listaPersonas.stream()
						.collect(Collectors.groupingBy(Persona::getEdad));
			
			 System.out.println(mapaPersonas.toString());
			
			
	
		}
	}
