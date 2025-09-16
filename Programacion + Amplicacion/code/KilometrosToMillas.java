package code;

import java.util.Scanner;

public class KilometrosToMillas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int 	opcion;
		double  kilometros,
				millasTotales;
		
		
		
		System.out.println("Elige una opcion [1, 2]");
		System.out.println("1.- millas marinas");
		System.out.println("2.- millas terrestres");
		opcion = teclado.nextInt();
		System.out.println("ingresa kilometros: ");
		kilometros = teclado.nextDouble();
		
		if(opcion == 1) millasTotales = (kilometros * 1000) /1852;
		else 			millasTotales = (kilometros * 1000) / 1609;
		
		System.out.println("total en millas: " + millasTotales);
		
		teclado.close();
	
	
	}
}
