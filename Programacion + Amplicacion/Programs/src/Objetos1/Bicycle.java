package Objetos1;

public class Bicycle {
	
	
	public int cadence;
	public int gear;
	public int speed;
	
	
	public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
	public Bicycle() {
        gear = 2;
        cadence = 3;
        speed = 4;
    }

	public int getCadence() {
		return cadence;
	}


	public void setCadence(int cadence) {
		this.cadence = cadence;
	}


	public int getGear() {
		return gear;
	}


	public void setGear(int gear) {
		this.gear = gear;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void frenar(int speed) {
		this.speed = 0;
	}
	

}
