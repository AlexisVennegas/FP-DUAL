package p05;

import java.util.Scanner;

public class Restaurante {
	
	
	public static void menu() {
		System.out.println("Hamburguesa.................500 pts.");
		System.out.println("Cerveza.....................150 pts.");
		System.out.println("Coca-Cola...................175 pts.");
		System.out.println("Ensalada....................200 pts.");
		System.out.println("Salchichas..................275 pts.");
		System.out.println("Refrescos...................200 pts.");
		System.out.println("Sopa .......................260 pts.");
		System.out.println("Pastel......................300 pts.");
	}
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int	hamburguesas,
			cervezas,
			cocaCola,
			ensaladas,
			salchichas,
			refrescos,
			sopas,
			pastel,
			total;
		
		double impuestos;
			
		
		System.out.println("cantidad de hamburguesas: ");
		hamburguesas = teclado.nextInt();
		
		System.out.println("cantidad de cervezas: ");
		cervezas = teclado.nextInt();
		
		System.out.println("cantidad de coca Colas: ");
		cocaCola = teclado.nextInt();
		
		System.out.println("cantidad de Ensalada: ");
		ensaladas = teclado.nextInt();
		
		System.out.println("cantidad de salchichas: ");
		salchichas = teclado.nextInt();
		
		System.out.println("cantidad de refrescos: ");
		refrescos = teclado.nextInt();
		
		System.out.println("cantidad de sopas: ");
		sopas = teclado.nextInt();
		
		System.out.println("cantidad de pastel: ");
		pastel = teclado.nextInt();
		
		total = (hamburguesas* 500) + 
				(cervezas * 150)    +
				(cocaCola * 175)    + 
				(ensaladas * 200)   +
				(salchichas * 275)  +
				(refrescos * 200)   +
				(sopas * 260)       +
				(pastel * 300);
		
		
		
		impuestos = total * 0.12;
		System.out.println("total: " + total);
		System.out.println("impuestos: " + impuestos);
		
		
	}
}
