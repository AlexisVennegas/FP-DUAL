package MisionBreak;

public abstract class Personaje {

	protected String nombre = "";
	protected int energia = 0;
	
	public Personaje(String nombre, int energia) {
		super();
		this.nombre = nombre;
		this.energia = energia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVitalidad() {
		return energia;
	}
	public void setVitalidad(int vitalidad) {
		this.energia = vitalidad;
	}
	
	public abstract void reaccionar();
	
	
	public final boolean estaVivo() {
		return energia > 0;
	}
	public final void recibirdano(int cantidad) {
		this.energia -= cantidad;
	}
	
}
