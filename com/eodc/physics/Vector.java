package com.eodc.physics;

/**
 * Write a description of class Vector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vector
{
    private double[] components;
    private double magnitude;
    private double angle;
    
    public Vector() {
        components = new double[2];
        components[0] = 0;
        components[1] = 0;
    }
    public double[] getComponents() {
        return components;
    }
    public double getMagnitude() {
        return magnitude;
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double ang) {
        angle = ang;
    }
    public void setIComponent(double i) {
        components[0] = i;
        angle = Math.toDegrees(Math.atan(components[1] / i));
        if (i < 0) {
            angle = 180 + angle;
        }
        magnitude = Math.sqrt(i * i + components[1] * components[1]);
    }
    public void setJComponent(double j) {
        components[1] = j;
        angle = Math.toDegrees(Math.atan(j / components[0]));
        if (components[0] < 0) {
            angle = 180 + angle;
        }
        magnitude = Math.sqrt(components[0] * components[0] + j * j);
    }
}
