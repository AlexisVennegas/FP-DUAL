package Cesar;

public class Cesar {
	
	
	public String cifrar(String texto) {
		
		String 	abc = "abcdefghijklmnopqrstuvwxyz",
				coding = "";

		int i = 0,
			j = 0;
		char letra;
	
		while(i < texto.length()) {
			letra = texto.charAt(i);

			j = abc.indexOf(letra);
			if(j ==25) coding += abc.charAt(2);
			else if(j == 24) coding += abc.charAt(1);
			else if(j == 23) coding += abc.charAt(0);
			else coding += (abc.charAt(j + 3));
			i++;
		}
		return coding;
	}
	
	public String decifrar(String texto) {
		
		String 	abc = "abcdefghijklmnopqrstuvwxyz",
				coding = "";
		
		int i = 0,
			j = 0;
		char letra;
		
		while(i < texto.length()) {
			letra = texto.charAt(i);
	
			j = abc.indexOf(letra);
		
			if(j == 0) coding += abc.charAt(27);
			else if (j == 1) coding += abc.charAt(26);
			else if (j == 2) coding += abc.charAt(25);
			else coding += abc.charAt(j - 3);
			i++;
		}
		
		return coding; 
	}
}
