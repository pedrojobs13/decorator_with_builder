package br.com.main.service;

import br.com.main.builder.BarChart;
import br.com.main.builder.ChartBuilder;
import br.com.main.decorator.CheckboxDecorator;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class ChartService {
  public void displayChartWithCheckboxes(String filename) {
    try {

      ChartBuilder chart = new BarChart(filename);

      CheckboxDecorator decorator = new CheckboxDecorator(chart);

      JFreeChart decoratedChart = decorator.buildChart();

      JFrame frame = new JFrame();
      ChartPanel chartPanel = new ChartPanel(decoratedChart);
      frame.add(chartPanel);
      frame.pack();
      frame.setTitle("Gráfico com Checkboxes");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayChartNormal(String filename) {
    try {

      ChartBuilder chart = new BarChart(filename);

      JFreeChart chartToDisplay = chart.buildChart();

      JFrame frame = new JFrame();
      ChartPanel chartPanel = new ChartPanel(chartToDisplay);
      frame.add(chartPanel);
      frame.pack();
      frame.setTitle("Gráfico");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void displayChartWithoutDecorator(String filename) {
    try {

      ChartBuilder chart = new BarChart("pessoas.csv");

      JFreeChart jfreeChart = chart.buildChart();
      ChartPanel chartPanel = new ChartPanel(jfreeChart);

      JFrame frame = new JFrame();
      frame.add(chartPanel);
      frame.pack();
      frame.setVisible(true);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
