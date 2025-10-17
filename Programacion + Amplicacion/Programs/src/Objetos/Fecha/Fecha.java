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
    	if(this.mes == 2 && esBisiesto()) return 29;
    	switch (this.mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {return 31;}
		case 2:  {return 28;}
		case 4: 
		case 6:
		case 9:
		case 11: {return 30;}
    	}
    	return 0;
    }

    private void validar() {    	
    	if(this.getAnio() < 1900 || this.getAnio() > 2050) this.anio = 1900;
    	if(this.getMes() < 1 || this.getMes() > 12) this.mes = 1;
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
