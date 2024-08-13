package com.asteroids.ui;


import com.asteroids.ui.components.Asteroid;
import com.asteroids.ui.components.Ship;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.*;


public class UserInterface extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {


        // importing the main layout and adding the pane for our layout
        Layout layout = new Layout();








        // adding the pane from out layout to a scene
        Scene mainScene = getMainScene(layout.getPane(WIDTH, HEIGHT));


        //sitting the scene to our stage, sets title and calls show()
        stage.setScene(mainScene);
        stage.setTitle("Asteroids!");
        stage.show();

    }

    public Scene getMainScene(Pane pane) {

        // initializing the components we need for our scene
        // first we create a ship object. after we initialize a polygon with the ship.getShip() method
        Ship playerShip = new Ship(WIDTH / 2, HEIGHT / 2);

        // list to store multiple asteroids
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            Asteroid asteroid = new Asteroid(random.nextInt(WIDTH / 3), random.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }


        // we then add the ship to the pane
        pane.getChildren().add(playerShip.getCharacter());


        // adds the asteroids to the pane
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));


        //calling the movements method of the asteroid class
        asteroids.forEach(asteroid -> asteroid.turnRight());
        asteroids.forEach(asteroid -> asteroid.turnRight());
        asteroids.forEach(asteroid -> asteroid.accelerate());
        asteroids.forEach(asteroid -> asteroid.accelerate());



        // add pane to scene
        Scene scene = new Scene(pane);


        // hash table for containing the KeyCode object as the key and a boolean as the value
        // if the value of the boolean variable of a particular key is true, then the key is pressed,
        //otherwise the key is not pressed
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();


        // adds functionality to the scene
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });


        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });


        // adding a AnimationTimer() to take care of rotating the ship
        new AnimationTimer() {


            @Override
            public void handle(long now) {
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    playerShip.turnLeft();
                }


                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    playerShip.turnRight();
                }

                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    playerShip.accelerate();
                }


                // movement
                playerShip.move();
                asteroids.forEach(asteroid -> asteroid.move());


                // checks for collition
                asteroids.forEach(asteroid -> {
                    if (playerShip.collide(asteroid)) {
                        stop();
                    }
                });

            }
        }.start();


        // adding functionality to asteroid



        return scene;

    }

}
