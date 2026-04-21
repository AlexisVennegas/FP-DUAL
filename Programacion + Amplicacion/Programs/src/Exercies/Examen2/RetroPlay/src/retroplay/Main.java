package retroplay;

import java.sql.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("=== INICIANDO SISTEMA RETROPLAY ===\n");

		// ---------------------------------------------------------
		// 1. PRUEBAS DE BASE DE DATOS (Videojuegos)
		// ---------------------------------------------------------
		System.out.println("--- 1. GESTIÓN DE BASE DE DATOS ---");
		Connection conexion = ConexionRetroDB.getInstance();
		VideojuegoDAO dao = new ServicioDAO(conexion);

		Videojuego juego1 = new Videojuego(1, "Super Mario World", "SNES", 25.50, 10);
		Videojuego juego2 = new Videojuego(2, "Sonic The Hedgehog", "MegaDrive", 20.00, 15);
		Videojuego juego3 = new Videojuego(3, "Zelda: Ocarina of Time", "N64", 45.00, 5);
		Videojuego juego4 = new Videojuego(4, "Metal Gear Solid", "PS1", 35.00, 8);

		// NOTA: Si ejecutas el main más de una vez, te saldrá el mensaje "Error al
		// insertar"
		// porque los IDs 1, 2, 3 y 4 ya existirán en tu base de datos. ¡Es normal!
		dao.insertar(juego1);
		dao.insertar(juego2);
		dao.insertar(juego3);
		dao.insertar(juego4);

		System.out.println("Juegos procesados correctamente en BD.");

		System.out.println("\nLeyendo juego 1 desde la Base de Datos:");
		ResultSet rs = dao.leer(juego1);

		try {
			if (rs != null && rs.next()) {
				System.out.println("> Título: " + rs.getString("titulo") + " | Precio: €" + rs.getDouble("precio"));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ---------------------------------------------------------
		// 2. PRUEBAS DE FICHEROS DE TEXTO (Ticket)
		// ---------------------------------------------------------
		System.out.println("\n--- 2. GESTIÓN DE FICHEROS DE TEXTO ---");
		System.out.println("Generando ticket de compra...");
		Ticket miTicket = new Ticket();

		miTicket.generarArchivo(juego1);
		miTicket.anadirLinea("¡Vuelva pronto!");
		miTicket.modificarPalabra("Pendiente", "Abonado"); // Solo hará efecto si "Pendiente" estuviese en el texto
															// original
		miTicket.eliminarLinea("Gracias por tu compra");

		// ---------------------------------------------------------
		// 3. PRUEBAS DE FICHEROS BINARIOS (Backup)
		// ---------------------------------------------------------
		System.out.println("\n--- 3. GESTIÓN DE FICHEROS BINARIOS ---");
		System.out.println("Realizando copia de seguridad de la portada...");
		GestorBackup backup = new GestorBackup();
		// Recuerda: Debes tener una imagen llamada "portada_default.jpg" en la carpeta
		// raíz de tu proyecto para que no salte error.
		backup.copiaSeguridad();

		// ---------------------------------------------------------
		// 4. PRUEBAS DE FICHEROS DE OBJETOS (Socios)
		// ---------------------------------------------------------
		System.out.println("\n--- 4. GESTIÓN DE FICHEROS DE OBJETOS ---");
		System.out.println("Inicializando gestor de socios... ");
		SocioDAO gestor = new SocioDAO();

		Socio socio = new Socio("123456", "Alina", true, 10);
		gestor.insertarSocio(socio);

		System.out.println("\n> Lista tras insertar:");
		gestor.mostrarSocios();

		System.out.println("\n> Modificando suscripción...");
		gestor.modificarSuscripcion("123456");
		gestor.mostrarSocios(); // Mostramos para comprobar el cambio

		//System.out.println("\n> Eliminando socio...");
		//gestor.eliminarSocio("123456");

		// ---------------------------------------------------------
		// 5. LIMPIEZA Y CIERRE
		// ---------------------------------------------------------
		ConexionRetroDB.close();
		System.out.println("\n=== FIN DE LA EJECUCIÓN ===");
	}
}
