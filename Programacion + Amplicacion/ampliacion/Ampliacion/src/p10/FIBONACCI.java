package p10;

public class FIBONACCI {
	public static int enesimaFibo(int numero) {
		
		if(numero == 0) return 0;
		if(numero == 1) return 1;
		if (numero < 0) return -1;
		
	
		return enesimaFibo(numero - 1) + (numero + 2);
		
		
		
	}
	public static void main(String[] args) {
		System.out.println(enesimaFibo(4));
	}
}
