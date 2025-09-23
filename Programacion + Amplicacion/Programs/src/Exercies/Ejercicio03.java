package Exercies;

import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		
		int numero,
			opcion,
			resultado;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("1-. cuadrado del numero");
			System.out.println("2.- raiz cuadrada");
			System.out.println("3.- valor absoluto");
			System.out.println("4.- es multiplo de 3");
			System.out.println("5.- salir");
			System.out.println("------------------------");
			System.out.println("introduce un numero que quieras modificar");
			numero = scanner.nextInt();
			
			System.out.println("introduce una opcion");
			opcion = scanner.nextInt();
			switch (opcion) {
			case 1: {
				resultado = numero * numero;
				System.out.println("resultado: " + resultado);
				break;
			}
			case 2: {
				resultado = (int) Math.sqrt(numero);
				System.out.println("resultado : " + resultado);
				break;
			}
			case 3: {
				resultado = Math.abs(numero);
				System.out.println("resultado : " + resultado);
				break;
			}
			case 4: {
				int temporal = numero % 3;
				if(temporal == 0) 	System.out.println("multiplo de 3");
				else 				System.out.println("no es multiplo de 3");
				break;
			}
			case 5: {
				System.out.println("hasta luego");
				return;
			}
			default:
				System.out.println("opcion no valida");
				break;
			}
			
		}
	}
}
