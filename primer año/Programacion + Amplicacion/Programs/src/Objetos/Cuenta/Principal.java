package Objetos.Cuenta;

public class Principal {

	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta(123);
		
		cuenta.mostrar();
		
		cuenta.ingresar(300);
		
		cuenta.mostrar();
		
		cuenta.retirar(310);
		
		cuenta.mostrar();
		

		cuenta.retirar(333);
		
		cuenta.mostrar();
	}

}
