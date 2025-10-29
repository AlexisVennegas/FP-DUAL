package Objetos.Cuentas;

public class Cuenta {
		private int id;
		private double saldo;
		private Titular titular;
		
		// CONSTRUCTOR
		public Cuenta(int id, double saldo, Titular titular) {
			super();
			this.id = id;
			this.saldo = saldo;
			this.titular = titular;
		}
		
		// METODOS PROPIOS
		public boolean compararTitular(Cuenta cuenta2) {
		    return  (this.getTitular().getNif().equals(cuenta2.getTitular().getNif()) && 
		            (this.getTitular().getNombre().equals(cuenta2.getTitular().getNombre()) &&
		            (this.getTitular().getApellidos().equals(cuenta2.getTitular().getApellidos())))) && 
		            (this.getTitular().getFechaNacimiento().esIgual(cuenta2.getTitular().getFechaNacimiento()));
		}
		
		public boolean compararCuenta(Cuenta cuenta2) {
			return((this.getId() == cuenta2.getId()));
		}
		
		public boolean compararElementos(String elemento1, String elemento2) {
			
			int i = 0,
				cantidadErrores = 0 ;
			while(i < elemento1.length()) {
				if(elemento1.charAt(i) != elemento2.charAt(i)) cantidadErrores++;
				i++;
			}
			if(cantidadErrores == 1) return true;
			return false;
		}
		
		
		public boolean compararTitularSimilar(Cuenta cuenta2) {
		
			return (compararElementos(this.getTitular().getNif(), cuenta2.getTitular().getNif()) &&
					compararElementos(this.getTitular().getNombre(), cuenta2.getTitular().getNombre()) &&
					compararElementos(this.getTitular().getApellidos(), cuenta2.getTitular().getApellidos()) &&
					cuenta2.getTitular().getFechaNacimiento().calcularDiferencia(cuenta2.getTitular().getFechaNacimiento(), this.getTitular().getFechaNacimiento()) < 5);
		}
		
		public void ingresar(double cantidad) {
			if(cantidad >= 0) this.saldo += cantidad;
		}
		public void retirar(double cantidad) {
			if(this.saldo >= 0 && cantidad >= 0) this.saldo -= cantidad;
		}
		
		
		
		// GETTERS AND SETTERS
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		public Titular getTitular() {
			return titular;
		}
		public void setTitular(Titular titular) {
			this.titular = titular;
		}
		

		public String mostrar() {
			titular.mostrar();
			return "Cuenta [id=" + id + ", saldo=" + saldo + "]";
		}
		
				
}
