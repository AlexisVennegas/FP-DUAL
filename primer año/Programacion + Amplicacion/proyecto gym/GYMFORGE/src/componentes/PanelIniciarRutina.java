package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Usuario;

public class PanelIniciarRutina extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelIniciarRutina(Usuario usuario) {
		

        JLabel bienvenidaLabel = new JLabel("¡Hola, " + usuario.getNombre() + "! " + " a entrenar");
        bienvenidaLabel.setForeground(new Color(255, 255, 255));
        bienvenidaLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        bienvenidaLabel.setBounds(25, 10, 561, 40); 
        add(bienvenidaLabel);
	}
}
