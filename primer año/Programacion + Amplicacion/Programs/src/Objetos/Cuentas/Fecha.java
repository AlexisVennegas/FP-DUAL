package Objetos.Cuentas;

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
        this.validar();
    }

    // METODOS
    public boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public void mostrar() {
        System.out.println("dia: " + this.dia);
        System.out.println("mes: " + this.mes);
        System.out.println("año: " + this.anio);
    }

    public int diasMes() {
        if (this.mes == 2 && esBisiesto()) return 29;
        switch (this.mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                return 31;
            }
            case 2: {
                return 28;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                return 30;
            }
        }
        return 0;
    }

    private void validar() {
        if (this.getAnio() < 1900 || this.getAnio() > 2050) this.anio = 1900;
        if (this.getMes() < 1 || this.getMes() > 12) this.mes = 1;
        if (this.dia < 1 || this.dia > this.diasMes()) dia = 1;
    }

    public void siguiente() {
        if (this.dia < diasMes()) this.dia++;
        else if (this.mes < 12) {
            this.dia = 1;
            this.mes++;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.anio++;
        }
        this.validar();
    }

    public void anterior() {
        if (this.dia > 1) {
            this.dia--;
        } else if (this.mes > 1) {
            this.dia = this.diasMes();
            this.mes--;
        } else {
            this.dia = this.diasMes();
            this.mes -= this.mes;
            this.anio--;
        }
        this.validar();
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

    public int calcularDiferencia(Fecha fecha1, Fecha fecha2) {
        Fecha copia = new Fecha(
            fecha1.getDia(),
            fecha1.getMes(),
            fecha1.getAnio()
        );
        int dias = 0;

        while (copia.esMenor(fecha2)) {
            copia.siguiente();
            dias++;
        }
        System.out.println("Diferencia en días: " + dias);
        return dias;
    }

    
    public int resetFecha(Fecha fecha) {
    
    	int dias = 0;
    	int añoObjetivo = fecha.getAnio() + 1;
    	
    	System.out.println(fecha.getAnio());
    	System.out.println(añoObjetivo);
    	  while(fecha.getAnio() < añoObjetivo) {
    		  if (fecha.getDia() == 1 && fecha.getMes() == 1 && fecha.getAnio() == añoObjetivo) break;
    		    fecha.siguiente();
    		    dias++;
          	}
    	  return dias; 
  }

    
    public int calcularDiferencia2(Fecha fecha1, Fecha fecha2) {
        // contamos los dias de los anios
        int anios,
        	diasRestantes1 = 0,
        	diasRestantes2 = 0,
        
        	totalDias;
        int bisiestos;
        
        
        Fecha copia1 = new Fecha(fecha1.getDia(), fecha1.getMes(), fecha1.getAnio());
        Fecha copia2 = new Fecha(fecha2.getDia(), fecha2.getMes(), fecha2.getAnio());
        
        int totalAnios = (copia1.getAnio() - copia2.getAnio()) * -1;
         
        diasRestantes1 = resetFecha(copia1);
        anios = (( copia2.getAnio()) - (copia1.getAnio()));
     
        bisiestos = totalAnios / 4;
     
        totalDias = diasRestantes1 + (anios * 365) + bisiestos;     
        System.out.println("la otra chingadera: " + totalDias);
        return totalDias;
    } 

    // GETTER AND SETTER
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
