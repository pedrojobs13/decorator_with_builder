package br.com.main.builder;

import br.com.main.builder.ChartBuilder;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class BarChart extends ChartBuilder{
    
    public BarChart(String filename) {
        super(filename);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public JFreeChart buildChart() throws Exception {
        CategoryDataset dataset = createDataset();

        JFreeChart barChart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.BLACK);
        
        //BarRenderer renderer = (BarRenderer) barChart.getCategoryPlot().getRenderer();
        //renderer.setSeriesFillColor(0, Color.GREEN);
        
        addChartSelectionButton(chartPanel, barChart);

        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.pack();
        frame.setTitle("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        
        frame.setVisible(true);
        barChart.getTitle().setVisible(false);
        return barChart;
    }

    @Override
    protected String processRecordData(CSVRecord record) {
        return record.get(0) + "-" + record.get(2);
    }

    @Override
    protected String getCategoryName(String[] parts) {
        return parts[0];
    }

    @Override
    protected String getLabel(String[] parts) {
        return parts[1];
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                " ",
                " ",
                " ",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        // ... configuração adicional do gráfico ...
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();

        // Alterar as cores das barras
        plot.setBackgroundPaint(Color.DARK_GRAY);
        plot.getRenderer().setSeriesPaint(0, Color.PINK);
        plot.getRenderer().setSeriesPaint(1, Color.BLUE);

        return barChart;
    }
}
