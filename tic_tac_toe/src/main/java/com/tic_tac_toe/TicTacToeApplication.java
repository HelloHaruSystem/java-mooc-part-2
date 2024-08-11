
package com.tic_tac_toe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage mainStage) {
        // instantiate a new GameBoardView
        GameBoardView layout = new GameBoardView();

        // creating a scene and adding our layout from GameBoardView to it
        Scene mainScene = new Scene(layout.getGameBoardView());

        //setting title of the stage as well as adding our scene to it and make it visible
        mainStage.setTitle("Tic-tac-toe");
        mainStage.setScene(mainScene);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
