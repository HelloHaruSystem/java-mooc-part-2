
package com.asteroids.ui;

import javafx.scene.layout.Pane;



public class Layout {


    public Layout() {

    }

    public Pane getPane(int width, int height) {
        // main layout


        // initializing a Pane for the main layout
        Pane mainPane = new Pane();

        // styling
        mainPane.setPrefSize(width, height);
        mainPane.setStyle("-fx-background-color: #808080");





        return mainPane;
    }

}
