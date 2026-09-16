package MisionBreak;

public class Guardia extends Personaje{

	public Guardia(String nombre, int energia) {
		super("guardia", 200);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reaccionar() {
		System.out.println("¡Intruso detectado!");
		
	}

}
