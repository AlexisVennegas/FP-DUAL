package Write;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class p02 {
	
	public static int leerArchivo(Scanner teclado, File fichero) {
		int media = 0;
		
		while(teclado.hasNext(fichero)) {
		    int linea = teclado.nextInt();
		    media += linea;
		}
		
		return media;
	}
	
	public static void main(String[] args) {
        File fichero = new File("notas.txt");

		Scanner teclado = new Scanner(System.in);
		int media = leerArchivo(teclado, fichero);
	

	}
}
