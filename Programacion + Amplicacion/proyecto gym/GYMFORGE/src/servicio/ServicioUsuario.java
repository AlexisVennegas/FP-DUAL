package servicio;

import java.security.PublicKey;

import dao.HistorialPesoDaoImpl;
import dao.UsuarioDaoImpl;
import modelo.Usuario;

public class ServicioUsuario {

	UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
	HistorialPesoDaoImpl historialPesoDaoImpl = new HistorialPesoDaoImpl();
	
	public boolean registrarUsuario(String nombre, String correo, String password, Double altura, Double peso) {
		Usuario u = new Usuario();
		
		// Validación de campos vacíos o ceros
	    if(nombre == null || nombre.trim().isEmpty() || 
	       correo == null || correo.trim().isEmpty() || 
	       password == null || password.trim().isEmpty() || 
	       peso <= 0 || altura <= 0) {
	        return false;
	    }
		u.setNombre(nombre);
		u.setCorreo(correo);
		u.setPassword(password);
		u.setAltura(altura);
		u.setPeso(peso);
		u.setDeporte("");
		usuarioDaoImpl.create(u);
	
		
		return true;
		
	}

	public Usuario accesoUsuario(String correo, String password) {
		Usuario usuario = null;
		// Validación de campos vacíos o ceros
	    if(correo == null || correo.trim().isEmpty() || 
	       password == null || password.trim().isEmpty()) {
	        return null;
	    }
	    else
	    	usuario = usuarioDaoImpl.findOneByEmail(correo, password);
	    
	    return usuario;
	
	}
	
}
