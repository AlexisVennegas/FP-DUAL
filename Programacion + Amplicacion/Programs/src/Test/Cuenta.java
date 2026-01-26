package Test;

public class Cuenta {
	private String numero; //Numero de la cuenta bancaria
	private float saldo; //Saldo de la cuenta bancaria en euros
	
	
	public Cuenta(String numCta, float saldoCta) {
		numero = numCta;
		saldo = saldoCta;
	}
	public String getNumero() {
		return numero;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setNumero(String numCta) {
		numero = numCta;
	}
	public void setSaldo(float saldoCta) {
		saldo = saldoCta;
	}
	public void ingresarDinero(float importe) {
		saldo = saldo + importe;
	}
	public void extraerDinero(float importe) {
		saldo = saldo - importe;
	}
	public void mostrarCuenta() {
		System.out.println("Nº de cuenta: "+ getNumero());
		System.out.println("Saldo: "+ getSaldo()+" €");
	}
}	