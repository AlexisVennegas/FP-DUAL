package Examen;

public class Pergamino {
	private int numero;
	private String hechizo;
	
	
	/**
	public String transformarHechizo(boolean pregunta) {
		int i = 0;
	    String resultado = "";
	    
		if(pregunta) {
			while(i < this.getHechizo().length() - 1) {
				char c = hechizo.charAt(i);
				int contador = 1;
				int j = i + 1;
				while(c == this.getHechizo().charAt(j)) {
					contador++;
					j++;
				}
				i = j;
				if(contador == 1)  resultado += c;
				else 			    resultado += (c + (Integer.toString(contador)));
			}
		}
		else {
			int contador = this.getHechizo().length();
			resultado += this.getHechizo() + contador;
		}
		return resultado;
	}
	**/ 
	
	public String transformarHechizo(boolean seTransforma) {
        String hechizoTransformado = "";
        if (this.getClass() != null) {
            if (this.getHechizo() != null) {
                String elHechizo = this.getHechizo();
                if (seTransforma) {
                    
                    for (int i = 0; i < elHechizo.length() - 1; i++) {
                    	int contadorAparece = 0;
                        char caracterDelHechizo = elHechizo.charAt(i);
                        for (int j = i + 1; j < elHechizo.length() - 1; j++) {
                            if (caracterDelHechizo == elHechizo.charAt(j)) {
                                contadorAparece++;
                            }
                            
                          
                            
                        }
                      
                        // si se repite, añadir letra + número
                        if (contadorAparece > 1) {
                            hechizoTransformado += caracterDelHechizo + "" + contadorAparece;
                            i += (contadorAparece - 1); // saltar los repetidos
                        } else {
                            hechizoTransformado += caracterDelHechizo;
                        }
                    }
                }
                if (!seTransforma) {
                    hechizoTransformado = this.getHechizo() + Integer.toString(elHechizo.length());
                }
            }
        }
        return hechizoTransformado;
    }
	
	// CONSTRUCTOR
	public Pergamino(int numero, String hechizo) {
		super();
		this.numero = numero;
		this.hechizo = hechizo;
	}
	// GETTERS AND SETTERS
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getHechizo() {
		return hechizo;
	}
	public void setHechizo(String hechizo) {
		this.hechizo = hechizo;
	}
	
	
}
