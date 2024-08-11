package com.multiple_views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViewsController extends Application {

    @Override
    public void start(Stage primaryStage) {

        // scene one layout
        BorderPane viewOneLayout = new BorderPane();
        Label viewOneLabel = new Label("First view!");
        Button viewOneButton = new Button("To the second view!");
        viewOneLayout.setTop(viewOneLabel);
        viewOneLayout.setCenter(viewOneButton);

        // scene two layout
        VBox viewTwoVerticalLayout = new VBox();
        Button viewTwoButton = new Button("To the third view");
        Label viewTwoLabel = new Label("Second view!");
        viewTwoVerticalLayout.setSpacing(10);
        viewTwoVerticalLayout.getChildren().addAll(viewTwoButton, viewTwoLabel);

        // scene three layout
        GridPane viewThreeGridLayout = new GridPane();
        Label viewThreeLabel = new Label("Third view!");
        Button viewThreeButton = new Button("To the first view!");
        viewThreeGridLayout.add(viewThreeLabel, 0, 0);
        viewThreeGridLayout.add(viewThreeButton, 1, 1);

        // scenes
        Scene viewOne = new Scene(viewOneLayout);
        Scene viewTwo = new Scene(viewTwoVerticalLayout);
        Scene viewThree = new Scene(viewThreeGridLayout);

        // button functionality
        viewOneButton.setOnAction(event -> primaryStage.setScene(viewTwo));
        viewTwoButton.setOnAction(event -> primaryStage.setScene(viewThree));
        viewThreeButton.setOnAction(event -> primaryStage.setScene(viewOne));

        // start of Program
        primaryStage.setTitle("Multiple Views");
        primaryStage.setScene(viewOne);
        primaryStage.show();
    }
}
