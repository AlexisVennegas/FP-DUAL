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
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.data.category.DefaultCategoryDataset;

import componentes.MiGraficaProgreso;
import componentes.Nav;
import componentes.PanelHome;
import componentes.PanelRutinas;
import modelo.Usuario;
import componentes.CrearGraficaPeso;
import servicio.ServicioUsuario;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class VentanaInicio {

	JFrame frame;
	private JPanel panelCartas;
	private JLabel homeLabel;
	private CardLayout cardLayout;
	private Usuario usuario;
	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio window = new VentanaInicio(null);
					window.frame.setVisible(true);
					window.mostrar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrar() {
		if (frame != null) {
	        frame.setVisible(true);
	    } else {
	        System.out.println("Error: El frame no ha sido inicializado.");
	    }
		
	}

	public VentanaInicio(Usuario usuario) {
		super();
		this.usuario = usuario;
		initialize();
	}
	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
	    frame.setBounds(100, 100, 648, 584);
	    frame.getContentPane().setLayout(null); // Seguimos con null para el marco general
	    frame.getContentPane().setBackground(new Color(35, 37, 58));

	 
	 // 2. LOGO (Se queda fijo arriba)
        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        // Cargamos el logo desde recursos
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imgEscalada));
        logo.setBounds(241, 11, 164, 64); // Posición fija arriba
        frame.getContentPane().add(logo);
	    
	    cardLayout = new CardLayout();
	    panelCartas = new JPanel(cardLayout);
	    panelCartas.setBounds(0, 100, 648, 380); 
	    panelCartas.setOpaque(false);
	    frame.getContentPane().add(panelCartas);

	    // 3. Añadir las pantallas (que ahora serán clases JPanel aparte)
	    panelCartas.add(new PanelHome(this.usuario), "PanelHome");
	    panelCartas.add(new PanelRutinas(this.usuario), "PanelRutinas");
	    panelCartas.add(new PanelRutinas(this.usuario), "PanelIniciarRutina");
	    // panelCartas.add(new PanelPerfil(), "PERFIL");

	    // CREAR LA NAV
	    Nav barra = new Nav(panelCartas, cardLayout); 
	    frame.getContentPane().add(barra);
	}

	
}
