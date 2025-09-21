package Exercies;

import java.util.Scanner;

public class Condicionales {
	public static void main(String[] args) {
				
		int numero;
		

		Scanner scanner = new Scanner(System.in);
		System.out.println("ingresa un numero");
		numero = scanner.nextInt();
		
		if(numero > 10) {
			System.out.println("tu numero es mayor que 10");
			if(numero%2==0) System.out.println("es par");
			else System.out.println("Es impar");
		}
		else  System.out.println("tu numero no es mayor que 10");
		
	
		
		scanner.close();
	}
}
