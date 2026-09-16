package p28;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int 		divisor, 
				dividendo,
				cociente,
				resto,
				i = 0,
				temporal = 0,
				j = 0;
		
		boolean salir = false;
		
		System.out.println("introduce el divisor");
		divisor = scanner.nextInt();
		
		System.out.println("introduce el dividendo");
		dividendo = scanner.nextInt();
		
		//cociente = divisor / dividendo;
		
		while(!salir) {
			 temporal = dividendo * j;
			 if(temporal > divisor) {
				 j--;
				 salir = true;
			 }
			 else j++;
		}
		
		
		
		System.out.println("cociente: " + j);
		resto =	divisor - (dividendo * j);
		System.out.println("resto: " + resto );
		
		
		
	}
}
