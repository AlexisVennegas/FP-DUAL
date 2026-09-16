package p60;

import java.util.Scanner;

public class Decena {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i,
			numero;
		
		for(i = 0; i < 10; i++) {
			System.out.println("introduce un numero: (1 - 49)");
			numero = scanner.nextInt();
			
			while(!(numero >= 1 && numero <= 49)) {
				System.out.println("rango incorrecto, intentalo de nuevo");
				numero = scanner.nextInt();
			}
			
			if		(numero >= 1 && numero <= 9) 		System.out.println("pertenece a la decena 1");
			else if	(numero >= 10 && numero <=  19) 	System.out.println("pertenece a la decena 2");
			else if 	(numero >= 20 && numero <= 29) 	System.out.println("pertenece a la decena 3");
			else if	(numero >= 30 && numero <= 39)	System.out.println("pertenece a la decena 4");
			else 											System.out.println("pertenece a la decena 5");
			
		}
	}
}
