package code;

import java.util.Scanner;

public class Avion {
	public static void main(String[] args) {
		Scanner  teclado = new Scanner(System.in);
		
		double	distanciakilometros,
				numerodias,
				total;
		boolean descuento;
		
		System.out.println("introduce la distancia a recorrer en kilometros: ");
		distanciakilometros = teclado.nextDouble();
		
		System.out.println("introduce el numero de dias");
		numerodias = teclado.nextDouble();
		
		if (distanciakilometros > 1000 && numerodias > 7)  descuento = true;
													else descuento = false;

		total = (distanciakilometros * 8.5) * 2;
		
		if(descuento) total = total * 0.7;
		System.out.println("total precio: " + total);
		
		teclado.close();
	}
}
