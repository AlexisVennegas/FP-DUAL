package gui;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import conexion.Singleton;
import dao.ContactoDAO;
import dao.ContactoDAOImpl;
import dao.DAOException;
import servicio.ContactoServicio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Agenda {

	private JFrame frame;
	private JTextField campoNombre;
	private JTextField campoTelefono;
   
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
		
		//Conexión, DAO, servicio
	    Connection conn = Singleton.getInstance();
	    ContactoDAO dao = new ContactoDAOImpl(conn);
	    ContactoServicio servicio = new ContactoServicio(dao);

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Singleton.close();
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(51, 50, 46, 14);
		frame.getContentPane().add(etiquetaNombre);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setBounds(51, 103, 46, 14);
		frame.getContentPane().add(etiquetaTelefono);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
	                servicio.registrarContacto(campoNombre.getText(), campoTelefono.getText());
	                JOptionPane.showMessageDialog(frame, "Contacto guardado");
	                campoNombre.setText(""); 
	                campoTelefono.setText("");
	            } catch (IllegalArgumentException ex) {
	                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
	            } catch (DAOException ex) {
	                JOptionPane.showMessageDialog(frame, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	            }
			
			}
		});
		botonGuardar.setBounds(133, 161, 89, 23);
		frame.getContentPane().add(botonGuardar);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(136, 47, 86, 20);
		frame.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(136, 100, 86, 20);
		frame.getContentPane().add(campoTelefono);
	}
}
