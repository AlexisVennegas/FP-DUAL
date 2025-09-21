package p12;

import java.util.Scanner;

public class Numero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero;
		
		System.out.println("intruce un numero: ");
		numero = scanner.nextInt();
		
		if(numero >= 10 && numero <= 100) 	System.out.println("numero entre 10 y 100");
		else 								System.out.println("tu numero no esta entre 10 y 100");
		
		scanner.close();
	}
}
