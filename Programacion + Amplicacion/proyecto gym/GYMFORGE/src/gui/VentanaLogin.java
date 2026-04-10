package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import modelo.Usuario;
import servicio.ServicioUsuario;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin {

	JFrame frame;
	private JTextField emailInput;
	private JTextField passwordInput;
	private String correo = "";
	private String password = "";
	ServicioUsuario servicioUsuario = new ServicioUsuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin window = new VentanaLogin();
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
	public VentanaLogin() {
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
		logo.setBounds(165, 11, 313, 101);
		frame.getContentPane().add(logo, BorderLayout.NORTH);
		
		
		// TITULO PRINCIPAL
		JLabel title = new JLabel("Bienvenudo de Vuelta");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(new Color(255, 255, 255));
		title.setBounds(165, 133, 313, 28);
		Font font = new Font("Arial", Font.BOLD, 26);
		title.setFont(font);
		frame.getContentPane().add(title);
		
		
		// PRIMER TUTILO DE INICIAR SESION
		JLabel title2 = new JLabel("inicia sesion para continuar tu entrenamiento");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(new Color(192, 192, 192));
		title2.setFont(new Font("Arial", Font.BOLD, 10));
		title2.setBounds(165, 172, 313, 14);
		frame.getContentPane().add(title2);
		
		// EMAIL LABLE
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(255, 255, 255));
		emailLabel.setBounds(165, 236, 62, 28);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(emailLabel);
		

		// EMAIL INPUT
		emailInput = new JTextField();
		emailInput.setForeground(new Color(255, 255, 255));
		emailInput.setBackground(new Color(26, 26, 38));
		emailInput.setBounds(165, 275, 313, 36);
		emailInput.setColumns(10);
		emailInput.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
		frame.getContentPane().add(emailInput);
		
		// PASSWORD LABEL
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));
		passwordLabel.setBounds(165, 322, 62, 28);
		frame.getContentPane().add(passwordLabel);
		
		// PASSWORD INPUT
		passwordInput = new JPasswordField();
		passwordInput.setForeground(Color.WHITE);
		passwordInput.setColumns(10);
		passwordInput.setBackground(new Color(26, 26, 38));
		passwordInput.setBounds(165, 361, 313, 36);
		passwordInput.setBorder(new javax.swing.border.LineBorder(new Color(60, 60, 80), 1, true));
		frame.getContentPane().add(passwordInput);
		
		
		// BUTTON LOGIN
		JButton btnLogin = new JButton("Iniciar Sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = null;
				correo = emailInput.getText();
				password = passwordInput.getText();
				boolean sirveBolean = false;
				
				try {
					u = servicioUsuario.accesoUsuario(correo, password);
					if(u == null) {
		                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios", 
                                "Error de Validación", JOptionPane.WARNING_MESSAGE);
		                	return; }
					 JOptionPane.showMessageDialog(frame, "¡inicio exitoso!");
					 VentanaInicio ventanaInicio = new VentanaInicio(u);
					 ventanaInicio.mostrar();
					
					 frame.dispose();
				} catch (Exception e2) {
					  JOptionPane.showMessageDialog(frame, "Error al registrar: " + e2.getMessage(), 
                              "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255)); 
		btnLogin.setBackground(new Color(236, 91, 13)); 
		btnLogin.setContentAreaFilled(true); 
		btnLogin.setOpaque(true); 
		btnLogin.setBorderPainted(false); 
		btnLogin.setBounds(165, 425, 313, 36);
		frame.getContentPane().add(btnLogin);
		
		// label de no tienes cuenta
		JLabel labelPreguta = new JLabel("¿No tienes Cuenta?");
		labelPreguta.setForeground(Color.WHITE);
		labelPreguta.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPreguta.setBounds(215, 472, 113, 28);
		labelPreguta.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(labelPreguta);
		
		// labeL PARA REGISTRARTE
		JLabel labelRegistrate = new JLabel("Registrate");
		labelRegistrate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        VentanaRegister vRegistro = new VentanaRegister();
		        vRegistro.frame.setVisible(true);
		        frame.setVisible(false); 
		        frame.dispose();
			}
		});
		
		labelRegistrate.setHorizontalAlignment(SwingConstants.LEFT);
		labelRegistrate.setForeground(new Color(255, 128, 0));
		labelRegistrate.setBounds(338, 472, 62, 28);
		labelRegistrate.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(labelRegistrate);


	
		frame.setBackground(new Color(10, 10, 15));
		frame.setBounds(100, 100, 648, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
