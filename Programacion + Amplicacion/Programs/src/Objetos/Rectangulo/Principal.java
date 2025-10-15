package Objetos.Rectangulo;

public class Principal {
	public static void main(String[] args) {
		
		Point punto1;
		
		Rectangle rectangulo1, rectangulo2;
		
		rectangulo1 = new Rectangle(new Point(3,4), 4,6);
		
		punto1 = new Point(5,6);
		
		rectangulo2 = new Rectangle(punto1, 6, 7);
		
		System.out.println(rectangulo1 + " || " + rectangulo1.getPoint() + " || " + rectangulo2.getPoint());
		

		System.out.println("memoria del punto: " + punto1.toString()); 
		
		
		System.out.println(punto1.getX());
		System.out.println(punto1.getY());
		punto1.movePoint(0,0);

		System.out.println(punto1.getX());
		System.out.println(punto1.getY());
		
		System.out.println(punto1.toString());
		punto1.mostrarDato();
	}
}
