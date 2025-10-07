package Objetos1;

public class Rectangle {
	public int width = 0;
	public int height = 0;
	public Point origin;
	
	
	public Rectangle() {
		this.origin = new Point(0, 0);
	}
	
	public Rectangle(Point p) {
		this.origin = p;
	}
	
	public Rectangle(int w, int h) {
		origin = new Point(0,0);
		this.width = w;
		this.height = h;
	}
	
	public Rectangle(Point p, int w, int h) {
		this.origin = p;
		this.width = w;
		this.height = h;
	}
	public void move(int x, int y) {
		this.origin.x = x;
		this.origin.y = y;
	}
	public int getArea() {
		return width * height;
	}
	public Point getPoint() {
		return this.origin;
	}
}
