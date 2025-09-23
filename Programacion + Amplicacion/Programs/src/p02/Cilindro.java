package p02;

import java.util.Scanner;

public class Cilindro {
	public static void main(String[] args) {
		
		Scanner teclado;
		double  altura,
				radio,
				pi,
				superficieBase,
				superficieLateral,
				superficieTotal,
				volumen;
				
		
		teclado = new Scanner(System.in);
		pi = Math.PI;
				
		
		System.out.println("introduce la altura: ");
		altura = teclado.nextDouble();
		
		System.out.println("introduce el radio: ");
		radio = teclado.nextDouble();
		
		volumen = pi * (radio * radio) * altura;
		superficieBase = pi * (radio * radio);
		superficieLateral = 2 * pi * radio * altura;
		superficieTotal = 2 * superficieBase + superficieLateral;
		
		System.out.println("volumen: " + volumen);
		System.out.println("superficie: " + superficieTotal);
		
		teclado.close();
	}
}
