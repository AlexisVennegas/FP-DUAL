package retroplay;

import java.util.*;
import java.io.*;

public class SocioDAO {
	private final String RUTA_OBJETO = "socios.dat";
	private ArrayList<Socio> socios = new ArrayList<>();

	// Leer el fichero e imprimir todos los datos de los objetos por consola
	public SocioDAO() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_OBJETO))) {
			this.socios = (ArrayList<Socio>) entrada.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	// ... con un formato tabular claro.
	public void mostrarSocios() {
		// 1. Imprimimos la cabecera de la tabla con los nombres de las columnas.
		// Usamos todos %s porque los títulos son textos.
		System.out.printf("%-15s %-30s %-15s %-10s\n", "DNI", "NOMBRE", "SUSCRIPCIÓN", "JUEGOS");

		// 2. Recorremos la lista principal de socios.
		for (Socio socio : socios) {
			// 3. Imprimimos cada socio respetando exactamente los mismos anchos de columna.
			// Aquí usamos %s (String), %b (boolean) y %d (entero).
			System.out.printf("%-15s %-30s %-15b %-10d\n", socio.getDni(), socio.getNombreCompleto(),
					socio.isSuscripcionActiva(), socio.getJuegosAlquilados());
		}
	}

	// Insertar un nuevo objeto Socio .
	public void insertarSocio(Socio nuevoSocio) {
		socios.add(nuevoSocio);
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
			salida.writeObject(socios);
		} catch (IOException e) {
			System.out.println("Error al guardar: " + e.getMessage());
		}
	}

	// Modificar un objeto: Buscar un socio por su DNI, cambiar su estado de
	// suscripcionActiva y guardar los cambios sin alterar a los demás socios.

	public void modificarSuscripcion(String dniBuscado) {
		boolean encontrado = false;
		for (Socio socio : socios) {
			if (dniBuscado.equals(socio.getDni())) {
				// Operar: cambiar su estado de suscripcion
				socio.setSuscripcionActiva(!socio.isSuscripcionActiva());
				encontrado = true;
				break; // Salimos del bucle porque ya lo encontramos

			}
		}
		// Guardar: escribir la lista entera de nuevo en el archivo para que el cambio
		// sea permanente
		if (encontrado) {
			try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
				salida.writeObject(socios);
				System.out.println("Socio modificado correctamente.");
			} catch (IOException e) {
				System.out.println("Error al guardar cambios: " + e.getMessage());
			}
		} else {
			System.out.println("No se encontró ningún socio con ese DNI");
		}
	}

	// Eliminar un objeto: Borrar un socio específico del archivo.
	public void eliminarSocio(String dniBuscado) {
		Socio socioAEliminar = null; // Variable temporal para guardar al socio si lo encontramos

		// 1. Buscamos el socio por su DNI
		for (Socio socio : socios) {
			if (dniBuscado.equals(socio.getDni())) {
				socioAEliminar = socio;
				break; // Lo encontramos, dejamos de buscar
			}
		}

		// 2. Si lo encontramos, lo borramos de la lista y guardamos los cambios en el
		// archivo
		if (socioAEliminar != null) {
			socios.remove(socioAEliminar); // Lo sacamos de la memoria principal

			try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
				salida.writeObject(socios);
				System.out.println("Socio eliminado correctamente.");
			} catch (IOException e) {
				System.out.println("Error al guardar cambios: " + e.getMessage());
			}
		} else {
			System.out.println("No se encontró ningún socio con ese DNI.");
		}
	}

	/*
	 * Si revisamos tu clase SocioDAO, tenemos un método modificarSuscripcion(String
	 * dniBuscado) que busca un socio y le cambia un dato, pero no tenemos un método
	 * para sumarle un alquiler. Dado que necesitamos saber si el socio existe para
	 * mostrar el mensaje de error en la interfaz, lo ideal sería crear un método
	 * nuevo en SocioDAO que intente hacer la suma y nos devuelva true si lo logró,
	 * o false si el socio no existe. Fijándote en cómo construiste
	 * modificarSuscripcion, ¿cómo crearías un nuevo método llamado
	 * registrarAlquiler(String dniBuscado) dentro de tu clase SocioDAO que busque
	 * al socio, le sume 1 a su variable juegosAlquilados, guarde el archivo, y
	 * devuelva un boolean?
	 */
	public boolean registrarAlquiler(String dniBuscado) {
		boolean encontrado = false;
		// 1. Buscar en la memoria
		for (Socio socio : socios) {
			if (dniBuscado.equals(socio.getDni())) {
				// Como necesitas sumarle uno al valor que ya tiene, la lógica en Java sería:
				// "establece los juegos alquilados al valor de los juegos que ya tiene + 1".
				// Algo así:
				socio.setJuegosAlquilados(socio.getJuegosAlquilados() + 1);
				encontrado = true;
				break; // Salimos del bucle para ahorrar tiempo de procesamiento
			}
		}
		// 2. Si hubo cambios, sobrescribimos el archivo
		if (encontrado) {
			try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
				salida.writeObject(socios);
				return true; // Éxito total
			} catch (IOException e) {
				System.out.println("Error al guardar cambios: " + e.getMessage());
				return false; // Falló al escribir el archivo
			}
		} else {
			return false; // El socio no existía
		}
	}

}
