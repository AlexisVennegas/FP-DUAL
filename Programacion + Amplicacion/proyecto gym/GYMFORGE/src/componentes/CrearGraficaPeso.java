package componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import modelo.Usuario;

public class CrearGraficaPeso {
	
	

    public ChartPanel crearGraficaLineal(DefaultCategoryDataset dataset, Color colorLinea) {
        
        JFreeChart chart = ChartFactory.createLineChart(
            null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);

        // ... Toda tu personalización de transparencia que ya tenías ...
        
        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        
        // Usamos el color que pasamos por parámetro
        renderer.setSeriesPaint(0, colorLinea);
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        
        // Suavizado y transparencia
        chart.setBackgroundPaint(new Color(0,0,0,0));
        plot.setBackgroundPaint(new Color(0,0,0,0));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        chartPanel.setBackground(new Color(0,0,0,0));
        
        return chartPanel;
    }
 // Cambia el método para que reciba el Dataset
    public ChartPanel crearGraficaFuerza(DefaultCategoryDataset dataset) {
        // 2. Usar el dataset que viene por parámetro en lugar de crear uno nuevo
        JFreeChart chart = ChartFactory.createLineChart(
            null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);

        // ... (Mantén todo tu código de personalización: transparente, blanco, grueso, etc.) ...
        
        // Un pequeño toque: para fuerza, quizás quieras un color azul cian o verde neón
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 255, 255)); // Cian
        
        return new ChartPanel(chart);
    }


       
        public ChartPanel crearGraficaPersonalizada(DefaultCategoryDataset dataset, Color colorLinea) {
            
            // 1. Crear el objeto JFreeChart usando el dataset externo
            JFreeChart chart = ChartFactory.createLineChart(
                    null,           // Título (null para que no ocupe espacio)
                    null,           // Etiqueta X
                    null,           // Etiqueta Y
                    dataset,        // DATOS REALES
                    PlotOrientation.VERTICAL, 
                    false,          // Leyenda
                    false,          // Tooltips
                    false           // URLs
            );

            // 2. Personalización de Transparencia y Estilo
            chart.setBackgroundPaint(new Color(0, 0, 0, 0)); // Chart transparente
            chart.setAntiAlias(true);

            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(new Color(0, 0, 0, 0)); // Área de dibujo transparente
            plot.setOutlineVisible(false);
            plot.setRangeGridlinesVisible(false);
            plot.setDomainGridlinesVisible(false);

            // 3. Configuración de Ejes
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setAutoRangeIncludesZero(false); // Zoom en los datos, no empieza en 0
            rangeAxis.setVisible(false);               // Ocultar números laterales
            plot.getDomainAxis().setVisible(false);    // Ocultar etiquetas inferiores

            // 4. Configuración del Renderer (La Línea)
            LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
            renderer.setSeriesPaint(0, colorLinea);
            renderer.setSeriesStroke(0, new BasicStroke(3.0f)); // Línea gruesa y suave
            
            // Hacer que los puntos no se vean, solo la línea
            renderer.setSeriesShapesVisible(0, false);

            // 5. Crear el ChartPanel contenedor
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(240, 60));
            chartPanel.setOpaque(false);
            chartPanel.setBackground(new Color(0, 0, 0, 0));
            chartPanel.setDomainZoomable(false);
            chartPanel.setRangeZoomable(false);

            return chartPanel;
        }
 
        public JPanel crearPanelMetricas(Usuario usuario) {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(26, 26, 38));
            panel.setBounds(0, 0, 267, 119);

            // Título
            JLabel titulo = new JLabel("Composición Corporal");
            titulo.setForeground(Color.WHITE);
            titulo.setFont(new Font("Arial", Font.BOLD, 16));
            titulo.setBounds(15, 10, 200, 25);
            panel.add(titulo);

            // Cálculos
            double peso = usuario.getPeso();
            double alturaM = usuario.getAltura() / 100.0;
            double imc = peso / (alturaM * alturaM);

            // Estilo de las etiquetas de datos
            Font fuenteDatos = new Font("Arial", Font.PLAIN, 14);
            Color colorTexto = new Color(180, 180, 190);

            // Peso
            JLabel lblPeso = new JLabel("Peso Actual: " + peso + " kg");
            lblPeso.setForeground(colorTexto);
            lblPeso.setFont(fuenteDatos);
            lblPeso.setBounds(15, 40, 200, 20);
            panel.add(lblPeso);

            // Altura
            JLabel lblAltura = new JLabel("Estatura: " + usuario.getAltura() + " cm");
            lblAltura.setForeground(colorTexto);
            lblAltura.setFont(fuenteDatos);
            lblAltura.setBounds(15, 60, 200, 20);
            panel.add(lblAltura);

            // IMC con color dinámico
            JLabel lblImc = new JLabel("IMC: " + String.format("%.1f", imc));
            lblImc.setFont(new Font("Arial", Font.BOLD, 15));
            
            // Lógica de colores para salud (Verde = Normal, Rojo = Fuera de rango)
            if (imc >= 18.5 && imc <= 24.9) {
                lblImc.setForeground(new Color(46, 204, 113)); // Verde 
            } else {
                lblImc.setForeground(new Color(231, 76, 60));  // Rojo 
            }
            lblImc.setBounds(15, 85, 200, 20);
            panel.add(lblImc);

            return panel;
        }
        
public ChartPanel crearGraficaPeso() {
    // 1. Crear los datos (X = Día, Y = Peso)
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(75.5, "Peso", "Lun");
    dataset.addValue(75.2, "Peso", "Mar");
    dataset.addValue(74.8, "Peso", "Mie");
    dataset.addValue(75.0, "Peso", "Jue");
    dataset.addValue(74.5, "Peso", "Vie");

    // 2. Crear el objeto JFreeChart (Línea básica)
    JFreeChart chart = ChartFactory.createLineChart(
        null, null, null, dataset, PlotOrientation.VERTICAL, false, false, false);

    // 3. PERSONALIZACIÓN PRO (Para que se vea como tu foto)
    chart.setBackgroundPaint(new Color(0,0,0,0)); // Fondo del gráfico transparente
    
    CategoryPlot plot = chart.getCategoryPlot();
    NumberAxis ejeY = (NumberAxis) plot.getRangeAxis();

    ejeY.setAutoRangeIncludesZero(false); // <--- ESTO QUITA LA LÍNEA RECTA
    ejeY.setLowerMargin(0.1);             // Deja un poco de aire abajo
    plot.setBackgroundPaint(new Color(0,0,0,0)); // Fondo del área de dibujo transparente
    plot.setOutlineVisible(false);               // Quitar borde exterior
    plot.setRangeGridlinesVisible(false);        // Quitar líneas horizontales
    plot.setDomainGridlinesVisible(false);       // Quitar líneas verticales

    // Hacer invisibles los ejes (como en la foto, que no tienen números a los lados)
    plot.getRangeAxis().setVisible(false);
    plot.getDomainAxis().setVisible(false);

    // Configurar la LÍNEA (Blanca y gruesa)
    LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
    renderer.setSeriesPaint(0, Color.WHITE);
    renderer.setSeriesStroke(0, new BasicStroke(3.0f)); // Grosor de 3 píxeles
    
    // Suavizar los bordes (Antialiasing)
    chart.setAntiAlias(true);

    
    
    
    
    // 4. Meterlo en el Panel de JFreeChart
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(200, 100));
    chartPanel.setDomainZoomable(false); // Evita que el usuario haga zoom raro
    chartPanel.setRangeZoomable(false);
    chartPanel.setBackground(new Color(0,0,0,0)); // Transparente total
    chartPanel.setOpaque(false);
 
    
    return chartPanel;
}
}