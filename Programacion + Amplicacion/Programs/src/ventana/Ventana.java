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

public class Ventana {

	private JFrame 	frame;
	private JTextField 	txtResult;
	private double 		primerNumero,	
						segundoNumero,
						resultado;



	

	List<Integer> numeros = new ArrayList<>();
	List<String> operaciones = new ArrayList<>();
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
		
	
		
		
		// NUMBER 1
		JButton buttonNumber1 = new JButton("1");
		buttonNumber1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(txtResult.getText() + buttonNumber1.getText());
				primerNumero = Integer.parseInt(txtResult.getText());
			}
		});
		
		buttonNumber1.setBounds(20, 202, 94, 38);
		frame.getContentPane().add(buttonNumber1);
		
		
		//  NUMBER 2
		JButton buttonNumber2 = new JButton("2");
		buttonNumber2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(txtResult.getText() + buttonNumber2.getText());
				primerNumero = Integer.parseInt(txtResult.getText());
			}
		});;
		buttonNumber2.setBounds(115, 202, 89, 38);
		frame.getContentPane().add(buttonNumber2);

		// NUMBER 3
		JButton buttonNumber3 = new JButton("3");
		buttonNumber3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(txtResult.getText() + buttonNumber3.getText());
		}
		});
		buttonNumber3.setBounds(204, 202, 111, 38);
		frame.getContentPane().add(buttonNumber3);
		
		// NUMBER 4
		JButton btnNewButton4 = new JButton("4");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(txtResult.getText() + btnNewButton4.getText());
		}
		});
		btnNewButton4.setBounds(20, 165, 94, 38);
		frame.getContentPane().add(btnNewButton4);
		
		
		
		// NUMBER 5
		JButton btnNewButton5 = new JButton("5");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton5.getText());
			}
		});
		btnNewButton5.setBounds(115, 165, 89, 38);
		frame.getContentPane().add(btnNewButton5);
		
		
		// number 6
		
		JButton btnNewButton6 = new JButton("6");
		btnNewButton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton6.getText());
			}
		});
		btnNewButton6.setBounds(204, 165, 111, 38);
		frame.getContentPane().add(btnNewButton6);
		
	
		
		// NUMBER 7
		
		JButton btnNewButton7 = new JButton("7");
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton7.getText());
				
			}
		});
		btnNewButton7.setBounds(20, 127, 94, 38);
		frame.getContentPane().add(btnNewButton7);
		
		
		// NUMBER 8
		JButton btnNewButton8 = new JButton("8");
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton8.getText());
				
			}
		});
		btnNewButton8.setBounds(115, 127, 89, 38);
		
		frame.getContentPane().add(btnNewButton8);
	
		// NUMBER 9
		JButton btnNewButton9 = new JButton("9");
		btnNewButton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton9.getText());
				
			}
		});
		btnNewButton9.setBounds(204, 127, 111, 38);
		frame.getContentPane().add(btnNewButton9);
		
		
		
		// number 0
		JButton btnNewButton0 = new JButton("0");
		btnNewButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtResult.setText(txtResult.getText() + btnNewButton0.getText());
				
			}
		});
		btnNewButton0.setBounds(204, 240, 111, 38);
		frame.getContentPane().add(btnNewButton0);
		
		
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
					primerNumero = Integer.parseInt(txtResult.getText());
					
					for(int i = 0; i <= txtResult.getText().length(); i++) {
						
					    char c = txtResult.getText().charAt(i);
					    if (Character.isDigit(c)) {
					        resultado += c;
					    } else {
					        numeros.add(Integer.parseInt(resultado));
					        operaciones.add(String.valueOf(c));
					        numeroActual = "";
					    }

					}
					txtResult.setText(txtResult.getText() + btnNewButtonSumar.getText());
				}
				else return;
			}
		
		});
		btnNewButtonSumar.setBounds(314, 202, 111, 38);
		frame.getContentPane().add(btnNewButtonSumar);
		
		// ========
	
		
		JButton btnNewButtonIgualdad= new JButton("=");
		btnNewButtonIgualdad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
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
	
	
		
		JButton btnNewButton_2_1 = new JButton("*");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(314, 127, 111, 38);
		frame.getContentPane().add(btnNewButton_2_1);
		
	
	
		
		JButton btnNewButton_2_1_1 = new JButton("-");
		btnNewButton_2_1_1.setBounds(314, 165, 111, 38);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		
		
		
	
		
	}
}
