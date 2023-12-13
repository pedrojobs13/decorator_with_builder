package br.com.main.decorator;

import br.com.main.builder.BarChart;
import br.com.main.builder.ChartBuilder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public abstract class Decorator extends Component{
  protected ChartBuilder builder;

  public Decorator(ChartBuilder builder) {
    this.builder = builder;
  }

  @Override
  public abstract JFreeChart buildChart() throws Exception;

  @Override
  protected String processRecordData(CSVRecord record) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  protected String getCategoryName(String[] parts) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  protected String getLabel(String[] parts) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
