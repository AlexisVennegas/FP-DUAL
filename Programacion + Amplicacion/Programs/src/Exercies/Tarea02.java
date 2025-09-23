package Exercies;

import java.util.Scanner;

public class Tarea02 {
	
	// desarolla un programa para una discoteca que pregunta la edad y si es vip, solo entra
	// si es mayor de edad y si es vip entra a zona exclusiva
	public static void main(String[] args) {
		
		boolean vip = false;
		int 	edad;
		String respuesta;
		
		System.out.println("ingresa tu edad: ");
		edad = new Scanner(System.in).nextInt();
		
		System.out.println("eres VIP? ");
		respuesta = new Scanner(System.in).next().toLowerCase();
		if(respuesta.equals("si")) vip = true;
		if(edad >= 18 && vip) 		System.out.println("puedes entrar y eres vip");
		else if(edad >= 18 && !vip) System.out.println("puedes entrar pero no eres vip");
		else if(edad <= 18) 		System.out.println("no puedes entrar");
	}
}
