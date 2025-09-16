import java.util.Scanner;

public class PrimerMundo {
	public static void main(String[] args) {
		
		// Declaro las variables de tipo int 
		int	 numeroEntero, 
			 numeroEntero2;
		byte numeroPequeno;
		long numeroGrande;
		char caracter, 
			 letra;
		boolean estadoActivo;
		
		
		numeroEntero = 7;
		numeroEntero2 = 10;
		numeroGrande = 1000;
		numeroPequeno = -12;
		caracter = 'q';
		letra = 'a';
		estadoActivo = true;
		
		System.out.println("El valor es " + numeroEntero);
		System.out.println("El valor es " + numeroEntero);
		
		
		float numeroDivido = 5;
		System.out.println(5 % 2);
		
		
		
		
		
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("introduce el numero 1");
		
		int numero1Usuario = teclado.nextInt();
		
		System.out.println("introduce el numero 2");
		
		int numero2Usuario = teclado.nextInt();
		
		int resultadoSuma = numero1Usuario + numero2Usuario;
		
		System.out.println("resultado suma: " + resultadoSuma);
		
	}
}
  