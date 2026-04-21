package service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serviceCliente {
	
	
	public String buscarCliente(String cliente) throws IOException {
		String ruta = "facturas.txt";
		String clienteFinal = "";
		String antes = "";
		String despues = "";
		int total = 0;
		 try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                if(linea.contains(cliente)) {
	                	int posicion = linea.indexOf("|");
						 antes = linea.substring(0, posicion);
						 despues = linea.substring(posicion + 1);
						//clienteFinal = clienteFinal +  linea;
						total += Integer.parseInt(despues);
						System.out.println("antes: " + antes);
						System.out.println("despues: " + despues);
	                	System.out.println("linea: " + linea);
	                	System.out.println("clientefinal: " + clienteFinal);
	                	System.out.println("total: " + total);
	                }
	            }
	        } catch (IOException e) {
	           System.out.println(e);
	        }
		 System.out.println("Cliente final" + clienteFinal);
		 return "" + antes + "|" + total;
	}
	
	public void anadirBinario(String cliente, String total) throws IOException{
		
		int totalNum = Integer.parseInt(total);
		
		if(totalNum > 200) {
			ObjectOutputStream oos = new ObjectOutputStream(
			        new FileOutputStream("factura.dat"));
			System.out.println(cliente + totalNum);
			oos.writeChars(cliente + total);	

			oos.close();
		}
		
	
		
		
		
	}
}
