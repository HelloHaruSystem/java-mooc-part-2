
package com.asteroids.ui;


import com.asteroids.ui.components.Asteroid;
import com.asteroids.ui.components.Projectiles;
import com.asteroids.ui.components.Ship;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class UserInterface extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {


        // importing the main layout and adding the pane for our layout
        Layout layout = new Layout();
        Pane root = layout.getPane(WIDTH, HEIGHT);


        // adding the pane from out layout to a scene
        Scene mainScene = getMainScene(root);


        //sitting the scene to our stage, sets title and calls show()
        stage.setScene(mainScene);
        stage.setTitle("Asteroids!");
        stage.show();

    }

    public Scene getMainScene(Pane pane) {


        // adding points to the pane
        Text text = new Text(10, 20, "Points: 0");
        pane.getChildren().add(text);


        // AtomicInteger class for points used to increase the points when the method is called
        AtomicInteger points = new AtomicInteger();


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


        // list to store projectiles
        List<Projectiles> projectilesList = new ArrayList<>();


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


                // projectiles  also limiting the size of active projectiles to 3
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectilesList.size() < 3) {
                    // we shoot!
                    Projectiles projectile = new Projectiles((int) playerShip.getCharacter().getTranslateX(),
                                                             (int) playerShip.getCharacter().getTranslateY());

                    projectile.getCharacter().setRotate(playerShip.getCharacter().getRotate());
                    projectilesList.add(projectile);


                    // projectile speed and movement
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));


                    // adds to the layout
                    pane.getChildren().add(projectile.getCharacter());
                }


                // movement
                playerShip.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectilesList.forEach(projectiles -> projectiles.move());


                // collision for projectiles vs asteroids
                projectilesList.forEach(projectiles -> {
                    List<Asteroid> collisions = asteroids.stream()
                                                                .filter(asteroid -> asteroid.collide(projectiles))
                                                                .collect(Collectors.toList());


                    collisions.stream().forEach(colided -> {
                        asteroids.remove(colided);
                        pane.getChildren().remove(colided.getCharacter());
                    });
                });


                // projectiles and asteroid setAlive(false) if collided
                projectilesList.forEach(projectiles -> {
                    asteroids.forEach(asteroid -> {
                        if (projectiles.collide(asteroid)) {
                            projectiles.setAlive(false);
                            asteroid.setAlive(false);

                        }

                    });


                    // adding functionality to points so when you hit an asteroid with an projectile your points increase
                    if(!projectiles.isAlive()) {
                        text.setText("Points: " + points.addAndGet(1000));
                    }
                });


                // removes the "dead" asteroids and projectiles
                // First projectiles
                // First we remove from pane
                projectilesList.stream()
                                        .filter(projectiles -> !projectiles.isAlive())
                                                .forEach(projectiles -> pane.getChildren().remove(projectiles.getCharacter()));
                // then from projectilesList
                projectilesList.removeAll(projectilesList.stream()
                                                                .filter(projectiles -> !projectiles.isAlive())
                                                                .collect(Collectors.toList()));


                // then asteroids
                //first remove from pane
                asteroids.stream()
                                .filter(asteroid -> !asteroid.isAlive())
                                .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                // then from the asteroids list
                asteroids.removeAll(asteroids.stream()
                                                    .filter(asteroid -> !asteroid.isAlive())
                                                    .collect(Collectors.toList()));


                // Continuous adding of asteroids
                // there is a 0.5 % chance each time the AnimationTimer-object is called a new asteroid is added
                // the handle method of the AnimationTimer-object is approximately called 60 times a second so in ten seconds a few asteroids should spawn.
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    // unless it collides with the ship then adds them to the list and pane
                    if(!asteroid.collide(playerShip)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }


                // checks for collision
                asteroids.forEach(asteroid -> {
                    if (playerShip.collide(asteroid)) {
                        stop();
                    }
                });


            }
        }.start();


        return scene;

    }

}
