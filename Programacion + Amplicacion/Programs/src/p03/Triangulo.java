package p03;

import java.util.Scanner;

public class Triangulo {
	public static void main(String[] args) {

		Scanner teclado;
		double  cateto1,
				cateto2,
				hipotenusa;
		
		
		teclado = new Scanner(System.in);
		
		
		System.err.println("intruce el primer cateto: ");
		cateto1 = teclado.nextDouble();
		
		System.out.println("introduce el segundo cateto: ");
		cateto2 = teclado.nextDouble();
		
		hipotenusa = Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
		System.out.println("hipotenusa: " + hipotenusa);
		
		
		teclado.close();
	}
}
