package Usuario;

import java.util.Scanner;

public class Principal {
	
	public static void menu() {
		int opcion = 0;
		Usuario usuario = null;
		Scanner scanner = new Scanner(System.in);

		while(true) {
			
			// 1 = crear un usuario
			// 2 = si el usuario esta creado mostrar datos, si no hay decir que no hay usuario
			// 3 = modificar el saldo de puntos si no hay usuario decirlo
			// 4 = salir
			System.out.println("--------------------------------------------");
			System.out.println("| Elige Una opcion introduciendo un numero:|");
			System.out.println("| 1.- Crear un usuario                     |");
			System.out.println("| 2.- mostrar datos                        |");
			System.out.println("| 3.- modificar saldo                      |");
			System.out.println("| 4.- salir                                |");
			System.out.println("--------------------------------------------");
			opcion = scanner.nextInt();
			if(opcion == 1) usuario = crearUsuario(scanner);
			if(opcion == 2) mostrarDatos(usuario);
			if(opcion == 3) modificarSaldo(scanner, usuario);
			if(opcion == 4) {
				System.out.println("hasta luego!!");
				break;
			}
			else if(opcion >= 5 || opcion <= 0)System.out.println("opcion invalida!");
			
		}
	}
	private static void modificarSaldo(Scanner scanner, Usuario usuario) {
		double cantidadPorcentaje = 0;
	
	
			System.out.println("Porcentaje a modificar: ");
			cantidadPorcentaje = scanner.nextDouble();
			if(usuario == null) {
				System.out.println("Error, no hay usuario creado");
				return;
			}
			else {
				usuario.IncrementarSaldo(cantidadPorcentaje);
				System.out.println("modificacion realizada");	
			}
	}
	private static void mostrarDatos(Usuario usuario) {
		if (usuario == null) {
			 System.out.println("no hay usuario creado");
			 return;
		}
		System.out.println(usuario.toString());
	}
	private static Usuario crearUsuario(Scanner scanner) {
		System.out.println("nombre: ");
		String nombre = scanner.next();
		System.out.println("saldo: ");
		double saldo = scanner.nextDouble();
		//int id = (int) (Math.random() * 100);
		System.out.println("id: ");
		int id = scanner.nextInt();
		Usuario usuario = new Usuario(id, nombre, saldo);
		System.out.println("usuario creado");
		return usuario;	
	}
	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario(1, "Alexis", 100);
		Usuario usuario2 = new Usuario(2, "Ana", 500);
		Usuario usuario3 = new Usuario(3, "Noe", 200);
		
		menu();
		
	}
}
