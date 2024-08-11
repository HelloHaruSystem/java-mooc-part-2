package com.finnishparties;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;


public class PartiesApplication extends Application {


    private LineChart lineChart;

    @Override
    public void start(Stage mainStage)  {
        // create the x and y-axis for the chart
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        // setting the title of the axes


        // creating the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        // importing data set
        DataSet dataSet = new DataSet();
        dataSet.loadData("partiesdata.tsv");
        Map<String, Map<Integer, Double>> data = dataSet.getPartyData();

        addDataToLineChart(lineChart, data);

        // end of data set methods

        // creating the data set that is to be added to the line chart
        // example XYChart.Series series1 = new XYChart.Series<>();

        // example series1.setName("partyName");

        // add singe points into the data set
        // example (series1.getData().add(new XYChart.Data<>(1968, 5.6));

        // add the data set to the line chart

        // example lineChart.getData().add(series1);

        // display the line chart
        Scene view = new Scene(lineChart);
        mainStage.setTitle("Finnish parties");
        mainStage.setScene(view);
        mainStage.show();
    }

    private static void addDataToLineChart(LineChart chart, Map<String, Map<Integer, Double>> dataSet) {


        dataSet.keySet().stream().forEach(partyName -> {
            XYChart.Series series = new XYChart.Series();
            series.setName(partyName);
            dataSet.get(partyName).entrySet().stream().forEach(entry -> {
                series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
            });
            System.out.println(series);
            chart.getData().add(series);
        });

    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);


    }

}
