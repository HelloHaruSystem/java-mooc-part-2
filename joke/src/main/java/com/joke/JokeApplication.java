
package com.joke;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        // main layout
        BorderPane mainLayout = new BorderPane();
        HBox horizontalMenu = new HBox();
        Button jokeButton = new Button("Joke");
        Button anwserButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        horizontalMenu.getChildren().addAll(jokeButton, anwserButton, explanationButton);
        mainLayout.setTop(horizontalMenu);

        // main layout styling
        horizontalMenu.setPadding(new Insets(20, 20, 20, 20));
        horizontalMenu.setSpacing(10);
        horizontalMenu.setAlignment(Pos.CENTER);
        mainLayout.setPrefSize(320, 180);

         // joke panes/views
        StackPane jokePane = createView("Why can’t you hear a pterodactyl going to the bathroom?");
        StackPane answerPane = createView("Because the “P” is silent.");
        StackPane explanationPane = createView("P as in pee... that is silent... so you can't here it...");

        // button functionality
        jokeButton.setOnAction(event -> mainLayout.setCenter(jokePane));
        anwserButton.setOnAction(event -> mainLayout.setCenter(answerPane));
        explanationButton.setOnAction(event -> mainLayout.setCenter(explanationPane));

        // initial start view and scene
        Scene scene = new Scene(mainLayout);
        mainLayout.setCenter(jokePane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Joke");
        primaryStage.show();
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
