package asd;

public class Hilo1 extends Thread {

	private Dato dato;

	public Hilo1(Dato dato) {
		this.dato = dato;
	}

	public void run() {
		int incrementado;
		for (int i = 0; i < 100; i++) {
			incrementado = this.dato.getValor();
			incrementado++;
			this.dato.setValor(incrementado);
		

		}
	}
}
