package nomina;


import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;


public class pruebaCollect {

	
	public static void main(String[] args) {
		
		List<Empleado>  empleados = List.of(
				 new Empleado("Juan", "IA", "Peru"),
				 new Empleado("perez", "PROGRAM", "EU"),
				 new Empleado("Erick", "IA", "EU"),
				 new Empleado("Kevin", "RRHH", "EU"),
				 new Empleado("Wil", "PROGRAM", "EU")
				);
	
		//  Agrupamiento
		Map<String, List<Empleado>> porDept = empleados  
		.stream()   
		.collect(groupingBy(Empleado::getDepartamento));
		
		System.out.println(porDept);
		
	}
}
