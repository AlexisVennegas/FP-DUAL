package ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioDAO {
	private final String RUTA_OBJETO = "usuarios.dat";
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	
	public UsuarioDAO() {
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_OBJETO))) {
			this.usuarios = (ArrayList<Usuario>) entrada.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertarUsuario(Usuario nuevoSocio) {
		usuarios.add(nuevoSocio);
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
			salida.writeObject(usuarios);
		} catch (IOException e) {
			System.out.println("Error al guardar: " + e.getMessage());
		}
	}
	
	public void listarUsuario() {
		// 1. Imprimimos la cabecera de la tabla con los nombres de las columnas.
		// Usamos todos %s porque los títulos son textos.
		System.out.printf("%-15s %-30s %-15s %-10s\n", "DNI", "NOMBRE", "ACTIVO", "ALQUILERES");

		// 2. Recorremos la lista principal de usuarios.
		for (Usuario usuario : usuarios) {
			// 3. Imprimimos cada socio respetando exactamente los mismos anchos de columna.
			// Aquí usamos %s (String), %b (boolean) y %d (entero).
			System.out.printf("%-15s %-30s %-15b %-10d\n", usuario.getDni(), usuario.getNombre(), usuario.isActivo(), usuario.getAlquileres());
		}
	}
	
	// Busca un usuario, le cambia el estado, y vuelve a guardar toda la lista.
	public void modificarSuscripcion(String dniBuscado) {
		boolean encontrado = false;
		// 1. Buscar en la memoria
		for (Usuario usuario : usuarios) {
			if (dniBuscado.equals(usuario.getDni())) {
				// Cambiamos el valor booleano por su contrario (true pasa a false, y viceversa)
				usuario.setActivo(!usuario.isActivo());
				encontrado = true;
				break; // Salimos del bucle para ahorrar tiempo de procesamiento
			}
		}
		// 2. Si hubo cambios, sobrescribimos el archivo
		if (encontrado) {
			try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
				salida.writeObject(usuarios);
				System.out.println("Socio modificado correctamente.");
			} catch (IOException e) {
				System.out.println("Error al guardar cambios: " + e.getMessage());
			}
		} else {
			System.out.println("No se encontró ningún socio con ese DNI");
		}
	}
	
	// Elimina un socio de la memoria y actualiza el archivo
		public void eliminarUsuario(String dniBuscado) {
			Usuario usuarioAEliminar = null; // Guardamos la referencia del objeto a borrar

			for (Usuario usuario : usuarios) {
				if (dniBuscado.equals(usuario.getDni())) {
					usuarioAEliminar = usuario;
					break;
				}
			}

			if (usuarioAEliminar != null) {
				usuarios.remove(usuarioAEliminar); // Borramos el objeto de la lista en memoria

				// Sobrescribimos el archivo sin el socio borrado
				try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
					salida.writeObject(usuarios);
					System.out.println("Socio eliminado correctamente.");
				} catch (IOException e) {
					System.out.println("Error al guardar cambios: " + e.getMessage());
				}
			} else {
				System.out.println("No se encontró ningún socio con ese DNI.");
			}
		}
		
		public boolean registrarAlquiler(String dniBuscado) {
			boolean encontrado = false;
			// 1. Buscar en la memoria
			for (Usuario usuario: usuarios) {
				if (dniBuscado.equals(usuario.getDni())) {
					// Como necesitas sumarle uno al valor que ya tiene, la lógica en Java sería:
					// "establece los juegos alquilados al valor de los juegos que ya tiene + 1".
					// Algo así:
					usuario.setAlquileres(usuario.getAlquileres() + 1);
					encontrado = true;
					break; // Salimos del bucle para ahorrar tiempo de procesamiento
				}
			}
			// 2. Si hubo cambios, sobrescribimos el archivo
			if (encontrado) {
				try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_OBJETO))) {
					salida.writeObject(usuarios);
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
