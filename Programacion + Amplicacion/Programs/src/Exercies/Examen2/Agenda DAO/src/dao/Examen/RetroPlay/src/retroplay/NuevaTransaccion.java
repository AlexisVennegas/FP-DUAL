package retroplay;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class NuevaTransaccion extends JFrame {

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
					NuevaTransaccion frame = new NuevaTransaccion();
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
	public NuevaTransaccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 616, 427);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Nueva Transacción", null, panel, null);
		panel.setLayout(null);

		JLabel labelDNI = new JLabel("Introduce el DNI del socio:  ");
		labelDNI.setBounds(10, 11, 163, 14);
		panel.add(labelDNI);

		dniTexto = new JTextField();
		dniTexto.setBounds(183, 8, 163, 20);
		panel.add(dniTexto);
		dniTexto.setColumns(10);

		JLabel labelIdJuego = new JLabel("Introduce el ID del juego: ");
		labelIdJuego.setBounds(10, 42, 163, 14);
		panel.add(labelIdJuego);

		idJuegoTexto = new JTextField();
		idJuegoTexto.setBounds(183, 39, 163, 20);
		panel.add(idJuegoTexto);
		idJuegoTexto.setColumns(10);

		JButton procesarBoton = new JButton("Procesar");
		procesarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Lo primero que necesitamos hacer es "leer" o capturar la información que el
				 * usuario ha escrito en esas dos cajas de texto. Si no guardamos esos datos en
				 * ese momento, no sabremos a qué socio o a qué juego se refiere la transacción.
				 */
				String dniUsuario = dniTexto.getText();
				int idJuegoUsuario = Integer.parseInt(idJuegoTexto.getText());

				// "La interfaz debe mostrar mensajes de éxito o de error si el socio o el juego
				// no existen."

				/*
				 * Para poder comprobar si existen (y para hacer el resto de operaciones),
				 * necesitamos conectarnos a nuestra base de datos y a nuestro fichero de
				 * objetos. Para eso construimos las clases SocioDAO y ServicioDAO.
				 */
				Connection conexion = ConexionRetroDB.getInstance();

				ServicioDAO servicio = new ServicioDAO(conexion);
				SocioDAO socio = new SocioDAO();

				/*
				 * Para poder usar este método, necesitamos crear un objeto Videojuego
				 * "temporal" utilizando el idJuegoUsuario que capturaste (puedes rellenar el
				 * resto de parámetros del constructor con valores falsos o ceros, ya que no se
				 * usarán para la búsqueda).
				 */
				// 1. Usamos la variable idJuegoUsuario en lugar de un 0
				Videojuego juego = new Videojuego(idJuegoUsuario, "Temp", "Temp", 0.0, 0);
				// 2. Guardamos la respuesta en una variable del tipo ResultSet
				ResultSet rsJuego = servicio.leer(juego);
				try {
					// 1. ¿Existe el juego en la base de datos?
					if (rsJuego != null && rsJuego.next()) {
						// // 2. SI EXISTE EL JUEGO -> ¿Existe el socio para registrarle el alquiler?
						if (socio.registrarAlquiler(dniUsuario)) {
							JOptionPane.showMessageDialog(null, "Alquiler registrado con éxito");

							// Aquí van los stock y ticket

							// ---------STOCK-------------------

							/*
							 * Aquí hay una trampa muy peligrosa en la que es fácil caer. Vamos a mirar la
							 * consulta SQL que programaste en tu método actualizar: UPDATE videojuegos SET
							 * idJuego = ?, titulo = ?, plataforma = ?, precio = ? , stock = ? WHERE idJuego
							 * = ?
							 * 
							 * Como puedes ver, tu método actualiza toda la fila. Si intentas usar el objeto
							 * juego "temporal" que creamos antes para buscar (el que tenía de título "Temp"
							 * y precio 0.0), ¡sobrescribirás el nombre real del juego en tu base de datos y
							 * lo llamarás "Temp"!
							 * 
							 * Para hacerlo bien y de forma segura, tenemos que aprovechar que el ResultSet
							 * (rsJuego) tiene todos los datos reales. Debemos "leer" esos datos, construir
							 * un objeto Videojuego con la información auténtica (pero con un stock menos) y
							 * pasárselo al método.
							 */

							// 1. Extraemos TODOS los datos reales del ResultSet
							String tituloReal = rsJuego.getString("titulo");
							String plataformaReal = rsJuego.getString("plataforma");
							double precioReal = rsJuego.getDouble("precio");
							int stockReal = rsJuego.getInt("stock");

							// 2. 2. Construimos un objeto Videojuego idéntico al de la base de datos,
							// pero le restamos 1 al stock.
							Videojuego juegoActualizar = new Videojuego(idJuegoUsuario, tituloReal, plataformaReal,
									precioReal, stockReal - 1);

							// 3. Enviamos el objeto completo para que la BD se actualice correctamente
							servicio.actualizar(juegoActualizar);

							// ---------TICKET-------------------
							Ticket ticket = new Ticket();
							ticket.generarArchivo(juegoActualizar);

						} else {
							// Si el juego existe, pero el socio no:
							JOptionPane.showMessageDialog(null, "El socio no existe");
						}
						rsJuego.close();
					} else {
						// 3. Si el juego no existe
						JOptionPane.showMessageDialog(null, "El juego no existe");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		procesarBoton.setBounds(382, 22, 106, 23);
		panel.add(procesarBoton);

	}
}
