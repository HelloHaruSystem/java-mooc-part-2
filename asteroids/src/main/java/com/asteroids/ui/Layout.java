package com.asteroids.ui;

import com.asteroids.ui.components.Ship;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Layout {


    public Layout() {

    }

    public Pane getPane() {
        // main layout


        // initializing a Pane for the main layout
        Pane mainPane = new Pane();

        // styling
        mainPane.setPrefSize(600, 400);
        mainPane.setStyle("-fx-background-color: #808080");





        return mainPane;
    }

}
