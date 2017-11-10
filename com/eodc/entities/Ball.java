package com.eodc.entities;

import com.eodc.physics.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ball extends Entity
{   
    private Rectangle ball;
    
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public final int MASS = 5;
    public Ball() {
        super(WIDTH, HEIGHT);
        ball = getObj();
        ball.setX(400);
        ball.setY(300);
    }
    public void moveLeft() {
        ball.setX(ball.getX() - 5);
    }
    public boolean checkCollision(Platform plat) {
        return PhysicsHandler.hitObject(this, plat);
    }
}
