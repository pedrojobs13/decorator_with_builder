package br.com.main.builder;

import br.com.main.builder.ChartBuilder;
import java.awt.BasicStroke;
import java.awt.Color;
import org.apache.commons.csv.CSVRecord;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class LineChart extends ChartBuilder {

    public LineChart(String filename) {
        super(filename);
    }

    @Override
    public JFreeChart buildChart() throws Exception {
        CategoryDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createLineChart(
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
        plot.getRenderer().setSeriesStroke(0, new BasicStroke(3.0f));
        plot.getRenderer().setSeriesStroke(1, new BasicStroke(3.0f));
        
        return chart;
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

}
