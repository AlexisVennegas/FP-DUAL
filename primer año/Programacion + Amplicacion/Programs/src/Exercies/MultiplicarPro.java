package Exercies;

import java.util.Scanner;

public class MultiplicarPro {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numero = 0,
			x;
		
		System.out.println("introduce un numero :");
		numero = scanner.nextInt();
		x = 1;
		System.out.println("--------------");
		
		
		while(numero < 1 || numero > 9) {
			System.out.println("rango 1 - 9 porfavor");
			numero = scanner.nextInt();
		}
		
		for(int i = 1; i <= numero; i++) {
			for(int j = 1; j <= 10; j++) {
				System.out.println(j + " * " + x + " = " + x * j);
			}
			x++;
			System.out.println("--------------");
		}
	}
}
