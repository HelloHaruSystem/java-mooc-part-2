
package com.notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        //BorderPane root = new BorderPane();

        VBox vbox = new VBox();
        TextField textField = new TextField();
        Label textComponent = new Label();
        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> {
            textComponent.setText(textField.getText());
        });
        vbox.getChildren().addAll(textField, updateButton, textComponent);

        //root.setTop(vbox);

        Scene mainScene = new Scene(vbox);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Notifier");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
