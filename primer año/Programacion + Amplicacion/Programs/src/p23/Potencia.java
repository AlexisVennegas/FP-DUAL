package p23;

import java.util.Scanner;

public class Potencia {
	public static void main(String[] args) {
		int n,
			x,
			result = 1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("introduce x: ");
		x = scanner.nextInt();
		
		System.out.println("introduce n: ");
		n = scanner.nextInt();
		
		while(n > 0) {
			result *= x;
			n--;
		}
		System.out.println("resultado: "  + result);
	}
}
