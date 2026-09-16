package Singleton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda {

	private JFrame frame;
	private JTextField nombreInput;
	private JLabel lblTelefono;
	private JTextField telefonoInput;
	private JTextField fechaInput;
	private JLabel lblFecha;
	private JTextField emailInput;
	private JLabel lblEmail;
	
	
	private String nombre = "";
	private String email = "";
	private String telefono = "";
	private String fecha = "";
	private String id = "";
	private JTextField txtId;
	private JTextField textResultLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
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
	public Agenda() {
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
		
		nombreInput = new JTextField();
		nombreInput.setBounds(225, 31, 97, 27);
		frame.getContentPane().add(nombreInput);
		nombreInput.setColumns(10);
		
		textResultLabel = new JTextField();
		textResultLabel.setBounds(146, 222, 262, 20);
		frame.getContentPane().add(textResultLabel);
		textResultLabel.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(134, 34, 63, 21);
		frame.getContentPane().add(lblNewLabel);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(134, 72, 63, 21);
		frame.getContentPane().add(lblTelefono);
		
		telefonoInput = new JTextField();
		telefonoInput.setColumns(10);
		telefonoInput.setBounds(225, 69, 97, 27);
		frame.getContentPane().add(telefonoInput);
		
		fechaInput = new JTextField();
		fechaInput.setColumns(10);
		fechaInput.setBounds(225, 140, 97, 27);
		frame.getContentPane().add(fechaInput);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(134, 143, 63, 21);
		frame.getContentPane().add(lblFecha);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(225, 102, 97, 27);
		frame.getContentPane().add(emailInput);
		
		txtId = new JTextField();
		txtId.setText("id");
		txtId.setColumns(10);
		txtId.setBounds(31, 222, 86, 21);
		frame.getContentPane().add(txtId);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre = nombreInput.getText();
				telefono = telefonoInput.getText();
				email = emailInput.getText();
				fecha = fechaInput.getText();
				prueba.insertData(nombre, telefono, email, fecha);
				prueba.seedAgenda();
			}
		});
		btnNewButton.setBounds(31, 188, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre = nombreInput.getText();
				telefono = telefonoInput.getText();
				email = emailInput.getText();
				fecha = fechaInput.getText();
				id = txtId.getText();
				prueba.actualizarData(id, nombre, telefono, email, fecha);
			}
		});
		btnUpdate.setBounds(168, 188, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDlete = new JButton("Delete");
		btnDlete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = txtId.getText();
				int result = prueba.deleteData(id);
					if(result != 0) {
					textResultLabel.setText("columna eliminada correctamente");
				}
			}
		});
		btnDlete.setBounds(319, 188, 89, 23);
		frame.getContentPane().add(btnDlete);
		
	
		
		lblEmail = new JLabel("email");
		lblEmail.setBounds(134, 111, 63, 21);
		frame.getContentPane().add(lblEmail);
		
		
		
	}
}
