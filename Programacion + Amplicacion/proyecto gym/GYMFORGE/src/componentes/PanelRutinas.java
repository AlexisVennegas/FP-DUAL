package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import modelo.Ejercicio;
import modelo.Rutina;
import modelo.Usuario;
import servicio.ServicioRutinas;

public class PanelRutinas extends JPanel {

    private static final long serialVersionUID = 1L;
    private Usuario usuario;
    private ServicioRutinas servicioRutinas = new ServicioRutinas();
    private List<Rutina> rutinas = null;
    
    // 1. Declaramos el contenedor como variable de clase para acceder desde el botón
    private JPanel contenedorCards;

    public PanelRutinas(Usuario usuario) {
        this.usuario = usuario;
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 648, 380);

        JLabel bienvenidaLabel = new JLabel("Hola, " + usuario.getNombre() + ". Tus rutinas:");
        bienvenidaLabel.setForeground(new Color(255, 255, 255));
        bienvenidaLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        bienvenidaLabel.setBounds(25, 10, 561, 40); 
        add(bienvenidaLabel);

        // Inicializamos el contenedor global
        contenedorCards = new JPanel();
        contenedorCards.setLayout(new BoxLayout(contenedorCards, BoxLayout.Y_AXIS));
        contenedorCards.setOpaque(false);
        contenedorCards.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(contenedorCards);
        scrollPane.setBounds(20, 60, 600, 300); 
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        actualizarListaRutinas();
    }

    // Método para cargar o recargar las rutinas
    private void actualizarListaRutinas() {
        contenedorCards.removeAll(); // Limpiamos lo que haya
        rutinas = servicioRutinas.mostrarAllRutinasByUsuario(usuario);

        for (Rutina r : rutinas) {
            JPanel card = crearCardRutina(r, usuario);
            contenedorCards.add(card);
            contenedorCards.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 15)));
        }
        contenedorCards.add(javax.swing.Box.createVerticalGlue());
        
        contenedorCards.revalidate();
        contenedorCards.repaint();
    }

    private JPanel crearCardRutina(Rutina rutina, Usuario usuario) {
        JPanel card = new JPanel();
        card.setLayout(new java.awt.BorderLayout());
        card.setBackground(new Color(45, 48, 71)); 
        card.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new Color(60, 63, 90), 1, true),
            new EmptyBorder(15, 15, 15, 15)
        ));
        card.setMaximumSize(new java.awt.Dimension(580, 200));

        JLabel lblNombre = new JLabel("📋 " + rutina.getNombre().toUpperCase());
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNombre.setForeground(new Color(0, 255, 200));
        card.add(lblNombre, java.awt.BorderLayout.NORTH);

        JPanel panelEjercicios = new JPanel();
        panelEjercicios.setLayout(new BoxLayout(panelEjercicios, BoxLayout.Y_AXIS));
        panelEjercicios.setOpaque(false);
        
        List<Ejercicio> ejercicios = servicioRutinas.ejerciciosDeUnaRutina(usuario, rutina);
        if (ejercicios.isEmpty()) {
            JLabel vacio = new JLabel("Sin ejercicios");
            vacio.setForeground(Color.GRAY);
            panelEjercicios.add(vacio);
        } else {
            for (Ejercicio ej : ejercicios) {
                JLabel lblEj = new JLabel("• " + ej.getNombre());
                lblEj.setForeground(new Color(220, 220, 220));
                panelEjercicios.add(lblEj);
            }
        }
        card.add(panelEjercicios, java.awt.BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0));
        panelBotones.setOpaque(false);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(new Color(200, 50, 50));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmar = JOptionPane.showConfirmDialog(null, 
                    "¿Estás seguro de eliminar la rutina '" + rutina.getNombre() + "'?", 
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirmar == JOptionPane.YES_OPTION) {
                    try {
                        servicioRutinas.eliminarRutina(usuario, rutina);
                        
                        // 2. CORRECCIÓN: El padre (contenedorCards) elimina al hijo (card)
                        contenedorCards.remove(card); 
                        
                        // 3. REFRESCO: Obligatorio para que desaparezca visualmente
                        contenedorCards.revalidate();
                        contenedorCards.repaint();
                        
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar: " + e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            }
        });

        JButton btnVer = new JButton("EMPEZAR");
        btnVer.setFocusPainted(false);
        btnVer.setBackground(new Color(0, 150, 136));
        btnVer.setForeground(Color.WHITE);
        btnVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelBotones.add(btnEliminar);
        panelBotones.add(btnVer);
        
        card.add(panelBotones, java.awt.BorderLayout.SOUTH);

        return card;
    } 
}