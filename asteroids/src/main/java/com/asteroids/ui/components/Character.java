
package com.asteroids.ui.components;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public abstract class Character {
    private Polygon character;
    private Point2D movement;

    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);

        this.movement = new Point2D(0, 0);
    }

    public Polygon getCharacter() {
        return this.character;
    }

    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }


    // using the Point2D java class(this.movement) to represent movement this class has both x and y coordinates.
    // beware! this class is immutable like a String!
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));

        // for changing move speed
        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }

    public boolean collide(Character otherCharacter) {
        // checks for collision
        // Shape.intersect(shape s1, shape s2) returns the intersection of two shape objects if 0 no collision
        Shape collisionArea = Shape.intersect(this.character, otherCharacter.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }

}
