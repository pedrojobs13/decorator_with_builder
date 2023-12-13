package br.com.main.builder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public abstract class ChartBuilder {
    private String filename;

    protected ChartBuilder(String filename) {
        this.filename = filename;
    }
    

    public abstract JFreeChart buildChart() throws Exception;

    protected CategoryDataset createDataset() throws Exception {
        Map<String, Integer> countMap = new HashMap<>();
        try (CSVParser parser = new CSVParser(new FileReader(filename), CSVFormat.DEFAULT)) {
            for (CSVRecord record : parser) {
                String key = processRecordData(record);
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String[] parts = entry.getKey().split("-");
            String category = getCategoryName(parts);
            String label = getLabel(parts);
            dataset.setValue(entry.getValue(), category, label);
        }

        return dataset;
    }
    
    protected void addChartSelectionButton(ChartPanel chartPanel, JFreeChart barChart) {
        // Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons for Bar, Area, and Line charts
        JButton barChartButton = new JButton("Bar Chart");
        JButton areaChartButton = new JButton("Area Chart");
        JButton lineChartButton = new JButton("Line Chart");

        // Add buttons to the panel
        buttonPanel.add(barChartButton);
        buttonPanel.add(areaChartButton);
        buttonPanel.add(lineChartButton);

        // Add the button panel to the chart panel
        chartPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Define listener action for each button
        barChartButton.addActionListener(e -> {
            // Set the chart panel to the BarChart
            chartPanel.setChart(barChart);
        });
        areaChartButton.addActionListener(e -> {
            // Create and display the AreaChart
            try {
                JFreeChart areaChart = new AreaChart(filename).buildChart();
                chartPanel.setChart(areaChart);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        lineChartButton.addActionListener(e -> {
            // Create and display the LineChart
            try {
                JFreeChart lineChart = new LineChart(filename).buildChart();
                chartPanel.setChart(lineChart);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
    public String getFilename() {
        return filename;
    }
    protected abstract String processRecordData(CSVRecord record);
    protected abstract String getCategoryName(String[] parts);
    protected abstract String getLabel(String[] parts);
}
