package p06;

import java.util.Scanner;

public class Avion {
	public static void main(String[] args) {
		Scanner  teclado = new Scanner(System.in);
		
		double	distanciakilometros,
				numerodias,
				total;
		boolean descuento;
		final double PRECIO_KM = 8.5;
		
		System.out.println("introduce la distancia a recorrer en kilometros de ida");
		distanciakilometros = teclado.nextDouble();
		
		System.out.println("introduce el numero de dias: ");
		numerodias = teclado.nextDouble();
		
		if (distanciakilometros > 1000 && numerodias > 7)  descuento = true;
													else descuento = false;

		total = (distanciakilometros * PRECIO_KM) * 2;
		
		if(descuento) total = total * 0.7;
		System.out.println("total precio: " + total);
		
		teclado.close();
	}
}
