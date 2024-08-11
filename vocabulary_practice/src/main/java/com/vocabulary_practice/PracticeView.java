package com.vocabulary_practice;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }

    public Parent getView() {

        // main layout and components
        GridPane layout = new GridPane();
        Label wordInstructions = new Label("Translate the word '" + this.word + "'");
        TextField translationField = new TextField();
        Button checkButton = new Button("Check");
        Label feedbackLabel = new Label("");

        // layout styling
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // add components to the layout
        layout.add(wordInstructions, 0, 0);
        layout.add(translationField, 0, 1);
        layout.add(checkButton, 0, 2);
        layout.add(feedbackLabel, 0, 3);

        // button functionality
        String translation = translationField.getText();

        checkButton.setOnAction(event -> {
            if (this.dictionary.get(this.word).equals(translation)) {
                feedbackLabel.setText("Correct!");
            } else {
                feedbackLabel.setText("Incorrect! The translation for the word '" + this.word +
                        "' is '" + this.dictionary.get(this.word));
                return;
            }

            this.word = this.dictionary.getRandomWord();
            wordInstructions.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });

        return layout;
    }

}
