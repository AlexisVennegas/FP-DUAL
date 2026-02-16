package Ficheros;

import java.util.Arrays;
import java.util.Scanner;

public class Prueba {
	
	
	public static void ordenar(Expedientes alumnos, int contador) {
		for (int i = 0; i <= contador; i++) {
		    System.out.println(alumnos[i]);
		}

		Arrays.sort(alumnos, 0, contador + 1);

		System.out.println("Ordenados:");
		for (int i = 0; i <= contador; i++) {
		    System.out.println(alumnos[i]);
		}
		
		System.out.println("ordenados: ");
		
	}
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Expedientes alumno = null;
		Expedientes[] alumnos = new Expedientes[10];

		int 		numeroExp = 0,
				contador = 0;
		
		String 	nombre = "",
				apellidos = "";
		
		while(true) {
			
			System.out.println("introduce numero de exp");
			numeroExp = teclado.nextInt();
			System.out.println("introduce nombre");
			nombre = teclado.next();
			System.out.println("introduce apellidos");
			apellidos = teclado.next();
			alumno = new Expedientes(numeroExp, nombre, apellidos);
			System.err.println("alumno creado: ");
			alumnos[contador] = alumno;
			System.out.println(alumno.toString());
			System.out.println();
			System.out.println("si = seguir --- no = terminar");
			if(teclado.next().equals("no")) break;
			contador++;
		}
		
		
		ordenar(alumnos, contador);
	
		
		
		
		
	}
}
