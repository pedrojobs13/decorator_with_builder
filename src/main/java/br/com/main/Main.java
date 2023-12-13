package br.com.main;

import br.com.main.service.ChartService;

public class Main {

  public static void main(String[] args) throws Exception {
    ChartService chartService = new ChartService();

    chartService.displayChartWithoutDecorator("pessoas.csv");
  }
}
