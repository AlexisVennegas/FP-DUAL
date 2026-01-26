package Examen;

public class Principal {
	public static void main(String[] args) {
		
		
		Pergamino perga = new Pergamino(2, "HHHHOOOLAAHH");
		Hechicero Harry = new Hechicero("1", "Ahloehneiuh", perga);
		
	
	
		
		System.out.println(perga.transformarHechizo(true));
	}
}
