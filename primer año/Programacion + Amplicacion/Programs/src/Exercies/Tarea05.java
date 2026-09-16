package Exercies;

import java.util.Scanner;

public class Tarea05 {
	public static void main(String[] args) {
		
		
		int numero,
			numeroDos = 0,
			mayor = 0,
			i = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(i <= 10) {
			System.out.println("introduce el numero: " + i );
			numero = scanner.nextInt();
			
			if(numero > mayor) mayor = numero;
			System.out.println("\nnumero mayor: " + mayor + "\n");
			i++;
			
		}
	}
}



