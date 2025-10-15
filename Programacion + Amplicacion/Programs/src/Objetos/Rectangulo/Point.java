package Objetos.Rectangulo;

public class Point {
	public int x = 0;
	public int y = 0;
	
	public Point(int a, int b) {
		x = a;
		y = b;
	}
	
	
	public void movePoint(int a, int b) {
		this.x = a;
		this.y = b;
	}
	
  

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", getX()=" + getX() + ", getY()=" + getY() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void mostrarDato() {
		System.out.println("mostrar x: " + x);
		System.out.println("mostrar y" + y);
	}
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
