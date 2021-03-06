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
    public final int MIN_X_POS = -200;
    public final int MAX_X_POS = 1000;
    public final int MIN_Y_POS = 0;
    public final int MAX_Y_POS = 600;
    public final int MASS = 2;

    private double[] deltas;
    private double[] distTravelled;
    public Ball() {
        super(WIDTH, HEIGHT);
        this.setX(400);
        deltas = new double[2];
        distTravelled = new double[2];
    }

    public void start() {
        double yVelocity;
        if (this.getY() < 300) {
            yVelocity = getXVelocity() * Math.tan(Math.toRadians(165));
            this.setYVelocity(yVelocity);
        }
        else {
            yVelocity = getXVelocity() * Math.tan(Math.toRadians(-165));
            this.setYVelocity(yVelocity);
        }
        setDeltas();
    }
    
    public double[] getFinalPos() {
        double finalPos[] = new double[] { getX() + getXVelocity(), getY() + getYVelocity() };
        return finalPos;
    }
    
    public boolean checkCollision(Platform plat, int playerNum) {
        return PhysicsHandler.hitObject(this, plat, playerNum);
    }

    public void handleCollision(Platform player) {
        double[] newVelocity = PhysicsHandler.calcDeflection(this, player);
        setXVelocity(newVelocity[0]);
        setYVelocity(newVelocity[1]);
        setDeltas();
    }
    
    public void handleWallCollision() 
    {
        setYVelocity(-getYVelocity());
        deltas[1] = -deltas[1];
    }
    
    public void setDeltas()
    {
        deltas[0] = 1/100.0 * this.getXVelocity();
        deltas[1] = 1/100.0 * this.getYVelocity();
    }
    
    public void move() {
        setX(getX() + deltas[0]);
        setXVelocity(getXVelocity() - deltas[0]);
        distTravelled[0] = distTravelled[0] + deltas[0];
        setY(getY() + deltas[1]);
        setYVelocity(getYVelocity() - deltas[1]);
        distTravelled[1] = distTravelled[1] + deltas[1];
    }
    
    public void reset(int player) {
        Random rand = new Random();
        if (player == 0) {
            setX(400);
            setY(rand.nextInt(400) + 1);
            setXVelocity(-1000);
            start();
        } else if (player == 1) {
            setX(400);
            setY(rand.nextInt(400) + 1);
            setXVelocity(1000);
            start();
        }
    }
}
