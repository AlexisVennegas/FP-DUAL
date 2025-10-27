package Objetos.palindromo;

public class Palindromo {

	public String texto;
	
	Palindromo(String texto){
		this.texto = texto;
	}
	
	public boolean esPalindromo() {
	
		String compararTexto = "";
		int i = this.texto.length() - 1;
		while(i >= 0) {
			if()
			compararTexto += this.texto.charAt(i );
			i--;
		}
	
		System.out.println(compararTexto);
		System.out.println(this.texto);
		return this.texto.contentEquals(compararTexto);
	}
}
