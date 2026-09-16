package Exercies;

import java.util.Scanner;

public class Multiplicar {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numero = 0;
		
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
		
		while(!(numero >= 1 && numero <= 9 )) {
			System.out.println("rango 1 - 9, vuelve  introducir: ");
			numero = scanner.nextInt();
		}
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " * " +  numero + " = " + numero * i);
		}
		
		scanner.close();
	
	}
}
