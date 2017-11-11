package com.eodc.entities;

import com.eodc.physics.*;
import java.util.Random;

/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ball extends Entity
{
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public final int MASS = 2;
    
    public double deltaX;
    public double deltaY;
    public Ball() {
        super(WIDTH, HEIGHT);
        this.setX(400);
    }
    public void start() {
        this.setXVelocity(-400);
        double yVelocity;
        if (this.getY() < 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(165));
            this.setYVelocity(yVelocity);
        }
        else if (this.getY() >= 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(-165));
            this.setYVelocity(yVelocity);
        }
    }
    public boolean checkCollision(Platform plat) {
        return PhysicsHandler.hitObject(this, plat);
    }
    public void setDeltas() {
        deltaX = 1/80.0 * this.getXVelocity();
        deltaY = 1/80.0 * this.getYVelocity();
    }
    public void move() {
        setX(getX() + deltaX);
        setXVelocity(getXVelocity() - deltaX);
        setY(getY() + deltaY);
        setYVelocity(getYVelocity() - deltaY);
    }
}
