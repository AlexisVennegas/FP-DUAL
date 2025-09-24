package p17;

import java.util.ArrayList;
import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);

		int numeroTemporal = 0,
			suma = 0,
			resultado = 0,
			i = 0;
		
		System.out.println("Calculador de Media");
		System.out.println("introduce los numeros (maximo 50)");
		System.out.println("escribe fin para terminar de agregar");
		while(true) {				
			numeroTemporal = scanner.nextInt();
		    if (i == 50 || !scanner.hasNextInt()) break; 
		    suma += numeroTemporal;
			i++;
		}
		resultado = suma / i;
		System.out.println("resultado: " + resultado);

		
		
		
	
		
	}
	
}
