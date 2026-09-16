package Write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class p01 {
	//1. Realizar un programa que cree un fichero llamado notas.txt con un número entero en
	// cada línea. Los datos se leerán por teclado. 
	
	public static FileOutputStream crearArchivo() throws FileNotFoundException {
		return new FileOutputStream("./notas.txt");
	}
	
	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		FileOutputStream out = crearArchivo();
		int contador = 0;
		String numero = "";
		
		while(contador != 10) {
			System.out.println("introduce un numero: ");
			numero = teclado.next();
            out.write((numero + "\n").getBytes());
			contador++;
		}
		System.out.println(new java.io.File("notas.txt").getAbsolutePath());

		out.close();
	}
}
