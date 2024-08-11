
package com.vocabulary_practice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {
    private Dictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new Dictionary();
    }

    @Override
    public void start(Stage mainStage) {

        // create the possible views (subviews)
        PracticeView practiceView = new PracticeView(dictionary);
        InputView inputView = new InputView(dictionary);

        // the higher layout and the components for it
        BorderPane layout = new BorderPane();
        HBox hMenu = new HBox();
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        // styling menu
        hMenu.setSpacing(10);
        hMenu.setPadding(new Insets(20, 20, 20, 20));

        // add components to the menu (buttons) and add the menu to the layout
        hMenu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(hMenu);

        // button functionality connect the subviews with the buttons i.e.clicking the menu buttons changes the subview
        enterButton.setOnAction(event -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction(event -> layout.setCenter(practiceView.getView()));

        // first show the input view
        layout.setCenter(inputView.getView());

        // create the scene and style it and add it to the higher layout
        Scene viewScene = new Scene(layout, 400, 300);

        // set title and show the application
        mainStage.setTitle("Vocabulary Practice");
        mainStage.setScene(viewScene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

}
