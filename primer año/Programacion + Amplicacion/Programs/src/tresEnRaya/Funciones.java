package tresEnRaya;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Funciones {
	
	
	public static void imprimirMatriz(int[][] matriz) {
		
		for(int i = 0; i <matriz.length; i++) {
			for(int y = 0; y < matriz[i].length; y++) {
				System.out.println(matriz[i][y] + " ");
			}
			   System.out.println();
		}
		
	}
	public static int comprobarGanador(JButton button, int[][] matriz, boolean turno, JTextPane txtpnTurno) {
		
		System.out.println(button.getLocation());
		
		if(button.getLocation().x == 200 && button.getLocation().y == 57 && turno) matriz[0][0] = 1;
		if(button.getLocation().x == 200 && button.getLocation().y == 57 && !turno) matriz[0][0] = 2;
		if(button.getLocation().x == 281 && button.getLocation().y == 57 && turno) matriz[0][1] = 1; //else matriz[0][1] = 1;
		if(button.getLocation().x == 281 && button.getLocation().y == 57 && !turno) matriz[0][1] = 2; //else matriz[0][1] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 57 && turno) matriz[0][2] = 1; // else matriz[0][1] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 57 && !turno) matriz[0][2] = 2; // else matriz[0][1] = 1;
		if(button.getLocation().x == 200 && button.getLocation().y == 139 && turno) matriz[1][0] = 1; // else matriz[0][1] = 1;
		if(button.getLocation().x == 200 && button.getLocation().y == 139 && !turno) matriz[1][0] = 2; // else matriz[0][1] = 1;
		if(button.getLocation().x == 281 && button.getLocation().y == 139 && turno) matriz[1][1] = 1; // else matriz[1][1] = 1;
		if(button.getLocation().x == 281 && button.getLocation().y == 139 && !turno) matriz[1][1] = 2; // else matriz[1][1] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 139 && turno) matriz[1][2] = 1; // else matriz[1][2] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 139 && !turno) matriz[1][2] = 2; // else matriz[1][2] = 1;
		if(button.getLocation().x == 200 && button.getLocation().y == 221 && turno) matriz[2][0] = 1; // else matriz[2][0] = 1;
		if(button.getLocation().x == 200 && button.getLocation().y == 221 && !turno) matriz[2][0] = 2; // else matriz[2][0] = 1;
		if(button.getLocation().x == 281 && button.getLocation().y == 221 && turno) matriz[2][1] = 1; //  else matriz[2][1] = 1;
		if(button.getLocation().x == 281 && button.getLocation().y == 221 && !turno) matriz[2][1] = 2; //  else matriz[2][1] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 221 && turno) matriz[2][2] = 1; // else matriz[2][2] = 1;
		if(button.getLocation().x == 360 && button.getLocation().y == 221 && !turno) matriz[2][2] = 2; // else matriz[2][2] = 1;
		
		
		imprimirMatriz(matriz);
		System.out.println(button.getLocation());
		
		// primera solucion fila
		if(matriz[0][0] == 1 && matriz[0][1] == 1 && matriz[0][2] == 1) txtpnTurno.setText("ganador 1");
		else if ((matriz[0][0] == 2 && matriz[0][1] == 2 && matriz[0][2] == 2)) txtpnTurno.setText("ganador 2");
		// segunda solucion fila
		if(matriz[1][0] == 1 && matriz[1][1] == 1 && matriz[1][2] == 1) txtpnTurno.setText("ganador 1");
		else if(matriz[1][0] == 2 && matriz[1][1] == 2 && matriz[1][2] == 2) txtpnTurno.setText("ganador 2");
		
		// tercer solucion fila
		if(matriz[2][0] == 1 && matriz[2][1] == 1 && matriz[2][2] == 1)  txtpnTurno.setText("ganador 1");
		else if(matriz[2][0] == 2 && matriz[2][1] == 2 && matriz[2][2] == 2) txtpnTurno.setText("ganador 2");
		
		//  cuarta solucion col
		if(matriz[0][0] == 1 && matriz[1][0] == 1 && matriz[2][0] == 1) txtpnTurno.setText("ganador 1");
		else if(matriz[0][0] == 2 && matriz[1][0] == 2 && matriz[2][0] == 2) txtpnTurno.setText("ganador 2");
		
		// quinta solucion col
		if(matriz[0][1] == 1 && matriz[1][1] == 1 && matriz[2][1] == 1) txtpnTurno.setText("ganador 1");
		else if ((matriz[0][1] == 2 && matriz[1][1] == 2 && matriz[2][1] == 2)) txtpnTurno.setText("ganador 2");
		
		// sexta solucion col
		if(matriz[0][2] == 1 && matriz[1][2] == 1 && matriz[2][2] == 1) txtpnTurno.setText("ganador 1");
		else if ((matriz[0][2] == 2 && matriz[1][2] == 2 && matriz[2][2] == 2)) txtpnTurno.setText("ganador 2");
		
		// primera solucion diagonal de izquierda a derecha
		if(matriz[0][0] == 1 && matriz[1][1] == 1 && matriz[2][2] == 1) txtpnTurno.setText("ganador 1");
		else if ((matriz[0][0] == 2 && matriz[1][1] == 2 && matriz[2][2] == 2)) txtpnTurno.setText("ganador 2");
				
		// segunda solucion diagonal de derecha a izquierda
		if(matriz[0][2] == 1 && matriz[1][1] == 1 && matriz[2][0] == 1) txtpnTurno.setText("ganador 1");
		else if ((matriz[0][2] == 2 && matriz[1][1] == 2 && matriz[2][0] == 2)) txtpnTurno.setText("ganador 2");
						
				
		
		return 0;
	}
	
	public static void ponerCasillaJugador1(JButton button, String casilla) {
		button.setIcon(new ImageIcon(
			    new ImageIcon(Funciones.class.getResource(casilla))
			        .getImage()
			        .getScaledInstance(60, 60, Image.SCALE_SMOOTH)
			));
	

		
		
	}
	public static void cambiarColor(JTextField jugador1,  JTextField jugador2, boolean turno) {
		if(turno) {
			jugador2.setBackground(new Color(128, 255, 128));
			jugador1.setBackground(null);
		}
		else {
			jugador1.setBackground(new Color(128, 255, 128));
			jugador2.setBackground(null);
		}
	}
}
