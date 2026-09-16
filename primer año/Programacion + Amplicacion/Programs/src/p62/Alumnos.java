package p62;

import java.util.Scanner;

public class Alumnos {
	public static void main(String[] args) {
		final int NUMERO_ALUMNOS = 10;
		
		Scanner scanner = new Scanner(System.in);
		double 	sumaExamenA = 0, 
				sumaExamenB = 0, 
				media;
		int nota;
		
		
		
		
		for(int i = 1; i <= NUMERO_ALUMNOS; i++) {
			System.out.println("nota: ");
			nota = scanner.nextInt();
			sumaExamenA += nota;
		}
		
		sumaExamenA = sumaExamenA / 10;
		System.out.println("total a: " + sumaExamenA);
		
		
		for(int j = 0; j <= NUMERO_ALUMNOS; j++) {
			System.out.println("nota: ");
			nota = scanner.nextInt();
			sumaExamenB += nota;
		}
		
		sumaExamenB = sumaExamenB / 25;
		System.out.println("total a: " + sumaExamenB);
		
		
		
	}
}
