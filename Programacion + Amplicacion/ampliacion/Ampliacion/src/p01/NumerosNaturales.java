package p01;

public class NumerosNaturales {
	
	
	public static void calcularNumerosNaturales(int numero, int resultado) {
		if(numero == 0) return;
		System.out.println(resultado += 1);
		calcularNumerosNaturales(numero - 1, resultado);
	}
	public static void main(String[] args) {
		calcularNumerosNaturales(10, 0);
	}
}
