package p20;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numero;
		int multiplo = 4;
		
		System.out.println("introduce un numero");
		numero = scanner.nextInt();
		if(numero % 4 != 0 ) {
			System.out.println("no es un multiplo de 4");
			return;
		}
		
		while(multiplo <= numero) {
			System.out.println(multiplo);
			multiplo += 4;
		}
	}
}
