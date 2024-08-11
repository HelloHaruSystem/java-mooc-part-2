package com.utton_and_text_field_application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage stage)  {
        final Button button = new Button("Button");

        final TextField textField = new TextField("Write here");

        final FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(button);
        flowPane.getChildren().add(textField);

        final Scene scene = new Scene(flowPane);


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
}