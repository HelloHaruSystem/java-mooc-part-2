
package com.asteroids.ui.components;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Ship extends Character {
        private Polygon ship;
        private Point2D movement;

    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }

}
