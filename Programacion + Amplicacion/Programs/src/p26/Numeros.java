package p26;

import java.util.Scanner;

public class Numeros {
	public static void main(String[] args) {
		int i = 0,
			sum = 0,
			num = 0;
		
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("introduce un numero: ");
		num = scanner.nextInt();
		
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.println("resultado: " + sum);
		
		
	}
}
