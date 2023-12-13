
package br.com.main.builder;

import java.awt.Color;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;


public class AreaChart extends ChartBuilder{
    public AreaChart(String filename) {
        super(filename);
    }

    @Override
    public JFreeChart buildChart() throws Exception {
        CategoryDataset dataset = createDataset();
        
        JFreeChart chart = ChartFactory.createAreaChart(
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
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.DARK_GRAY);
        // Alterar as cores das barras
        plot.getRenderer().setSeriesPaint(0, Color.PINK);
        plot.getRenderer().setSeriesPaint(1, Color.BLUE);
        return chart;
    }
    
    


    /**
     *
     * @param record
     * @return
     */
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
}
