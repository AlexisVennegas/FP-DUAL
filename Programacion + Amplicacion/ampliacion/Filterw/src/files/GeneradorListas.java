package files;

import java.util.Arrays;
import java.util.List;

public class GeneradorListas {

	public static void main(String[] args) {
		
		
		List<Transaccion> transacciones=Arrays.asList(
				new Transaccion(new Proveedor("Sydney"),34,1200),
				new Transaccion(new Proveedor("Nairobi"),33,1200),
				new Transaccion(new Proveedor("Ushuaia"),45,4200),
				new Transaccion(new Proveedor("Katmandu"),35,1200),
				new Transaccion(new Proveedor("Osaka"),31,2500),
				new Transaccion(new Proveedor("Cali"),34,2300),
				new Transaccion(new Proveedor("Paris"),120,120000)				
				);
		
		
		
		
		List<Empleado> empleados =Arrays.asList(
				new Empleado("SpongeBob","Krusty Krab","Bikini Bottom"),
				new Empleado("Michael Knight","Knight Industries","Stanford"),
				new Empleado("Clark Kent","Daily Planet","Metropolis"),
				new Empleado("Neil Peart","Music","Hamilton")
				);

		
	}

}
