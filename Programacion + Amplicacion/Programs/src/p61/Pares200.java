package p61;

import java.util.Scanner;


public class Pares200 {
	public static void main(String[] args){
		int pares = 0,
			impares = 0;


		for(int i = 0; i <= 200; i++){
			if(i % 2 == 0) pares++;
			if(i % 2 != 0) impares++;
		}
			System.out.println(impares  + " " + pares);
			
	}
}
