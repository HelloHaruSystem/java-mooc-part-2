package com.shanghai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage mainStage) throws Exception {
        // initializing x and y-axis
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);


        // setting the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // create the line chart the values given to  the chart will be numbers
        // it also uses the axis we created before
        LineChart<Number, Number> shanghaiRankingChart = new LineChart<>(xAxis, yAxis);
        shanghaiRankingChart.setTitle("University of Helsinki, Shanghai ranking");

        // we then create a series called data and add the data set to the series we also set the name of the series
        XYChart.Series data = new XYChart.Series();
        data.setName("University of Helsinki");

        data.getData().add(new XYChart.Data(2007, 73));
        data.getData().add(new XYChart.Data(2008, 68));
        data.getData().add(new XYChart.Data(2009, 72));
        data.getData().add(new XYChart.Data(2010, 72));
        data.getData().add(new XYChart.Data(2011, 74));
        data.getData().add(new XYChart.Data(2012, 73));
        data.getData().add(new XYChart.Data(2013, 76));
        data.getData().add(new XYChart.Data(2014, 73));
        data.getData().add(new XYChart.Data(2015, 67));
        data.getData().add(new XYChart.Data(2016, 56));
        data.getData().add(new XYChart.Data(2017, 56));

        // add the data set to the line chart
        shanghaiRankingChart.getData().add(data);

        // display the line chart (we also at a title to the stage)
        Scene mainScene = new Scene(shanghaiRankingChart);
        mainStage.setTitle("Shanghai");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
