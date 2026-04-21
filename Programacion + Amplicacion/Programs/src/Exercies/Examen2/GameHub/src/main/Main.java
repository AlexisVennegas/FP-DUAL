package main;

import bbdd.ConexionGameHub;
import bbdd.ServicioDAO;
import ficheros.UsuarioDAO;
import gui.Ventana;
import modelo.Juego;
import modelo.Usuario;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		System.out.println("=== INICIANDO SISTEMA GAMEHUB ===");

		// ---------------------------------------------------------
		// 1. PREPARAR LA BASE DE DATOS (Añadir un juego de prueba)
		// ---------------------------------------------------------
		System.out.println("\n[1] Conectando a la base de datos...");
		Connection conn = ConexionGameHub.getInstance();

		if (conn != null) {
			System.out.println("¡Conexión exitosa!");
			ServicioDAO servicioJuego = new ServicioDAO(conn);

			// Creamos un juego (ID: 1, Nombre: "The Legend of Zelda", Plataforma: "Switch",
			// Precio: 59.99, Stock: 5)
			Juego juegoPrueba = new Juego(1, "The Legend of Zelda", "Switch", 59.99, 5);

			System.out.println("Insertando juego de prueba (ID: 1)...");
			// Nota: Si ejecutas esto varias veces, saltará el mensaje de "Error al
			// insertar"
			// en la consola porque el ID 1 ya existirá. Es completamente normal.
			servicioJuego.insertar(juegoPrueba);
		} else {
			System.out.println("ERROR: No se pudo conectar a la base de datos.");
			return; // Detenemos la ejecución si no hay BD
		}

		// ---------------------------------------------------------
		// 2. PREPARAR FICHEROS (Añadir un usuario de prueba)
		// ---------------------------------------------------------
		System.out.println("\n[2] Configurando ficheros de usuarios...");
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Creamos un usuario (DNI: "12345678A", Nombre: "Juan Perez", Activo: true,
		// Alquileres: 0)
		Usuario usuarioPrueba = new Usuario("12345678A", "Juan Perez", true, 0);

		System.out.println("Insertando usuario de prueba (DNI: 12345678A)...");
		usuarioDAO.insertarUsuario(usuarioPrueba);

		System.out.println("--- Lista de usuarios en el sistema ---");
		usuarioDAO.listarUsuario();

		// ---------------------------------------------------------
		// 3. LANZAR LA INTERFAZ GRÁFICA
		// ---------------------------------------------------------
		System.out.println("\n[3] Lanzando la interfaz gráfica...");
		System.out.println("=> Para probar, escribe DNI: '12345678A' e ID Juego: '1' en la ventana.");

		// Llamamos al método main de tu Ventana para que se dibuje en pantalla
		Ventana.main(args);
	}
}
