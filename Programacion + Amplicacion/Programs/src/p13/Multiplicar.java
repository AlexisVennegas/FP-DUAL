package p13;

import java.util.Scanner;

public class Multiplicar {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numero;
		
		
		System.out.println("introduce un numero");
		numero = scanner.nextInt();
		
		
		if(numero > 1) {
			for(int i = 1; i <= 9; i++) {
				System.out.println(numero + "*" + i + "= " + numero * i);
			}
		}
		else System.out.println("introduce un numero valido");
		
		scanner.close();
	}
}
