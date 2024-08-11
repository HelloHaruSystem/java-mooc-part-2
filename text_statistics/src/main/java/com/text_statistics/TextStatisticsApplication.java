package com.text_statistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new TextArea("Write here!"));

        HBox horiBox = new HBox();
        horiBox.setSpacing(10);
        horiBox.getChildren().add(new Label("Letters: 0"));
        horiBox.getChildren().add(new Label("Words: 0"));
        horiBox.getChildren().add(new Label("The longest word is:"));
        borderPane.setBottom(horiBox);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}