package Objetos.Cuentas;

public class Principal {
	public static void main(String[] args) {

		Titular alexis = new Titular("12345A", "Alexis", "Venegas", new Fecha(27,6,2001));
		Cuenta cuenta1 = new Cuenta(1, 100, alexis);
		
		Titular andres = new Titular("12345B", "Alexia", "venegas", new Fecha(23,6,2001));
		Cuenta cuenta2 = new Cuenta(2, 5000, andres);
		
		
		System.out.println("similares: " + cuenta1.compararTitularSimilar(cuenta2));
		
	
	}
}
