package br.com.main.decorator;

import br.com.main.builder.BarChart;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.JFreeChart;

public class Chart extends Component {
  @Override
  public JFreeChart buildChart() throws Exception {
    BarChart chart = new BarChart("pessoas.csv");
    return chart.buildChart();
  }

  @Override
  public String processRecordData(CSVRecord record) {

    return "";
  }

  @Override
  public String getCategoryName(String[] parts) {

    return "";
  }

  @Override
  public String getLabel(String[] parts) {

    return "";
  }
}
