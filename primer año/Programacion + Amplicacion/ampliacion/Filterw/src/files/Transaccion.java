package files;


public class Transaccion {
	private Proveedor proveedor;// ciudad de Cali
	private int precio;
	private double valor;// 2000

	public Transaccion(Proveedor proveedor, int precio, double valor) {
		super();
		this.proveedor = proveedor;
		this.precio = precio;
		this.valor = valor;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transaccion [proveedor=" + proveedor + ", precio=" + precio + ", valor=" + valor + "]";
	}

}
