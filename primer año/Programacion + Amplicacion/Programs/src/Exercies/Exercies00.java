package Exercies;

import java.util.Scanner;

public class Exercies00 {
	public static void main(String[] args) {
		
		int 	mes = 2;
	
		
		switch (mes) {
		case 1: {
			System.out.println("Enero");
			break;
		}
		case 2: {
			
			System.out.println("febrero");
			break;
		}
		case 3: {
			System.out.println("marzo");
			break;
		}
		case 4: {
			System.out.println("abril ");
			break;
		}
		case 5: {
			System.out.println("Mayo");
			break;
		}
		case 6: {
			System.out.println("junio");
			break;
		}
		case 7: {
			System.out.println("julio");
			break;
		}
		case 8: {
			System.out.println("Agosto");
			break;
		}
		case 9: {
			System.out.println("septiembre");
			break;
		}
		case 10: {
			System.out.println("octubre");
			break;
		}
		case 11: {
			System.out.println("noviembre");
			break;
		}
		case 12: {
			System.out.println("diciembre");
			break;
		}
		
		
		
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}
}
