package Exercies;

import java.util.Scanner;

public class NumeroMayor {
	public static void main(String[] args) {
		int numero = 0,
			menor;
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("introduce 50 numeros");
		menor = scanner.nextInt();

		for(int i = 0; i < 10; i++) {
			numero = scanner.nextInt();
			if(numero < menor) menor = numero; 
		}
		System.out.println("el menor numero es: " + menor);
	}
	
}
