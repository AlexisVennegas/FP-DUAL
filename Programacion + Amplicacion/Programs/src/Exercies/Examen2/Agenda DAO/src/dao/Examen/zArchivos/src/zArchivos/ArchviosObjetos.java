package zArchivos;

import java.io.*;

public class ArchviosObjetos {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	//Sin buffer
		//Leer
		
	ObjectInputStream ois = new ObjectInputStream(
	        new FileInputStream("archivo.dat"));

	MiClase obj = (MiClase) ois.readObject();

	ois.close();

		//Escribir
	
	ObjectOutputStream oos = new ObjectOutputStream(
	        new FileOutputStream("archivo.dat"));

	oos.writeObject(obj);	//(obj): objeto que quieras escribir

	oos.close();
	
	//Con buffer
		//Leer
	
	ObjectInputStream ois = new ObjectInputStream(
	        new BufferedInputStream(
	                new FileInputStream("personas.dat")));

	MiClase obj = (MiClase) ois.readObject();

	ois.close();
	
		//Escribir
	
	ObjectOutputStream oos = new ObjectOutputStream(
	        new BufferedOutputStream(
	                new FileOutputStream("archivo.dat")));

	oos.writeObject(new MiClase("xxx", 25));

	oos.close();
	
	}
}
