package main;

public class Hilo2 extends Thread {

	private Dato dato;

	public Hilo2(Dato dato) {
		this.dato = dato;
	}

	public void run() {
		int decrementado;
		for (int i = 0; i < 100; i++) {
			
			decrementado = this.dato.getValor();
			decrementado--;
			this.dato.setValor(decrementado);
			

		}
	}
}
