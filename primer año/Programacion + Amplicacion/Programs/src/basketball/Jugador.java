package basketball;

public class Jugador {

	
		private double altura;
		private double porcentajeTirosDos;
		private double porcentajeTirosTres;
		
		public Jugador() {
			this.altura = 1.85;
			this.porcentajeTirosDos = 40;
			this.porcentajeTirosTres = 25;
		}
		public Jugador(double altura, double porcentajeTirosDos, double porcentajeTirosTres) {
			this.altura = altura;
			this.porcentajeTirosDos = porcentajeTirosDos;
			this.porcentajeTirosTres = porcentajeTirosTres;
			
		}
		
		
		// METODOS PROPIOS
		
		public boolean lanzar_de_tres() {
			return Math.random() * 100 <= this.porcentajeTirosTres;
		}

		public boolean lanzar_de_dos(){	
			return Math.random() * 100 <= this.porcentajeTirosDos;
		}
		
	
		public void entrenar_dos(){
			  if (Math.random() < 0.5) {
			        this.porcentajeTirosDos += 0.5;
			        if (this.porcentajeTirosDos > 100) this.porcentajeTirosDos = 100;
			    }
		}
		public void entrenar_tres(){
			 if (Math.random() < 0.5) {
			        this.porcentajeTirosTres += 0.5;
			        if (this.porcentajeTirosTres > 100) this.porcentajeTirosTres = 100;
			    }
		}

		public void entrenar_dos(int dias){
			 if (Math.random() < 0.5) {
			        this.porcentajeTirosTres += dias * 0.5;
			        if (this.porcentajeTirosTres > 100) this.porcentajeTirosTres = 100;
			    }
		}
		public void entrenar_tres(int dias){
			this.porcentajeTirosTres += dias * 0.5;
			if (this.porcentajeTirosTres > 100) this.porcentajeTirosTres = 100;
		}
		
		
		
		
		

		
		
		// METODOS GETTER AND SETTER
		public double getAltura() {
			return altura;
		}
		public void setAltura(double altura) {
			this.altura = altura;
		}
		public double getPorcentajeTirosDos() {
			return porcentajeTirosDos;
		}
		public void setPorcentajeTirosDos(double porcentajeTirosDos) {
			this.porcentajeTirosDos = porcentajeTirosDos;
		}
		public double getPorcentajeTirosTres() {
			return porcentajeTirosTres;
		}
		public void setPorcentajeTirosTres(double porcentajeTirosTres) {
			this.porcentajeTirosTres = porcentajeTirosTres;
		}
		
}
