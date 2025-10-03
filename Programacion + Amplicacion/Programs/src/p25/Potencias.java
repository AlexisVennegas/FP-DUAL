package p25;

public class Potencias {
	public static void main(String[] args) {
		int numero = 4,
			i = 0;
		
		
		long potencia = 1;
		
		while(i < 30) {
		
		potencia*= numero;
		 System.out.println("4 ^ " + i + " = " + potencia);
		 i++;
		}
		
	}
}
