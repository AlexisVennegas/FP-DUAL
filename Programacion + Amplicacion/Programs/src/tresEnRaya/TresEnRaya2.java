package tresEnRaya;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

public class TresEnRaya2 {

	private JFrame 		frame;
	private JTextField 	txtJugador;
	private JTextField 	txtJugador_1;
	private boolean 		turno = true;
	
	private int ganador = 0;
	
	public static int[][] matriz = new int[3][3];


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya2 window = new TresEnRaya2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TresEnRaya2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		// jugadores 
		
		txtJugador = new JTextField();
		txtJugador.setBackground(new Color(128, 255, 128));
		txtJugador.setText("JUGADOR 1   O");
		txtJugador.setBounds(39, 106, 86, 20);
		frame.getContentPane().add(txtJugador);
		txtJugador.setColumns(10);
		
		
	
		txtJugador_1 = new JTextField();
		txtJugador_1.setText("JUGADOR 2 X");
		txtJugador_1.setColumns(10);
		txtJugador_1.setBounds(39, 147, 86, 20);
		frame.getContentPane().add(txtJugador_1);
		
		Funciones.imprimirMatriz(matriz);
		
		JTextPane txtpnTurno = new JTextPane();
		txtpnTurno.setText("TURNO:");
		txtpnTurno.setBounds(39, 65, 76, 20);
		frame.getContentPane().add(txtpnTurno);
		
		// BUTTON 1
		JButton btnNewButton1 = new JButton("");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton1, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton1, "o.png");
					turno = false;
					
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton1, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton1.setBounds(200, 57, 76, 80);
		frame.getContentPane().add(btnNewButton1);
		
		// BUTTON 1
		JButton btnNewButton2 = new JButton("");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton2, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton2, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton2, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton2.setBounds(281, 57, 76, 80);
		frame.getContentPane().add(btnNewButton2);
		
		
		// button 3
		JButton btnNewButton3 = new JButton("");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton3, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton3, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton3, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton3.setBounds(360, 57, 76, 80);
		frame.getContentPane().add(btnNewButton3);
		
		
		// button 4
		JButton btnNewButton4 = new JButton("");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton4, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton4, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton4, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton4.setBounds(200, 139, 76, 80);
		frame.getContentPane().add(btnNewButton4);
		
		
		// button 5
		JButton btnNewButton5 = new JButton("");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton5, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton5, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton5, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton5.setBounds(281, 139, 76, 80);
		frame.getContentPane().add(btnNewButton5);
		
		
		// button 6
		JButton btnNewButton6 = new JButton("");
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton6, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton6, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton6, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton6.setBounds(360, 139, 76, 80);
		frame.getContentPane().add(btnNewButton6);
		
		
		// button 7
		JButton btnNewButton7 = new JButton("");
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton7, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton7, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton7, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton7.setBounds(200, 221, 76, 80);
		frame.getContentPane().add(btnNewButton7);
		
		// button 8
		JButton btnNewButton8= new JButton("");
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton8, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton8, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton8, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton8.setBounds(281, 221, 76, 80);
		frame.getContentPane().add(btnNewButton8);
		
		
		// button 9
		JButton btnNewButton9= new JButton("");
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funciones.cambiarColor(txtJugador, txtJugador_1, turno);
				ganador = Funciones.comprobarGanador(btnNewButton9, matriz, turno, txtpnTurno);
				if(ganador == 1 || ganador == 2) return;
				if(turno) {
					Funciones.ponerCasillaJugador1(btnNewButton9, "o.png");
					turno = false;
				}
				else {
					Funciones.ponerCasillaJugador1(btnNewButton9, "x.png");
					turno = true;
				}
			}
		});
		btnNewButton9.setBounds(360, 221, 76, 80);
		frame.getContentPane().add(btnNewButton9);
		
	
		
		
	}
}
