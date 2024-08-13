
package com.asteroids.ui.components;

import javafx.scene.shape.Polygon;

public class Projectiles extends Character {

    public Projectiles(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);

    }

}
