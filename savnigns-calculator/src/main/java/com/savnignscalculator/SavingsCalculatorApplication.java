package com.savnignscalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage mainStage) {

        // importing the ui
        UserInterface ui = new UserInterface();

        // creating a scene
        Scene scene = new Scene(ui.getUi());

        //displays the scene on the main stage and sets title to the stage
        mainStage.setTitle("Savings calculator");
        mainStage.setScene(scene);
        mainStage.show();
    }



    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}