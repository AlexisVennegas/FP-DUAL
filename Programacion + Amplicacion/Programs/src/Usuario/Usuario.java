package Usuario;

public class Usuario {
	private int id;
	private String nombre;
	private double saldo;
	
	// CONSTRUCTOR
	public Usuario(int id, String nombre, double saldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	// METODOS PROPIOS
	public void IncrementarSaldo(double porcentaje) {
		if(this.id >= 1 && this.id <= 10) this.saldo += (this.saldo * porcentaje) / 100; 
	}

	
	
	// GETTERS ANDS SETTERS 
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	
}
