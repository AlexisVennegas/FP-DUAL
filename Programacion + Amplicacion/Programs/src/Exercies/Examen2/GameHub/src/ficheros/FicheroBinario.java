package ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroBinario {
	
	public void copiarArchivo() {
		String rutaOrigen = "imagen_base.jpg";
		String nombreCarpeta = "backups";
		String rutaDestino = nombreCarpeta + "\\imagen_base.jpg";
		
		// CREAR LA CARPETA SI NO EXISTE:
		File carpeta = new File(nombreCarpeta);
		if (!carpeta.exists()) {
			carpeta.mkdirs();
			System.out.println("Carpeta creada correctamente");
		}
		
		try (FileInputStream entrada = new FileInputStream(rutaOrigen);
				FileOutputStream salida = new FileOutputStream(rutaDestino)) {
			
			int unByte; // Variable para guardar el byte que leemos
			
			// "Mientras leas un byte y no sea -1 (fin de archivo)..."
			while ((unByte = entrada.read()) != -1) {
				salida.write(unByte); // "...escribe ese mismo byte en el archivo nuevo"
			}
			System.out.println("Archivo binario copiado con éxito.");
		} catch (IOException e) {
			System.out.println("Error al procesar los bytes: " + e.getMessage());
		}
	}

}
