package p13;

import java.util.Scanner;

public class Multiplicar {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numero,
			temporal = -1;
		
		while(true) {
			
			System.out.println("introduce un numero del 1 al 9");
			numero = scanner.nextInt();
			
			if(!(numero >= 0 && numero <= 9)) System.out.println("no esta en el rango");
			else {
				while(++temporal <= 10) 
					System.out.println(numero + " * " + temporal + " = " + numero * temporal);
				break;
				}
		}
		scanner.close();
	}
}
