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
    
    public Vector() {
        components = new double[2];
    }
    public double[] getComponents() {
        return components;
    }
    public double getMagnitude() {
        return magnitude;
    }
    public void setIComponent(double i) {
        components[0] = i;
        magnitude = Math.sqrt(i * i + components[1] * components[1]);
    }
    public void setJComponent(double j) {
        components[1] = j;
        magnitude = Math.sqrt(components[0] * components[0] + j * j);
    }
    public void reset() {
        components[0] = 0;
        components[1] = 0;
        magnitude = 0;
    }
}
