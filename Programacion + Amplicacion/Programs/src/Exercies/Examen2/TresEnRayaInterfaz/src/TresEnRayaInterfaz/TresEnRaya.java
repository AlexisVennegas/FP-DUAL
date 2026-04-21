package TresEnRayaInterfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane; // Añadido para los mensajes de victoria/empate

public class TresEnRaya {

	private JFrame frame;

	// 1. SACAMOS LOS BOTONES AQUÍ ARRIBA para que todo el código los pueda ver
	private JButton btn00, btn01, btn02;
	private JButton btn10, btn11, btn12;
	private JButton btn20, btn21, btn22;

	// 2. VARIABLES DEL JUEGO
	private boolean turnoX = true; // true = X, false = O
	private int movimientos = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya window = new TresEnRaya();
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
	public TresEnRaya() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(3, 3, 0, 0));

		// 3. INICIALIZAMOS LOS BOTONES Y AÑADIMOS LA LÓGICA AL HACER CLIC
		btn00 = new JButton("");
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn00);
			}
		});
		btn00.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn00);

		btn01 = new JButton("");
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn01);
			}
		});
		btn01.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn01);

		btn02 = new JButton("");
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn02);
			}
		});
		btn02.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn02);

		btn10 = new JButton("");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn10);
			}
		});
		btn10.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn10);

		btn11 = new JButton("");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn11);
			}
		});
		btn11.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn11);

		btn12 = new JButton("");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn12);
			}
		});
		btn12.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn12);

		btn20 = new JButton("");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn20);
			}
		});
		btn20.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn20);

		btn21 = new JButton("");
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn21);
			}
		});
		btn21.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn21);

		btn22 = new JButton("");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesarJugada(btn22);
			}
		});
		btn22.setFont(new Font("Arial", Font.BOLD, 50));
		frame.getContentPane().add(btn22);
	}

	private void procesarJugada(JButton boton) {
		if (!boton.getText().equals("")) {
			return;
		}

		if (turnoX) {
			boton.setText("X");
		} else {
			boton.setText("O");
		}

		movimientos++;

		if (comprobarGanador()) {

			String ganador;

			if (turnoX == true) {
				ganador = "X";
			} else {
				ganador = "O";
			}

			JOptionPane.showMessageDialog(frame, "¡Ha ganado la " + ganador + "!");
			reiniciarJuego();

		} else if (movimientos == 9) {
			JOptionPane.showMessageDialog(frame, "¡Empate!");
			reiniciarJuego();
		} else {
			turnoX = !turnoX; // Cambiamos el turno
		}
	}

	// Comprobar linea
	private boolean comprobarLinea(JButton b1, JButton b2, JButton b3) {
		if (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())) {
			return true;
		}
		return false;
	}

	private boolean comprobarGanador() {
		// Filas
		if (comprobarLinea(btn00, btn01, btn02))
			return true;
		if (comprobarLinea(btn10, btn11, btn12))
			return true;
		if (comprobarLinea(btn20, btn21, btn22))
			return true;
		// Columnas
		if (comprobarLinea(btn00, btn10, btn20))
			return true;
		if (comprobarLinea(btn01, btn11, btn21))
			return true;
		if (comprobarLinea(btn02, btn12, btn22))
			return true;
		// Diagonales
		if (comprobarLinea(btn00, btn11, btn22))
			return true;
		if (comprobarLinea(btn02, btn11, btn20))
			return true;

		return false;
	}

	// Reiniciar el tablero
	private void reiniciarJuego() {
		turnoX = true;
		movimientos = 0;
		btn00.setText("");
		btn01.setText("");
		btn02.setText("");
		btn10.setText("");
		btn11.setText("");
		btn12.setText("");
		btn20.setText("");
		btn21.setText("");
		btn22.setText("");
	}
}