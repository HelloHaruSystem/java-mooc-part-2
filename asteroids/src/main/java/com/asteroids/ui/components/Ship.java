package com.asteroids.ui.components;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Ship {
        private Polygon ship;
        private Point2D movement;

    public Ship(int x, int y) {
        this.ship = new Polygon(-5, -5, 10, 0, -5, 5);
        this.ship.setTranslateX(x);
        this.ship.setTranslateY(y);

        this.movement = new Point2D(0, 0);
    }

    public Polygon getShip() {
        return this.ship;
    }

    public void turnLeft() {
        this.ship.setRotate(this.ship.getRotate() - 5);
    }

    public void turnRight() {
        this.ship.setRotate(this.ship.getRotate() + 5);
    }

    public void move() {

        // using the Point2D java class(this.movement) to represent movement this class has both x and y coordinates.
        // beware! this class is immutable like a String!
        this.ship.setTranslateX(this.ship.getTranslateX() + this.movement.getX());
        this.ship.setTranslateY(this.ship.getTranslateY() + this.movement.getY());
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.ship.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.ship.getRotate()));

        // tweaking speed
        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }


}
