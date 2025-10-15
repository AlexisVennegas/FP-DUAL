package Objetos.Fecha;

public class Fecha {

    // ATRIBUTOS
    private int dia;
    private int mes;
    private int anio;

    // CONSTRUCTORES
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 1900;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // METODOS
    public boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
    }

    public void mostrar() {
    	System.out.println("dia: " + this.dia);
    	System.out.println("mes: " + this.mes);
    	System.out.println("año: " + this.anio);
    }
    
    public int diasMes(int mes) {
        return (mes == 2 && esBisiesto())
            ? 29
            : new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }[mes -
              1];
    }

    public boolean valida(int dia, int mes, int anio) {
        return (
            dia >= 1 &&
            dia <= diasMes(mes) &&
            mes >= 1 &&
            mes <= 12 &&
            anio >= 1900
        );
    }

    public void siguiente() {
        if (dia < diasMes(mes)) {
            dia++;
        } else if (mes < 12) {
            dia = 1;
            mes++;
        } else {
            dia = 1;
            mes = 1;
            anio++;
        }
    }

    public void anterior() {
        if (dia > 1) {
            dia--;
        } else if (mes > 1) {
            dia = diasMes(mes - 1);
            mes--;
        } else {
            dia = 31;
            mes = 12;
            anio--;
        }
    }

    public boolean esIgual(Fecha otraFecha) {
        return (
            this.dia == otraFecha.dia &&
            this.mes == otraFecha.mes &&
            this.anio == otraFecha.anio
        );
    }

    public boolean esMenor(Fecha otraFecha) {
        return (
            this.anio < otraFecha.anio ||
            (this.anio == otraFecha.anio && this.mes < otraFecha.mes) ||
            (this.anio == otraFecha.anio &&
                this.mes == otraFecha.mes &&
                this.dia < otraFecha.dia)
        );
    }

    public boolean esMayor(Fecha otraFecha) {
        return (
            this.anio > otraFecha.anio ||
            (this.anio == otraFecha.anio && this.mes > otraFecha.mes) ||
            (this.anio == otraFecha.anio &&
                this.mes == otraFecha.mes &&
                this.dia > otraFecha.dia)
        );
    }
}
