package p41;

public class Multiplos {
	public static void main(String[] args) {
		
		int resultado = 0;
		for(int i = 10; i <= 700; i+=2) {
			resultado += i;
			System.out.println(i);
		}
		System.out.println("resultado: " + resultado);
	}
}
