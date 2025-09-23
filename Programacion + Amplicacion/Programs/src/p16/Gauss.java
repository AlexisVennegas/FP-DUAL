package p16;

import java.util.Scanner;




public class Gauss {
	
	public static int primerIntento() {
		
		int resultado,
			numero;
		
		
		numero = 0;
		resultado = 0;
		while(numero <= 1000) {
			resultado += numero;
			numero++;
		}
		
		return resultado;
	}

	
	public static int segundoIntento() {
		
		
		int resultado = 0;
		int numeroUno = 1000;
		int numeroDos = 1;
		
	    while (numeroUno > numeroDos) {
	        resultado += numeroUno + numeroDos;
	        numeroUno--;
	        numeroDos++;
	    }
		
		return resultado;
	}
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int resultado;
		
		
		resultado = segundoIntento();
	
		
		
		System.out.println("resultado: " + resultado);
	}
}
