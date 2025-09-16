package code;

import java.util.Scanner;



public class Divisas {
	
	
	public static void menu() {
		System.out.println("1.- 100 Chelines Austriacos.....956.871 pts.");
		System.out.println("2.-   1 Dolar EEUU....122.499 pts");
		System.out.println("3.- 100 Dracmas Griegas....88.607 pts");
		System.out.println("4.- 100 Francos Belgas.... 323.728 pts.");
		System.out.println("5.-   1 Franco Francés.... 20.110 pts.");
		System.out.println("6.-   1 Libra Esterlina....178.938 pts.");
		System.out.println("7.- 100 Liras Italianas....9.289 pts. ");
	}
	
	
	public static void main(String[] args) {
		
		
		Scanner teclado;
		double  chelinesAustriacos,
				dracmasGriegas,
				pesetas,
				resultado;
		
		
		teclado = new Scanner(System.in);
		menu();
		
		
		System.out.println("introduce la cantidad de Chelines Austriacos: ");
		chelinesAustriacos = teclado.nextDouble();
		resultado = chelinesAustriacos * (956.871 / 100.0);
		System.out.println("pesetas: " + resultado);
		
		
		System.out.println("introduce la cantidad de Dracmas Griegas: ");
		dracmasGriegas = teclado.nextDouble();
		resultado = 0;
		resultado = dracmasGriegas * (88.607 / 100.0); 
		resultado = resultado / (9.289 / 100.0);
		System.out.println("francos: " + resultado);
		
		
		
		
		System.out.println("introduce la cantidad de Pesetas: ");
		pesetas = teclado.nextDouble();
		resultado = 0;
		resultado = pesetas / 122.499;
		System.out.println("dolares: " + resultado);
		
		resultado = 0;
		resultado = pesetas / (9.289 / 100.0);
		System.out.println("libras italianas: " + resultado);
		
		
		
		
		
		teclado.close();
	}
}
