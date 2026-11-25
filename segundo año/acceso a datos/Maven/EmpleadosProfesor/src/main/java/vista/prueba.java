package vista;

import java.nio.channels.Pipe.SourceChannel;

import controlador.EmpleadoController;
import modelo.Empleado;

public class prueba {
	public static void main(String[] args) {
		
		EmpleadoController empleadoController = new EmpleadoController();
		
		Empleado empleado = empleadoController.getEmpleado(7900);
		System.out.println(empleado.toString());
		
		//empleadoController.insertEmpleado(new Empleado(12, "Alexis", "Sepa", 7698, null, 0, null, null));
		System.out.println(empleadoController.getEmpleado(12).toString());
		
		
		empleadoController.selectEmpleadoMasivo();
		
	}
		
	
}
