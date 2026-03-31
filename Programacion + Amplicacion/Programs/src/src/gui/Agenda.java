package src.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

import src.conexion.Singleton;
import src.dao.ContactoDAO;
import src.dao.ContactoDAOImpl;
import src.dao.DAOException;
import src.modelo.Contacto;
import src.servicio.ContactoServicio;
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
		etiquetaNombre.setBounds(24, 85, 46, 14);
		frame.getContentPane().add(etiquetaNombre);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setBounds(24, 138, 46, 14);
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
		botonGuardar.setBounds(335, 82, 89, 23);
		frame.getContentPane().add(botonGuardar);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(109, 82, 86, 20);
		frame.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		campoTelefono = new JTextField();
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(109, 135, 86, 20);
		frame.getContentPane().add(campoTelefono);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cambios = 0;
				cambios = servicio.EliminarContacto(campoNombre.getText());
				System.out.println(cambios);
				if(cambios == 1) {
					  JFrame ventana = new JFrame("Todos los contactos");
				        ventana.setBounds(100, 100, 300, 300);
				        ventana.getContentPane().setLayout(null);
				        JLabel lblNombre = new JLabel("columan elimianda correctamente" );
			            lblNombre.setBounds(20, 30, 250, 20);
			            ventana.getContentPane().add(lblNombre);
			            ventana.setVisible(true);
				}
			}
		});
		btnEliminar.setBounds(335, 104, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnMostrarTodo = new JButton("Mostrar todo");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        List<Contacto> contactos = servicio.MostrarTodo();
		      
		        JFrame ventana = new JFrame("Todos los contactos");
		        ventana.setBounds(100, 100, 300, 300);
		        ventana.getContentPane().setLayout(null);

		        JTextArea area = new JTextArea();
		        area.setBounds(10, 10, 260, 240);

	
		        StringBuilder sb = new StringBuilder();

		        for(Contacto c : contactos) {
		            sb.append(c.getNombre())
		              .append(" - ")
		              .append(c.getTelefono())
		              .append("\n");
		        }

		        area.setText(sb.toString());

		        ventana.getContentPane().add(area);
		        ventana.setVisible(true);
			}
		});
		btnMostrarTodo.setBounds(335, 151, 89, 23);
		frame.getContentPane().add(btnMostrarTodo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto contacto = servicio.BuscarContacto(campoNombre.getText());
				if(contacto != null) {

		            // 🔥 crear nueva ventana
		            JFrame nuevaVentana = new JFrame("Resultado");
		            nuevaVentana.setBounds(100, 100, 300, 200);
		            nuevaVentana.getContentPane().setLayout(null);

		            // Label nombre
		            JLabel lblNombre = new JLabel("Nombre: " + contacto.getNombre());
		            lblNombre.setBounds(20, 30, 250, 20);
		            nuevaVentana.getContentPane().add(lblNombre);

		            // Label teléfono
		            JLabel lblTelefono = new JLabel("Teléfono: " + contacto.getTelefono());
		            lblTelefono.setBounds(20, 70, 250, 20);
		            nuevaVentana.getContentPane().add(lblTelefono);

		            // hacer visible
		            nuevaVentana.setVisible(true);

		        } else {
		            JOptionPane.showMessageDialog(frame, "No encontrado");
		        }
			}
		});
		btnBuscar.setBounds(335, 60, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas = servicio.editarContacto(campoNombre.getText(), campoTelefono.getText());
				if(filas != 0) {
					 JFrame ventana = new JFrame("Todos los contactos");
				        ventana.setBounds(100, 100, 300, 300);
				        ventana.getContentPane().setLayout(null);
				        JLabel lblNombre = new JLabel("columan modificada correctamente" );
			            lblNombre.setBounds(20, 30, 250, 20);
			            ventana.getContentPane().add(lblNombre);
			            ventana.setVisible(true);
				}
			}
		});
		btnEditar.setBounds(335, 127, 89, 23);
		frame.getContentPane().add(btnEditar);
		
		
	}
}
