package superSayan;

import java.util.Scanner;

public class Fase3 {
	
	public static void imprimirEspacios(int cantidad) {
		while(cantidad > 0) {
			System.out.print(" ");
			cantidad--;
		}
	}
	public static void imprimirDerecha(int i) {
		int x = 2;
		while(x <= i) {
			System.out.print(x);
			x++;
		}
	}
	
	public static void ImprimirIzquierda(int i) {
		int x = i;
		while(x >= 1) {
			System.out.print(x);
			x--;
		}
	}
	
	public static void main(String[] args) {
		int 		 numero,
				 i,
				 j;
		Scanner scanner = new Scanner(System.in);
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
		j = numero - 1;
		i = 1;
		while(i <= numero) {
			imprimirEspacios(j);
			ImprimirIzquierda(i);
			imprimirDerecha(i);
			System.out.println(" ");
			i++;
			j--;
		}
		
		i = numero - 1;
		j = 1;
		while(i >= 1) {
			imprimirEspacios(j);
			ImprimirIzquierda(i);
			imprimirDerecha(i);
			System.out.println(" ");
			i--;
			j++;
			
		}

	}
}
