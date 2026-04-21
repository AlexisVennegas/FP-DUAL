package p04;

public class Exponente {
	public static int calcularExponente(int base, int exp) {
	    if (exp == 0) return 1;

	    return base * calcularExponente(base, exp - 1);
	}
	public static void main(String[] args) {
		System.out.println(calcularExponente(3, 3));
	}
}