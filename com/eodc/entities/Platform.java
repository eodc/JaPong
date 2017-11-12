package com.eodc.entities;
/**
 * Write a description of class Platform here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Platform extends Entity
{
    public static final int WIDTH = 10;
    public static final int HEIGHT = 100;
    public Platform(double startX) {
        super(WIDTH, HEIGHT);
        this.setX(startX);
    }
    public void moveUp() {
        if (getY() > 0) {
            setY(getY() - 7.5);
        }
    }
    public void moveDown() {
        if (getY() + HEIGHT < 600) {
            setY(getY() + 7.5);
        }
    }
}
