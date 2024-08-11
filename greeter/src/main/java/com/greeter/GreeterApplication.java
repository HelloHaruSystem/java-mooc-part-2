package com.greeter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        // login scene components and layout
        GridPane gridLayout = new GridPane();
        Label startNamePrompt = new Label("Enter your name and start.");
        TextField enterNameField = new TextField();
        Button startButton = new Button("Start");
        Label ifEmptyError = new Label();

        gridLayout.add(startNamePrompt, 0, 0);
        gridLayout.add(enterNameField, 0, 1);
        gridLayout.add(startButton, 0, 2);

        // login scene styling
        gridLayout.setPrefSize(300, 250);
        gridLayout.setAlignment(Pos.CENTER);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        gridLayout.setPadding(new Insets(10, 10, 10, 10));

        // welcome scene after login
        StackPane welcomeWindow = new StackPane();
        Label welcomePrompt = new Label();

        welcomeWindow.getChildren().add(welcomePrompt);

        //welcome scene styling
        welcomeWindow.setPrefSize(300, 250);
        welcomeWindow.setAlignment(Pos.CENTER);

        // scenes
        Scene namePrompter = new Scene(gridLayout);
        Scene welcomeScene = new Scene(welcomeWindow);

        // button functionality
        // String userName = enterNameField.getText();

        startButton.setOnAction(Event -> {
            if (enterNameField.getText().isEmpty()) {
                ifEmptyError.setText("Please enter your name.");
            } else {
                welcomePrompt.setText("Welcome " + enterNameField.getText() + "!");
                primaryStage.setScene(welcomeScene);
            }
        });

        // start of program
        primaryStage.setTitle("Greeter");
        primaryStage.setScene(namePrompter);
        primaryStage.show();
    }

    // start of program
    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
