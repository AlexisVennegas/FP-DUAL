package componentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo.Usuario;

public class ChatIA extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextArea areaRespuesta;
    private JTextField inputUsuario;
    private JButton btnEnviar;

    public ChatIA() {
        // Configuración del panel contenedor (el que irá dentro de PanelHome)
        setBackground(new Color(26, 26, 38));
        setLayout(null);
        setPreferredSize(new Dimension(267, 240));

        // Título estilizado
        JLabel lblIA = new JLabel("Asistente AI");
        lblIA.setForeground(new Color(155, 89, 182)); // Púrpura IA
        lblIA.setFont(new Font("Arial", Font.BOLD, 14));
        lblIA.setBounds(10, 5, 200, 20);
        add(lblIA);

        // Área de respuesta (Scrollable)
        areaRespuesta = new JTextArea("¡Hola! ¿En qué puedo ayudarte hoy?");
        areaRespuesta.setEditable(false);
        areaRespuesta.setLineWrap(true);
        areaRespuesta.setWrapStyleWord(true);
        areaRespuesta.setBackground(new Color(35, 37, 58));
        areaRespuesta.setForeground(Color.WHITE);
        areaRespuesta.setFont(new Font("Arial", Font.PLAIN, 11));
        areaRespuesta.setBorder(new EmptyBorder(5, 5, 5, 5));

        JScrollPane scrollRespuesta = new JScrollPane(areaRespuesta);
        scrollRespuesta.setBounds(10, 30, 247, 150);
        scrollRespuesta.setBorder(null);
        add(scrollRespuesta);

        // Campo de texto para el usuario
        inputUsuario = new JTextField();
        inputUsuario.setBounds(10, 190, 180, 35);
        inputUsuario.setBackground(new Color(45, 45, 65));
        inputUsuario.setForeground(Color.WHITE);
        inputUsuario.setCaretColor(Color.WHITE);
        inputUsuario.setBorder(new EmptyBorder(5, 10, 5, 10));
        add(inputUsuario);

        // Botón de envío
        btnEnviar = new JButton(">");
        btnEnviar.setBounds(200, 190, 57, 35);
        btnEnviar.setBackground(new Color(155, 89, 182));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEnviar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        add(btnEnviar);
    }

    // Método para obtener el texto que escribió el usuario
    public String getMensajeUsuario() {
        return inputUsuario.getText().trim();
    }

    // Método para limpiar el input después de enviar
    public void limpiarInput() {
        inputUsuario.setText("");
    }

    // Método para mostrar la respuesta de la IA
    public void setRespuestaIA(String texto) {
        areaRespuesta.setText(texto);
    }

    // Método para exponer el botón y añadirle el listener desde el PanelHome o un Controller
    public JButton getBtnEnviar() {
        return btnEnviar;
    }
}