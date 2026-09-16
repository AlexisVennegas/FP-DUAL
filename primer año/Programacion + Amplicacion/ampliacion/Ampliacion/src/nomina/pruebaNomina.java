package nomina;

import java.util.List;

public class pruebaNomina {

	public static void main(String[] args) {
		
		List<Nomina> nominasMensuales = List.of(
				 new Nomina("Juan", List.of("Sueldo Base", "Transporte")),
				 new Nomina("Juan", List.of("Sueldo Base", "Bono Navidad")),
				 new Nomina("Juan", List.of("Sueldo Base", "Horas Extra"))
				);
		
		int totalConceptosUnicos = nominasMensuales.stream()
				 .map(n -> n.conceptos().size()) 
				 .reduce(0, Integer::sum); 
		
		Long totalConceptos2 = nominasMensuales.stream()
				.flatMap(n-> n.conceptos().stream())
				.distinct().count();
		
		
		System.out.println(totalConceptosUnicos);
		System.out.println(nominasMensuales);
		System.out.println(totalConceptos2);
	}
}
