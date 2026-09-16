package Objetos.Conversor;

public class Conversor {
	private String binario;

	public Conversor(String binario) {
		this.binario = binario;
	}
	
	public boolean esBinario() {
		int i = 0;
		while(++i < this.binario.length()) {
			if(this.binario.charAt(i) != '0' && this.binario.charAt(i) != '1') return false;
			
		}
		return true;
	}
	public boolean esBinarioPro() {
		return this.binario.matches("[01]+");
	}
	
	public String hexa(String binario) {
		
		if(binario.equals("0000")) return "0";
		if(binario.equals("0001")) return "1";
		if(binario.equals("0010")) return "2";
		if(binario.equals("0011")) return "3";
		if(binario.equals("0100")) return "4";
		if(binario.equals("0101")) return "5";
		if(binario.equals("0110")) return "6";
		if(binario.equals("0111")) return "7";
		if(binario.equals("1000")) return "8";
		if(binario.equals("1001")) return "9";
		if(binario.equals("1010")) return "A";
		if(binario.equals("1011")) return "B";
		if(binario.equals("1100")) return "C";
		if(binario.equals("1101")) return "D";
		if(binario.equals("1110")) return "E";
		if(binario.equals("1111")) return "F";


		
		return "";
		
	}
	
	public String convertirHexadecimal() {
		int 		i = 0,
				j = 0;
		String 	grupo = "",
				hexadecimal = "";
		
		while(i < this.binario.length()) {
			j = i;
			grupo = "";
			while (j < i + 4 && j < this.binario.length()) {
				grupo += this.binario.charAt(j);
				j++;
			}
		
			if(grupo.length() == 4) hexadecimal += hexa(grupo);
			else if (grupo.length()<4) {
				int rellenar = 4 - grupo.length();
			
				while(rellenar > 0) {
					grupo += "0";
				
					rellenar--;
				}	
				hexadecimal += hexa(grupo);
			}	
			i += 4;
		}
		return hexadecimal;
	}
	
}
