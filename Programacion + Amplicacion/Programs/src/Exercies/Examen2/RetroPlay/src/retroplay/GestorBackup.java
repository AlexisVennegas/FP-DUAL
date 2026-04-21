package retroplay;

import java.io.*;

public class GestorBackup {
	
	public void copiaSeguridad() {
		
		String rutaOrigen = "portada_default.jpg";
		String nombreCarpeta = "backups";
		String rutaDestino = nombreCarpeta + "\\portada_default.jpg";
		
		// CREAR LA CARPETA SI NO EXISTE:
		File carpeta = new File(nombreCarpeta);
		if (!carpeta.exists()) {
			carpeta.mkdirs();
			System.out.println("Carpeta creada correctamente");
		}
		
		try (FileInputStream entrada = new FileInputStream(rutaOrigen);
				FileOutputStream salida = new FileOutputStream(rutaDestino)) {
			
			int unByte; // Variable para guardar el byte que leemos
			
			// "Mientrras leas un byte y no sea -1 (fin de archivo)..."
			while ((unByte = entrada.read()) != -1) {
				salida.write(unByte); // "...escribe ese mismo byte en el archivo nuevo"
			}
			System.out.println("Archivo binario copiado con éxito.");
		} catch (IOException e) {
			System.out.println("Error al procesar los bytes: " + e.getMessage());
		}
	}

}
