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
public class Ball
{   
    private Rectangle ball;
    private Vector velocity;
    
    public final int WIDTH = 10;
    public final int HEIGHT = 10;
    public Ball() {
        ball = new Rectangle(10, 10, Color.WHITE);
        ball.setX(400);
        ball.setY(300);
        
        velocity = new Vector();
    }
    public Rectangle getBall() {
        return ball;
    }
    public double getX() {
        return ball.getX();
    }
    public double getY() {
        return ball.getY();
    }
    public void moveLeft() {
        ball.setX(ball.getX() - 5);
    }
    public boolean checkCollision(Platform plat) {
        return PhysicsHandler.hitObject(this, plat);
    }
}
