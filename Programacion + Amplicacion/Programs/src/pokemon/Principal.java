package pokemon;

public class Principal {
	public static void main(String[] args) {
		
		
		Pokimon pokimon1, pokimon2;
		boolean result;
		
		
		pokimon1 = new Pokimon(45, 5.6, 78.6, new Point(8,9));
		pokimon2 = new Pokimon(32, 7.8, 60.6, new Point(8,9));
		
		
		
		result = pokimon1.combatir(pokimon2);
		System.out.println("---------------------------");
		pokimon1.mostrarDatos();
		System.out.println("---------------------------");

		
		pokimon1.girarDerecha();
		pokimon1.mostrarDatos();
		pokimon1.girarDerecha();
		System.out.println("---------------------------");
		pokimon1.mostrarDatos();
		
		
	}
}
