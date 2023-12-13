package br.com.main.decorator;

import br.com.main.builder.BarChart;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public abstract class Component {

  public abstract JFreeChart buildChart() throws Exception;

  protected abstract String processRecordData(CSVRecord record);

  protected abstract String getCategoryName(String[] parts);

  protected abstract String getLabel(String[] parts);
}
