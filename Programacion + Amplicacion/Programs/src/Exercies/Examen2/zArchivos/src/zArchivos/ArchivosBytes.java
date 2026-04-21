package zArchivos;

import java.io.*;

public class ArchivosBytes {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	
	//Sin buffer
		//Leer
	
	FileInputStream fis = new FileInputStream("archivo.txt");

	int dato;

	while ((dato = fis.read()) != -1) {
	    System.out.print((char) dato);
	}

	fis.close();
	
			//Escribir
	
	FileOutputStream fos = new FileOutputStream("archivo.txt");

	fos.write(65); // 'A'

	fos.close();
	
	//Con buffer
		//Leer
	
	BufferedInputStream bis2 = new BufferedInputStream(
	        new FileInputStream("archivo.txt"));

	int dato2 = bis2.read();

	bis2.close();
	
		//Escribir
	
	BufferedOutputStream bos = new BufferedOutputStream(
	        new FileOutputStream("archivo.txt"));

	bos.write(65); // escribe 'A'

	bos.close();
	
	}
}
