package Ejercicios;

import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class pinfinite {
	public static void main(String[] args) {
		
		List<Integer> listaNumeros =	List.of(10,9,8,7,6,5,4,3,2,1, 10);
		List<String> listStrings  =		List.of("Alexis", "Ana", "Ana", "12", "Eric3k", "Zendaya", "Carlos", "Fabio"); 
		List<Empleado> listaEmpleados = List.of(new Empleado(1, "Juan", 45000, "Ventas", 7), new Empleado(2, "Maria", 55000, "Ventas", 2), new Empleado(3, "Carmen", 3500, "Informática", 1), new Empleado(4, "Julio", 1300, "Comunicaciones", 8), new Empleado(5, "Alonso", 60000, "Informática", 12));
		List<String> listaCiudades    =	List.of("Madrid", "ban", "Bal", "Barcelona");
		List<Producto> listaProductos = List.of(new Producto("Pera", 25, 2, "Fruta"), new Producto("Manzana", 15, 5, "Fruta"), new Producto("Uva", 25, 55, "Fruta"));
		List<Estudiante> listaEstudiantes = List.of(new Estudiante("Maria", 50), new Estudiante("Juan", 100), new Estudiante("Pedro", 70));
		List<Persona> listaPersonas = List.of(new Persona("Mateo", 24), new Persona("Clara", 40), new Persona("Adrian", 29), new Persona("Diego", 67));
		List<String> listaCorreos = Arrays.asList("holasi@gmail.com", "aaaaaaa@hotmail.com", "bbbbbb@gmail.com");
		List<String> listaFrases = Arrays.asList("Hola si hola", "Programacion-en-Java", "Hola, Mundo");
		List<List<Integer>> listaDeListaNumeros = Arrays.asList(Arrays.asList(1, 4, 6, 2), Arrays.asList(8, 2, 6, 1), Arrays.asList(0, 1, 3, 6));

		//  45. Sumar todos los elementos de una lista con collect

		int resultado =	listaNumeros.stream()
						.collect(Collectors.summingInt(n -> n));
		
		//System.out.println(resultado);
		
		//  46. Encontrar el primer número primo en una lista de enteros
//		Optional<Integer> numeroPrimo = 	listaNumeros.stream()
//						.filter(n -> n > 1 && java.util.stream.IntStream.range(2, n)
//                        .noneMatch(divisor -> n % divisor == 0)) // <--- Esto devuelve el boolean                     
//						.findFirst();
						
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
			
	//  65. Obtener los cuadrados de una lista de números

			List<Integer> sol65 =	listaNumeros.stream()
									.map(n -> n * n)
									.collect(Collectors.toList());
			
   //  66. Transformar una lista de empleados en una lista con sus nombres
			
			List<String> sol66 =	listaEmpleados.stream()
									.map(n -> n.getNombre())
									.toList();
			
	// 67. Obtener todas las palabras de una lista de frases (en una frase las palabras están separadas por
	// espacio, coma o guion)
			
		
			List<String> sol67 =	listaFrases.stream()
					.flatMap(n -> Arrays.stream(n.split("[^a-zA-Z0-9]+"))) 
					.filter(s -> !s.isEmpty())
					.collect(Collectors.toList());

	
	//  68. Aplanar una lista de listas de números en una sola lista

			List<Integer> sol68 =	listaDeListaNumeros.stream()
			.flatMap(List::stream)
			.toList();
			
			
			
	//  69. Extraer y almacenar todas las letras individuales (lista de caracteres) de una lista de palabras

			List<String> sol69 =	listStrings.stream()
									.map(String::valueOf)
									.collect(Collectors.toList());
			
			
	// 70. Ordenar una lista de números de menor a mayor

			List<Integer> sol70 =	listaNumeros.stream()
									.sorted()
									.collect(Collectors.toList());
			
		
	//  71. Ordenar una lista de nombres alfabéticamente


			
	//  72. Ordenar una lista de empleados por salario descendente

			List<Empleado> sol72 =	listaEmpleados.stream()
									.sorted(Comparator.comparingDouble(Empleado::getSueldo).reversed())
									.collect(Collectors.toList());
			
	//  73. Eliminar elementos duplicados en una lista de números

			List<Integer> sol73 =	listaNumeros.stream()
									.distinct()
									.collect(Collectors.toList());
	//  74. Eliminar nombres repetidos en una lista

			List<String> sol74 =	listStrings.stream()
									.distinct()
									.collect(Collectors.toList());
	//  75. Obtener los primeros 3 números de una lista
			
			List<Integer> sol75 =	listaNumeros.stream()
									.limit(3)
									.collect(Collectors.toList());
			
			System.out.println(sol75);
		
	//  76. Saltar los primeros 2 números de una lista y quedarse con el resto

			List<Integer> sol76 =	listaNumeros.stream()
									.skip(2)
									.collect(Collectors.toList());
		
	//  77. Obtener los 2 primeros productos más caros

			List<Producto> sol77 =	listaProductos.stream()
								.sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
								.limit(2)
								.collect(Collectors.toList());
								
	//  78. Filtrar empleados con salario mayor a 50,000 y antigüedad mayor a 5 años

			
			List<Empleado> sol78 =	listaEmpleados.stream()
									.filter(n -> n.getSueldo() > 50000 && n.getAntiguedad() > 5)
									.collect(Collectors.toList());
			
			System.out.println(sol78);
								
	//  79. Filtrar pedidos con al menos un producto con precio mayor a 100

		
			List<Producto> l1 = Arrays.asList(new Producto("Camisa", 10, 40, "Ropa"), new Producto("Pantalones", 70, 70, "Ropa"), new Producto("Gafas", 150, 150, "Ropa"));
			List<Producto> l2 = Arrays.asList(new Producto("Portatil", 1500, 1500, "Electronica"), new Producto("Televisor", 4000, 4000, "Electronica"), new Producto("Cascos", 70, 70, "Electronica"));
						
			List<Pedido> listaPedidos = Arrays.asList(new Pedido(l1), new Pedido(l2));
						
					
			
		
	}
}
