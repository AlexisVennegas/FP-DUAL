package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FicheroTexto {

	final private String RUTA_TEXTO = "ticket_operacion.txt";

	public void añadirLineas(String nuevaLinea) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_TEXTO, true))) {
			escritor.write(nuevaLinea); // 1. Escribimos el texto directamente
			escritor.newLine(); // 2. Añadimos el salto de línea
			System.out.println("Línea añadida correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir: " + e.getMessage());
		}

	}

	public void leerArchivoReemplazarPalabra(String buscarPalabra, String replace) {
		String contenido  =  "";
		
		try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_TEXTO))) {
			String linea; 
			
			while ((linea = lector.readLine())!=null) {
				linea = linea.replace(buscarPalabra, replace);
				contenido = contenido+linea+"\n";
			}
		} catch (IOException e) {
			System.out.println("Error a la hora de encontrar la palabra: " + e.getMessage());
		}
		
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_TEXTO))) {
			escritor.write(contenido);
		} catch (IOException e) {
			System.out.println("Error al escribir: " + e.getMessage());
		}
		
	}

	public void eliminarLinea(String lineaABorrar) {
		// 1. Crear una lista ArrayList<String> para guardar el texto temporalmente
		ArrayList<String> lineas = new ArrayList<>();

		// 2. Leer el archivo línea a línea con BufferedReader
		try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_TEXTO))) {
			String linea;
			// Si la linea NO es igual a lineaABorrar...
			while ((linea = lector.readLine()) != null) {
				if (!linea.equals(lineaABorrar)) {
					lineas.add(linea); // ...la guardamos en la lista
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}

		// 4. Una vez terminado de leer, abrir el archivo para escribir BufferedWriter y
		// FileWriter
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_TEXTO))) {
			// 5. Recorrer nuestra lista y escribir cada línea en el archivo
			for (String l : lineas) {
				escritor.write(l);
				escritor.newLine();
			}
			System.out.println("Archivo actualizado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo: " + e.getMessage());
		}
	}
}
