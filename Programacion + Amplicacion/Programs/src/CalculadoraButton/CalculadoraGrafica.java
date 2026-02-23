package CalculadoraButton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculadoraGrafica extends JFrame {
	private double primerNumero;
	private double segundoNumero;
	private char operacion;
	private double resultado;
	private boolean opNueva = true;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pantalla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGrafica frame = new CalculadoraGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pantalla = new JTextField();
		pantalla.setBorder(null);
		pantalla.setBackground(new Color(255, 244, 250));
		pantalla.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(pantalla, BorderLayout.NORTH);
		pantalla.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 192));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		
		JButton btnUno = new JButton("1");
		btnUno.setBackground(new Color(255, 213, 234));
		estiloBoton(btnUno);
		btnUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("1");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "1");
				}
			}
		});
		panel.add(btnUno);
		
		JButton btnDos = new JButton("2");
		btnDos.setBackground(new Color(255, 213, 234));
		estiloBoton(btnDos);
		btnDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("2");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "2");
				}
			}
		});
		panel.add(btnDos);
		
		JButton btnTres = new JButton("3");
		estiloBoton(btnTres);
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("3");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "3");
				}
			}
		});
		panel.add(btnTres);
		
		JButton btnSuma = new JButton("+");
		estiloBoton(btnSuma);
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerNumero = Double.parseDouble(pantalla.getText());
				operacion = '+';
				pantalla.setText("");
			}
		});
		panel.add(btnSuma);
		
		JButton btnCuatro = new JButton("4");
		estiloBoton(btnCuatro);
		btnCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("4");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "4");
				}
			}
		});
		panel.add(btnCuatro);
		
		JButton btnCinco = new JButton("5");
		estiloBoton(btnCinco);
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("5");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "5");
				}
			}
		});
		panel.add(btnCinco);
		
		JButton btnSeis = new JButton("6");
		estiloBoton(btnSeis);
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("6");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "6");
				}
			}
		});
		panel.add(btnSeis);
		
		JButton btnMenos = new JButton("-");
		estiloBoton(btnMenos);
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerNumero = Double.parseDouble(pantalla.getText());
				operacion = '-';
				pantalla.setText("");
			}
		});
		panel.add(btnMenos);
		
		JButton btnSiete = new JButton("7");
		estiloBoton(btnSiete);
		btnSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("7");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "7");
				}
			}
		});
		panel.add(btnSiete);
		
		JButton btnOcho = new JButton("8");
		estiloBoton(btnOcho);
		btnOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("8");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "8");
				}
			}
		});
		panel.add(btnOcho);
		
		JButton btnNueve = new JButton("9");
		estiloBoton(btnNueve);
		btnNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("9");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "9");
				}
			}
		});
		panel.add(btnNueve);
		
		JButton btnMult = new JButton("x");
		estiloBoton(btnMult);
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerNumero = Double.parseDouble(pantalla.getText());
				operacion = 'x';
				pantalla.setText("");
			}
		});
		panel.add(btnMult);
		
		JButton btnBorrar = new JButton("C");
		estiloBoton(btnBorrar);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText("");
				primerNumero = 0;
				segundoNumero = 0;
				operacion = ' ';
				opNueva = true;
			}
		});
		panel.add(btnBorrar);
		
		JButton btnCero = new JButton("0");
		estiloBoton(btnCero);
		btnCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opNueva) {
					pantalla.setText("0");
					opNueva = false;
				} else {
					String actual = pantalla.getText();
					pantalla.setText(actual + "0");
				}
			}
		});
		panel.add(btnCero);
		
		JButton btnIgual = new JButton("=");
		estiloBoton(btnIgual);
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				segundoNumero = Double.parseDouble(pantalla.getText());
				switch(operacion) {
				case '+':
					resultado = primerNumero + segundoNumero;
					break;
				case '-':
					resultado = primerNumero - segundoNumero;
					break;
				case 'x':
					resultado = primerNumero * segundoNumero;
					break;
				case '/':
					if(segundoNumero != 0) {
						resultado = primerNumero / segundoNumero;
					} else {
						pantalla.setText("ERROR");
						opNueva = true;
						return;
					}
					break;
				}
				opNueva = true;
				pantalla.setText(String.valueOf(resultado));
			}
		});
		panel.add(btnIgual);
		
		JButton btnDiv = new JButton("/");
		estiloBoton(btnDiv);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primerNumero = Double.parseDouble(pantalla.getText());
				operacion = '/';
				pantalla.setText("");
			}
		});
		panel.add(btnDiv);

	}
	
	private void estiloBoton(JButton b) {
		b.setBackground(new Color(255, 213, 234));
		b.setOpaque(true);
	    b.setBorderPainted(false);
	    b.setFocusable(false);
	}

}