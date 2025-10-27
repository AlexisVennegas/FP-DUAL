package Cesar;

public class Principal {
	public static void main(String[] args) {
		Cesar cifrar = new Cesar();
		
		System.out.println(cifrar.cifrar("arroz con mole "));
		System.out.println(cifrar.decifrar("arroz con mole "));
	
	}
}
