package p02;

public class CantidadNumerosNaturales {
	public static int calcularNNaturales(int numero, int r) {
		
		if(numero <= 0) return r;
		
		return calcularNNaturales(numero / 10 , r + 1);
		
	
	}

	
	public static int calcularNNaturalesDos(int numero) {
	  
	    if (numero < 10) return 1;
	   
	    return 1 + calcularNNaturalesDos(numero / 10);
	}

	public static void main(String[] args) {
	    System.out.println(calcularNNaturales(123, 0)); 
	}

}
