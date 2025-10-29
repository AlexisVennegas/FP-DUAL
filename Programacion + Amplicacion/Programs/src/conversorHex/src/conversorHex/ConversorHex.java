package conversorHex.src.conversorHex;


public class ConversorHex {
	private String textoBinario;

	public ConversorHex(String textoBinario) {
		this.textoBinario = textoBinario;
	}
	
	public boolean esBinario() {
		char caracter;
		
		for(int i=0;i<this.textoBinario.length();i++) {
			caracter=this.textoBinario.charAt(i);
			if(caracter!='0'&&caracter!='1') {
				return false;
			}
		}
		return true;		
	}
		
	public String convertirAHexadecimal() {
		String hexadecimal="";
		int resto;
		char digitoHexadecimal;
		if (this.esBinario()) {
			resto=this.textoBinario.length()%4;
			if (resto>0) {
				this.añadirCerosIzquierda(resto);
			}
			for(int i=0;i<this.textoBinario.length();i+=4) {
				digitoHexadecimal=this.convertirADigitoHexadecimal(this.textoBinario.substring(i,i+4)); 
				hexadecimal+=digitoHexadecimal;			
			}
		}			
		return hexadecimal;
	}

	private char convertirADigitoHexadecimal(String grupoCuatroBinario) {
		char valorADevolver=' ';
		switch(grupoCuatroBinario) {
		case "0000":valorADevolver='0';
					break;
		case "0001":valorADevolver='1';
					break;
		case "0010":valorADevolver='2';
					break;
		case "0011":valorADevolver='3';
					break;
		case "0100":valorADevolver='4';
					break;
		case "0101":valorADevolver='5';
					break;
		case "0110":valorADevolver='6';
					break;
		case "0111":valorADevolver='7';
					break;
		case "1000":valorADevolver='8';
					break;
		case "1001":valorADevolver='9';
					break;
		case "1010":valorADevolver='A';
					break;
		case "1011":valorADevolver='B';
					break;
		case "1100":valorADevolver='C';
					break;
		case "1101":valorADevolver='D';
					break;
		case "1110":valorADevolver='E';
					break;
		case "1111":valorADevolver='F';
					break;
		
		}
			
		return  valorADevolver;
	}

	private void añadirCerosIzquierda(int resto) {
	
		for(int i=0;i<4-resto;i++) {
			this.textoBinario='0'+this.textoBinario;		
		}
		
		
	}

	
}
