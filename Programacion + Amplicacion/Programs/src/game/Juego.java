package game;

import java.util.Scanner;

public class Juego {
	
	public static void bienvenida() {
		System.out.println("........................................");
		System.out.println("B I E N V E N U D O  ");
		System.out.println("TU NUMERO A ADIVINAR: # ");
		System.out.println("TIENES 7 INTENTOS D: ");

		System.out.print("\033[H\033[2J");  
		System.out.flush();
		System.out.println("........................................");
	}

	// un juego que el usuario tiene que adivinar un numero del 1 al 100
	// el usuario introduce un valor (12)
	// diciendole si es mayor o menor de el numero a advinar y asi hasta que lo 
	// adivine 
	// con un numero de intentos 7 
	
	public static void main(String[] args) {
		
		int numeroUsuario,
			intentos = 7,
			numeroAdivinar = (int) (Math.random() * 100) + 1;
		
		boolean ganador = false;
		
		Scanner scanner = new Scanner(System.in);
		
		bienvenida();
		
		
		System.out.println("(DEBUG) número a adivinar: " + numeroAdivinar);
		System.out.println("intentos: " + intentos);
	
		while(intentos >= 1 && !ganador) {
			System.out.println("--------------------------------");
			System.out.println("INTENTOS: " + intentos);
			System.out.println("INTRODUCE UN NUMERO: ");
			numeroUsuario = scanner.nextInt();
		
			
			if(numeroUsuario == numeroAdivinar) {
				System.out.println("🎉 HAZ GANADO");
				ganador = true;
			}
			else if(numeroUsuario < numeroAdivinar) 	System.out.println("EL NUMERO ES MAYOR :D");
			else if (numeroUsuario > numeroAdivinar) 	System.out.println("EL NUMERO ES MENOR :D");
			else  										System.out.println("VUELVE A INTENTARLO");
			intentos--;
			
		
		}
		if(!ganador) System.out.println("haz perdido 😭​");
		
		System.out.println("tu numero: " + numeroAdivinar);
		scanner.close();
	

	}
}
