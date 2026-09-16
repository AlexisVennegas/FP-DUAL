package Objetos.Conversor;

public class Principal {
	public static void main(String[] args) {
		Conversor con = new Conversor("10101001");
		
		System.out.println(con.esBinario());
		System.out.println(con.esBinarioPro());
		
		System.out.println("final: " + con.convertirHexadecimal());
	}
}
