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

	
	
	public boolean combatir(Pokimon rival) {
		rival.setVida(rival.vida -= this.ataque); 
		if	 (rival.getVida() > 0) return true;
		else {
			this.vida = (int) (rival.getAtaque() - this.getDefensa());
			if(this.getVida() <= 0) return false;
		}
		
		return this.vida > rival.ataque;
	}
	
	
	public char girarDerecha() {
			
		if (this.getPuntoCardinal() == 'N')  this.setPuntoCardinal('E');
		else if(this.getPuntoCardinal() == 'S')   this.setPuntoCardinal('W');
		else if(this.getPuntoCardinal() == 'E')   this.setPuntoCardinal('S');
		else if(this.getPuntoCardinal() == 'W')   this.setPuntoCardinal('N');

		
		return this.getPuntoCardinal();
	}

	public void mostrarDatos() {
		System.out.println("vida: " + 			 this.vida);
		System.out.println("ataque: " +		 this.ataque);
		System.out.println("defensa: " +		 this.defensa);
		System.out.println("puntoCardinal: " + this.puntoCardinal);
		System.out.println("ubicacion: ");   	 this.ubicacion.mostrarDato();
		
		}

	
	public void caminar() {

		
		if(this.getPuntoCardinal() == 'N') this.ubicacion.setY(this.ubicacion.getY() + 1);
		if(this.getPuntoCardinal() == 'S') this.ubicacion.setY(this.ubicacion.getY() - 1);
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
