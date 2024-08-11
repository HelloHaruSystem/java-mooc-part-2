package com.vocabulary_practice;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {

        // main layout and components
        GridPane layout = new GridPane();

        Label wordInstructiion = new Label("Word");
        TextField wordField = new TextField();
        Label translationInstructiion = new Label("Translation");
        TextField translationField = new TextField();
        Button addToDictionaryButton = new Button("Add the word pair");

        // styling of the main layout
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // add components to the layout
        layout.add(wordInstructiion, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationInstructiion, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(addToDictionaryButton, 0, 4);

        // button functionality
        addToDictionaryButton.setOnAction(event -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            this.dictionary.add(word, translation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }
}
