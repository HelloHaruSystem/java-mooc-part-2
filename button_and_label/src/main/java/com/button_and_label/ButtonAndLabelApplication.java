package com.button_and_label;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        Button button = new Button("Button");

        Label label = new Label("Label");

        FlowPane forButtonAndLabel = new FlowPane();
        forButtonAndLabel.getChildren().add(label);
        forButtonAndLabel.getChildren().add(button);

        Scene scene = new Scene(forButtonAndLabel);

        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}