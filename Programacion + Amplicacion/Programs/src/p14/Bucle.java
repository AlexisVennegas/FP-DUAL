package p14;

public class Bucle {
	public static void main(String[] args) throws InterruptedException {
		
		
		int numero;
		
		numero = 0;
		
		
		while(numero <= 1000) {
			System.out.println(numero);
			   Thread.sleep(20); 
			numero++;
		}
	}
}
