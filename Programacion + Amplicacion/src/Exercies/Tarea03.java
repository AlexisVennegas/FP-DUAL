package Exercies;

import java.util.Scanner;

public class Tarea03 {
	public static void main(String[] args) {
		// > 0 par <0 o >10
		
		int valor; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("introduce un dato: ");
		
		valor = scanner.nextInt();
		
		if (valor < 0 && valor%2==0 || valor <0 || valor> 10)	System.out.println("es valido y es par");
		else 							System.out.println("es invalido y es par");
			
			
		scanner.close();
		
	}
}
