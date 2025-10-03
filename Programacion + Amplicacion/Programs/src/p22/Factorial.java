package p22;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		
		
	
		long 		numero = 0,
				result = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
		while(numero <= 0) {
			System.out.println("mayor o igual a 0 introducelo otr vez");
			numero = scanner.nextInt();
		}
		
		for(int i = 1; i <= numero; i++) {
			System.out.print(i);
			result *= i;
			if(i < numero) System.out.print(" * ");
		}
		System.out.println(" resultado: " + result);
		scanner.close();
	}
}
