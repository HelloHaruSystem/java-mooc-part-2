package com.text_statistics_part_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HBox horiBox = new HBox();
        horiBox.setSpacing(10);
        Label letters = new Label();
        Label words = new Label();
        Label longestWord = new Label();

        horiBox.getChildren().addAll(letters, words, longestWord);

        TextArea textBox = new TextArea();
        textBox.textProperty().addListener((observable, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] wordSplit = newValue.split(" ");
            int wordsAmount = wordSplit.length;
            String getLongestWord = Arrays.stream(wordSplit)
                    .sorted((str1, str2) -> str2.length() - str1.length())
                    .findFirst()
                    .get();

            letters.setText("Letters: " + characters);
            words.setText("Words: " + wordsAmount);
            longestWord.setText("The longest word is: " + getLongestWord);
        });

        borderPane.setCenter(textBox);
        borderPane.setBottom(horiBox);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
