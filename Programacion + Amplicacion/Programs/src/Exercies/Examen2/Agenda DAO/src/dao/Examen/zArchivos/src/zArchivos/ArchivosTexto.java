package zArchivos;

import java.io.*;

public class ArchivosTexto {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//Sin buffer
		//Leer
	
	FileReader fr= new FileReader("archivo.txt");

	int numero = fr.read();

	fr.close();
	
		//Escribir
	
	FileWriter fw=new FileWriter("archivo.txt");

	fw.write("1");

	fw.close();
	
	//Con buffer
		//Leer
	
	BufferedReader br = new BufferedReader(
	        new FileReader("archivo.txt"));

	String linea = br.readLine();

	br.close();
	
		//Escribir
	
	BufferedWriter bw = new BufferedWriter(
	        new FileWriter("archivo.txt"));

	bw.write("Hola");
	bw.newLine();

	bw.close();
	
	}
}
