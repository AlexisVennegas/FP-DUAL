package Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import conexion.Singleton;
import modelo.Pelicula;

public class Generate {
	public static void main(String[] args) {
		Util util = new Util();
		Scanner scanner = new Scanner(System.in);
		String titulo = "";
		
		util.conexionAndBBDD();
		
		util.crearElementos("Tokyo monogatari", 1953);
		util.crearElementos("Gattaca", 1997);
		util.crearElementos("Mary and Max", 2009);
		util.crearElementos("Tiempos modernos", 1936);
		System.out.println("primer apartado");
		util.mostrarPeliculas();
		util.eliminarPorAno(1990, 2000);
		System.out.println("segundo apartado");
		util.mostrarPeliculas();
		System.out.println("introduce un titulo");
		titulo = scanner.nextLine();
		
		util.modificarPelicula(titulo);
		System.out.println("tercer apartado");
		util.mostrarPeliculas();

	}	
}
