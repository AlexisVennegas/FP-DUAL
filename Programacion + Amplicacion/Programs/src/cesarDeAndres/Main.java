package cesarDeAndres;

public class Main {
	public static void main(String[]args) {
		
		String mensaje="cazafantasmas";
		String cifrado, descifrado;
		cifrado=Cesar.cifrar(mensaje);
		descifrado=Cesar.descifrar(cifrado);
		System.out.println("Original: "+mensaje);
		System.out.println("Cifrado: "+cifrado);
		//System.out.println("Descifrado: "+descifrado);
		
	}
}
