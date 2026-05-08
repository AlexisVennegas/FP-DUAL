package Ejercicios;

import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class pinfinite {
	public static void main(String[] args) {
		
		List<Integer> listaNumeros =	List.of(10,9,8,7,6,5,4,3,2,1);
		List<String> listStrings  =		List.of("Alexis", "Ana", "Eric3k", "12Alexis"); 
		List<Empleado> listaEmpleados = List.of(new Empleado(1, "Juan", 45000, "Ventas", 7), new Empleado(2, "Maria", 55000, "Ventas", 2), new Empleado(3, "Carmen", 3500, "Informática", 1), new Empleado(4, "Julio", 1300, "Comunicaciones", 8), new Empleado(5, "Alonso", 60000, "Informática", 12));
		List<String> listaCiudades    =	List.of("Madrid", "ban", "Bal", "Barcelona");
		List<Producto> listaProductos = List.of(new Producto("Pera", 25, 2, "Fruta"), new Producto("Manzana", 15, 5, "Fruta"), new Producto("Uva", 25, 55, "Fruta"));
		List<Estudiante> listaEstudiantes = List.of(new Estudiante("Maria", 50), new Estudiante("Juan", 100), new Estudiante("Pedro", 70));
		List<Persona> listaPersonas = List.of(new Persona("Mateo", 24), new Persona("Clara", 40), new Persona("Adrian", 29), new Persona("Diego", 67));
		List<String> listaCorreos = Arrays.asList("holasi@gmail.com", "aaaaaaa@hotmail.com", "bbbbbb@gmail.com");

		//  45. Sumar todos los elementos de una lista con collect

		int resultado =	listaNumeros.stream()
						.collect(Collectors.summingInt(n -> n));
		
		//System.out.println(resultado);
		
		//  46. Encontrar el primer número primo en una lista de enteros
		Optional<Integer> numeroPrimo = 	listaNumeros.stream()
						.filter(n -> n > 1 && java.util.stream.IntStream.range(2, n)
                        .noneMatch(divisor -> n % divisor == 0)) // <--- Esto devuelve el boolean                     
						.findFirst();
						
		//System.out.println(numeroPrimo.get());
		
		//  47. Encontrar cualquier cadena en una lista que contenga al menos dos dígitos

				Optional<String> sol47 =	listStrings.stream()
						.filter(n -> n.chars().filter(Character::isDigit).count() == 2)
						.findFirst();
			
						//System.out.println(sol47.get());
		
		//  48. Buscar el primer empleado con salario mayor a 50,000
		
				Optional<Empleado> sol48 =	listaEmpleados.stream()
									.filter(n -> n.getSueldo() > 50000)
									.findFirst();
				//System.out.println(sol48.get().toString());
		
		//  49. Obtener cualquier ciudad de una lista que empiece con "B" y tenga más de 5 letras

		Optional<String> sol49 = listaCiudades.stream()
		.filter(n -> n.length() > 5)
		.filter(n -> n.startsWith("B"))
		.findAny();
		
				//	System.out.println(sol49.get());
		
		 //50. Encontrar el primer producto en una lista con stock mayor a 10 y precio menor de 20
		
			Optional<Producto> sol50 =	listaProductos.stream()
										.filter(n -> n.getStock() > 10)
										.filter(n -> n.getPrecio() < 20)
										.findFirst();
			
			//System.out.println(sol50.get().toString());
					
		//  51. Verificar si hay algún estudiante con calificación superior a 90

			Optional<Estudiante> sol51 = listaEstudiantes.stream()
							.filter(n -> n.getCalificacion() > 50)
							.findAny();
			
			//sol51.ifPresent(System.out::println);
		
		//  52. Comprobar si todos los productos en una lista tienen un precio mayor a 5
		
		boolean sol52 = listaProductos.stream()
						.allMatch(n -> n.getPrecio() > 5);
		
			//System.out.println("todos los productos tienen un precio > 5? " + sol52);
		
		//  53. Determinar si ninguna persona en una lista tiene menos de 18 años

			boolean sol53 = listaPersonas.stream()
							.noneMatch(n -> n.getEdad() < 18);
			
			//System.out.println("todas las personas tienen 18? " + sol53);
		
		//  54. Verificar si hay algún número que sea potencia de 2 en una lista

		boolean sol54 =	listaNumeros.stream()
						.anyMatch(n -> n > 0 && Integer.bitCount(n) == 1);
		
		//System.out.println("hay algun numero ptoencia 2? " + sol54);
		
		
		
		//  55. Comprobar si todos los correos en una lista tienen el dominio "gmail.com"

			boolean sol55 = listaCorreos.stream()
							.allMatch(n -> n.contains("gmail.com"));
		
			// System.out.println("todos los correos tienen gmail.com? " + sol55);
		
			
		// 56.-  Agrupar empleados por departamento (Empleado tiene nombre, salario y departamento de
		// atributos)
		
			
		Map<String, List<Empleado>> sol56 =  listaEmpleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento));
		
	
		
		
		//  57. Contar cuántos empleados hay por departamento	
		
		Map<String, Long> sol57 =  	listaEmpleados.stream()
												.collect(Collectors.groupingBy(
																	Empleado::getDepartamento, 
																	Collectors.counting()
																	));
			// System.out.println(sol57.toString());				
													
		//	58. Obtener el salario promedio de una lista de empleados (usar Collectors)
										
			Double sol58 = listaEmpleados.stream().collect(Collectors.averagingDouble(Empleado::getSueldo));
			
	
			
		//  59. Concatenar todas las palabras de una lista separadas por espacio
				
			
			String sol59 =	listStrings.stream()
							.collect(Collectors.joining(" "));
			
			
			
		// 60. Crear un conjunto con los nombres de empleados sin duplicados (usar Collectors)
			
			
			Set<String> sol60 =	listaEmpleados.stream()
								.map(Empleado::getNombre)
								.collect(Collectors.toSet());
			
		
		// 61. Filtrar números pares de una lista
			
			List<Integer> sol61 =	listaNumeros.stream()
									.filter(n -> n % 2 == 0)
									.collect(Collectors.toList());

	   //  62. Filtrar nombres que empiecen con "A"

			List<String> sol62 =	listStrings.stream()
									.filter(n -> n.startsWith("A"))
									.collect(Collectors.toList());
			
		
	  //  63. Obtener productos con precio mayor a 50

			
			List<Producto> sol63 =	listaProductos.stream()
									.filter(n -> n.getPrecio() > 50)
									.collect(Collectors.toList());
			
	//  64. Obtener la longitud de cada palabra en una lista

			List<Integer> sol64 =	listStrings.stream()
									.map(String::length)
									.collect(Collectors.toList());
			System.out.println(sol64);	
				
	}
}
