package Ejercicios;

import java.lang.ProcessHandle.Info;
import java.util.List;
import java.util.Optional;

public class p11 {
	public static void main(String[] args) {
		//  11. Contar cuántos elementos hay en una lista de números

		
		List<Integer> numeros = List.of(1,2,3,4,5,6,7);
		
		
		long total = numeros.stream().count();
		
		System.out.println(total);
		
	}
}
