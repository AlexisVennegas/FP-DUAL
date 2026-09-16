package documentNIO;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	static Path e1origen = Path.of("notas.txt");
	static Path e1destino = Path.of("notasCopia.txt");
	static Path e2destino = Path.of("notasv2.txt");
	static List<String> e3lineas;
	static List<String> e4nombres = List.of("Laura", "Juan", "Manu", "Pablo", "Alicia");
	static Path e4destino = Path.of("nombres.txt");
	static String fhoraejer5 = LocalDate.now().toString();
	static long nvocalese6;
	static Path e7origen = Path.of("lineasJava.txt");
	static Path e7destino = Path.of("lineasJavaFiltrado.txt");
	static List<String> linease7;
	
	
	public static void main(String[] args) {
		System.out.println(Path.of("").toAbsolutePath());
			Main.ejer1();
			Main.ejer2();
			Main.ejer3();
			System.out.println(e3lineas);
			Main.ejer4();
			Main.ejer5();
			Main.ejer6();
			System.out.println(nvocalese6);
			Main.ejer7();
	}
	
	private static void ejer1() {
		try {
			Files.copy(e1origen, e1destino, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer2() {
		try {
			Files.move(e1destino, e2destino, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer3() {
		try (Stream<String> si = Files.lines(e1origen)) {
			e3lineas = si.collect(Collectors.toList());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer4() {
		try{
			Files.write(e4destino, e4nombres, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer5() {
		try {
			Files.writeString(e4destino, "\n" + fhoraejer5, StandardOpenOption.APPEND);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer6() {
		try (Stream<String> st = Files.lines(e4destino)) {
			nvocalese6 = st.map(String::toLowerCase)
						 .flatMapToInt(String::chars)
						 .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
	                             c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú')
						 .count();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ejer7() {
		try (Stream<String> st = Files.lines(e7origen)) {
			linease7 = st.filter(p -> p.contains("Java"))
						 .collect(Collectors.toList());
			Files.write(e7destino, linease7, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}