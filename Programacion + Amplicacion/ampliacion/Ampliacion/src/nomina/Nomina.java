package nomina;

import java.util.List;
import java.util.Objects;

public record Nomina(String empleado, List<String> conceptos) {
	 // 1. Constructor compacto para limpiar la lista usando Stream API
	 public Nomina {

		 empleado = Objects.requireNonNullElse(empleado, "Sin nombre");
		 conceptos = (conceptos == null) ? List.of() : conceptos.stream()
		 .filter(c -> c != null && !c.isBlank())
		 .distinct()
		 .toList();
	 }
	 
	 // Método with para cambiar el empleado
	 public Nomina withEmpleado(String nuevoEmpleado) {
		 return new Nomina(nuevoEmpleado, this.conceptos);
	 
	 }
	 
	 // Método with para cambiar la lista completa de conceptos
	 public Nomina withConceptos(List<String> nuevosConceptos) {
		 return new Nomina(this.empleado, nuevosConceptos);
	 }
	 
}