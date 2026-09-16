package p08;

import java.util.Scanner;

public class Telefono {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		int minutos,
			total;
		
		System.out.println("ingresa los minutos: ");
		minutos = scanner.nextInt();
		
		if(minutos <= 3) total = 10;
		else {
			total = 10;
			minutos -= 3;
			total = total + (minutos * 5);
		}
		System.out.println("total: " + total);
		scanner.close();
	}
}
