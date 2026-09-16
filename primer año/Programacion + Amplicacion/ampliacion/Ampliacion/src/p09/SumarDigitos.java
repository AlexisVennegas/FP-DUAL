package p09;

public class SumarDigitos {
	
	public static int calcularSuma(int numero) {
		
		if(numero ==  0) return 0	;
		
		
		return (numero % 10) + calcularSuma(numero / 10);
		
	}
	
	public static void main(String[] args) {
		System.out.println("resultado: " + calcularSuma(1234));
	}
}
