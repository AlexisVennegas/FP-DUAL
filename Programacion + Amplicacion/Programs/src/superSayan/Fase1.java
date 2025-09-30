package superSayan;

import java.util.Scanner;

public class Fase1 {
	
public static void imprimirEspacios(int cantidad) {
		
		while(cantidad != 0) {
			System.out.print(" ");
			cantidad--;
		}
	}
	public static void main(String[] args) {
		int 		numero,
				i,
				j;
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
		j = numero;
		i = 1;
		while(i <= numero) {
			int x = 1;
			imprimirEspacios(j - 1);
			while(x <= i) {
				System.out.print(x);
				x++;
			}
			System.out.println();
		
			i++;
			j--;
		}
	}
}
