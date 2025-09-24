package p16;

import java.util.Scanner;




public class Gauss {
	
	public static int primerIntento() {
		
		int resultado,
			numero;
		
		numero = 1;
		resultado = 0;
		while(numero <= 1000) {
			resultado += numero;
			System.out.println(resultado + " + " + numero + " = " + resultado);
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
		
		
		resultado = primerIntento();
	
		
		
		System.out.println("resultado: " + resultado);
		
		
	}
}
