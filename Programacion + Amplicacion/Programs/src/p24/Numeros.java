package p24;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		int numeroUno,
			numeroDos,
			i = 0;
			
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("introduce el primer numero: ");
		numeroUno = scanner.nextInt();
		System.out.println("introduce el segundo numero: ");
		numeroDos = scanner.nextInt();
		
		System.out.print(numeroUno + " * " + numeroDos + " = ");
		while(i < numeroDos) {
			System.out.print(numeroUno);
			if(i + 1 != numeroDos)	System.out.print(" + ");
			i++;
		}
	}
}
