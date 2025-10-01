package p54;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		int		a,
				b,
				i;
		
		Scanner scanner = new Scanner(System.in);
		
	
		
		for(i = 0; i < 10; i++) {
			System.out.println("\nintroduce a: ");
			a = scanner.nextInt();
			System.out.println("introduce b: ");
			b = scanner.nextInt();
			System.out.print(a + " * " + b + " = " );
			int producto = 0;
			for(int j = 0; j < a; j++) {
				System.out.print(b);
				producto += b;
				if(j + 1 != a) System.out.print(" + ");
			}
			System.out.println(" = " + producto);
		}
		System.out.println("fin");
	}
}
