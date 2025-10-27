package Objetos.palindromo;

public class Principal {
	public static void main(String[] args) {
		Palindromo pal = new Palindromo("anita lava la tina");
		
		System.out.println(pal.esPalindromo());
	}
}
