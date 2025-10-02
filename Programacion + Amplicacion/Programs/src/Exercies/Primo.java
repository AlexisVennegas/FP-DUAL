package Exercies;

import java.util.Scanner;

public class Primo {
	public static void main(String[] args) {
		int numero = 0;
		int resultado = 0;
		int j = 1;
		boolean esPrimo = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
	
		while(j <= numero) {
			resultado = numero % j;
			System.out.println("j: " + j + " resultado: " + resultado);
			if(resultado == 0 && j != 1 && j != numero) {
				esPrimo = false;
			}
			j++;
		}

		if(esPrimo) System.out.println("es primo");
		else 		System.out.println("no es primo");

		scanner.close();
	}

}
