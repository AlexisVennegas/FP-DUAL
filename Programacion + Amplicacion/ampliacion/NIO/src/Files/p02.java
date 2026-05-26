package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class p02 {
	public static void main(String[] args) throws IOException {
		// 2.Mover   /   Renombrar: Renombra el archivo notasCopia.txt a notasv2.txt.
	
		Path directorio = Paths.get(".src/Files");
		
		 if (Files.notExists(directorio)) {
	            Files.createDirectories(directorio);
	        }
		 
		 
	}
}
