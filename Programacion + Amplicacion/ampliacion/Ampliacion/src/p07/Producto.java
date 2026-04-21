package p07;

public class Producto {
	public static int calcularProducto(int num1, int num2) {
		if(num2 == 1) return num1;	
		return num1 + calcularProducto(num1, num2 - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(calcularProducto(5, 5));
	}
}
