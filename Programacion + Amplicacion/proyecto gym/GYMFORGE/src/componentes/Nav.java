package componentes;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Nav extends JPanel {
    private JPanel contenedor;
    private CardLayout cl;
    
    // Listas para gestionar los labels y las rutas
    private List<JLabel> botones = new ArrayList<>();
    private String[] rutasNormales = { "/imagenes/Home.png", "/imagenes/rutina.png", "/imagenes/empezar.png", "/imagenes/historial.png", "/imagenes/perfil.png" };
    private String[] rutasSelected = { "/imagenes/Home1.png", "/imagenes/rutina1.png", "/imagenes/empezar1.png", "/imagenes/historial1.png", "/imagenes/perfil1.png" };

    public Nav(JPanel contenedor, CardLayout cl) {
        this.contenedor = contenedor;
        this.cl = cl;

        this.setOpaque(false);
        this.setLayout(null);
        this.setBounds(111, 491, 452, 54);

        // Nombres de las cartas para el CardLayout
        String[] nombres = {"PanelHome", "PanelRutinas", "EMPEZAR", "HISTORIAL", "PERFIL"};

        int x = 0;
        for (int i = 0; i < rutasNormales.length; i++) {
         
            String rutaInicial = (i == 0) ? rutasSelected[i] : rutasNormales[i];
            
            JLabel btn = crearBotonNav(rutaInicial, x, nombres[i], i);
            botones.add(btn);
            this.add(btn);
            x += 90;
        }
    }

    private JLabel crearBotonNav(String ruta, int x, String nombreCarta, int indice) {
        JLabel label = new JLabel();
        actualizarIcono(label, ruta);
        
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setBounds(x, 0, 80, 54);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
             
                cl.show(contenedor, nombreCarta);
                for (int i = 0; i < botones.size(); i++) {
                    actualizarIcono(botones.get(i), rutasNormales[i]);
                }
                
            
                actualizarIcono(label, rutasSelected[indice]);
            }
        });

        return label;
    }

   
    private void actualizarIcono(JLabel label, String ruta) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
            Image img = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.err.println("No se pudo cargar: " + ruta);
        }
    }
}