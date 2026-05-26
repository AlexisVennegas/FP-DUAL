package asd;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class prueba {
	public static void main(String[] args) throws IOException {
		
			int bytesLeidos = 3;
	
		   Path ruta = Path.of("archivo.txt");
		   int digitos = 0;

	        // Usamos try-with-resources para cerrar el canal automáticamente
	        try (FileChannel canal = FileChannel.open(ruta, StandardOpenOption.READ)) {
	            
	            // Creamos el buffer con una capacidad de 48 bytes
	            ByteBuffer buffer = ByteBuffer.allocate(bytesLeidos);
	            
	            // El canal llena el buffer
	            bytesLeidos = canal.read(buffer);
	            System.out.println(bytesLeidos);
	            
	            while (bytesLeidos != -1) {
	                
	                // Preparamos el buffer para leer desde él
	                buffer.flip();
	                
	                while (buffer.hasRemaining()) {
	                    // Imprimimos cada caracter
	                    char c = (char) canal.read(buffer);
	                    if(Character.isDigit(c)) {
	                    	digitos++;
	                    }
	                }
	                
	                // Limpiamos los índices para la siguiente carga
	                buffer.clear();
	                bytesLeidos = canal.read(buffer);
	            }
	            
	        } catch (IOException e) {
	            // Manejo de errores de entrada/salida
	            e.printStackTrace();
	        }
	        
	        System.out.println(digitos);
     
	}
}
