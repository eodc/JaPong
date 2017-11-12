package com.eodc.entities;

import com.eodc.physics.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
/**
 * Write a description of class Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Entity
{
    private Rectangle obj;
    private Vector velocity;

    /**
     * Constructor for objects of class Entity
     */
    public Entity(int width, int height) {
        obj = new Rectangle(width, height, Color.WHITE);
        velocity = new Vector();
    }
    public Rectangle getObj() {
        return obj;
    }
    public double getX() {
        return obj.getX();
    }
    public double getY() {
        return obj.getY();
    }
    public double getVelocity() {
        return velocity.getMagnitude();
    }
    public double getXVelocity() {
        return velocity.getComponents()[0];
    }
    public double getYVelocity() {
        return velocity.getComponents()[1];
    }
    public void setXVelocity(double v) {
        velocity.setIComponent(v);
    }
    public void setYVelocity(double v) {
        velocity.setJComponent(v);
    }
    public void setX(double x) {
        obj.setX(x);
    }
    public void setY(double y) {
        obj.setY(y);
    }
    public void resetVelocity() {
        velocity.reset();
    }
}
