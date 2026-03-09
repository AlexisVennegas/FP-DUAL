package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import ventana.Buttons;

public class Ventana  implements ActionListener {

	private JFrame 	frame;
	private JTextField 	txtResult;
	private String operacionCompleta = "";
	private double 		primerNumero,	
						segundoNumero,
						resultado;


	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	

		
		// borrar
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText("");
			}
		});
		btnNewButton.setBounds(20, 89, 184, 38);
		frame.getContentPane().add(btnNewButton);
		
		
		// PUNTO DECIMAL
		
		JButton btnNewButtonPunto = new JButton(".");
		btnNewButtonPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtResult.getText().contains(".")) 
					txtResult.setText(txtResult.getText() + btnNewButtonPunto.getText());
				else return;
			}
		});
		btnNewButtonPunto.setBounds(20, 240, 184, 38);
		frame.getContentPane().add(btnNewButtonPunto);
		
		
		
		//OPEACIONES
		
		//++++++++++++
		
		
		
		JButton btnNewButtonSumar = new JButton("+");
		btnNewButtonSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtResult.getText().contains("+")) {
				
					txtResult.setText(txtResult.getText() + "+");
					
				}
				else return;
			}
		
		});
		btnNewButtonSumar.setBounds(314, 202, 111, 38);
		frame.getContentPane().add(btnNewButtonSumar);
		
		
		// ------
		
		JButton btnNewButtonRestar = new JButton("-");
		btnNewButtonRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtResult.getText().contains("-")) {
				
					txtResult.setText(txtResult.getText() + "-");
					
				}
				else return;
			}
		
		});
		btnNewButtonRestar.setBounds(314, 165, 111, 38);
		frame.getContentPane().add(btnNewButtonRestar);
		
		// ******
		
		JButton btnNewButtonMultiplicar = new JButton("*");
		btnNewButtonMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtResult.getText().contains("*")) {
					txtResult.setText(txtResult.getText() + "*");	
				}
				else return;
			}
		});
		btnNewButtonMultiplicar.setBounds(314, 127, 111, 38);
		frame.getContentPane().add(btnNewButtonMultiplicar);
		
		// ========
	
		
		JButton btnNewButtonIgualdad= new JButton("=");
		btnNewButtonIgualdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionCompleta = txtResult.getText(); // 10+10-20*30
				resultado = Buttons.evaluarExpresion(operacionCompleta);
			    txtResult.setText(String.valueOf(resultado));

			}
		
		});
		btnNewButtonIgualdad.setBounds(314, 240, 111, 38);
		frame.getContentPane().add(btnNewButtonIgualdad);
		
	
		
		
		txtResult = new JTextField();
		txtResult.setText("");
		txtResult.setBounds(20, 11, 404, 65);
		frame.getContentPane().add(txtResult);
		txtResult.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("%");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(204, 89, 111, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("/");
		btnNewButton_2.setBounds(314, 89, 111, 38);
		frame.getContentPane().add(btnNewButton_2);
	
	
		
		
		
	
	
		

		
		
		Buttons.crearButtons(txtResult, frame);
		
	
		
	}
}
