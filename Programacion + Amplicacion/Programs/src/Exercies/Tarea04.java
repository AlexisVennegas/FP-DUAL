package Exercies;

import java.util.Scanner;

public class Tarea04 {
	//Una discoteca tiene las siguientes reglas para permitir la entrada:
		//La persona debe tener 18 años o más.
		//Pueden entrar a la discoteca personas de 17 años, solo si es viernes y vienen acompañado de un adulto.
		// Como segurata, usa el programa para saber si las personas pueden entrar o no.
	

		
		public static void main(String[] args) {
			
			int 	edad;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("ingresa tu edad: ");
			edad = scanner.nextInt();
			
			if (edad == 17) {
				System.out.println("ingresa el dia: ");
				if(scanner.next().toLowerCase().equals("viernes")) {		
					System.out.println("vienes con algun padre?");
					if(scanner.next().toLowerCase().equals("si")) 	System.out.println("puedes entrar");
					else 											System.out.println("no puedes entrar");
				}
  			}
			else System.out.println("puedes entrar");
		}
}
