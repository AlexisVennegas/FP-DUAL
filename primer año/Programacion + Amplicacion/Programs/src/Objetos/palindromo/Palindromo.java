package Objetos.palindromo;

public class Palindromo {

	public String texto;
	
	Palindromo(String texto){
		this.texto = limpiar(texto);
	}
	
	public String limpiar(String texto) {
		
		int i = 0;
		String nuevoTexto = "";
		while(i < texto.length()) {
			if(texto.toLowerCase().charAt(i) >= 'a' && texto.toLowerCase() .charAt(i) <= 'z') {
				nuevoTexto += texto.charAt(i);
			}
			else nuevoTexto += "";
			i++;
		}
	
		
		return nuevoTexto.toLowerCase().replaceAll(texto, texto);
	}

	public String generarAlReves(String texto) {
		String nuevoTexto = "";
		int i = texto.length() - 1;
		
		while(i >= 0) {
			nuevoTexto += texto.charAt(i);
			i--;
		}
		return nuevoTexto;
		
	}
	
	
	public boolean esPalindromo() {
		
	return limpiar(this.texto).toLowerCase().contentEquals(generarAlReves(limpiar(this.texto)));
	}
}
