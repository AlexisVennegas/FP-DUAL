package p08;

public class Binario {
	public static String binarioToDecimal(int numero) {
	
		if (numero == 0) return ""; 
	    
	 
	    return binarioToDecimal(numero / 2) + (numero % 2);
	}
	public static void main(String[] args) {
		System.out.println(binarioToDecimal(46));
	}
}
