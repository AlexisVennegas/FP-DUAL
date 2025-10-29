package conversorHex.src.conversorHex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversorHex prueba1;
		
		prueba1=new ConversorHex("ss1010010s¡¡1ss");
		System.out.println(prueba1.esBinario());
		
		prueba1=new ConversorHex("ss121212ss");
		System.out.println(prueba1.esBinario());
		System.out.println(prueba1.convertirAHexadecimal());
		
		
		
		
		
		
	}

}
