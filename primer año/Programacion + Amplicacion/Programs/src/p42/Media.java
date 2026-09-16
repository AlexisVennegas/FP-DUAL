	package p42;
	
	import java.util.Scanner;
	
	public class Media {
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
		
			int i = 0,
				j = 0,
				resultadoPositivos = 0,
				resultadoNegativos = 0;
			
			int temporal = -1;
			
			while(temporal != 0) {
				System.out.println("introduce un numero: ");
				temporal = scanner.nextInt();
				if(temporal < 0) {
					resultadoNegativos += temporal;
					i++;
				}
				else {
					resultadoPositivos += temporal;
					j++;
				}
			}
			
			if(j == 0) 	System.out.println("no hay positivos");
			else 		System.out.println("resultado Positivos: " + resultadoPositivos / j);
			
			if(i == 0) 	System.out.println("no hay negativos");
			else 		System.out.println("resultado Negativos: " + resultadoNegativos / i); 
			
			
		}
	}
