package Objetos.Fecha;

public class Principal {

    public static void main(String[] args) {
    	// 2 FECHAS (27/2/1954 y 1/1/1970)

        Fecha fecha1 = new Fecha(27, 2, 1954);
        Fecha fecha2 = new Fecha(1, 1, 2004);	
        
   
        
        fecha1.calcularDiferencia(fecha1, fecha2);
        fecha1.calcularDiferencia2(fecha1, fecha2);
    }     
}
