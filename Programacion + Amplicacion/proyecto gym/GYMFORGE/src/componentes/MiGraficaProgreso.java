package componentes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MiGraficaProgreso extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Double> puntos;

    public MiGraficaProgreso(List<Double> puntos) {
        this.puntos = puntos;
        setOpaque(false); // Para que se vea el fondo de la tarjeta
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // 1. Suavizar los bordes (Antialiasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 2. Configurar el color y el grosor de la línea
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3f)); // Línea gruesa como la de la foto

        // 3. Dibujar la línea uniendo los puntos
        if (puntos.size() < 2) return;

        // Calculamos el espacio entre puntos basado en el ancho del panel
        int margen = 10;
        int anchoEfectivo = getWidth() - (margen * 2);
        int altoEfectivo = getHeight() - (margen * 2);
        int distanciaX = anchoEfectivo / (puntos.size() - 1);

        // Buscamos el valor máximo para escalar la gráfica
        double max = 0;
        for (Double p : puntos) if (p > max) max = p;

        for (int i = 0; i < puntos.size() - 1; i++) {
            // Punto actual
            int x1 = margen + (i * distanciaX);
            int y1 = (int) (getHeight() - margen - (puntos.get(i) / max * altoEfectivo));

            // Punto siguiente
            int x2 = margen + ((i + 1) * distanciaX);
            int y2 = (int) (getHeight() - margen - (puntos.get(i + 1) / max * altoEfectivo));

            g2.drawLine(x1, y1, x2, y2);
            
            // Opcional: Dibujar el puntito (círculo) al final
            if(i + 1 == puntos.size() - 1) {
                g2.fillOval(x2 - 4, y2 - 4, 8, 8);
            }
        }
    }
}