package testexamen1;
import java.util.List;
import java.util.stream.Collectors;


public class prueba {
	public static void main(String[] args) {
		
		List<Restaurante> restaurantes = List.of(
			    new Restaurante("R1", List.of("SPA", "WIFI"), 12, List.of(new Reserva(2), new Reserva(4))),
			    new Restaurante("R2", List.of("PARKING"), 14, List.of(new Reserva(3))),
			    new Restaurante("R3", List.of("SPA", "PARKING"), 11, List.of(new Reserva(5), new Reserva(1))),
			    new Restaurante("R4", List.of("WIFI"), 10, List.of())
			);
		List<Restaurante> pruebaList = 	restaurantes.stream()
										.filter(n -> n.getCheckIn() > 13)
										.collect(Collectors.toList());
		
		System.out.println(pruebaList);
	
	
//		Obtén los restaurantes que:
//
//			tengan servicio "SPA"
//			checkIn < 13
		
									
										
										
									
		
	}
}
