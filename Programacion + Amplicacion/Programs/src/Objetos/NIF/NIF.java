package Objetos.NIF;

public class NIF {

	// ATRIBUTOS
	private int dni;
	private char letra;
	
	
	// CONSTRUCTORES
	public NIF() {
		this.dni = 0;
		this.letra = ' ';
	}
	public NIF(int dni) {
		this.dni = dni;
		this.letra = this.calcular();
	}
	
	
	// METODOS
	public void mostrarNif() {
		System.out.print(this.dni);
		System.out.println(this.letra);
	}
	public char calcular() {
		return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(this.dni % 23);
	}
}
