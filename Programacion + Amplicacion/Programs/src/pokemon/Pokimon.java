package pokemon;

public class Pokimon {
	
	private int vida;
	private double ataque;
	private double defensa;
	private Point ubicacion;
	private char puntoCardinal; // N E S Q 
	
	
	
	public Pokimon(int vida, double ataque, double defensa, Point ubicacion) {
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ubicacion = ubicacion;
		this.puntoCardinal = 'N';
	}


	public void mostrarDatos() {
		System.out.println("vida: " + 			 this.vida);
		System.out.println("ataque: " +		 this.ataque);
		System.out.println("defensa: " +		 this.defensa);
		System.out.println("puntoCardinal: " + this.puntoCardinal);
		System.out.println("ubicacion: ");   	 this.ubicacion.mostrarDato();
		
		}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public double getAtaque() {
		return ataque;
	}


	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}


	public double getDefensa() {
		return defensa;
	}


	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}


	public Point getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}


	public char getPuntoCardinal() {
		return puntoCardinal;
	}


	public void setPuntoCardinal(char puntoCardinal) {
		this.puntoCardinal = puntoCardinal;
	}
	
	
	
	
	

	
	
	

	
}
