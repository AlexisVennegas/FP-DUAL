package ventana;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Buttons {
	public static double evaluarExpresion(String operacionCompleta) {

	    List<Double> numeros = new ArrayList<>();
	    List<Character> operaciones = new ArrayList<>();
	    String numeroActual = "";

	    for(int i = 0; i < operacionCompleta.length(); i++) {

	        char c = operacionCompleta.charAt(i);

	        if(Character.isDigit(c) || c == '.') {
	            numeroActual += c;
	        } else {
	            if(!numeroActual.isEmpty()) {
	                numeros.add(Double.parseDouble(numeroActual));
	            }
	            operaciones.add(c);
	            numeroActual = "";
	        }
	    }

	    // ✅ AGREGAR ÚLTIMO NÚMERO AQUÍ (FUERA DEL FOR)
	    if(!numeroActual.isEmpty()) {
	        numeros.add(Double.parseDouble(numeroActual));
	    }

	    // Resolver * y /
	    for(int i = 0; i < operaciones.size(); i++) {

	        if(operaciones.get(i) == '*' || operaciones.get(i) == '/') {

	            double a = numeros.get(i);
	            double b = numeros.get(i + 1);
	            double res = (operaciones.get(i) == '*') ? a * b : a / b;

	            numeros.set(i, res);
	            numeros.remove(i + 1);
	            operaciones.remove(i);
	            i--;
	        }
	    }

	    // Resolver + y -
	    double resultado = numeros.get(0);

	    for(int i = 0; i < operaciones.size(); i++) {
	        if(operaciones.get(i) == '+')
	            resultado += numeros.get(i + 1);
	        else
	            resultado -= numeros.get(i + 1);
	    }

	    return resultado;
	}
	
	public static void crearButtons(JTextField txtResult, JFrame frame) {
			// NUMBER 1
		Rectangle[] posiciones = {
			    new Rectangle(204, 240, 111, 38), // 0
			    new Rectangle(20, 202, 94, 38), // 1
			    new Rectangle(115, 202, 89, 38), // 2
			    new Rectangle(204, 202, 111, 38), // 3
			    new Rectangle(20, 165, 94, 38), // 4
			    new Rectangle(115, 165, 89, 38), // 5
			    new Rectangle(204, 165, 111, 38), // 6
			    new Rectangle(20, 127, 94, 38), // 7
			    new Rectangle(115, 127, 89, 38), // 8 
			    new Rectangle(204, 127, 111, 38), // 9
			
			};
			for(int i = 0; i <= 9; ++i) {
			    JButton button = new JButton((i) + "");
			    
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtResult.setText(txtResult.getText() + button.getText());
						//primerNumero = Integer.parseInt(txtResult.getText());
					}
				});
				
				button.setBounds(posiciones[i]);
				frame.getContentPane().add(button);
			}
			
			
		}
}
