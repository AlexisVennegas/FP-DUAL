package Exercies;

import java.util.Scanner;

public class ParesFor {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int 		numero = 0,
				result = 0;
		
		System.out.println("introduce 10 numeros: ");
		for(int i = 0; i < 10; i++) {
			numero = scanner.nextInt();
			if(numero % 2 == 0) result += numero;
		}
		System.out.println("resultado: " + result );
	}
}
