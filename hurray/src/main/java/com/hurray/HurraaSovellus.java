package com.hurray;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        // adding the AudioClip
        File file = new File(Paths.get("Applause-Yannick_Lemieux.wav").toAbsolutePath().toString());



        Button nappi = new Button("Hurraa!");
        pane.setCenter(nappi);
        Button stop = new Button("Stop");
        pane.setBottom(stop);

        // adding the functionality to the button so that it plays the sound clip above
        nappi.setOnAction(Event -> {
            startMusic(file);
        });

        stop.setOnAction(event -> {
            stopMusic();
        });

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public void startMusic(File file) {
        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();

        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopMusic() {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
