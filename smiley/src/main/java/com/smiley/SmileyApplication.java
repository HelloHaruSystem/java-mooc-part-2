package com.smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage mainStage) {

        // main layout
        BorderPane root = new BorderPane();

        // initializing canvas components as well as the canvas itself
        Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ColorPicker colorPicker = new ColorPicker();

        // styling the background of the layout
        root.setStyle("-fx-background-color: WHITE;");

        // adding the components to the layout
        root.setCenter(canvas);
        root.setTop(colorPicker);

        // adding the functionality to draw on the canvas choose color and so on
        canvas.setOnMouseDragged(event -> {
            double xLocal  = event.getX();
            double yLocal  = event.getY();
            gc.setFill(colorPicker.getValue());
            gc.fillRect(xLocal, yLocal, 4, 4);
        });

        // using the GraphicsContext gc object we initialized earlier we will draw a smiley on the canvas
        gc.setFill(Color.BLACK);
        gc.fillRect(70, 60, 25, 25);
        gc.fillRect(200, 60, 25, 25);
        gc.fillRect(75, 200, 150, 25);
        gc.fillRect(50, 175, 25, 25);
        gc.fillRect(225, 175, 25, 25);

        // initializing the scene and adding it to the stages and calls show() also sets the title for the stage
        Scene scene = new Scene(root);
        mainStage.setTitle("Smiley");
        mainStage.setScene(scene);
        mainStage.show();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

}
