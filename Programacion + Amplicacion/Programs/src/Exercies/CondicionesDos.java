package Exercies;

import java.util.Scanner;

public class CondicionesDos {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numero = 0; 
		
		
		System.out.println("introduce un valor");
		numero = scanner.nextInt();
		
		if ((numero >= 1 && numero <= 10) || (numero >= 90 && numero <= 100)) 
			System.out.println("el numero esta entre los rangos 1-0 o 90-100");
		else							
			System.out.println("el numero no esta en los rangos 1-0 90-100");
		
		scanner.close();
		
		// tarea Ejercicio 1 pedir dos numeros por teclado y el pgorama muestra el primero es menor que el segundo 
		// el son iguales	
		
		
		// ejercicio 6
		
		// nos inventamos un ejercicio que use and or ||
	}
}
