package p18;

import java.util.Scanner;

public class Pares {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		int 		resultado = 0,
				i= 0;

		System.out.println("introduce 10 numeros");		
		while(i < 10) {
			int temporal = 0;
			temporal = scanner.nextInt();
			if(temporal % 2 == 0) {
				resultado += temporal;
			}
			i++;
		}
		System.out.println("resultado: " + resultado);
		scanner.close();
	}
}
