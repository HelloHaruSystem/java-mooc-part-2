
package com.asteroids.ui;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Layout {


    public Layout() {

    }

    public Pane getPane(int width, int height) {

        // initializing a Pane for the main layout
        Pane mainPane = new Pane();


        // Initializing text for points


        // styling
        mainPane.setPrefSize(width, height);
        mainPane.setStyle("-fx-background-color: #808080");

        return mainPane;
    }

}
