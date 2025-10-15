package Objetos.Fecha;

public class Principal {

    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(27, 6, 2001);
        Fecha fecha2 = new Fecha(11, 12, 2023);

        fecha1.mostrar();
        fecha2.mostrar();

        System.out.println(
            "¿Fecha 1 es menor que Fecha 2? " + fecha1.esMenor(fecha2)
        );
        System.out.println(
            "¿Fecha 1 es mayor que Fecha 2? " + fecha1.esMayor(fecha2)
        );
        System.out.println("fecha 1 es bisiesto: " + fecha2.esBisiesto());
    }
}
