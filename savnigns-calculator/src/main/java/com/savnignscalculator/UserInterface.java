package com.savnignscalculator;

import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UserInterface {

    public BorderPane getUi() {

        // initializing the main BorderPane
        BorderPane ui = new BorderPane();


        // initializing a new lineChart that is to be added to the middle of the ui
        // first we create the x and y-axis for the lineChart
        // the x-axis displays years from 0-30.
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        // the y-axis adapts to the values being shown
        NumberAxis yAxis = new NumberAxis();


        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);


        // adding the series that we will store our data in
        XYChart.Series savingsSeries = new XYChart.Series();
        savingsSeries.setName("Savings without interest");


        // also adding a new series that will store our data with interest rate
        XYChart.Series interestSeries = new XYChart.Series();
        interestSeries.setName("Savings with Interest");


        // styling lineChart
        lineChart.setTitle("Savings calculator");


        // initializing a vertical box for the top of the ui
        // the VBox will contain 2 BorderPanes "monthly savings" and "Yearly interest"
        VBox vBox = new VBox();
        BorderPane monthlySavings = new BorderPane();
        BorderPane yearlyInterest = new BorderPane();


        // styling the VBox and BorderPanes
        vBox.setPadding(new Insets(15, 15, 15, 15));
        monthlySavings.setPadding(new Insets(10, 10, 10, 10));
        yearlyInterest.setPadding(new Insets(10, 10, 10, 10));


        // adding label and slider to monthlySavings
        monthlySavings.setLeft(new Label("Monthly savings"));
        Slider monthlySavingsSlider = createSlider(25, 250, 25);
        monthlySavings.setCenter(monthlySavingsSlider);
        Label monthlySliderLabel = new Label(String.format("%.1f", monthlySavingsSlider.getValue()));


        // adding the label to the monthlySavings
        monthlySavings.setRight(monthlySliderLabel);


        // adding label and slider to yearlyInterest
        yearlyInterest.setLeft(new Label("Yearly interest rate"));
        Slider yearlyInterestSlider = createSlider(0, 10, 10);
        yearlyInterestSlider.setMinorTickCount(4);
        yearlyInterest.setCenter(yearlyInterestSlider);
        Label yearlyInterestSliderLabel = new Label(String.format("%.2f", yearlyInterestSlider.getValue()));

        // calling the getSavingsData() method when the programs start it has a line on the diagram
        getSavingsData(monthlySavingsSlider.getValue(), yearlyInterestSlider.getValue(), savingsSeries, interestSeries);

        // slider functionality
        // adding a label that dynamically tracks the number at the points of the savings slider also calls the getSavingsData to update the chart
        monthlySavingsSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            monthlySliderLabel.setText(String.format("%.1f", newValue.doubleValue()));

            getSavingsData(monthlySavingsSlider.getValue(), yearlyInterestSlider.getValue(), savingsSeries, interestSeries);
        });


        // adding a label that dynamically tracks the number at the points of the interest rate slider
        yearlyInterestSlider.valueProperty().addListener((observableValue, oldValue, newValue) ->{
            yearlyInterestSliderLabel.setText(String.format("%.2f", newValue.doubleValue()));

            getSavingsData(monthlySavingsSlider.getValue(), yearlyInterestSlider.getValue(), savingsSeries, interestSeries);
        });


        // adding label to the yearlyInterest
        yearlyInterest.setRight(yearlyInterestSliderLabel);


        // adding the two Borderpanes to the vbox monthlySavings on top
        vBox.getChildren().addAll(monthlySavings, yearlyInterest);


        // adding the savings Series and interestSeries to the lineChart
        lineChart.getData().add(savingsSeries);
        lineChart.getData().add(interestSeries);


        // adding the components
        ui.setCenter(lineChart);
        ui.setTop(vBox);
        return ui;
    }

    private Slider createSlider(int min, int max, int tickValue) {
        // initializing slider and mikes tick labels and marks visible
        Slider slider = new Slider(min, max, tickValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        return slider;

    }

    private static void getSavingsData(double savings, double interestRate, XYChart.Series savingsSeries, XYChart.Series interestSeries) {
        savingsSeries.getData().clear();
        interestSeries.getData().clear();

        savingsSeries.getData().add(new XYChart.Data(0, 0));
        interestSeries.getData().add(new XYChart.Data(0, 0));

        double savingSum = 0.0;
        double interestSum = 0.0;

        for (int i = 1; i <= 30; i++) {
            savingSum += savings * 12;
            interestSum = (interestSum + savings * 12) * (1.0 + interestRate / 100);

            savingsSeries.getData().add(new XYChart.Data(i, savingSum));
            interestSeries.getData().add(new XYChart.Data(i, interestSum));

        }

    }

}
