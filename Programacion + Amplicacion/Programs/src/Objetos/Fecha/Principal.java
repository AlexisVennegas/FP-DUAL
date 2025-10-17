package Objetos.Fecha;

public class Principal {

    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(1, 12, 2050);
      
        fecha1.mostrar();
        System.out.println("es bisiesto?: " + fecha1.esBisiesto());
        System.out.println("dias del mes: " + fecha1.diasMes());
        fecha1.anterior();
        fecha1.mostrar();
        System.out.println("es menor: " + fecha1.esMenor(new Fecha(10, 10, 2005)));
        System.out.println("es mayor: " + fecha1.esMayor(new Fecha(10, 10, 2005)));
    }     
}
