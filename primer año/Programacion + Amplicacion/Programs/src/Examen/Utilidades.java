package Examen;

public class Utilidades {

	
	public static boolean comprobarHechicero(Hechicero hechicero) {
		return hechicero.getNombre().contains("aeiou") && hechicero.getPergamino().getHechizo().contains("h");
	}
}
