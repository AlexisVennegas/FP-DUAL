package pokidex;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gui implements ActionListener, ChangeListener {

	private JTabbedPane tabbedPane, pestaña;
	private JPanel Favoritos;
	private JFrame frame;
	private JButton boton, btnCuriosidad, btnVerEvolucion, btnPrimero, btnAnterior, btnSiguiente, btnUltimo, btnCuriosidad_1,
			btnEliminarDeFavoritos, btnExportarFavoritos;
	private JTextField campoTextoNombreBuscar, campoTextoIDBuscar, campoTextoAltura, campoTextoPeso, 
			campoTextoIDFavorito, campoTextoAltura_1, campoTextoPeso_1;
	private JTextArea campoTextoDescripcion, campoTextoDescripcion_1;
	private JLabel etiquetaNombre, etiquetaID, etiquetaImagen, etiquetaNombre_1, etiquetaImagen_1, 
			etiquetaID_1;
	private Connection conexion;
	private Statement sentencia;
	private String sql, rutaImagen;
	private ResultSet rs;
	private FileWriter f_writer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 298, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Exploracion = new JPanel();
		tabbedPane.addTab("Exploración", null, Exploracion, null);
		Exploracion.setLayout(null);
		
		JLabel Busqueda = new JLabel("Búsqueda");
		Busqueda.setBounds(10, 11, 63, 14);
		Exploracion.add(Busqueda);
		
		JLabel etiquetaBusquedaNombre = new JLabel("Nombre");
		etiquetaBusquedaNombre.setBounds(10, 36, 46, 14);
		Exploracion.add(etiquetaBusquedaNombre);
		
		campoTextoNombreBuscar = new JTextField();
		campoTextoNombreBuscar.setBounds(66, 33, 96, 20);
		Exploracion.add(campoTextoNombreBuscar);
		campoTextoNombreBuscar.setColumns(10);
		
		JLabel etiquetaBusquedaID = new JLabel("ID");
		etiquetaBusquedaID.setBounds(10, 61, 46, 14);
		Exploracion.add(etiquetaBusquedaID);
		
		campoTextoIDBuscar = new JTextField();
		campoTextoIDBuscar.setBounds(66, 58, 96, 20);
		Exploracion.add(campoTextoIDBuscar);
		campoTextoIDBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(172, 32, 93, 23);
		Exploracion.add(btnBuscar);
		
		etiquetaID = new JLabel("ID");
		etiquetaID.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaID.setBounds(172, 91, 46, 14);
		Exploracion.add(etiquetaID);
		
		etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiquetaNombre.setBounds(128, 116, 137, 14);
		Exploracion.add(etiquetaNombre);
		
		JLabel etiquetaAltura = new JLabel("Altura");
		etiquetaAltura.setBounds(148, 151, 46, 14);
		Exploracion.add(etiquetaAltura);
		
		JLabel etiquetaPeso = new JLabel("Peso");
		etiquetaPeso.setBounds(148, 182, 36, 14);
		Exploracion.add(etiquetaPeso);
		
		campoTextoAltura = new JTextField();
		campoTextoAltura.setEditable(false);
		campoTextoAltura.setBounds(198, 148, 46, 20);
		Exploracion.add(campoTextoAltura);
		campoTextoAltura.setColumns(10);
		
		campoTextoPeso = new JTextField();
		campoTextoPeso.setEditable(false);
		campoTextoPeso.setBounds(198, 179, 46, 20);
		Exploracion.add(campoTextoPeso);
		campoTextoPeso.setColumns(10);
		
		JLabel etiquetaDescripcion = new JLabel("Descripción");
		etiquetaDescripcion.setBounds(10, 220, 96, 14);
		Exploracion.add(etiquetaDescripcion);
		
		campoTextoDescripcion = new JTextArea();
		campoTextoDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		campoTextoDescripcion.setLineWrap(true);
		campoTextoDescripcion.setEditable(false);
		campoTextoDescripcion.setBounds(7, 237, 111, 105);
		Exploracion.add(campoTextoDescripcion);
		
		btnCuriosidad = new JButton("Curiosidad");
		btnCuriosidad.setBounds(128, 220, 137, 23);
		Exploracion.add(btnCuriosidad);
		
		JButton btnAñadirAFavoritos = new JButton("Añadir a Favoritos");
		btnAñadirAFavoritos.setBounds(128, 254, 137, 23);
		Exploracion.add(btnAñadirAFavoritos);
		
		btnVerEvolucion = new JButton("Ver evolución");
		btnVerEvolucion.setBounds(128, 288, 137, 23);
		Exploracion.add(btnVerEvolucion);
		
		JButton btnAleatorio = new JButton("Aleatorio");
		btnAleatorio.setBounds(172, 57, 93, 23);
		Exploracion.add(btnAleatorio);
		
		JButton btnCombate = new JButton("Combate");
		btnCombate.setBounds(128, 322, 137, 23);
		Exploracion.add(btnCombate);
		
		etiquetaImagen = new JLabel("");
		etiquetaImagen.setIcon(null);
		etiquetaImagen.setBounds(44, 116, 63, 67);
		Exploracion.add(etiquetaImagen);
		
		Favoritos = new JPanel();
		tabbedPane.addTab("Favoritos", null, Favoritos, null);
		Favoritos.setLayout(null);
		
		btnPrimero = new JButton("<<");
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPrimero.setBounds(10, 11, 51, 23);
		Favoritos.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBounds(66, 11, 46, 23);
		Favoritos.add(btnAnterior);
		
		btnUltimo = new JButton(">>");
		btnUltimo.setBounds(216, 11, 51, 23);
		Favoritos.add(btnUltimo);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.setBounds(165, 11, 46, 23);
		Favoritos.add(btnSiguiente);
		
		campoTextoIDFavorito = new JTextField();
		campoTextoIDFavorito.setEditable(false);
		campoTextoIDFavorito.setBounds(116, 12, 45, 22);
		Favoritos.add(campoTextoIDFavorito);
		campoTextoIDFavorito.setColumns(10);
		
		etiquetaImagen_1 = new JLabel("");
		etiquetaImagen_1.setIcon(null);
		etiquetaImagen_1.setBounds(42, 83, 63, 67);
		Favoritos.add(etiquetaImagen_1);
		
		etiquetaNombre_1 = new JLabel("Nombre");
		etiquetaNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		etiquetaNombre_1.setBounds(130, 83, 137, 14);
		Favoritos.add(etiquetaNombre_1);
		
		etiquetaID_1 = new JLabel("ID");
		etiquetaID_1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaID_1.setBounds(171, 58, 46, 14);
		Favoritos.add(etiquetaID_1);
		
		JLabel etiquetaAltura_1 = new JLabel("Altura");
		etiquetaAltura_1.setBounds(148, 129, 46, 14);
		Favoritos.add(etiquetaAltura_1);
		
		campoTextoAltura_1 = new JTextField();
		campoTextoAltura_1.setEditable(false);
		campoTextoAltura_1.setColumns(10);
		campoTextoAltura_1.setBounds(204, 126, 46, 20);
		Favoritos.add(campoTextoAltura_1);
		
		JLabel etiquetaPeso_1 = new JLabel("Peso");
		etiquetaPeso_1.setBounds(147, 154, 36, 14);
		Favoritos.add(etiquetaPeso_1);
		
		campoTextoPeso_1 = new JTextField();
		campoTextoPeso_1.setEditable(false);
		campoTextoPeso_1.setColumns(10);
		campoTextoPeso_1.setBounds(204, 151, 46, 20);
		Favoritos.add(campoTextoPeso_1);
		
		JLabel etiquetaDescripcion_1 = new JLabel("Descripción");
		etiquetaDescripcion_1.setBounds(10, 194, 102, 14);
		Favoritos.add(etiquetaDescripcion_1);
		
		campoTextoDescripcion_1 = new JTextArea();
		campoTextoDescripcion_1.setLineWrap(true);
		campoTextoDescripcion_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		campoTextoDescripcion_1.setEditable(false);
		campoTextoDescripcion_1.setBounds(10, 213, 111, 134);
		Favoritos.add(campoTextoDescripcion_1);
		
		btnCuriosidad_1 = new JButton("Curiosidad");
		btnCuriosidad_1.setBounds(130, 213, 137, 32);
		Favoritos.add(btnCuriosidad_1);
		
		btnEliminarDeFavoritos = new JButton("Eliminar de Favoritos");
		btnEliminarDeFavoritos.setBounds(130, 264, 137, 32);
		Favoritos.add(btnEliminarDeFavoritos);
		
		btnExportarFavoritos = new JButton("Exportar favoritos");
		btnExportarFavoritos.setIcon(null);
		btnExportarFavoritos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportarFavoritos.setBackground(new Color(204, 255, 255));
		btnExportarFavoritos.setForeground(new Color(51, 0, 204));
		btnExportarFavoritos.setBounds(130, 315, 137, 32);
		Favoritos.add(btnExportarFavoritos);
		
		JPanel Comparacion = new JPanel();
		tabbedPane.addTab("Comparación", null, Comparacion, null);
		Comparacion.setLayout(null);
		
		conexion = Singleton.getConnection();
		try {
			sentencia = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			sql="DROP DATABASE IF EXISTS pokidex;";
			sentencia.executeUpdate(sql);
			sql="CREATE DATABASE pokidex;";
			sentencia.executeUpdate(sql);
			sql="USE pokidex;";
			sentencia.executeUpdate(sql);
			sql="CREATE TABLE tipos ("
					+ "id INT PRIMARY KEY,"
					+ "nombre_tipo VARCHAR(20) NOT NULL"
					+ ");";
			sentencia.executeUpdate(sql);
			sql="CREATE TABLE efectividades ("
					+ "id_tipo_atacante INT,"
					+ "id_tipo_defensor INT,"
					+ "multiplicador DECIMAL(3,1),"
					+ "PRIMARY KEY (id_tipo_atacante, id_tipo_defensor),"
					+ "FOREIGN KEY (id_tipo_atacante) REFERENCES tipos(id),"
					+ "FOREIGN KEY (id_tipo_defensor) REFERENCES tipos(id)"
					+ ");";
			sentencia.executeUpdate(sql);
			sql="CREATE TABLE pokimon ("
					+ "id INT PRIMARY KEY,"
					+ "nombre VARCHAR(50) NOT NULL,"
					+ "altura DECIMAL(5,2),"
					+ "peso DECIMAL(5,2),"
					+ "descripcion TEXT,"
					+ "ataque INT,"
					+ "defensa INT,"
					+ "curiosidad TEXT,"
					+ "id_tipo INT,"
					+ "id_evolucion INT NULL,"
					+ "FOREIGN KEY (id_tipo) REFERENCES tipos(id),"
					+ "FOREIGN KEY (id_evolucion) REFERENCES pokimon(id)"
					+ ");";
			sentencia.executeUpdate(sql);
			sql="CREATE TABLE favoritos ("
					+ "id_pokimon INT PRIMARY KEY,"
					+ "fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
					+ "FOREIGN KEY (id_pokimon) REFERENCES pokimon(id) ON DELETE CASCADE"
					+ ");";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO tipos (id, nombre_tipo) VALUES"
					+ "(1, 'Normal'), (2, 'Fuego'), (3, 'Agua'), (4, 'Planta'), (5, 'Eléctrico'),"
					+ "(6, 'Hielo'), (7, 'Lucha'), (8, 'Veneno'), (9, 'Tierra'), (10, 'Volador'),"
					+ "(11, 'Psíquico'), (12, 'Bicho'), (13, 'Roca'), (14, 'Fantasma'), (15, 'Dragón');";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO efectividades (id_tipo_atacante, id_tipo_defensor, multiplicador) VALUES"
					+ "(2, 4, 1.5),"
					+ "(3, 2, 1.5),"
					+ "(4, 3, 1.5),"
					+ "(5, 3, 1.5),"
					+ "(7, 1, 1.5),"
					+ "(9, 5, 1.5),"
					+ "(11, 7, 1.5),"
					+ "(12, 4, 1.5),"
					+ "(13, 2, 1.5);";
			sentencia.executeUpdate(sql);
			sql="SET FOREIGN_KEY_CHECKS = 0;";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO pokimon (id, nombre, altura, peso, descripcion, ataque, defensa, curiosidad, id_tipo, id_evolucion) VALUES"
					+ "(1, 'Bulbasaur', 0.7, 6.9, 'Lleva una semilla en el lomo desde que nace.', 49, 49, 'Es el primer Pokémon de la Pokédex.', 4, 2),"
					+ "(2, 'Ivysaur', 1.0, 13.0, 'Cuando el bulbo de su espalda crece, no puede erguirse.', 62, 63, 'Su bulbo desprende un olor dulce cuando va a florecer.', 4, 3),"
					+ "(3, 'Venusaur', 2.0, 100.0, 'La flor de su lomo absorbe energía solar.', 82, 83, 'Puede calmar las emociones de la gente con su aroma.', 4, NULL),"
					+ "(4, 'Charmander', 0.6, 8.5, 'La llama de su cola indica su salud y estado de ánimo.', 52, 43, 'Si se apaga su llama, moriría.', 2, 5),"
					+ "(5, 'Charmeleon', 1.1, 19.0, 'Suele usar su cola en llamas para derribar rivales.', 64, 58, 'Es mucho más agresivo que su preevolución.', 2, 6),"
					+ "(6, 'Charizard', 1.7, 90.5, 'Vuela por el cielo en busca de rivales fuertes.', 84, 78, 'Sus llamas pueden derretir rocas al instante.', 2, NULL),"
					+ "(7, 'Squirtle', 0.5, 9.0, 'Se refugia en su caparazón y lanza chorros de agua.', 48, 65, 'Su caparazón es muy duro y resistente.', 3, 8),"
					+ "(8, 'Wartortle', 1.0, 22.5, 'Su cola larga y peluda es un símbolo de longevidad.', 63, 80, 'Es un Pokémon muy popular entre la gente mayor.', 3, 9),"
					+ "(9, 'Blastoise', 1.6, 85.5, 'Lanza chorros de agua a presión por sus cañones.', 83, 100, 'Puede perforar el acero con sus chorros.', 3, NULL),"
					+ "(10, 'Caterpie', 0.3, 2.9, 'Sus patas tienen ventosas que le permiten trepar.', 30, 35, 'Muda de piel varias veces antes de crecer.', 12, 11),"
					+ "(11, 'Metapod', 0.7, 9.9, 'Su cuerpo está protegido por una cáscara dura.', 20, 55, 'En este estado solo puede endurecerse.', 12, 12),"
					+ "(12, 'Butterfree', 1.1, 32.0, 'Sus alas están cubiertas de polvillo tóxico.', 45, 50, 'Puede buscar polen en flores a 10km de distancia.', 12, NULL),"
					+ "(13, 'Weedle', 0.3, 3.2, 'Tiene un aguijón venenoso en la cabeza.', 35, 30, 'Su sentido del olfato es muy agudo.', 12, 14),"
					+ "(14, 'Kakuna', 0.6, 10.0, 'Apenas se mueve porque está evolucionando.', 25, 50, 'Su cáscara se calienta cuando va a evolucionar.', 12, 15),"
					+ "(15, 'Beedrill', 1.0, 29.5, 'Tiene tres aguijones venenosos.', 90, 40, 'Vuela a gran velocidad para atacar.', 12, NULL),"
					+ "(16, 'Pidgey', 0.3, 1.8, 'Es un Pokémon muy común y dócil.', 45, 40, 'Lanza arena con las alas para defenderse.', 10, 17),"
					+ "(17, 'Pidgeotto', 1.1, 30.0, 'Tiene garras muy fuertes para capturar presas.', 60, 55, 'Vuela en círculos sobre su territorio.', 10, 18),"
					+ "(18, 'Pidgeot', 1.5, 39.5, 'Vuela a una velocidad de Mach 2.', 80, 75, 'Sus músculos pectorales son potentísimos.', 10, NULL),"
					+ "(19, 'Rattata', 0.3, 3.5, 'Sus colmillos crecen sin parar.', 56, 35, 'Puede vivir en cualquier lugar y comer de todo.', 1, 20),"
					+ "(20, 'Raticate', 0.7, 18.5, 'Sus bigotes le ayudan a mantener el equilibrio.', 81, 60, 'Sus patas traseras están palmeadas para nadar.', 1, NULL),"
					+ "(21, 'Spearow', 0.3, 2.0, 'Es muy territorial y agresivo.', 60, 30, 'Emite un chillido que se oye a 1km.', 10, 22),"
					+ "(22, 'Fearow', 1.2, 38.0, 'Tiene un pico largo para capturar comida.', 90, 65, 'Puede volar durante todo un día sin descansar.', 10, NULL),"
					+ "(23, 'Ekans', 2.0, 6.9, 'Se enrosca para descansar.', 60, 44, 'Puede desencajar la mandíbula para comer.', 8, 24),"
					+ "(24, 'Arbok', 3.5, 65.0, 'El dibujo de su pecho intimida a los rivales.', 85, 69, 'Hay varios patrones diferentes de su dibujo.', 8, NULL),"
					+ "(25, 'Pikachu', 0.4, 6.0, 'Almacena electricidad en las mejillas.', 55, 40, 'Es la mascota oficial de la franquicia.', 5, 26),"
					+ "(26, 'Raichu', 0.8, 30.0, 'Su cola actúa como toma de tierra.', 90, 55, 'Puede soltar descargas de 100.000 voltios.', 5, NULL),"
					+ "(27, 'Sandshrew', 0.6, 12.0, 'Se hace una bola para protegerse.', 75, 85, 'Vive en madrigueras bajo tierra.', 9, 28),"
					+ "(28, 'Sandslash', 1.0, 29.5, 'Tiene púas duras en su espalda.', 100, 110, 'Se enrolla para rodar y atacar.', 9, NULL),"
					+ "(29, 'Nidoran', 0.4, 7.0, 'Tiene cuernos que segregan veneno.', 47, 52, 'Aunque es pequeña, sus cuernos son peligrosos.', 8, 30),"
					+ "(30, 'Nidorina', 0.8, 20.0, 'Prefiere no luchar, pero tiene ataques fuertes.', 62, 67, 'Cuando descansa, retrae sus púas.', 8, 31);";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO pokimon (id, nombre, altura, peso, descripcion, ataque, defensa, curiosidad, id_tipo, id_evolucion) VALUES"
					+ "(31, 'Nidoqueen', 1.3, 60.0, 'Su cuerpo está cubierto de escamas duras.', 92, 87, 'Protege a sus crías con su propia vida.', 8, NULL),"
					+ "(32, 'Nidoran-M', 0.5, 9.0, 'Mueve las orejas para vigilar su entorno.', 57, 40, 'Su cuerno es más grande que el de la hembra.', 8, 33),"
					+ "(33, 'Nidorino', 0.9, 19.5, 'Es muy fácil de enfadar.', 72, 57, 'Usa su cuerno para perforar rocas.', 8, 34),"
					+ "(34, 'Nidoking', 1.4, 62.0, 'Usa su cola para aplastar a sus oponentes.', 102, 77, 'Su piel es tan dura como el acero.', 8, NULL),"
					+ "(35, 'Clefairy', 0.6, 7.5, 'Es un Pokémon muy raro y mágico.', 45, 48, 'Dicen que vienen de la Luna.', 1, 36),"
					+ "(36, 'Clefable', 1.3, 40.0, 'Tiene un oído tan agudo que oye caer una aguja.', 70, 73, 'Camina dando saltitos como si flotara.', 1, NULL),"
					+ "(37, 'Vulpix', 0.6, 9.9, 'Nace con una sola cola blanca.', 41, 40, 'A medida que crece, su cola se divide en seis.', 2, 38),"
					+ "(38, 'Ninetales', 1.1, 19.9, 'Se dice que cada una de sus colas tiene poderes.', 76, 75, 'Puede vivir hasta mil años.', 2, NULL),"
					+ "(39, 'Jigglypuff', 0.5, 5.5, 'Canta una nana que duerme a cualquiera.', 45, 20, 'Sus ojos son grandes para hipnotizar.', 1, 40),"
					+ "(40, 'Wigglytuff', 1.0, 12.0, 'Su cuerpo es muy elástico y suave.', 70, 45, 'Si se enfada, se hincha enormemente.', 1, NULL),"
					+ "(41, 'Zubat', 0.8, 7.5, 'No tiene ojos, usa ultrasonidos.', 45, 35, 'Vive en cuevas oscuras durante el día.', 8, 42),"
					+ "(42, 'Golbat', 1.6, 55.0, 'Chupa la sangre de humanos y Pokémon.', 80, 70, 'Una vez que muerde, no suelta a su presa.', 8, NULL),"
					+ "(43, 'Oddish', 0.5, 5.4, 'Parece una planta que camina.', 50, 55, 'Se entierra de día para que no lo vean.', 4, 44),"
					+ "(44, 'Gloom', 0.8, 8.6, 'Desprende un olor fétido por su flor.', 65, 70, 'El olor es más fuerte si se siente en peligro.', 4, 45),"
					+ "(45, 'Vileplume', 1.2, 18.6, 'Tiene los pétalos más grandes del mundo.', 80, 85, 'Sus pétalos sueltan polen alérgico.', 4, NULL),"
					+ "(46, 'Paras', 0.3, 5.4, 'Tiene hongos parásitos en la espalda.', 70, 55, 'Los hongos crecen gracias a los nutrientes del huésped.', 12, 47),"
					+ "(47, 'Parasect', 1.0, 29.5, 'El hongo ha tomado el control del insecto.', 95, 80, 'Vive en lugares oscuros y húmedos.', 12, NULL),"
					+ "(48, 'Venonat', 1.0, 30.0, 'Sus ojos funcionan como radares.', 55, 50, 'Le atraen las luces en la noche.', 12, 49),"
					+ "(49, 'Venomoth', 1.5, 12.5, 'Suelta escamas de diferentes colores.', 65, 60, 'Las escamas de color oscuro son venenosas.', 12, NULL),"
					+ "(50, 'Diglett', 0.2, 0.8, 'Pasa casi todo el tiempo bajo tierra.', 55, 25, 'Su piel es muy fina y no aguanta la luz solar.', 9, 51),"
					+ "(51, 'Dugtrio', 0.7, 33.3, 'Son tres Diglett que siempre van juntos.', 80, 50, 'Pueden excavar hasta 100km de profundidad.', 9, NULL),"
					+ "(52, 'Meowth', 0.4, 4.2, 'Le encantan las cosas brillantes y las monedas.', 45, 35, 'Retrae sus garras para caminar en silencio.', 1, 53),"
					+ "(53, 'Persian', 1.0, 32.0, 'Es muy elegante pero muy temperamental.', 70, 60, 'Es muy difícil de domesticar.', 1, NULL),"
					+ "(54, 'Psyduck', 0.8, 19.6, 'Sufre de constantes dolores de cabeza.', 52, 48, 'Cuando el dolor es fuerte, usa poderes psíquicos.', 3, 55),"
					+ "(55, 'Golduck', 1.7, 76.6, 'Es un nadador experto.', 82, 78, 'A veces se le confunde con el monstruo Kappa.', 3, NULL),"
					+ "(56, 'Mankey', 0.5, 28.0, 'Se enfada con muchísima facilidad.', 80, 35, 'Vive en colonias en las copas de los árboles.', 7, 57),"
					+ "(57, 'Primeape', 1.0, 32.0, 'Siempre está enfadado por algo.', 105, 60, 'Solo deja de estar enfadado cuando duerme.', 7, NULL),"
					+ "(58, 'Growlithe', 0.7, 19.0, 'Es muy fiel y valiente.', 70, 45, 'Ladra a todo lo que le resulta extraño.', 2, 59),"
					+ "(59, 'Arcanine', 1.9, 155.0, 'Es un Pokémon legendario en muchas culturas.', 110, 80, 'Puede correr 10.000 km en un solo día.', 2, NULL),"
					+ "(60, 'Poliwag', 0.6, 12.4, 'Su piel es muy fina y húmeda.', 50, 40, 'El espiral de su vientre son sus intestinos.', 3, 61);";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO pokimon (id, nombre, altura, peso, descripcion, ataque, defensa, curiosidad, id_tipo, id_evolucion) VALUES"
					+ "(61, 'Poliwhirl', 1.0, 20.0, 'Puede vivir tanto en tierra como en agua.', 65, 65, 'Suda para mantener su piel pegajosa.', 3, 62),"
					+ "(62, 'Poliwrath', 1.3, 54.0, 'Es un nadador fortísimo y luchador.', 95, 95, 'Puede cruzar el océano nadando.', 3, NULL),"
					+ "(63, 'Abra', 0.9, 19.5, 'Duerme 18 horas al día.', 20, 15, 'Usa Teletransporte incluso mientras duerme.', 11, 64),"
					+ "(64, 'Kadabra', 1.3, 56.5, 'Emite ondas alfa que rompen aparatos.', 35, 30, 'Siempre lleva una cuchara de plata.', 11, 65),"
					+ "(65, 'Alakazam', 1.5, 48.0, 'Su cerebro nunca deja de crecer.', 50, 45, 'Tiene un cociente intelectual de 5000.', 11, NULL),"
					+ "(66, 'Machop', 0.8, 19.5, 'Sus músculos nunca se cansan.', 80, 50, 'Puede levantar a un Sumo con facilidad.', 7, 67),"
					+ "(67, 'Machoke', 1.5, 70.5, 'Lleva un cinturón para controlar su fuerza.', 100, 70, 'Es tan fuerte que ayuda en mudanzas.', 7, 68),"
					+ "(68, 'Machamp', 1.6, 130.0, 'Tiene cuatro brazos que reaccionan solos.', 130, 80, 'Puede lanzar 1000 puñetazos en 2 segundos.', 7, NULL),"
					+ "(69, 'Bellsprout', 0.7, 4.0, 'Su cuerpo es delgado y flexible.', 75, 35, 'Come insectos para obtener nutrientes.', 4, 70),"
					+ "(70, 'Weepinbell', 1.0, 6.4, 'Escupe un ácido que lo derrite todo.', 90, 50, 'Se cuelga de los árboles para dormir.', 4, 71),"
					+ "(71, 'Victreebel', 1.7, 15.5, 'Atrae a sus presas con un aroma dulce.', 105, 65, 'Vive en colonias en selvas profundas.', 4, NULL),"
					+ "(72, 'Tentacool', 0.9, 45.5, 'Su cuerpo es un 99% agua.', 40, 35, 'Tiene dos tentáculos con veneno.', 3, 73),"
					+ "(73, 'Tentacruel', 1.6, 55.0, 'Tiene 80 tentáculos retráctiles.', 70, 65, 'Se le conoce como el gánster del mar.', 3, NULL),"
					+ "(74, 'Geodude', 0.4, 20.0, 'Parece una roca común.', 80, 100, 'Se enfada si lo pisas sin querer.', 13, 75),"
					+ "(75, 'Graveler', 1.0, 105.0, 'Baja por las montañas rodando.', 95, 115, 'Come rocas para crecer.', 13, 76),"
					+ "(76, 'Golem', 1.4, 300.0, 'Su cuerpo es como una armadura de roca.', 120, 130, 'Ni las explosiones le hacen daño.', 13, NULL),"
					+ "(77, 'Ponyta', 1.0, 30.0, 'Sus patas son muy resistentes.', 85, 55, 'Al nacer apenas puede mantenerse en pie.', 2, 78),"
					+ "(78, 'Rapidash', 1.7, 95.0, 'Le encanta correr por los campos.', 100, 70, 'Sus llamas crecen cuando corre rápido.', 2, NULL),"
					+ "(79, 'Slowpoke', 1.2, 36.0, 'Es increíblemente lento de reflejos.', 65, 65, 'Tarda 5 minutos en sentir dolor.', 3, 80),"
					+ "(80, 'Slowbro', 1.6, 78.5, 'Un Shellder le ha mordido la cola.', 75, 110, 'Si el Shellder se suelta, volverá a ser Slowpoke.', 3, NULL),"
					+ "(81, 'Magnemite', 0.3, 6.0, 'Flota usando magnetismo.', 35, 70, 'Se siente atraído por la electricidad.', 5, 82),"
					+ "(82, 'Magneton', 1.0, 60.0, 'Son tres Magnemite unidos.', 60, 95, 'Genera potentes ondas magnéticas.', 5, NULL),"
					+ "(83, 'Farfetch`d', 0.8, 15.0, 'Siempre lleva un puerro consigo.', 90, 55, 'Usa el puerro como espada y comida.', 1, NULL),"
					+ "(84, 'Doduo', 1.4, 39.2, 'Tiene dos cabezas con cerebros idénticos.', 85, 45, 'Corre a 100km/h.', 10, 85),"
					+ "(85, 'Dodrio', 1.8, 85.2, 'Sus tres cabezas representan alegría, tristeza e ira.', 110, 70, 'Cada cabeza tiene su propio cerebro.', 10, NULL),"
					+ "(86, 'Seel', 1.1, 90.0, 'Le encanta vivir en icebergs.', 45, 55, 'Su cuerno puede romper hielo grueso.', 3, 87),"
					+ "(87, 'Dewgong', 1.7, 120.0, 'Duerme en el fondo del mar.', 70, 80, 'Su cuerpo blanco le ayuda a camuflarse.', 3, NULL),"
					+ "(88, 'Grimer', 0.9, 30.0, 'Nació del lodo contaminado.', 80, 50, 'Donde pasa, no vuelve a crecer hierba.', 8, 89),"
					+ "(89, 'Muk', 1.2, 30.0, 'Es tan tóxico que una gota contamina un lago.', 105, 75, 'Huele tan mal que desmaya a la gente.', 8, NULL),"
					+ "(90, 'Shellder', 0.3, 4.0, 'Su concha es más dura que el diamante.', 65, 100, 'Expulsa arena para atacar.', 3, 91);";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO pokimon (id, nombre, altura, peso, descripcion, ataque, defensa, curiosidad, id_tipo, id_evolucion) VALUES"
					+ "(91, 'Cloyster', 1.5, 132.5, 'Solo abre su concha para atacar.', 95, 180, 'Lanza púas muy fuertes.', 3, NULL),"
					+ "(92, 'Gastly', 1.3, 0.1, 'Su cuerpo es un 95% de gas.', 35, 30, 'Puede envolver a un elefante y dormirlo.', 14, 93),"
					+ "(93, 'Haunter', 1.6, 0.1, 'Le gusta esconderse en las paredes.', 50, 45, 'Su lengua está hecha de gas lamiendo.', 14, 94),"
					+ "(94, 'Gengar', 1.5, 40.5, 'Se esconde en las sombras de la gente.', 65, 60, 'Baja la temperatura a su alrededor.', 14, NULL),"
					+ "(95, 'Onix', 8.8, 210.0, 'Excava túneles a 80km/h.', 45, 160, 'Su cuerpo se vuelve más duro con la edad.', 13, NULL),"
					+ "(96, 'Drowzee', 1.0, 32.4, 'Come los sueños de la gente.', 48, 45, 'Recuerda todos los sueños que come.', 11, 97),"
					+ "(97, 'Hypno', 1.6, 75.6, 'Lleva un péndulo para hipnotizar.', 73, 70, 'Nunca mires su péndulo directamente.', 11, NULL),"
					+ "(98, 'Krabby', 0.4, 6.5, 'Vive en agujeros en la playa.', 105, 90, 'Si pierde una pinza, le vuelve a crecer.', 3, 99),"
					+ "(99, 'Kingler', 1.3, 60.0, 'Su pinza izquierda es gigantesca.', 130, 115, 'Su pinza tiene 10.000 caballos de fuerza.', 3, NULL),"
					+ "(100, 'Voltorb', 0.5, 10.4, 'Se parece a una Poké Ball.', 30, 50, 'Explota al menor contacto.', 5, 101),"
					+ "(101, 'Electrode', 1.2, 66.6, 'Se alimenta de la electricidad del aire.', 50, 70, 'Es el Pokémon más rápido del juego original.', 5, NULL),"
					+ "(102, 'Exeggcute', 0.4, 2.5, 'Parecen huevos pero son semillas.', 40, 80, 'Se comunican por telepatía.', 4, 103),"
					+ "(103, 'Exeggutor', 2.0, 120.0, 'Cada cabeza piensa de forma distinta.', 95, 85, 'Si una cabeza cae, se convierte en Exeggcute.', 4, NULL),"
					+ "(104, 'Cubone', 0.4, 6.5, 'Lleva el cráneo de su madre muerta.', 50, 95, 'Nadie le ha visto la cara nunca.', 9, 105),"
					+ "(105, 'Marowak', 1.0, 45.0, 'Ha superado su tristeza y es más fuerte.', 80, 110, 'Usa huesos como bumeranes.', 9, NULL),"
					+ "(106, 'Hitmonlee', 1.5, 49.8, 'Sus piernas se estiran como muelles.', 120, 53, 'Se le conoce como el \"Maestro de las patadas\".', 7, NULL),"
					+ "(107, 'Hitmonchan', 1.4, 50.2, 'Lanza puñetazos invisibles.', 105, 79, 'Puede golpear a través del cemento.', 7, NULL),"
					+ "(108, 'Lickitung', 1.2, 65.5, 'Su lengua mide más de 2 metros.', 55, 75, 'Lame todo para reconocerlo.', 1, NULL),"
					+ "(109, 'Koffing', 0.6, 1.0, 'Su cuerpo está lleno de gases tóxicos.', 65, 95, 'A veces explota sin previo aviso.', 8, 110),"
					+ "(110, 'Weezing', 1.2, 9.5, 'Dos Koffing se han fusionado.', 90, 120, 'Vive en lugares muy contaminados.', 8, NULL),"
					+ "(111, 'Rhyhorn', 1.0, 115.0, 'Sus huesos son 1000 veces más duros.', 85, 95, 'Es muy fuerte pero poco inteligente.', 9, 112),"
					+ "(112, 'Rhydon', 1.9, 120.0, 'Su cuerno puede taladrar diamantes.', 130, 120, 'Fue el primer Pokémon diseñado por Game Freak.', 9, NULL),"
					+ "(113, 'Chansey', 1.1, 34.6, 'Pone huevos muy nutritivos.', 5, 5, 'Trae felicidad a quien la captura.', 1, NULL),"
					+ "(114, 'Tangela', 1.0, 35.0, 'Está cubierto de lianas azules.', 55, 115, 'Sus lianas no dejan de moverse.', 4, NULL),"
					+ "(115, 'Kangaskhan', 2.2, 80.0, 'Lleva a su cría en una bolsa ventral.', 95, 80, 'Es muy protectora con su bebé.', 1, NULL),"
					+ "(116, 'Horsea', 0.4, 8.0, 'Nada con gran destreza.', 40, 70, 'Lanza tinta para escapar de enemigos.', 3, 117),"
					+ "(117, 'Seadra', 1.2, 25.0, 'Sus aletas son venenosas.', 65, 95, 'Duerme enganchado al coral.', 3, NULL),"
					+ "(118, 'Goldeen', 0.6, 15.0, 'Es muy elegante al nadar.', 67, 60, 'Se le conoce como la reina del agua.', 3, 119),"
					+ "(119, 'Seaking', 1.3, 39.0, 'Hace nidos en las rocas de los ríos.', 92, 65, 'En otoño se vuelve más rojizo.', 3, NULL),"
					+ "(120, 'Staryu', 0.8, 34.5, 'Su cuerpo se regenera si pierde una parte.', 45, 55, 'Brilla de noche como las estrellas.', 3, 121);";
			sentencia.executeUpdate(sql);
			sql="INSERT INTO pokimon (id, nombre, altura, peso, descripcion, ataque, defensa, curiosidad, id_tipo, id_evolucion) VALUES"
					+ "(121, 'Starmie', 1.1, 80.0, 'Su núcleo brilla con siete colores.', 75, 85, 'Muchos creen que viene del espacio.', 3, NULL),"
					+ "(122, 'Mr. Mime', 1.3, 54.5, 'Es un maestro del mimo.', 45, 65, 'Crea paredes invisibles con sus manos.', 11, NULL),"
					+ "(123, 'Scyther', 1.5, 56.0, 'Es increíblemente rápido con sus guadañas.', 110, 80, 'Sus alas son tan rápidas que ni se ven.', 12, NULL),"
					+ "(124, 'Jynx', 1.4, 40.6, 'Mueve las caderas al caminar.', 50, 35, 'Habla un lenguaje similar al humano.', 6, NULL),"
					+ "(125, 'Electabuzz', 1.1, 30.0, 'Le encanta comer electricidad.', 83, 57, 'Suele vivir cerca de centrales eléctricas.', 5, NULL),"
					+ "(126, 'Magmar', 1.3, 44.5, 'Nace en volcanes activos.', 95, 57, 'Su cuerpo siempre está ardiendo.', 2, NULL),"
					+ "(127, 'Pinsir', 1.5, 55.0, 'Agarra a sus presas con sus cuernos.', 125, 100, 'Si no puede romper algo, lo lanza lejos.', 12, NULL),"
					+ "(128, 'Tauros', 1.4, 88.4, 'Es un Pokémon muy violento.', 100, 95, 'Se azota a sí mismo con sus colas.', 1, NULL),"
					+ "(129, 'Magikarp', 0.9, 10.0, 'Es el Pokémon más débil del mundo.', 10, 55, 'Apenas puede saltar más de 2 metros.', 3, 130),"
					+ "(130, 'Gyarados', 6.5, 235.0, 'Es extremadamente agresivo.', 125, 79, 'Puede destruir ciudades enteras.', 3, NULL),"
					+ "(131, 'Lapras', 2.5, 220.0, 'Es muy inteligente y bondadoso.', 85, 80, 'Le encanta llevar gente sobre su lomo.', 3, NULL),"
					+ "(132, 'Ditto', 0.3, 4.0, 'Puede transformarse en cualquier cosa.', 48, 48, 'Si se ríe, pierde su transformación.', 1, NULL),"
					+ "(133, 'Eevee', 0.3, 6.5, 'Tiene un código genético inestable.', 55, 50, 'Puede evolucionar de muchas formas.', 1, NULL),"
					+ "(134, 'Vaporeon', 1.0, 29.0, 'Su cuerpo es similar al agua.', 65, 60, 'Puede volverse invisible en el agua.', 3, NULL),"
					+ "(135, 'Jolteon', 0.8, 24.5, 'Sus pelos son como agujas cargadas.', 65, 60, 'Se eriza cuando se enfada.', 5, NULL),"
					+ "(136, 'Flareon', 0.9, 25.0, 'Su temperatura corporal es muy alta.', 130, 60, 'Almacena fuego en su cuerpo.', 2, NULL),"
					+ "(137, 'Porygon', 0.8, 36.5, 'Es un Pokémon creado por código.', 60, 70, 'Puede vivir dentro de los ordenadores.', 1, NULL),"
					+ "(138, 'Omanyte', 0.4, 7.5, 'Es un Pokémon fósil ya extinguido.', 40, 100, 'Usaba sus tentáculos para nadar.', 13, 139),"
					+ "(139, 'Omastar', 1.0, 35.0, 'Su concha era demasiado pesada.', 60, 125, 'Se extinguió porque no podía moverse rápido.', 13, NULL),"
					+ "(140, 'Kabuto', 0.5, 11.5, 'Se protege con un caparazón duro.', 80, 90, 'Tiene ojos en la espalda también.', 13, 141),"
					+ "(141, 'Kabutops', 1.3, 40.5, 'Es un nadador rapidísimo.', 115, 105, 'Sus brazos son cuchillas afiladas.', 13, NULL),"
					+ "(142, 'Aerodactyl', 1.8, 59.0, 'El rey de los cielos prehistóricos.', 105, 65, 'Sus colmillos son como sierras.', 13, NULL),"
					+ "(143, 'Snorlax', 2.1, 460.0, 'Solo se despierta para comer.', 110, 65, 'Puede comer comida podrida sin problemas.', 1, NULL),"
					+ "(144, 'Articuno', 1.7, 55.4, 'Ave legendaria del hielo.', 85, 100, 'Se dice que aparece a los montañeros perdidos.', 6, NULL),"
					+ "(145, 'Zapdos', 1.6, 52.6, 'Ave legendaria eléctrica.', 90, 85, 'Vive en nubes de tormenta.', 5, NULL),"
					+ "(146, 'Moltres', 2.0, 60.0, 'Ave legendaria de fuego.', 100, 90, 'Sus llamas curan sus propias heridas.', 2, NULL),"
					+ "(147, 'Dratini', 1.8, 3.3, 'Es un Pokémon dragón muy raro.', 64, 45, 'Muda de piel constantemente al crecer.', 15, 148),"
					+ "(148, 'Dragonair', 4.0, 16.5, 'Controla el clima a su voluntad.', 84, 65, 'Sus esferas brillan cuando cambia el tiempo.', 15, 149),"
					+ "(149, 'Dragonite', 2.2, 210.0, 'Es muy inteligente y salva a náufragos.', 134, 95, 'Puede dar la vuelta al mundo en 16 horas.', 15, NULL),"
					+ "(150, 'Mewtwo', 2.0, 122.0, 'Creado por manipulación genética.', 110, 90, 'Es considerado el Pokémon más poderoso de Kanto.', 11, NULL),"
					+ "(151, 'Mew', 0.4, 4.0, 'Contiene el ADN de todos los Pokémon.', 100, 100, 'Solo se aparece a personas de corazón puro.', 11, NULL);";
			sentencia.executeUpdate(sql);
			sql="SET FOREIGN_KEY_CHECKS = 1;";
			sentencia.executeUpdate(sql);
		} catch (SQLException f) {
			f.printStackTrace();
		}
		
		tabbedPane.addChangeListener(this);
		
		btnBuscar.addActionListener(this);
		btnAleatorio.addActionListener(this);
		btnCuriosidad.addActionListener(this);
		btnAñadirAFavoritos.addActionListener(this);
		btnVerEvolucion.addActionListener(this);
		btnCombate.addActionListener(this);
		btnPrimero.addActionListener(this);
		btnAnterior.addActionListener(this);
		btnSiguiente.addActionListener(this);
		btnUltimo.addActionListener(this);
		btnCuriosidad_1.addActionListener(this);
		btnEliminarDeFavoritos.addActionListener(this);
		btnExportarFavoritos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boton=(JButton)e.getSource();
		
		if(boton.getText().equals("Buscar")) {
			if(campoTextoNombreBuscar.getText().isBlank() && campoTextoIDBuscar.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
			} else {
				sql="SELECT * FROM pokimon WHERE nombre LIKE '"+campoTextoNombreBuscar.getText()
				+"' OR id LIKE '"+Integer.parseInt(campoTextoIDBuscar.getText())+"'";
				try {
					String nombreABuscar = null, idABuscar = null;
					rs=sentencia.executeQuery(sql);
					rs.first();
					etiquetaNombre.setText(rs.getString("nombre"));
					etiquetaID.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion.setText(rs.getString("descripcion"));
					
					if(campoTextoNombreBuscar.getText().isBlank()) {
						nombreABuscar=rs.getString("nombre");
					}
					
					idABuscar=String.valueOf(rs.getInt("id"));
					rutaImagen="/imagenes/Regular/"+idABuscar+" "+nombreABuscar+".png";
					etiquetaImagen.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				} catch (SQLException f) {
					f.printStackTrace();
				}
			}
		}
		
		if(boton.getText().equals("Aleatorio")) {
			Random r=new Random();
			String idRandom=String.valueOf(r.nextInt(152));
			if(idRandom=="0") {
				idRandom="1";
			}
			sql="SELECT * FROM pokimon WHERE id LIKE '"+idRandom+"'";
			try {
				rs=sentencia.executeQuery(sql);
				rs.first();
				etiquetaNombre.setText(rs.getString("nombre"));
				etiquetaID.setText(String.valueOf(rs.getInt("id")));
				campoTextoAltura.setText(String.valueOf(rs.getDouble("altura")));
				campoTextoPeso.setText(String.valueOf(rs.getDouble("peso")));
				campoTextoDescripcion.setText(rs.getString("descripcion"));
				rutaImagen="/imagenes/Regular/"+idRandom+" "+rs.getString("nombre")+".png";
				etiquetaImagen.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
			} catch (SQLException f) {
				f.printStackTrace();
			}
			
		}
		
		if(boton.getText().equals("Curiosidad")) {
			if (boton.equals(btnCuriosidad)) {
				if(etiquetaNombre.getText().equals("Nombre")) {
					JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
				} else {
					sql="SELECT curiosidad FROM pokimon WHERE id LIKE "+etiquetaID.getText();
					try {
						rs=sentencia.executeQuery(sql);
						rs.first();
						JOptionPane.showMessageDialog(null,rs.getString("curiosidad"),"Curiosidad",JOptionPane.PLAIN_MESSAGE);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				if (boton.equals(btnCuriosidad_1)) {
					if(etiquetaNombre_1.getText().equals("Nombre")) {
						JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
					} else {
						sql="SELECT curiosidad FROM pokimon WHERE id LIKE "+etiquetaID_1.getText();
						try {
							rs=sentencia.executeQuery(sql);
							rs.first();
							JOptionPane.showMessageDialog(null,rs.getString("curiosidad"),"Curiosidad",JOptionPane.PLAIN_MESSAGE);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
		
		if(boton.getText().equals("Añadir a Favoritos")) {
			if(etiquetaNombre.getText().equals("Nombre")) {
				JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
			} else {
				sql="INSERT INTO favoritos VALUES("+etiquetaID.getText()+", DEFAULT)";
				try {
					sentencia.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Pokémon agregado con éxito","Alerta",JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(boton.getText().equals("Ver evolución")) {
				if(etiquetaNombre.getText().equals("Nombre")) {
					JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
				} else {
					sql="SELECT * FROM pokimon WHERE id LIKE '"+etiquetaID.getText()+"'";
					try {
						rs=sentencia.executeQuery(sql);
						rs.first();
						if(rs.getInt("id_evolucion")==0) {
							JOptionPane.showMessageDialog(null,"Este pokémon no tiene evolución!","Alerta",JOptionPane.PLAIN_MESSAGE);
						} else {
							sql="SELECT * FROM pokimon WHERE id LIKE '"+String.valueOf(rs.getInt("id_evolucion"))+"'";
							rs=sentencia.executeQuery(sql);
							rs.first();
							etiquetaNombre.setText(rs.getString("nombre"));
							etiquetaID.setText(String.valueOf(rs.getInt("id")));
							campoTextoAltura.setText(String.valueOf(rs.getDouble("altura")));
							campoTextoPeso.setText(String.valueOf(rs.getDouble("peso")));
							campoTextoDescripcion.setText(rs.getString("descripcion"));
							rutaImagen="/imagenes/Regular/"+String.valueOf(rs.getInt("id"))+" "+rs.getString("nombre")+".png";
							etiquetaImagen.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
						}
					} catch (SQLException f) {
						f.printStackTrace();
					}
				}
		}
		
		if(boton.getText().equals("Combate")) {
			if(etiquetaNombre.getText().equals("Nombre")) {
				JOptionPane.showMessageDialog(null, "No tienes un pokémon seleccionado", "Alerta", JOptionPane.PLAIN_MESSAGE);
			} else {
				tabbedPane.setSelectedIndex(2);
			
			}
		}
		
		if(boton.getText().equals("<<")) {
			sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
			try {
				sentencia=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				rs=sentencia.executeQuery(sql);
				if(rs.absolute(1)) {
					campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
					etiquetaNombre_1.setText(rs.getString("nombre"));
					etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion_1.setText(rs.getString("descripcion"));
					rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
					etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				} else {
					JOptionPane.showMessageDialog(null,"No hay más pokemones!","Alerta",JOptionPane.PLAIN_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(boton.getText().equals("<")) {
			sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
			try {
				rs=sentencia.executeQuery(sql);
				if(rs.absolute(Integer.parseInt(campoTextoIDFavorito.getText())-1)) {
					campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
					etiquetaNombre_1.setText(rs.getString("nombre"));
					etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion_1.setText(rs.getString("descripcion"));
					rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
					etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				} else {
					JOptionPane.showMessageDialog(null,"No hay más pokemones!","Alerta",JOptionPane.PLAIN_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(boton.getText().equals(">")) {
			try {
				rs=sentencia.executeQuery(sql);
				if (rs.absolute(Integer.parseInt(campoTextoIDFavorito.getText())+1)) {
					campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
					etiquetaNombre_1.setText(rs.getString("nombre"));
					etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion_1.setText(rs.getString("descripcion"));
					rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
					etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				} else {
					JOptionPane.showMessageDialog(null,"No hay más pokemones!","Alerta",JOptionPane.PLAIN_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(boton.getText().equals(">>")) {
			sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
			try {
				rs=sentencia.executeQuery(sql);
				if(rs.absolute(-1)) {
					campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
					etiquetaNombre_1.setText(rs.getString("nombre"));
					etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion_1.setText(rs.getString("descripcion"));
					rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
					etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				} else {
					JOptionPane.showMessageDialog(null,"No hay más pokemones!","Alerta",JOptionPane.PLAIN_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if(boton.getText().equals("Eliminar de Favoritos")) {
			Object[] opciones = { "Sí", "No"};
			int eleccion = JOptionPane.showOptionDialog(null, "¿Quieres eliminar este pokémon de tus Favoritos?", 
					"Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[1]);
			if(eleccion==JOptionPane.YES_OPTION) {
				sql="DELETE FROM favoritos WHERE id_pokimon LIKE "+etiquetaID_1.getText();
				try {
					sentencia.executeUpdate(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Cambios guardados", "Alerta", JOptionPane.PLAIN_MESSAGE);
				sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
				try {
					sentencia=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					rs=sentencia.executeQuery(sql);
					if(rs.absolute(Integer.parseInt(campoTextoIDFavorito.getText())-1)) {
						campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
						etiquetaNombre_1.setText(rs.getString("nombre"));
						etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
						campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
						campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
						campoTextoDescripcion_1.setText(rs.getString("descripcion"));
						rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
						etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(boton.getText().equals("Exportar favoritos")) {
			String desktopPath = System.getProperty("user.home") + "/Desktop";
			String appFolder = desktopPath + "/favoritosPokimon";
			String rutaFavoritos = appFolder + "/archivo.txt";

			// Create your app folder
			File folder = new File(appFolder);
			if (!folder.exists()) {
			    folder.mkdirs();
			}
			
			sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
			try {
				rs=sentencia.executeQuery(sql);
				
			    //Define el f_writer
				try {
					f_writer = new FileWriter(rutaFavoritos);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				while(rs.next()) {
					String s =String.valueOf(rs.getRow())+" "
							+rs.getString("nombre")
							+": ID="+String.valueOf(rs.getInt("id"))
							+", Altura="+String.valueOf(rs.getDouble("altura"))
							+", Peso="+String.valueOf(rs.getDouble("peso"))
							+", Ataque="+String.valueOf(rs.getInt("ataque"))
							+", Defensa="+String.valueOf(rs.getInt("defensa"))
							+"\n";
					
					//Escribe en el archivo
					try {
						f_writer.write(s);
			        } catch (IOException f) {
			            System.out.print(f.getMessage());
			        }
				}
				
				//Cierra f_writer
				try {
					f_writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Archivo creado. Revisa tu escritorio!","Alerta",JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		//p
		pestaña=(JTabbedPane) e.getSource();
		if(pestaña.getSelectedIndex()==1){
			sql="SELECT * FROM pokimon WHERE id IN (SELECT id_pokimon FROM favoritos)";
			try {
				rs=sentencia.executeQuery(sql);
				rs.first();
				if (rs.first()==false) {
					JOptionPane.showMessageDialog(null,"No hay favoritos agregados!","Alerta",JOptionPane.PLAIN_MESSAGE);
					btnPrimero.setEnabled(false);
					btnAnterior.setEnabled(false);
					btnSiguiente.setEnabled(false);
					btnUltimo.setEnabled(false);
					btnCuriosidad_1.setEnabled(false);
					btnEliminarDeFavoritos.setEnabled(false);
					btnExportarFavoritos.setEnabled(false);
				} else {
					btnPrimero.setEnabled(true);
					btnAnterior.setEnabled(true);
					btnSiguiente.setEnabled(true);
					btnUltimo.setEnabled(true);
					btnCuriosidad_1.setEnabled(true);
					btnEliminarDeFavoritos.setEnabled(true);
					btnExportarFavoritos.setEnabled(true);
					campoTextoIDFavorito.setText(String.valueOf(rs.getRow()));
					etiquetaNombre_1.setText(rs.getString("nombre"));
					etiquetaID_1.setText(String.valueOf(rs.getInt("id")));
					campoTextoAltura_1.setText(String.valueOf(rs.getDouble("altura")));
					campoTextoPeso_1.setText(String.valueOf(rs.getDouble("peso")));
					campoTextoDescripcion_1.setText(rs.getString("descripcion"));
					rutaImagen="/imagenes/Regular/"+rs.getInt("id")+" "+rs.getString("nombre")+".png";
					etiquetaImagen_1.setIcon(new ImageIcon(Gui.class.getResource(rutaImagen)));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}
	}
}
