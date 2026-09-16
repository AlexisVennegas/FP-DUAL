package p24;

import java.util.Scanner;

public class Numerosfor {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int 		numeroUno,
				numeroDos,
				resultado = 0,
				i;
		
		System.out.println("introduce el primer numero: ");
		numeroUno = scanner.nextInt();
		
		System.out.println("introduce el segundo numero: ");
		numeroDos = scanner.nextInt();
		
		System.out.print(numeroUno + " * " + numeroDos + " = ");
		
		for(i = 0; i < numeroDos; i++) {
			System.out.print(numeroUno);
			if(i + 1 != numeroDos)	System.out.print(" + ");
			resultado += numeroUno;
		}
		System.out.println("\nresultado: " + resultado);
	}
}
