package basketball;

public class Principal {

	
	public static void entrenar(Jugador jugador) {
		while(jugador.getPorcentajeTirosDos() < 65 || jugador.getPorcentajeTirosTres() <= 45) {
			jugador.entrenar_dos();
			jugador.entrenar_tres();
		}
		System.out.println(jugador.getPorcentajeTirosDos());
		System.out.println(jugador.getPorcentajeTirosTres());
		
		
		
		// Lanzamientos hasta lograr las canastas
        int canastasDos = 0;
        int canastasTres = 0;
        int intentosDos = 0;
        int intentosTres = 0;

        while (canastasDos < 10) {
            intentosDos++;
            if (jugador.lanzar_de_dos()) canastasDos++;
        }

        while (canastasTres < 4) {
            intentosTres++;
            if (jugador.lanzar_de_tres()) canastasTres++;
        }

        System.out.println("¡Jugador ha conseguido las canastas deseadas!");
        System.out.println("Intentos de dos: " + intentosDos + ", Intentos de tres: " + intentosTres);
	}
	
	public static void main(String[] args) {
		
		Jugador jugadorUno,
				jugadorDos;
		
		
		jugadorUno = new Jugador();
		jugadorDos = new Jugador();
		
		
		jugadorUno.entrenar_dos(10);
		jugadorUno.entrenar_tres(10);
		
		jugadorDos.entrenar_dos(10);
		jugadorDos.entrenar_tres(10);
	
		System.out.println("jugador 1 ---------------");
		
		entrenar(jugadorUno);
		System.out.println("jugador 2 ---------------");
		entrenar(jugadorDos);
		
	
		
		
}
	
}
