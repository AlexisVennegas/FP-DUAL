package p81;

import java.util.Scanner;

public class Convert {

	public static void menu() {
		System.out.println("convertidor euros || pesetas");
		System.out.println("si quieres convertir euros to pesetas || E");
		System.out.println("si quieres convertir pesetas to euros || P");
	
	}
	
	public static double eurosToPesetas(Scanner scanner) {
		
		double 	euros = 0,
				total = 0;
		System.out.println("introduce la cantidad de euros: ");
		euros = scanner.nextDouble();
		
		total = euros * 166.386;
		
		System.out.println("total: " + total + " pesetas");
		return total;
	}
	
	public static double pesetasToEuros(Scanner scanner) {
		double 	pesetas = 0,
				total = 0;
		
		System.out.println("introduce la cantidad de pesetas: ");
		pesetas = scanner.nextDouble();
		
		total = pesetas / 166.386;
		
		System.out.println("total: " + total + " euros");
		return total;
	}
	
	public static void main(String[] args) {
		

		String desicion;
		
		menu();
		Scanner scanner = new Scanner(System.in);
		
		desicion = scanner.nextLine();
		
		while(!desicion.equalsIgnoreCase("e") && !desicion.equalsIgnoreCase("p")) {
			System.out.println("introduce un valor correcto: ");
			desicion = scanner.nextLine(); 
		}
		

			if(desicion.toLowerCase().equals("e")) eurosToPesetas(scanner);
			if(desicion.toLowerCase().equals("p")) pesetasToEuros(scanner);
	
			System.out.println("fin");
		
	}
}
