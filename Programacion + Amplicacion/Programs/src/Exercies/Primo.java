package Exercies;

import java.util.Scanner;

public class Primo {
	public static void main(String[] args) {
		int numero = 0;
		int resultado = 0;
		int resultado2 = 0;
	
		int j = 0;
		boolean esPrimo = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
	
		for(int i = 2; i <= Math.sqrt(numero); i++) {
			System.out.println(Math.sqrt(numero));
			if(numero% i == 0) {
				esPrimo = false;
				break;				
			}
		}
	
	if(esPrimo) System.out.println("es primo");
	else System.out.println("no es primo");

	}
	
}
