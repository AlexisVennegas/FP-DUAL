package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dao.DAOException;
import dao.HistorialPesoDaoImpl;
import dao.TipoException;
import modelo.Usuario;
import servicio.ServicioUsuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegister {

	JFrame frame;
	private JTextField emailInput;
	private JTextField passwordInput;
	private JTextField NombreInput;
	private JPasswordField passwordInput2;
	private String nombre = "";
	private String correo = "";
	private String password = "";
	private Double altura = null;
	private Double peso = null;
	ServicioUsuario servicioUsuario = new ServicioUsuario();
	HistorialPesoDaoImpl hdao = new HistorialPesoDaoImpl(); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegister window = new VentanaRegister();
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
	public VentanaRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(35, 37, 58));
		frame.getContentPane().setLayout(null);
		
		
		// LOGO
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBorder(new javax.swing.border.EmptyBorder(50, 0, 20, 0));
		ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(480, 320, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(imgEscalada));
		logo.setBounds(150, 11, 348, 96);
		frame.getContentPane().add(logo, BorderLayout.NORTH);
		
		
		// TITULO PRINCIPAL
		JLabel title = new JLabel("Crea tu cuenta");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(150, 118, 348, 28);
		Font font = new Font("Arial", Font.BOLD, 26);
		title.setFont(font);
		frame.getContentPane().add(title);
		
		
		// PRIMER TUTILO DE INICIAR SESION
		JLabel title2 = new JLabel("Empieza a forjar tu mejor version hoy");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(new Color(192, 192, 192));
		title2.setFont(new Font("Arial", Font.BOLD, 10));
		title2.setBounds(150, 157, 348, 14);
		frame.getContentPane().add(title2);
		
		
		// LABEL INPUT
		
		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setForeground(Color.WHITE);
		nombreLabel.setFont(new Font("Arial", Font.BOLD, 12));
		nombreLabel.setBounds(150, 193, 62, 28);
		frame.getContentPane().add(nombreLabel);
		
		
		
		// NAME INPUT
		NombreInput = new JTextField();
		NombreInput.setForeground(new Color(255, 255, 255));
		NombreInput.setBackground(new Color(26, 26, 38));
		NombreInput.setBounds(150, 221, 348, 36);
		NombreInput.setColumns(10);
		NombreInput.setColumns(10);
		NombreInput.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
		frame.getContentPane().add(NombreInput);

		
		// EMAIL LABLE
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(255, 255, 255));
		emailLabel.setBounds(150, 261, 62, 28);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(emailLabel);
		

		// EMAIL INPUT
		emailInput = new JTextField();
		emailInput.setForeground(new Color(255, 255, 255));
		emailInput.setBackground(new Color(26, 26, 38));
		emailInput.setBounds(150, 289, 348, 36);
		emailInput.setColumns(10);
		emailInput.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
		frame.getContentPane().add(emailInput);
		
		// PASSWORD LABEL
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
		passwordLabel.setBounds(150, 324, 62, 28);
		frame.getContentPane().add(passwordLabel);
		
		// PASSWORD INPUT
		passwordInput =  new JPasswordField();
		passwordInput.setForeground(Color.WHITE);
		passwordInput.setColumns(10);
		passwordInput.setBackground(new Color(26, 26, 38));
		passwordInput.setBounds(150, 348, 348, 36);
		passwordInput.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
		frame.getContentPane().add(passwordInput);
		

		// PESO LABEL
			
			
			JLabel PesoLabel = new JLabel("Peso:");
			PesoLabel.setForeground(Color.WHITE);
			PesoLabel.setFont(new Font("Arial", Font.BOLD, 12));
			PesoLabel.setBounds(204, 393, 62, 28);
			frame.getContentPane().add(PesoLabel);
			
			
			// INPUT NUMBER PESO
			
			JSpinner spinnerPeso = new JSpinner();
			spinnerPeso.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
			spinnerPeso.setBounds(204, 422, 94, 36);
			spinnerPeso.setBackground(new Color(26, 26, 38));
			spinnerPeso.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
			JComponent editor2 = spinnerPeso.getEditor();
			JFormattedTextField campoTexto2 = ((JSpinner.DefaultEditor) editor2).getTextField();
			campoTexto2.setBackground(new Color(26, 26, 38)); 
			campoTexto2.setForeground(Color.WHITE);         
			campoTexto2.setCaretColor(Color.WHITE);        
			
			
			frame.getContentPane().add(spinnerPeso);
			
			// ALTURA LABEL
			
			JLabel AlturaLabel = new JLabel("Altura");
			AlturaLabel.setForeground(Color.WHITE);
			AlturaLabel.setFont(new Font("Arial", Font.BOLD, 12));
			AlturaLabel.setBounds(380, 395, 62, 28);
			frame.getContentPane().add(AlturaLabel);
			
		
			// INPUT NUMBER ALTURA
			JSpinner spinnerAltura = new JSpinner();
			spinnerAltura.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
			spinnerAltura.setBounds(362, 422, 94, 36);
			spinnerAltura.setBackground(new Color(26, 26, 38));
			spinnerAltura.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
			JComponent editor = spinnerAltura.getEditor();
			JFormattedTextField campoTexto = ((JSpinner.DefaultEditor) editor).getTextField();
			campoTexto.setBackground(new Color(26, 26, 38)); 
			campoTexto.setForeground(Color.WHITE);         
			campoTexto.setCaretColor(Color.WHITE);           
			frame.getContentPane().add(spinnerAltura);
		
	
		
		// BUTTON LOGIN
		JButton btnRegister = new JButton("Crear tu Cuenta");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean sirveBoolean = false;
				nombre = NombreInput.getText();
				correo = emailInput.getText();
				password = passwordInput.getText();
				altura = (Double) spinnerAltura.getValue();
				peso = (Double) spinnerPeso.getValue();
			try {
			 	sirveBoolean = servicioUsuario.registrarUsuario(nombre, correo, password, altura, peso);
			 	if (!sirveBoolean) {
	                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios", 
	                                              "Error de Validación", JOptionPane.WARNING_MESSAGE);
	               
	                return; 
	            }
			 	
		        JOptionPane.showMessageDialog(frame, "¡Registro exitoso!");
		        Usuario usuario = new Usuario();
		        usuario = servicioUsuario.accesoUsuario(correo, password);
		        VentanaInicio vInicio = new VentanaInicio(usuario);
		        hdao.insert(usuario);
		        vInicio.mostrar();
		        frame.dispose(); // Cerramos el registro
			} catch (Exception e2) {
				
		        JOptionPane.showMessageDialog(frame, "Error al registrar: " + e2.getMessage(), 
		                                      "Error", JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		
		btnRegister.setForeground(new Color(255, 255, 255)); 
		btnRegister.setBackground(new Color(236, 91, 13)); 
		btnRegister.setContentAreaFilled(true); 
		btnRegister.setOpaque(true); 
		btnRegister.setBorderPainted(false); 
		btnRegister.setBounds(150, 469, 348, 36);
		frame.getContentPane().add(btnRegister);
		
		// label de no tienes cuenta
		JLabel labelPreguta = new JLabel("¿Ya tienes Cuenta?");
		labelPreguta.setForeground(Color.WHITE);
		labelPreguta.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPreguta.setBounds(217, 506, 113, 28);
		labelPreguta.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(labelPreguta);
		
		
		
		
		// labeL PARA REGISTRARTE
		JLabel labelLogin = new JLabel("Iniciar Sesion");
		labelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaLogin ventanaLogin = new VentanaLogin();
				
				ventanaLogin.frame.setVisible(true);
				
				frame.setVisible(false);
				frame.dispose();
			}
		});
		labelLogin.setHorizontalAlignment(SwingConstants.LEFT);
		labelLogin.setForeground(new Color(255, 128, 0));
		labelLogin.setBounds(340, 506, 83, 28);
		labelLogin.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(labelLogin);
		
		
	
		
	
	
		
		 

	
	

	
		frame.setBackground(new Color(10, 10, 15));
		frame.setBounds(100, 100, 648, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
