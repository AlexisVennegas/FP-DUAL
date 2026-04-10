package main;

public class VariableCompartida {
	
    public static void main(String[] args) {
        Dato dato = new Dato(0); // Objeto compartido

       
        Hilo1 h1 = new Hilo1(dato);
        Hilo2 h2 = new Hilo2(dato);
       
        h1.start();
        h2.start();
        
        try {
			h1.join();
			 h2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        System.out.println("Valor final: "+dato.getValor());
        
    }
    
   
}
