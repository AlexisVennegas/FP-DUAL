package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.ConexionGameHub;
import bbdd.ServicioDAO;
import ficheros.FicheroTexto;
import ficheros.UsuarioDAO;
import modelo.Juego;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dniTexto;
	private JTextField idJuegoTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 572, 344);
		contentPane.add(tabbedPane);

		JPanel ventana = new JPanel();
		tabbedPane.addTab("Ventana", null, ventana, null);
		ventana.setLayout(null);

		JLabel dniLabel = new JLabel("Insertar DNI del usuario: ");
		dniLabel.setBounds(10, 11, 142, 14);
		ventana.add(dniLabel);

		dniTexto = new JTextField();
		dniTexto.setBounds(162, 8, 142, 20);
		ventana.add(dniTexto);
		dniTexto.setColumns(10);

		JLabel idJuegoLabel = new JLabel("Insertar ID del juego: ");
		idJuegoLabel.setBounds(10, 36, 142, 14);
		ventana.add(idJuegoLabel);

		idJuegoTexto = new JTextField();
		idJuegoTexto.setBounds(162, 33, 142, 20);
		ventana.add(idJuegoTexto);
		idJuegoTexto.setColumns(10);

		JButton procesarBoton = new JButton("Procesar operación");
		procesarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// 1. Leemos la información (protegido por el catch de NumberFormatException)
					String dniUsuario = dniTexto.getText();
					int idJuegoUsuario = Integer.parseInt(idJuegoTexto.getText());

					// 2. Conectamos a BD y ficheros
					Connection conexion = ConexionGameHub.getInstance();
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					ServicioDAO servicio = new ServicioDAO(conexion);

					// 3. Buscamos el juego
					Juego juegoBusqueda = new Juego(idJuegoUsuario, "Temp", "Temp", 0.0, 0);
					ResultSet rsJuego = servicio.listar(juegoBusqueda);

					// 4. ¿Existe el juego en la base de datos?
					if (rsJuego != null && rsJuego.next()) {

						// Extraemos TODOS los datos reales. Corregido "titulo" por "nombre"
						String nombreReal = rsJuego.getString("nombre");
						String plataformaReal = rsJuego.getString("plataforma");
						double precioReal = rsJuego.getDouble("precio");
						int stockReal = rsJuego.getInt("stock");

						// 5. Validar que haya stock antes de alquilar
						if (stockReal > 0) {

							// 6. ¿Existe el socio para registrarle el alquiler? (usamos usuarioDAO, no
							// socio)
							if (usuarioDAO.registrarAlquiler(dniUsuario)) {

								// --------- STOCK -------------------
								// Construimos el objeto Juego restando 1 al stock actual
								Juego juegoActualizar = new Juego(idJuegoUsuario, nombreReal, plataformaReal,
										precioReal, stockReal - 1);

								// Actualizamos en BD
								servicio.actualizar(juegoActualizar);

								// --------- TICKET -------------------
								// Usamos FicheroTexto para generar una línea de registro
								FicheroTexto ticket = new FicheroTexto();
								String detalleTicket = "TICKET: Usuario [" + dniUsuario + "] ha alquilado el juego '"
										+ nombreReal + "' (Plataforma: " + plataformaReal + ") por " + precioReal + "€";
								ticket.añadirLineas(detalleTicket);

								// Mensaje final de éxito
								JOptionPane.showMessageDialog(null,
										"Alquiler registrado con éxito.\nStock actualizado y ticket generado.");

							} else {
								// El socio no existe
								JOptionPane.showMessageDialog(null, "Error: El DNI no está registrado en el sistema.",
										"Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							// No hay stock
							JOptionPane.showMessageDialog(null,
									"Error: No hay copias disponibles (Stock 0) para este juego.", "Sin stock",
									JOptionPane.WARNING_MESSAGE);
						}
						rsJuego.close();
					} else {
						// El juego no existe
						JOptionPane.showMessageDialog(null, "Error: El ID del juego introducido no existe.",
								"Juego no encontrado", JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException ex) {
					// Si el usuario deja el ID vacío o escribe letras
					JOptionPane.showMessageDialog(null, "Por favor, introduce un ID de juego numérico válido.",
							"Error de formato", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException ex) {
					// Error de base de datos
					JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage(), "Error SQL",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		procesarBoton.setBounds(20, 64, 284, 23);
		ventana.add(procesarBoton);

	}

}
