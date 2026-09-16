package bloque2;

public class Nsumando {
	public static int calcularSuma(int numero) {
		
		if(numero < 0 ) 	return 0;
		if(numero == 0 )	return 1;
		
		return calcularSuma(numero -1) + calcularSuma(numero - 3) + calcularSuma(numero - 4);
	}
	
	public static void main(String[] args) {
		System.out.println(calcularSuma(30));
	}
}
