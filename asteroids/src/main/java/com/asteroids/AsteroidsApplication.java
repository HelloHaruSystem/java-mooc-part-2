package com.asteroids;

import com.asteroids.ui.UserInterface;
import javafx.application.Application;



public class AsteroidsApplication {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        // launching the application
        Application.launch(UserInterface.class, args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 0;
    }

}
