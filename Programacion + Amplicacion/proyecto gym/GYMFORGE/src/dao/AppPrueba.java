package dao;

import java.sql.Connection;
import java.util.List;

import modelo.Usuario;

public class AppPrueba {
	public static void main(String[] args) {
        UsuarioDaoImpl dao = new UsuarioDaoImpl();
     
        try {
            // --- PRUEBA 1: CREAR ---
            System.out.println("--- Probando Crear ---");
            Usuario nuevo = new Usuario();
            nuevo.setNombre("David Test");
            nuevo.setCorreo("test@appgym.com");
            nuevo.setPassword("1234");
            nuevo.setPeso(80.5);
            nuevo.setAltura(1.80);
            nuevo.setDeporte("Pesas");
            
            dao.create(nuevo);
            System.out.println("Usuario insertado correctamente.");

            // --- PRUEBA 2: LISTAR ---
            System.out.println("\n--- Probando Listar Todos ---");
            List<Usuario> lista = dao.findAll();
            for (Usuario u : lista) {
                System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre());
            }

            // --- PRUEBA 3: BUSCAR POR ID ---
            // Suponiendo que el ID 1 existe
            System.out.println("\n--- Probando Buscar ID 1 ---");
            Usuario encontrado = dao.findOne(5L);
            if(encontrado != null) {
                System.out.println("Encontrado: " + encontrado.toString());
            }
          
        

        } catch (DAOException e) {
            System.err.println("Error en las pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
