package p38;

import java.util.Scanner;

public class Total {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i = 0,
			numero,
			positivos = 0,
			negativos = 0,
			nulos = 0;
		System.out.println("introduce 100 numeros");
		
		for(; i < 100; i++) {
			numero = scanner.nextInt();
			
			if		(numero < 0 ) 	negativos++;
			else if 	(numero > 0 ) 	positivos++;
			else if  (numero == 0) 	nulos++;
		}
		System.out.println("total positivos: " + positivos);
		System.out.println("total negativos: " + negativos);
		System.out.println("total nulos: " + nulos);
	}
}
