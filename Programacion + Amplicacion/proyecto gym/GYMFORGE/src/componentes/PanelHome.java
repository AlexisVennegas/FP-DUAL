package componentes;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import gui.VentanaLogin;
import gui.VentanaRutina;
import modelo.Ejercicio;
import modelo.Rutina;
import modelo.RutinaEjercicio;
import modelo.Usuario;
import servicio.ServicioGemini;
import servicio.ServicioRutinas;

public class PanelHome extends JPanel {
    
    private static final long serialVersionUID = 3353267550877575421L;
    private ServicioRutinas servicioRutinas = new ServicioRutinas();
    private List<Ejercicio> ejerciciosDeUnaRutina = null;
    ServicioGemini gemini = new ServicioGemini();
    public PanelHome(Usuario usuario) {
    
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 648, 550); // Aumenté el alto del panel total para que quepa la IA abajo

        // TITLE DE BIENVENIDO
        JLabel bievenudaLabel = new JLabel("¡Hola de Nuevo " + usuario.getNombre() + " !");
        bievenudaLabel.setForeground(new Color(255, 255, 255));
        bievenudaLabel.setFont(new Font("Arial", Font.BOLD, 26));
        bievenudaLabel.setBounds(45, 10, 561, 29);
        add(bievenudaLabel);
        
        // PROGRESO LABEL
        JLabel progresoLabel = new JLabel("Tu progreso hoy:");
        progresoLabel.setForeground(new Color(192, 192, 192));
        progresoLabel.setFont(new Font("Arial", Font.BOLD, 15));
        progresoLabel.setBounds(45, 50, 150, 24);
        add(progresoLabel);
    
        // PRIMERA TARJETA (FUERZA)
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(null); 
        tarjeta.setBackground(new Color(26, 26, 38)); 
        tarjeta.setBounds(45, 85, 267, 119); 
        add(tarjeta);

        JLabel titulo = new JLabel("Resumen de Actividad");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(10, 10, 238, 25);
        tarjeta.add(titulo);

        CrearGraficaPeso fabricaGraficas = new CrearGraficaPeso();
        DefaultCategoryDataset dsFuerza = new DefaultCategoryDataset();
        dsFuerza.addValue(500, "Fuerza", "Día 1");
        dsFuerza.addValue(700, "Fuerza", "Día 2");
        dsFuerza.addValue(650, "Fuerza", "Día 3");
        ChartPanel graficoFuerza = fabricaGraficas.crearGraficaPersonalizada(dsFuerza, new Color(0, 255, 255));
        graficoFuerza.setBounds(10, 50, 240, 60);
        tarjeta.add(graficoFuerza);
        
        // SEGUNDA TARJETA (PESO)
        JPanel tarjeta_1 = new JPanel();
        tarjeta_1.setLayout(null);
        tarjeta_1.setBackground(new Color(26, 26, 38));
        tarjeta_1.setBounds(339, 85, 267, 119);
        add(tarjeta_1);
        
        JPanel tarjetaMetricas = fabricaGraficas.crearPanelMetricas(usuario); 
        tarjeta_1.add(tarjetaMetricas);
        
        // PANEL RUTINAS
        JPanel panelRutinasContenedor = new JPanel();
        panelRutinasContenedor.setBackground(new Color(26, 26, 38));
        panelRutinasContenedor.setBounds(45, 220, 267, 240); // Ajustado para dejar espacio a la IA
        panelRutinasContenedor.setLayout(new BorderLayout(0, 10)); 

        JButton btnAgregar = new JButton("+ Crear nueva rutina");
        btnAgregar.setBackground(new Color(70, 70, 95));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setPreferredSize(new Dimension(267, 35));
        btnAgregar.addActionListener(e -> {
            VentanaRutina ventanaNueva = new VentanaRutina(usuario);
            ventanaNueva.mostrar();
        });
        panelRutinasContenedor.add(btnAgregar, BorderLayout.NORTH);

        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.setBackground(new Color(26, 26, 38));

        Rutina r = null;
        try {
            r = servicioRutinas.rutinasTiene(usuario);
        } catch (Exception e) {}

        if (r == null) {
            JLabel lblVacio = new JLabel("Aún no tienes rutinas");
            lblVacio.setForeground(Color.GRAY);
            lblVacio.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelLista.add(lblVacio);
        } else {
            List<Ejercicio> listaEjercicios = servicioRutinas.ejerciciosDeUnaRutina(usuario, r);
            JPanel cardRutina = new JPanel();
            cardRutina.setLayout(new BoxLayout(cardRutina, BoxLayout.Y_AXIS));
            cardRutina.setBackground(new Color(35, 37, 58));
            cardRutina.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            JLabel lblNombre = new JLabel("📋 " + r.getNombre());
            lblNombre.setForeground(Color.WHITE);
            cardRutina.add(lblNombre);
            
            for (Ejercicio ej : listaEjercicios) {
                JLabel ejLbl = new JLabel("• " + ej.getNombre());
                ejLbl.setForeground(Color.LIGHT_GRAY);
                ejLbl.setFont(new Font("Arial", Font.PLAIN, 11));
                cardRutina.add(ejLbl);
            }
            panelLista.add(cardRutina);
            cardRutina.revalidate();
        }

        JScrollPane scroll = new JScrollPane(panelLista);
        scroll.setBorder(null);
        panelRutinasContenedor.add(scroll, BorderLayout.CENTER);
        add(panelRutinasContenedor);

     // --- SECCIÓN CHAT IA (Derecha) ---
        // 1. Creamos la instancia del componente que creamos antes
        ChatIA chatIA = new ChatIA();
        chatIA.setBounds(339, 220, 267, 240); 
        add(chatIA);

        // 2. Configuración del botón para preguntas manuales
        chatIA.getBtnEnviar().addActionListener(e -> {
            String pregunta = chatIA.getMensajeUsuario();
            if (!pregunta.isEmpty()) {
                procesarPeticionIA(chatIA, pregunta);
            }
        });

        // 3. PETICIÓN AUTOMÁTICA AL INICIAR
     
        String promptInicial = "Hola Gemini. Soy " + usuario.getNombre() + ". "
                + "Actualmente mi peso es de " + usuario.getPeso() + "kg. ";
        try {
          
            if(r != null) {
                promptInicial += "Mi rutina actual se llama '" + r.getNombre() + "'. ";
            }
        } catch(Exception ex) {}

        promptInicial += "dame una recomendacion basica de maximo 4 lineas basado en mis datos.";

        // Enviamos la petición automática
        procesarPeticionIA(chatIA, promptInicial);
    }

    // Método auxiliar para no repetir código de hilos
    private void procesarPeticionIA(ChatIA chat, String consulta) {
        chat.setRespuestaIA("Analizando datos...");
        chat.limpiarInput();

        new Thread(() -> {
            try {
                String respuesta = gemini.obtenerRespuesta(consulta);
                SwingUtilities.invokeLater(() -> chat.setRespuestaIA(respuesta));
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> chat.setRespuestaIA("Error al conectar con el asistente."));
            }
        }).start();
    }
    
}