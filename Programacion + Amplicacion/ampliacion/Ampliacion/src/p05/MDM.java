package p05;

public class MDM {                   // 150    // 39
	public static int calcularMCD(int num1, int num2) {
		
	if (num2 == 0) return num1;
	int prueba = num1 / num2;
	System.out.println(num1 + " = " + num2 +  " * " + prueba +  " + " +  num1 % num2);
	
	int resultado = num1 % num2; 
	
	

	return calcularMCD(num2, resultado);

	}
	public static void main(String[] args) {
		System.out.println(calcularMCD(150, 39));
	}
}
