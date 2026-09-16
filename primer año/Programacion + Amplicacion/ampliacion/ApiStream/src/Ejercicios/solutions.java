package Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class solutions {

	public class Main {

		public static void main(String[] args) {
			List<String> listaEmail = Arrays.asList("holasi@gmail.com", "aaaaaaa@hotmail.com", "bbbbbb@gmail.com");
			List<Integer> listaEnteros = Arrays.asList(1, 2, 3, 5, 1, 7, 3, 4, 53);
			List<Integer> listaEnteros2;
			List<Integer> listaNegativos = Arrays.asList(1, 5, 2, -3, 8, -20, 30, -15);
			List<String> listaString = Arrays.asList("Maria", "Juan", "Pedro", "Pablo", "Ana", "Paula", "Reconocer", "Ana", "Bulgaria");
			List<Character> listaCaracter;
			Set<String> listaNoDuplicados;
			List<Persona> listaPersonas = List.of(new Persona("Mateo", 24), new Persona("Clara", 40), new Persona("Adrian", 29), new Persona("Diego", 67));
			Map<Empleado, String> mapaMasTresMil;
			List<Empleado> listaEmpleados = List.of(new Empleado(1, "Juan", 45000, "Ventas", 7), new Empleado(2, "Maria", 55000, "Ventas", 2), new Empleado(3, "Carmen", 3500, "Informática", 1), new Empleado(4, "Julio", 1300, "Comunicaciones", 8), new Empleado(5, "Alonso", 60000, "Informática", 12));
			Map<String, List<Empleado>> mapaEmpleados;
			Map<Integer, List<Persona>> mapaPersonas;
			List<Producto> listaProductos = List.of(new Producto("Pera", 25, 2, "Fruta"), new Producto("Manzana", 15, 5, "Fruta"), new Producto("Uva", 25, 23, "Fruta"));
			 List<Estudiante> listaEstudiantes = List.of(new Estudiante("Maria", 50), new Estudiante("Juan", 100), new Estudiante("Pedro", 70));
			Optional<Integer> total;
			Optional<String> cadena;
			Optional<Empleado> empleado;
			Optional<Producto> producto;
			OptionalDouble decimal;
			boolean condicion;
			long v;
			String c2;
			Map<String, Integer> mapa = Map.of("Pera", 20, "Manzana", 10, "Cereza", 30);
			int[] arrayEnteros = {1, 2, 3, 5, 1, 7, 3, 15};
			ArrayList<Integer> setEnteros = new ArrayList<>();
			int numm;
			
			// E1. Imprimir cada elemento de una lista de enteros.
			listaEnteros.stream()
						.forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E2. Imprimir cada nombre en mayúsculas en una lista de nombres
			listaString.stream()
					   .map(String::toUpperCase)
					   .forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E3. Sumar todos los elementos de una lista dentro del forEach.
			System.out.println(Main.ejer3(listaEnteros)[0]);
			System.out.println("---------------------------");
			
			// E4. Multiplicar cada número de una lista por 2 y mostrarlo.
			listaEnteros.stream()
						.map(a -> a*2)
						.forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E5. Agregar un sufijo a cada nombre en una lista.
			listaString.stream()
					   .map(a -> a + "Sufijo")
					   .forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E6. Sumar todos los números de una lista.
			total = listaEnteros.stream()
						.reduce((a,b) -> a + b);
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E7. Multiplicar todos los números de una lista y guardar el resultado en una variable.
			total = listaEnteros.stream()
								.reduce((a,b) -> a*b);
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E8. Encontrar el número mayor en una lista.
			total = listaEnteros.stream()
								.max(Integer::compare);
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E9. Concatenar una lista de palabras en una sola cadena
			cadena = listaString.stream()
								.reduce(String::concat);
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E10. Contar el número de caracteres en una lista de palabras
			total = listaString.stream()
								.map(String::length)
								.reduce((a, b) -> a + b);
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E11. Contar cuántos elementos hay en una lista de números
			System.out.println(Main.ejer11(listaEnteros)[0]);
			System.out.println("---------------------------");
			
			// E12. Contar cuántos nombres tienen más de 4 letras.
			v = listaString.stream()
								.filter(a -> a.length() > 4)
								.count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E13. Contar cuántos números son mayores que 10.
			v = listaEnteros.stream()
							.filter(a -> a > 10)
							.count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E14. Contar cuántas palabras comienzan con una vocal.
			v = listaString.stream()
						   .map(String::toLowerCase)
						   .filter(a -> a.startsWith("a", 0) || a.startsWith("e", 0) || a.startsWith("i", 0) || a.startsWith("o", 0) || a.startsWith("u", 0))
						   .count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E15. Contar cuántos números son pares en una lista.
			v = listaEnteros.stream()
							.filter(a -> a%2 == 0)
							.count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E16. Modificar los valores de una lista de enteros (multiplicar por 3 cada valor).
			listaEnteros.stream()
						.map(a -> a * 3)
						.forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E17. Convertir una lista de nombres en sus iniciales y almacenarlas en otra lista.
			listaCaracter = listaString.stream()
					   .map(a -> a.charAt(0))
					   .toList();
			System.out.println(listaCaracter);
			System.out.println("---------------------------");
			
			// E18. Sumar los valores de un Map y almacenarlos en una variable externa.
			System.out.println(Main.ejer18(mapa)[0]);
			System.out.println("---------------------------");
			
			// E19. Reemplazar cada valor de una lista de enteros según una condición.
			listaEnteros.stream()
						.map(a -> a%2 == 0 ? a * 20 : a * 10) // Si el numero es par, se multiplica por 20, sino por 10
						.forEach(System.out::println);
			System.out.println("---------------------------");
			
			// E20. Agregar los valores de un array a un conjunto utilizando forEach
			Arrays.stream(arrayEnteros)
				  .forEach(setEnteros::add);
			System.out.println(setEnteros);
			System.out.println("---------------------------");
			
			// E21. Calcular el máximo número par de una lista.
			total = listaEnteros.stream()
								.filter(a -> a%2 == 0)
								.max(Integer::compare);
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E22. Determinar si todos los elementos de una lista son positivos.
			condicion = listaEnteros.stream()
									.allMatch(a -> a>0);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E23. Encontrar la palabra más larga en una lista de strings.
			cadena = listaString.stream()
								.reduce((a,b) -> a.length() > b.length() ? a : b);
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E24. Concatenar solo las palabras que tengan más de 4 letras.
			cadena = listaString.stream()
								.filter(a -> a.length() > 4)
								.reduce(String::concat);
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E25. Calcular el factorial de un número usando reduce.
			System.out.println(Main.ejer25(4));
			System.out.println("---------------------------");
			
			// E26. Contar cuántas cadenas contienen al menos un dígito.
			v = listaString.stream()
							   .filter(s -> s.chars().anyMatch(Character::isDigit))
							   .count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E27. Contar cuántos empleados ganan más de 3000 y almacenarlos en  un Map.
//			
//			mapaMasTresMil = listaEmpleados.stream()
//										   .filter(e -> e.getSueldo() > 3000)
//										   .collect(Collectors.toMap(e->e, Empleado::getNombre));
//			mapaMasTresMil.forEach((e, nombre) -> {
//				System.out.println("Empleado (Salario): "+e.getSueldo()+" Nombre: "+nombre);
//			});
			System.out.println("---------------------------");
			
			// E28. Contar cuántos números en una lista son primos (usar rangeClosed).
			v = listaEnteros.stream()
							.filter(Main::ejer28)
							.count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E29. Contar cuántos strings en una lista son palíndromos.
			v = listaString.stream()
						   .filter(s -> Main.ejer29(s.toLowerCase()))
						   .count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E30. Contar cuántos números en un array cumplen una condición específica (múltiplos de 5 y mayores que 10)
			v= Arrays.stream(arrayEnteros)
				  .filter(s -> s%5==0 && s>10)
				  .count();
			System.out.println(v);
			System.out.println("---------------------------");
			
			// E31. Encontrar el primer número par en una lista de enteros.
			total = listaEnteros.stream()
								.filter(n -> n%2==0)
								.findFirst();
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E32. Encontrar cualquier número mayor que 50 en una lista.
			total = listaEnteros.stream()
								.filter(n -> n>50)
								.findAny();
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E33. Obtener el primer nombre que empiece con "M" en una lista.
			cadena = listaString.stream()
								.filter(s -> s.startsWith("M"))
								.findFirst();
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E34. Buscar cualquier número negativo en una lista.
			total = listaNegativos.stream()
								  .filter(n -> n<0)
								  .findAny();
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E35. Encontrar el primer string con más de 5 caracteres.
			cadena = listaString.stream()
								.filter(s -> s.length() > 5)
								.findFirst();
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E36. Verificar si hay algún número mayor que 100 en una lista.
			condicion = listaEnteros.stream()
									.anyMatch(n -> n>100);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E37. Comprobar si todos los elementos de una lista son pares.
			condicion = listaEnteros.stream()
									.allMatch(n -> n%2==0);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E38. Determinar si ninguna palabra en una lista empieza con "Z".
			condicion = listaString.stream()
								   .noneMatch(s -> s.startsWith("Z"));
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E39. Verificar si alguna persona en una lista tiene más de 30 años.
//			condicion = listaPersonas.stream()
//									 .anyMatch(p -> p.getEdad() > 30);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E40. Comprobar si todas las cadenas de una lista tienen al menos 3 caracteres.
			condicion = listaString.stream()
								   .allMatch(s -> s.length() >= 3);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E41. Convertir una lista de strings en una sola cadena separada por comas  (usar Collectors).
			c2 = listaString.stream()
								.collect(Collectors.joining(", "));
			System.out.println(c2);
			System.out.println("---------------------------");
			
			// E42. Filtrar los números mayores de 10 y almacenarlos en una nueva lista.
			listaEnteros2 = listaEnteros.stream()
										.filter(n -> n>10)
										.collect(Collectors.toList());
			System.out.println(listaEnteros2);
			System.out.println("---------------------------");
			
			// E43. Convertir una lista de palabras a un conjunto eliminando duplicados.
			listaNoDuplicados = listaString.stream()
										   .collect(Collectors.toSet());
			System.out.println(listaNoDuplicados);
			System.out.println("---------------------------");
			
			// E44. Agrupar una lista de personas por edad (usar groupingBy).
			mapaPersonas = listaPersonas.stream()
										.collect(Collectors.groupingBy(Persona::getEdad));
			
			// E45. Sumar todos los elementos de una lista con collect
			numm = listaEnteros.stream()
								.collect(Collectors.summingInt(n -> n));
			System.out.println(numm);
			System.out.println("---------------------------");
			
			// E46. Encontrar el primer número primo en una lista de enteros.
			total = listaEnteros.stream()	
								.filter(Main::ejer28)
								.findFirst();
			System.out.println(total.get());
			System.out.println("---------------------------");
			
			// E47. Encontrar cualquier cadena en una lista que contenga al menos dos dígitos.
			cadena = listaString.stream()
								.filter(s -> s.length() >= 2)
								.findAny();
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E48. Buscar el primer empleado con salario mayor a 50,000.
			empleado = listaEmpleados.stream()
									 .filter(e -> e.getSueldo() > 50000)
									 .findFirst();
			System.out.println(empleado.get().getNombre());
			System.out.println("---------------------------");
			
			// E49. Obtener cualquier ciudad de una lista que empiece con "B" y tenga más de 5 letras.
			cadena = listaString.stream()
								.filter(s -> s.length() > 5 && s.startsWith("B"))
								.findAny();
			System.out.println(cadena.get());
			System.out.println("---------------------------");
			
			// E50. Encontrar el primer producto en una lista con stock mayor a 10 y precio menor de 20.
			producto = listaProductos.stream()
									 .filter(p -> p.getStock() > 10 && p.getPrecio() < 20)
									 .findFirst();
			System.out.println(producto.get().getNombre());
			System.out.println("---------------------------");
			
			// E51. Verificar si hay algún estudiante con calificación superior a 90.
			condicion = listaEstudiantes.stream()
										.anyMatch(e -> e.getCalificacion() > 90);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E52. Comprobar si todos los productos en una lista tienen un precio mayor a 5.
			condicion = listaProductos.stream()
									  .allMatch(p -> p.getPrecio() > 5);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E53. Determinar si ninguna persona en una lista tiene menos de 18 años.
			condicion = listaPersonas.stream()
									 .noneMatch(p -> p.getEdad() < 18);
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E54. Verificar si hay algún número que sea potencia de 2 en una lista.
			condicion = listaEnteros.stream()
									.anyMatch(n -> ejer54(n));
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E55. Comprobar si todos los correos en una lista tienen el dominio "gmail.com"
			condicion = listaEmail.stream()
								  .allMatch(s -> ejer55(s));
			System.out.println(condicion);
			System.out.println("---------------------------");
			
			// E56. Agrupar empleados por departamento (Empleado tiene nombre, salario y departamento de atributos)
			mapaEmpleados = listaEmpleados.stream()
										  .collect(Collectors.groupingBy(Empleado::getDepartamento));
			
			// E57. Contar cuántos empleados hay por departamento.
			Map<String, Long> mapaEmpleadosContar = mapaEmpleados.entrySet().stream()
																			.collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));
			System.out.println(mapaEmpleadosContar);
			System.out.println("---------------------------");
			
			// E58. Obtener el salario promedio de una lista de empleados (usar Collectors).
			double sal_promedio = listaEmpleados.stream()
												.collect(Collectors.averagingDouble(Empleado::getSueldo));
			System.out.println(sal_promedio);
			System.out.println("---------------------------");
			
			// E59. Concatenar todas las palabras de una lista separadas por espacio.
			String res = listaString.stream()
								.collect(Collectors.joining(" "));
			System.out.println(res);
			System.out.println("---------------------------");
			
			// E60. Crear un conjunto con los nombres de empleados sin duplicados (usar Collectors).
			listaNoDuplicados = listaEmpleados.stream()
											  .map(Empleado::getNombre)
											  .collect(Collectors.toSet());
			System.out.println(listaNoDuplicados);
			System.out.println("---------------------------");
			
			// E61. Filtrar números pares de una lista.
			List<Integer> listaPares = listaEnteros.stream()
												   .filter(n -> n%2 == 0)
												   .toList();
			System.out.println(listaPares);
			System.out.println("---------------------------");
			
			// E62. Filtrar nombres que empiecen con "A".
			List<String> listaNombresA = listaString.stream()	
													.filter(s -> s.startsWith("A"))
													.toList();
			System.out.println(listaNombresA);
			System.out.println("---------------------------");
			
			// E63. Obtener productos con precio mayor a 50.
			List<Producto> listaProductosMasCinc = listaProductos.stream()
																 .filter(p -> p.getPrecio() > 50)
																 .toList();
			System.out.println(listaProductosMasCinc);
			System.out.println("---------------------------");
			
			// E64. Obtener la longitud de cada palabra en una lista.
			List<Integer> listaLongitudes = listaString.stream()
													   .map(String::length)
													   .toList();
			System.out.println(listaLongitudes);
			System.out.println("---------------------------");
			
			// E65. Obtener los cuadrados de una lista de números.
			List<Integer> listaCuadrados = listaEnteros.stream()
													   .map(n -> n*n)
													   .toList();
			System.out.println(listaCuadrados);
			System.out.println("---------------------------");
			
			// E66. Transformar una lista de empleados en una lista con sus nombres.
			List<String> nombresEmpleados = listaEmpleados.stream()
														  .map(Empleado::getNombre)
														  .toList();
			System.out.println(nombresEmpleados);
			System.out.println("---------------------------");
			
			// E67. Obtener todas las palabras de una lista de frases (en una frase las palabras están separadas por espacio, coma o guion) ??
			List<String> listaFrases = Arrays.asList("Hola si hola", "Programacion-en-Java", "Hola, Mundo");
			List<String> listaPalabras = listaFrases.stream()
										 			.map(s -> s.replace('-', ' ').replace(',', ' '))
										 			.flatMap(f -> Arrays.stream(f.split(" ")))
										 			.filter(p -> !p.isBlank())
										 			.toList();
			System.out.println(listaPalabras);
			System.out.println("---------------------------");
			
			// E68. Aplanar una lista de listas de números en una sola lista.
			List<List<Integer>> listaDeLista = Arrays.asList(Arrays.asList(1, 4, 6, 2), Arrays.asList(8, 2, 6, 1), Arrays.asList(0, 1, 3, 6));
			List<Integer> listaNumeros = listaDeLista.stream()
													 .flatMap(List::stream)
													 .toList();
			System.out.println(listaNumeros);
			System.out.println("---------------------------");
			
			// E69. Extraer y almacenar todas las letras individuales (lista de caracteres) de una lista de palabras.
			List<Character> listaChars = listaString.stream()
													.flatMapToInt(CharSequence::chars)
													.mapToObj(c -> (char) c)
													.toList();
			System.out.println(listaChars);
			System.out.println("---------------------------");
			
			// E70. Ordenar una lista de números de menor a mayor.
			List<Integer> listaOrdenados = listaEnteros.stream()
						.sorted()
						.toList();
			System.out.println(listaOrdenados);
			System.out.println("---------------------------");
			
			// E71. Ordenar una lista de nombres alfabéticamente.
			List<String> listaSOrdenados = listaString.stream()
													  .sorted()
													  .toList();
			System.out.println(listaSOrdenados);
			System.out.println("---------------------------");
			
			// E72. Ordenar una lista de empleados por salario descendente.
			List<Empleado> listaEOrdenadosSal = listaEmpleados.stream()
															  .sorted(Comparator.comparingDouble(Empleado::getSueldo).reversed())
															  .toList();
			listaEOrdenadosSal.forEach(e -> System.out.println(e.getNombre()));
			System.out.println("---------------------------");
			
			// E73. Eliminar elementos duplicados en una lista de números.
			List<Integer> listaNumSinDuplicados = listaEnteros.stream()
															  .distinct()
															  .toList();
			System.out.println(listaNumSinDuplicados);
			System.out.println("---------------------------");
			
			// E74. Eliminar nombres repetidos en una lista.
			List<String> listaStrSinDuplicados = listaString.stream()
															.distinct()
															.toList();
			System.out.println(listaStrSinDuplicados);
			System.out.println("---------------------------");
			
			// E75. Obtener los primeros 3 números de una lista.
			List<Integer> listaTresPNum = listaEnteros.stream()
													  .limit(3)
													  .toList();
			System.out.println(listaTresPNum);
			System.out.println("---------------------------");
			
			// E76. Saltar los primeros 2 números de una lista  y quedarse con el resto.
			List<Integer> listaResto = listaEnteros.stream()
												   .skip(2)
												   .toList();
			System.out.println(listaResto);
			System.out.println("---------------------------");
			
			// E77. Obtener los 2 primeros productos más caros.
			List<Producto> productosCaros = listaProductos.stream()
														  .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
														  .limit(2)
														  .toList();
			productosCaros.forEach(p -> System.out.println(p.getNombre()));
			System.out.println("---------------------------");
			
			// E78. Filtrar empleados con salario mayor a 50,000 y antigüedad mayor a 5 años.
			List<Empleado> empleadosFiltro = listaEmpleados.stream()
														   .filter(e -> e.getSueldo() > 50000 && e.getAntiguedad() > 5)
														   .toList();
			empleadosFiltro.forEach(e -> System.out.println(e.getNombre()));
			System.out.println("---------------------------");
			
			// E79. Filtrar pedidos con al menos un producto con precio mayor a 100
			List<Producto> l1 = Arrays.asList(new Producto("Camisa", 10, 40, "Ropa"), new Producto("Pantalones", 70, 70, "Ropa"), new Producto("Gafas", 150, 150, "Ropa"));
			List<Producto> l2 = Arrays.asList(new Producto("Portatil", 1500, 1500, "Electronica"), new Producto("Televisor", 4000, 4000, "Electronica"), new Producto("Cascos", 70, 70, "Electronica"));
			
			List<Pedido> listaPedidos = Arrays.asList(new Pedido(l1), new Pedido(l2));
			List<Pedido> listaPFiltrada = listaPedidos.stream()
													  .filter(pe -> pe.getProductos().stream()
															  						 .anyMatch(p -> p.getPrecio() > 100))
													  .toList();
			listaPFiltrada.forEach(pe -> pe.getProductos().forEach(p -> System.out.println(p.getNombre())));
			System.out.println("---------------------------");
			
			// E80. Convertir lista de empleados en una lista de nombres en mayúsculas .
			List<String> listaNEmpleados = listaEmpleados.stream()
														 .map(e -> e.getNombre().toUpperCase())
														 .toList();
			System.out.println(listaNEmpleados);
			System.out.println("---------------------------");
			
			// E81. Obtener el promedio de los salarios de los empleados.
			decimal = listaEmpleados.stream()
										 .mapToDouble(Empleado::getSueldo)
										 .average();
			System.out.println(decimal.getAsDouble());
			System.out.println("---------------------------");
			
			// E82. Obtener todas las palabras únicas de una lista de libros (cada libro es una lista de palabras).
			Libro li1 = new Libro("Enredados", Arrays.asList("Princesa", "Cuento", "Pelicula", "Princesa", "Principe", "Cuento", "Palacio"));
			Libro li2 = new Libro("Accion", Arrays.asList("Dragon", "Caballero", "Espada", "Espada", "Escudo"));
			Libro li3 = new Libro("Accion", Arrays.asList("Coche", "Motor", "Ganador", "Carrera", "Pista", "Carrera", "Circuito", "Circuito"));
			List<Libro> listaLibros = Arrays.asList(li1, li2, li3);
			List<String> listaPalabrasLibros = listaLibros.stream()
													.flatMap(l -> l.getPalabras().stream())
													.distinct()
													.toList();
			System.out.println(listaPalabrasLibros);
			System.out.println("---------------------------");
			
			// E83. Obtener todas las transacciones realizadas por clientes de una lista de bancos. La clase Banco tiene como atributo una lista de transacciones
			Banco b1 = new Banco(Arrays.asList(1300.0, 233.0, 439.0, 129.0, 402.0));
			Banco b2 = new Banco(Arrays.asList(2892.0, 53.0, 3234.0, 12.0, 66.0));
			Banco b3 = new Banco(Arrays.asList(12313.0, 23.0, 45.0, 123.0, 234.0));
			Banco b4 = new Banco(Arrays.asList(7585.0, 354.0, 5123.0, 1242.0, 1234.0));
			List<Banco> listaBancos = Arrays.asList(b1, b2, b3, b4);
			List<Double> listaTransacciones = listaBancos.stream()
														 .flatMap(b -> b.getTransacciones().stream())
														 .toList();
			System.out.println(listaTransacciones);
			System.out.println("---------------------------");
			
			// E84. Ordenar una lista de empleados por salario descendente y luego por nombre ascendente. Usar thenComparing.
			List<Empleado> empleadosOrdenados1 = listaEmpleados.stream()
															   .sorted(Comparator.comparingDouble(Empleado::getSueldo).reversed().thenComparing(Empleado::getNombre))
															   .toList();
			
			// E85. Ordenar pedidos por cantidad de productos y luego por el total del pedido. Pedido tiene como atributo una lista de productos. Cada producto tiene nombre y precio
			List<Pedido> pedidosOrdenados = listaPedidos.stream()
														.sorted(Comparator.comparingInt((Pedido p) -> p.getProductos().size()).thenComparingDouble(p -> p.getProductos().stream().mapToDouble(Producto::getPrecio).sum()))
														.toList();
			
			// E86. Eliminar empleados duplicados con el mismo nombre y salario.
			List<Empleado> empleadosSinDuplicadosNS = listaEmpleados.stream()
																	.collect(Collectors.toMap(e -> e.getNombre() + "-" + e.getSueldo(),  e -> e, (existente, nuevo) -> existente))
																	.values()
																	.stream()
																	.toList();
			empleadosSinDuplicadosNS.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			/* E87. Obtener productos únicos basados en su nombre (ignorar duplicados con diferentes precios). 
			 		Cada producto tiene nombre y precio. En la lista original puede haber mismo nombre con distinto 
			 		precio. Se puede usar Collectors.toMap 
			*/
			List<Producto> productosSinDuplicado = listaProductos.stream()
																 .collect(Collectors.toMap(p -> p.getNombre(), p -> p, (existente, nuevo) -> existente))
																 .values()
																 .stream()
																 .toList();
			productosSinDuplicado.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E88. Obtener los 5 empleados con mayor salario.
			List<Empleado> empleadosMayorSal = listaEmpleados.stream()
															  .sorted(Comparator.comparingDouble(Empleado::getSueldo).reversed())
															  .limit(5)
															  .toList();
			empleadosMayorSal.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E89. Saltar los primeros 3 elementos y tomar los siguientes 5 de una lista de clientes
			List<Persona> cincoSigPersonas = listaPersonas.stream()
														  .skip(3)
														  .limit(5)
														  .toList();
			cincoSigPersonas.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E90. Filtrar empleados con salario mayor a 40,000, ordenarlos por antigüedad y obtener los primeros 3.
			List<Empleado> empleadosFiltrados = listaEmpleados.stream()
															  .filter(e -> e.getSueldo() > 40000)
															  .sorted(Comparator.comparingInt(Empleado::getAntiguedad))
															  .limit(3)
															  .toList();
			empleadosFiltrados.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E91. Obtener los 3 productos más caros, pero ignorando los 2 primeros.
			List<Producto> listaProductos2 = listaPedidos.stream()
														 .flatMap(pe -> pe.getProductos().stream())
														 .toList();
			List<Producto> productosCaros2 = listaProductos2.stream()
														   .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
														   .skip(2)
														   .limit(3)
														   .toList();
			productosCaros2.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E92. Filtrar empleados cuyo nombre empiece con "A", obtener sus salarios y calcular la suma total.
			double resultado = listaEmpleados.stream()
									 .filter(e -> e.getNombre().startsWith("A"))
									 .mapToDouble(Empleado::getSueldo)
									 .sum();
			System.out.println(resultado);
			System.out.println("---------------------------");
			
			// E93. Obtener una lista de nombres de empleados cuyo salario sea mayor a 50,000.
			List<String> nombresSalario = listaEmpleados.stream()
														.filter(e -> e.getSueldo() > 50000)
														.map(Empleado::getNombre)
														.toList();
			System.out.println(nombresSalario);
			System.out.println("---------------------------");
			
			// E94. Filtrar números primos de una lista y guardarlos en una nueva lista.
			List<Integer> numerosPrimos = listaEnteros.stream()
													  .filter(Main::ejer28)
													  .toList();
			System.out.println(numerosPrimos);
			System.out.println("---------------------------");
			
			// E95. Convertir una lista de pedidos en una lista de sus totales.
			List<Double> totales = listaPedidos.stream()
											   .map(pe -> pe.getProductos().stream().mapToDouble(Producto::getPrecio).sum())
											   .toList();
			System.out.println(totales);
			System.out.println("---------------------------");

			// E96. Extraer la lista de títulos de una colección de libros, eliminando duplicados.
			List<String> listaTitulos = listaLibros.stream()
												   .map(Libro::getTitulo)
												   .distinct()
												   .toList();
			System.out.println(listaTitulos);
			System.out.println("---------------------------");
			
			// E97. Filtrar las personas cuya edad sea mayor a 30 y ordenarlas por edad en una lista.
			List<Persona> personasOrdenadas = listaPersonas.stream()
														   .filter(p -> p.getEdad() > 30)
														   .sorted(Comparator.comparingInt(p -> p.getEdad()))
														   .toList();
			personasOrdenadas.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E98. Obtener una lista con los primeros 5 productos más vendidos (Entiendo que los mas vendidos son los que menos stock tienen)
			List<Producto> productosMasVendidos = listaProductos2.stream()
																 .sorted(Comparator.comparingInt(Producto::getStock))
																 .limit(5)
																 .toList();
			productosMasVendidos.forEach(e -> System.out.println(e.getNombre()));;
			System.out.println("---------------------------");
			
			// E99. Generar una lista con los nombres de los estudiantes con calificación mayor a 8.
			List<String> listaCalificacionOcho = listaEstudiantes.stream()
																 .filter(e -> (e.getCalificacion()/10) > 8)
																 .map(Estudiante::getNombre)
																 .toList();
			System.out.println(listaCalificacionOcho);
			System.out.println("---------------------------");
			
			// E100. Obtener una lista de números cuadrados de otra lista de enteros.
			List<Integer> listaCuadrados2 = listaEnteros.stream()
													   .map(n -> n*n)
													   .toList();
			System.out.println(listaCuadrados2);
			System.out.println("---------------------------");
			
			// E101. Filtrar clientes VIP y almacenar sus correos electrónicos en una lista.
			List<Cliente> listaClientes = Arrays.asList(
					new Cliente("Maria", "maria@hotmail.com", true),
					new Cliente("Juan", "juan@hotmail.com", false),
					new Cliente("Luna", "luna@hotmail.com", true),
					new Cliente("Lola", "lola@hotmail.com", false)
			);
			
			List<String> listaCorreosVip = listaClientes.stream()
														.filter(p -> p.isVip() ? true : false)
														.map(Cliente::getCorreo)
														.toList();
			System.out.println(listaCorreosVip);
			System.out.println("---------------------------");
			
			// E102. Obtener una lista de categorías únicas de productos.
			List<String> listaCategorias = listaProductos2.stream()
														  .map(Producto::getCategoria)
														  .distinct()
														  .toList();
			System.out.println(listaCategorias);
			System.out.println("---------------------------");
			
			// E103. Convertir una lista de empleados en un array de objetos.
			Object[] objetos = listaEmpleados.stream()
											 .toArray(Object[]::new);
			
			// E104. Filtrar y convertir nombres de productos en un array de Strings.
			String[] nombres = listaProductos2.stream()
											  .map(Producto::getNombre)
											  .toArray(String[]::new);
			
			for(int i=0; i<nombres.length;i++) {
				System.out.println(nombres[i]);
			}
			System.out.println("---------------------------");
			
			// E105. Obtener un array con los primeros 10 números pares de una lista de enteros
			Integer[] numerosPares = listaEnteros.stream()
											 .filter(n -> n%2 == 0)
											 .limit(10)
											 .toArray(Integer[]::new);
			
			for(int i=0; i<numerosPares.length;i++) {
				System.out.println(numerosPares[i]);
			}
			System.out.println("---------------------------");
			
			// E106. Convertir una lista de edades en un array de enteros.
			Integer[] edades = listaPersonas.stream()
											.map(Persona::getEdad)
											.toArray(Integer[]::new);
			for(int i=0; i<edades.length;i++) {
				System.out.println(edades[i]);
			}
			System.out.println("---------------------------");
			
			// E107. Extraer las calificaciones de los alumnos en un array de doubles.
			Integer[] calificaciones = listaEstudiantes.stream()
													  .map(Estudiante::getCalificacion)
													  .toArray(Integer[]::new);
			for(int i=0; i<calificaciones.length;i++) {
				System.out.println(calificaciones[i]);
			}
			System.out.println("---------------------------");
		}
		
		private static int[] ejer3(List<Integer> lista) {
			int[] total = {0};
			lista.stream()
				 .forEach(n -> total[0]+=n);
			return total;
		}
		
		private static int[] ejer11(List<Integer> lista) {
			int[] total = {0};
			lista.stream()
				 .forEach(n -> total[0]++);
			return total;
		}
		
		private static int[] ejer18(Map<String, Integer> mapa) {
			int[] total = {0};
			mapa.forEach((a,b) -> total[0] += b);
			return total;
		}
		
		private static long ejer25(int n) {
			return IntStream.rangeClosed(1, n)
							.reduce(1, (a,b) -> a*b);
		}
		
		private static boolean ejer28(int n) {
			if(n<=1) { return false; }
			return IntStream.rangeClosed(2, (int) Math.sqrt(n))
							.noneMatch(i -> n % i == 0);
		}
		
		private static boolean ejer54(int n) {
			if(n<0) {
				return false;
			}
			
			while(n%2 == 0) {
				n = n/2;
			}
			
			return n==1;
		}
		
		private static boolean ejer29(String s) {
			if(s.length() <= 1) {
				return true;
			}
			if(s.charAt(0) != s.charAt(s.length()-1)) {
				return false;
			}
			return ejer29(s.substring(1, s.length()-1));
		}
		
		private static boolean ejer55(String s) {
			if(!s.contains("@")) {
				return false;
			}
			int idx=0;
			String dominio = "";
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '@') {
					idx = i; 
					break;
				}
			}
			dominio = s.substring(idx+1);
			return dominio.equalsIgnoreCase("gmail.com");
		}
	}

}
