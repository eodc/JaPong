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
    public final int MASS = 5;
    public Ball() {
        super(WIDTH, HEIGHT);
        this.setX(400);
    }
    public void start() {
        this.setXVelocity(-400);
        double yVelocity;
        if (this.getY() < 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(-165));
            this.setYVelocity(yVelocity);
        }
        else if (this.getY() >= 300) {
            yVelocity = -400 * Math.tan(Math.toRadians(165));
            this.setYVelocity(yVelocity);
        }
    }
    public boolean checkCollision(Platform plat) {
        return PhysicsHandler.hitObject(this, plat);
    }
    public void move() {
        double[] finalPos = { this.getX() + this.getXVelocity(), this.getY() + this.getYVelocity() };
        double deltaX = 1/80.0 * this.getXVelocity();
        double deltaY = 1/80.0 * this.getYVelocity();
        if (finalPos[0] < getX()) {
            setX(getX() + deltaX);
            setXVelocity(getXVelocity() - deltaX);
        } else {
            setX(getX() - deltaX);
            setXVelocity(getXVelocity() - deltaX);
        }
        if (finalPos[1] > getY()) {
            setY(getY() + deltaY);
            setYVelocity(getYVelocity() - deltaY);
        } else {
            setY(getY() - deltaY);
            setYVelocity(getYVelocity() - deltaY);
        }
    }
}
