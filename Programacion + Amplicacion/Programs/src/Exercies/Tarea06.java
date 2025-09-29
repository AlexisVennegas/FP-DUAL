package Exercies;

import java.util.Scanner;

public class Tarea06 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int numero,
			i = 1;
			j = 1;
		
		System.out.println("introduce un numero: ");
		numero = scanner.nextInt();
		
	    while (i <= numero) {	
	    	int j = 1; 
	    	while (j <= i) {
	    		System.out.print(j);
	    		j++;
	        }
	    System.out.println(); 
	    i++;
	    }
		
	
	
		if(numero < 0) {
			System.out.println("entre qui");
			numero *= -1;
			int w = 1;
			
			
			while(w <= numero) {
				int x = 1;
				while(x <= w) {
					System.out.print("-");
					System.out.print(x);
					x++;
				}
				System.out.println();
				w++;
			}
			
			
		}
	}
}
