package Cesar;

public class Principal {
	public static void main(String[] args) {
		Cesar cifrar = new Cesar();
		
		System.out.println(cifrar.cifrar("arroz"));
		System.out.println(cifrar.decifrar(cifrar.cifrar("arroz")));
	}
}
