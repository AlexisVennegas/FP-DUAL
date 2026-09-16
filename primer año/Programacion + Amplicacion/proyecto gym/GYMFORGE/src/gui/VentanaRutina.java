package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import modelo.Ejercicio;
import modelo.Rutina;
import modelo.Usuario;
import servicio.ServicioEjercicio;
import servicio.ServicioRutinas;

public class VentanaRutina {

    private JFrame frame;
    private Usuario usuario;
    private JTextField nameRutinaInput;
    private ServicioEjercicio servicioEjercicio = new ServicioEjercicio();
    private ServicioRutinas servicioRutinas = new ServicioRutinas();
    private List<Ejercicio> ejerciciosSeleccionados = new java.util.ArrayList<>();
    private JPanel listaEjerciciosPanel; // Panel que contendrá las cards

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaRutina window = new VentanaRutina(null);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaRutina(Usuario usuario) {
        this.usuario = usuario;
        initialize();
        cargarEjerciciosEnPanel(); // Cargamos los ejercicios al iniciar
    }

    private void cargarEjerciciosEnPanel() {
        // Obtenemos ejercicios de la BD
        List<Ejercicio> lista = servicioEjercicio.mostrarEjercicios();
        
        for (Ejercicio ej : lista) {
            listaEjerciciosPanel.add(crearCardEjercicio(ej));
            listaEjerciciosPanel.add(Box.createRigidArea(new Dimension(0, 8))); // Espaciado
        }
        
        listaEjerciciosPanel.revalidate();
        listaEjerciciosPanel.repaint();
    }

    private JPanel crearCardEjercicio(Ejercicio ej) {
        JPanel card = new JPanel(new BorderLayout(15, 0));
        card.setBackground(new Color(35, 37, 58));
        card.setMaximumSize(new Dimension(580, 80));
        card.setPreferredSize(new Dimension(580, 80));
        card.setBorder(new EmptyBorder(10, 10, 10, 10));

        // 1. Imagen
        JLabel imgLabel = new JLabel();
        imgLabel.setPreferredSize(new Dimension(60, 60));
        try {
            if (ej.getImagen() != null && !ej.getImagen().isEmpty()) {
                ImageIcon icon = new ImageIcon(new java.net.URL(ej.getImagen()));
                Image img = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                imgLabel.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) { imgLabel.setText("No Img"); }
        card.add(imgLabel, BorderLayout.WEST);

        // 2. Textos
        JPanel textos = new JPanel(new GridLayout(2, 1));
        textos.setOpaque(false);
        JLabel nombre = new JLabel(ej.getNombre());
        nombre.setForeground(Color.WHITE);
        nombre.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel musculo = new JLabel(ej.getGrupo_muscular());
        musculo.setForeground(Color.LIGHT_GRAY);
        textos.add(nombre);
        textos.add(musculo);
        card.add(textos, BorderLayout.CENTER);

        // 3. Botones
        JPanel acciones = new JPanel();
        acciones.setOpaque(false);

        JButton btnInfo = new JButton("i");
        btnInfo.addActionListener(e -> JOptionPane.showMessageDialog(frame, ej.getDescripcion(), ej.getNombre(), JOptionPane.INFORMATION_MESSAGE));
        
        JButton btnAdd = new JButton("+");
        btnAdd.setBackground(new Color(46, 204, 113));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        btnAdd.addActionListener(e -> {
            if (!ejerciciosSeleccionados.contains(ej)) {
                ejerciciosSeleccionados.add(ej);
                btnAdd.setText("✓");
                btnAdd.setEnabled(false);
                btnAdd.setBackground(Color.GRAY);
            }
        });

        acciones.add(btnInfo);
        acciones.add(btnAdd);
        card.add(acciones, BorderLayout.EAST);

        return card;
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(35, 37, 58));
        frame.setBounds(100, 100, 700, 650);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // LOGO
        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setBounds(185, 11, 313, 101);
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/imagenes/logo.png"));
            logo.setIcon(new ImageIcon(iconoOriginal.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
        } catch (Exception e) {}
        frame.getContentPane().add(logo);

        // PANEL PRINCIPAL OSCURO
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(26, 26, 38));
        panelContenedor.setBounds(25, 120, 635, 470);
        panelContenedor.setLayout(null);
        frame.getContentPane().add(panelContenedor);

        // INPUT NOMBRE
        nameRutinaInput = new JTextField("Nombre de la rutina");
        nameRutinaInput.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        nameRutinaInput.setBackground(new Color(26, 26, 38));
        nameRutinaInput.setHorizontalAlignment(SwingConstants.CENTER);
        nameRutinaInput.setForeground(Color.WHITE);
        nameRutinaInput.setBounds(130, 20, 378, 31);
        panelContenedor.add(nameRutinaInput);

        // PANEL DE LISTA DE EJERCICIOS (SCROLLABLE)
        listaEjerciciosPanel = new JPanel();
        listaEjerciciosPanel.setBackground(new Color(26, 26, 38));
        listaEjerciciosPanel.setLayout(new BoxLayout(listaEjerciciosPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listaEjerciciosPanel);
        scrollPane.setBounds(20, 70, 595, 320);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        panelContenedor.add(scrollPane);

        // BOTÓN GUARDAR FINAL
        JButton btnGuardarRutina = new JButton("FINALIZAR Y GUARDAR RUTINA");
        btnGuardarRutina.setBounds(130, 405, 378, 45);
        btnGuardarRutina.setBackground(new Color(52, 152, 219));
        btnGuardarRutina.setForeground(Color.WHITE);
        btnGuardarRutina.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuardarRutina.addActionListener(e -> {
            if(ejerciciosSeleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Selecciona al menos un ejercicio.");
                return;
            }
           
            JOptionPane.showMessageDialog(frame, "Rutina '" + nameRutinaInput.getText() + "' guardada con éxito.");
            Rutina rutinatemporal = null;
         
            rutinatemporal = servicioRutinas.guardarRutina(nameRutinaInput.getText(), usuario);
            System.out.println("aqui estamos en la gui" + rutinatemporal);
            if(rutinatemporal != null) servicioRutinas.GuardarEjerciosEnRutina(ejerciciosSeleccionados, usuario, rutinatemporal);
            frame.dispose();
            VentanaInicio vInicio = new VentanaInicio(usuario);
            vInicio.mostrar();
        });
        panelContenedor.add(btnGuardarRutina);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}