package Ejercicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class p20 {
	public static void main(String[] args) {
		//  20. Agregar los valores de un array a un conjunto utilizando forEachç
		
		String[] nombres  = {"Alexis", "Erick", "Venegas", "Alexis", "Gonzalez"};
		Set<String> nombresSet = new HashSet<>();
		Stream.of(nombres).forEach(n -> nombresSet.add(n));	
		System.out.println(nombresSet);
	}
}
