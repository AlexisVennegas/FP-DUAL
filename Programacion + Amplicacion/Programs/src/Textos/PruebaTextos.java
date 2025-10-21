package Textos;


public class PruebaTextos {
	public static void main(String[] args) {
		
		
		String texto12 = "casa";
		String texto11 = new String("casa");
		
		
		if(texto12 == texto11) System.out.println("son iguales");
		else System.out.println("no son iguales");
		
		
		String texto = "anita lava la tina";
		// 1
		System.out.println("1.- " + texto.toUpperCase());
		// 2
		System.out.println("2.- " + texto.toLowerCase());
		// 3
		if(texto.length() > 2) System.out.println("3.- " + texto.substring(0, 2));
		// 4
		if(texto.length() > 2) System.out.println("4.- " + texto.substring(texto.length() -2));
		
		// 5
		int i = 0;
		int contains = 0;
		while(++i < texto.length() ) {
			if (texto.toLowerCase().charAt(i) == texto.toLowerCase().charAt(texto.length() - 1)) contains++;
		}
		System.out.println("5.- " + contains);
		
		// 6 	
		
		String result = texto.replace(texto.charAt(0), texto.toUpperCase().charAt(0));
		System.out.println("6.- " + result);
		
		// 7 
		i = 0;
		String icon = "***";
	
		
		String  result2 = icon.concat(texto).concat(icon);
		System.out.println("7.- " + result2);
		
		// 8
		String textoInvertido = "";
		i = texto.length();
		
		while(--i >= 0) {
			textoInvertido += (texto.charAt(i));
		}
		System.out.println("8.- " + textoInvertido);
		
		for(int x = texto.length() - 1; x > 0; x--) {
			System.out.print(texto.charAt(x));
		}
		
		
	}
}
