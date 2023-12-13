package br.com.main.decorator;

import br.com.main.builder.BarChart;
import br.com.main.builder.ChartBuilder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class CheckboxDecorator extends Decorator {
  private ChartBuilder builder;
  private JPanel checkboxPanel;

  public CheckboxDecorator(ChartBuilder builder) {
    super(builder);
    this.builder = builder;
    this.checkboxPanel = new JPanel();
    this.checkboxPanel.setLayout(new FlowLayout());

    JCheckBox checkbox1 = new JCheckBox("Checkbox 1");
    JCheckBox checkbox2 = new JCheckBox("Checkbox 2");
    JCheckBox checkbox3 = new JCheckBox("Checkbox 3");
    checkboxPanel.add(checkbox1);
    checkboxPanel.add(checkbox2);
    checkboxPanel.add(checkbox3);

    checkbox1.addActionListener(new CheckboxListener());
    checkbox2.addActionListener(new CheckboxListener());
    checkbox3.addActionListener(new CheckboxListener());
  }

  @Override
  public JFreeChart buildChart() throws Exception {
    JFreeChart baseChart = builder.buildChart();

    JPanel chartPanel = new ChartPanel(baseChart);
    chartPanel.add(checkboxPanel, BorderLayout.WEST);

    return baseChart;
  }

  private class CheckboxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() instanceof JCheckBox) {
        JCheckBox checkBox = (JCheckBox) e.getSource();
        if (checkBox.getText().equals("Checkbox 1")) {
          System.out.println("Checkbox 1 selecionado!");
        } else if (checkBox.getText().equals("Checkbox 2")) {
          System.out.println("Checkbox 2 selecionado!");
        } else if (checkBox.getText().equals("Checkbox 3")) {
          System.out.println("Checkbox 3 selecionado!");
        }
      }
    }
  }
}
