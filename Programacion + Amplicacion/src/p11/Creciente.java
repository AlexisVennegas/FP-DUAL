package p11;

import java.util.Scanner;

public class Creciente {
	public static void main(String[] args) {
		
		int numero1,
			numero2,
			numero3;
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("introduce el primer numero: ");
		numero1 = scanner.nextInt();
		
		System.out.println("introduce el segundo numero: ");
		numero2 = scanner.nextInt();
				
		System.out.println("introduce el tercer numero: ");
		numero3 = scanner.nextInt();
		
		if(numero1 < numero2 && numero2 < numero3)	System.out.println("orden creciente");
		else										System.out.println("no es orden creciente");
			
		
	}
}
