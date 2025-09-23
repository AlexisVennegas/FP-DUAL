package p10;

import java.util.Scanner;

public class Ecuacion {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double 	a,
				b,
				c,
				resultOne,
				resultTwo,
				discriminante;
		
		String sing = "+";
		
		System.out.println("introduce a: ");
		a = scanner.nextDouble();
		
		System.out.println("introduce b: ");
		b = scanner.nextDouble();
		
		System.out.println("introduce c: ");
		c = scanner.nextDouble();
		
		discriminante = (b * b) - (4 * a * c);
		if(discriminante < 0) return;
		resultOne = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		resultTwo = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		

		
		System.out.println("1.- " + resultOne);
		System.out.println("2.- " + resultTwo);
		
		
		
		scanner.close();
		
	}
}
