package MisionBreak;


public class Espia extends Personaje {

	public Espia(String nombre, int energia) {
		super("agente", 100);
		
	}

	@Override
	public void reaccionar() {
		System.out.println("en silencio y alerta");
		
	}

}
