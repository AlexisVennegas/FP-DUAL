package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.Provider.Service;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import service.serviceCliente;

public class Menu {

	private JFrame frame;
	private JTextField inputCliente;
	String numCliente = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelCliente = new JLabel("Numero de cliente: ");
		labelCliente.setBounds(159, 31, 135, 14);
		frame.getContentPane().add(labelCliente);
		
		inputCliente = new JTextField();
		inputCliente.setBounds(55, 57, 345, 20);
		frame.getContentPane().add(inputCliente);
		inputCliente.setColumns(10);
		
		JLabel labelMensaje = new JLabel("");
		labelMensaje.setBorder(new EmptyBorder(0, 0, 0, 0));
		labelMensaje.setBackground(new Color(0, 255, 255));
		labelMensaje.setBounds(76, 199, 324, 14);
		frame.getContentPane().add(labelMensaje);
		
		JButton buttonGenerarFichero = new JButton("Generar fichero");
		buttonGenerarFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numCliente = inputCliente.getText();
			
				
				if(numCliente.equals("")) {
					labelMensaje.setText("se deben introducir datos");
				
				}
				else {
					try {
						serviceCliente serviceCliente = new serviceCliente();
						numCliente = serviceCliente.buscarCliente(numCliente);
						
						if(numCliente.equals("")) {
							labelMensaje.setText("cliente no encontrado");
						}else {
							int posicion = numCliente.indexOf("|");
							String cliente = numCliente.substring(0, posicion);
							String totalDinero = numCliente.substring(posicion + 1);
							String soloDespues = numCliente.replace(cliente + "|", ""); 
							
							serviceCliente.anadirBinario(numCliente, totalDinero);
						
							labelMensaje.setText("numero de cliente: " + cliente + " || total: " + totalDinero);
						}
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		buttonGenerarFichero.setBounds(55, 165, 345, 23);
		frame.getContentPane().add(buttonGenerarFichero);
		
	
	}
}
