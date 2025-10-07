package Objetos1;

public class Principal {
	public static void main(String[] args) {
		
		Point punto1;
		
		Rectangle rectangulo1, rectangulo2;
		
		rectangulo1 = new Rectangle(new Point(3,4), 4,6);
		
		punto1 = new Point(5,6);
		
		rectangulo2 = new Rectangle(punto1, 6, 7);
		
		System.out.println(rectangulo1 + " || " + rectangulo1.getPoint() + " || " + rectangulo2.getPoint());
		
	}
}
