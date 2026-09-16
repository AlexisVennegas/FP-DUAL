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

	public boolean contieneA() {
		if(this.getNombre() == null) return false;
		return this.getNombre().charAt(0) == 'A';
	}
	public boolean compararNombres(String otroNombre) {
		int i = 0;
		while(i < this.nombre.length()) {
		if(this.nombre.toLowerCase().charAt(i) != otroNombre.toLowerCase().charAt(i)) return false;
		i++;
		}
		return true;
	}
	public int calcularDigitos() {
	    int digitos = 0;
	    int i = 0;
	    while(i < this.nombre.length()) {
	    	if(this.nombre.charAt(i) >= '0' && this.nombre.charAt(i) <= '9') digitos++;
	    	i++;
	    }
	    return digitos;
	}
	public int calcularletrasIngles() {
		int digitos = 0;
		int i = 0;
		while(i < this.nombre.length()) {
			if(this.nombre.toLowerCase().charAt(i) >= 'a' && this.nombre.toLowerCase()p.charAt(i) <= 'z') digitos++;
			i++;
		}
		return digitos;
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
