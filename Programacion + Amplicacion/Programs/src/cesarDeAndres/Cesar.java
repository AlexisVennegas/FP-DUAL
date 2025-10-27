package cesarDeAndres;

public class Cesar {
	
	private static final String abecedario="abcdefghijklmnñopqrstuvwxyz";

	//Método de cifrado
	public static String cifrar(String original) {
		String textoCifrado="";
		char caracterOriginal, caracterCifrado=' ';
		int posicion, longitud;
		longitud=original.length();
		
		//Algoritmo de cifrado
		for (int i=0; i<longitud; i++) {
			//Comprobamos las posiciones del texto original uno por uno
			caracterOriginal=original.charAt(i);
			posicion=abecedario.indexOf(caracterOriginal);
			//Lo guardamos en la variable caracterCifrado
			caracterCifrado=caracterOriginal;
			//Condiciones de cifrado
			if (posicion!=-1) {
				if (posicion<abecedario.length()-3) {
					caracterCifrado=abecedario.charAt(posicion+3);
					//Otra manera:
					//if (caracterOriginal!='x'&&if caracterOriginal!='y'&&if caracterOriginal!='z')
				}else {
					if (caracterOriginal=='x') {
						caracterCifrado='a';
					}
					if (caracterOriginal=='y') {
						caracterCifrado='b';
					}
					if (caracterOriginal=='z') {
						caracterCifrado='c';
					}
				}
						
			}
			textoCifrado+=caracterCifrado;
		}
		return textoCifrado;
	}
	
	//Método de descifrado
	public static String descifrar(String cifrado) {
		String textoDescifrado="";
		char caracterCifrado, caracterDescifrado=' ';
		int posicion, longitud;
		longitud=cifrado.length();
		
		//ALgoritmo de descifrado
		for (int i=0; i<longitud; i++) {
			caracterCifrado=cifrado.charAt(i);
			posicion=abecedario.indexOf(caracterCifrado);
			
			caracterDescifrado=caracterCifrado;
			
			if (posicion!=-1) {
				if (posicion<abecedario.length()-3) {
					if (caracterCifrado=='a') {
						caracterDescifrado='x';
					}
					if (caracterCifrado=='b') {
						caracterDescifrado='y';
					}
					if (caracterCifrado=='c') {
						caracterDescifrado='z';
					}
				}else {
					
					if (caracterCifrado=='a') {
						caracterDescifrado='x';
					}
					if (caracterCifrado=='b') {
						caracterDescifrado='y';
					}
					if (caracterCifrado=='c') {
						caracterDescifrado='z';
					}
				}
			}
			textoDescifrado+=caracterDescifrado;
		}
	
	return textoDescifrado;
	}
}
