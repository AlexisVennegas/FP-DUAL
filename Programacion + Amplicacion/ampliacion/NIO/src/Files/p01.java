package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p01 {
		// 1.Copiar archivos: Crea una copia de notas.txt llamada notasCopia.txt.
		public static void main(String[] args) throws IOException {
			Path directorio = Paths.get("./src/Files");
			System.out.println(directorio);
			// Aseguramos que la carpeta exista
	        if (Files.notExists(directorio)) {
	            Files.createDirectories(directorio);
	        }
	        Path original = directorio.resolve("notas.txt");
	        Path destino = directorio.resolve("notasCopia.txt");
	        
		
			Files.copy(original, destino);
			System.out.println("Archivo copiado a: " + destino);

			
			
		}
}
