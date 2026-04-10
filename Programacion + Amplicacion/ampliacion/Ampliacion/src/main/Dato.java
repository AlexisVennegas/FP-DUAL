package main;

public class Dato {
    private int valor = 0; // Variable compartida

   
    public Dato(int valor) {
    	this.valor=valor;
    }


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}
    
   
    
   
}