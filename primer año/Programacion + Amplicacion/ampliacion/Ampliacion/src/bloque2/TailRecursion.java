package bloque2;

public class TailRecursion {
	// 3. Contar la cantidad de dígitos de un número entero.
	public static int calcularNNaturales(int num, int accumulator) {
		if(num <= 0) return accumulator;
				
	
		return calcularNNaturales(num / 10, accumulator + 1);
	} 
	
	public static void main(String[] args) {
		System.out.println(calcularNNaturales(1, 0));
	}
}	
