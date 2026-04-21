package retroplay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Ticket {
	private final String RUTA_ARCHIVO = "ticket_venta.txt";

	public void generarArchivo(Videojuego juegoComprado) {

		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
			escritor.write("Artículo: " + juegoComprado.getTitulo());
			escritor.newLine();
			escritor.write("Consola:  " + juegoComprado.getPlataforma());
			escritor.newLine();
			escritor.write("Precio:   $" + juegoComprado.getPrecio());
			escritor.newLine();
			escritor.write("-----------------------------------");
			escritor.newLine();
			escritor.write("Gracias por tu compra");
			System.out.println("Ticket escrito correctamente");

		} catch (IOException e) {
			System.out.println("Error al escribir: " + e.getMessage());
		}

		try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
			String linea;

			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}
	}

	// Modificar una palabra concreta dentro del fichero.
	public void modificarPalabra(String palabraAntigua, String palabraNueva) {
		// 1. Crear una lista ArrayList<String> para guardar el texto temporalmente
		ArrayList<String> lineas = new ArrayList<>();

		// 2. Leer el archivo línea a línea con BufferedReader
		try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				// 3. Por cada línea leída, usar el método replace() para cambiar la palabra y
				// añadir esa línea
				linea = linea.replace(palabraAntigua, palabraNueva);
				lineas.add(linea);
			}

		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}

		// 4. Una vez terminado de leer, abrir el archivo para escribir BufferedWriter y
		// FileWriter
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
			// 5. Recorrer nuestra lista y escribir cada línea en el archivo
			for (String l : lineas) {
				escritor.write(l);
				escritor.newLine();
			}
			System.out.println("Archivo actualizado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}

	}

	// Eliminar una línea específica
	public void eliminarLinea(String lineaABorrar) {
		// 1. Crear una lista ArrayList<String> para guardar el texto temporalmente
		ArrayList<String> lineas = new ArrayList<>();

		// 2. Leer el archivo línea a línea con BufferedReader
		try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
			String linea;
			// Si la linea NO es igual a lineaABorrar...
			while ((linea = lector.readLine()) != null) {
				if (!linea.contains(lineaABorrar)) {
					lineas.add(linea); // ...la guardamos en la lista
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}

		// 4. Una vez terminado de leer, abrir el archivo para escribir BufferedWriter y
		// FileWriter
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
			// 5. Recorrer nuestra lista y escribir cada línea en el archivo
			for (String l : lineas) {
				escritor.write(l);
				escritor.newLine();
			}
			System.out.println("Archivo actualizado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al leer: " + e.getMessage());
		}

	}

	// Añadir nuevas líneas al fichero.
	public void anadirLinea(String nuevaLinea) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
			escritor.write(nuevaLinea); // 1. Escribimos el texto directamente
			escritor.newLine(); // 2. Añadimos el salto de línea
			System.out.println("Línea añadida correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir: " + e.getMessage());
		}

	}

}
