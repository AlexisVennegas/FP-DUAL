package Objetos;

public class Principal {
	public static void main(String[] args) {
			Bicycle bicicleta1 = new Bicycle(2,3,4);
			Bicycle bicicleta2 = new Bicycle(5,6,7);
			Bicycle bicicleta3 = new Bicycle(7,8,9);
			
			System.out.println(bicicleta1.getID());
			System.out.println(bicicleta2.getID());
			System.out.println(bicicleta3.getID());
			System.out.println(bicicleta3.getNumberOfBicycles());
	}
}
