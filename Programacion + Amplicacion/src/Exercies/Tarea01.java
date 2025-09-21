package Exercies;

import java.util.Scanner;

public class Tarea01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		
		int 	numeroUno,
				numeroDos;
		
		System.out.println("ingresa el primero numero: ");
		numeroUno = new Scanner(System.in).nextInt();
		System.out.println("ingresa el segundo numero: ");
		numeroDos = new Scanner(System.in).nextInt();
		
		if (numeroDos == numeroUno) 	System.out.println("ambos numeros son iguales");
		else if(numeroUno > numeroDos)  System.out.println("el primero es mayor");
		else  							System.out.println("el segundo es mayor");
		
		
	}
}	
