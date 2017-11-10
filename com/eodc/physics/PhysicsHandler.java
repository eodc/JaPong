package com.eodc.physics;

import com.eodc.entities.*;
/**
 * Write a description of class PhysicsHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhysicsHandler
{
    public static boolean hitObject(Ball ball, Platform plat) {
        return ball.getY() + ball.HEIGHT >= plat.getY() 
            && ball.getY() + ball.HEIGHT <= plat.getY() + plat.HEIGHT
            && ball.getX() == plat.getX() + plat.WIDTH;
    }
    public static double[] calcDeflection(Ball ball, Platform plat) {
        double[] newVelocity = new double[2];
        double kinEnergy = 1/2 * ball.MASS * Math.pow(ball.getVelocity(), 2);
        double finVel = Math.sqrt((2 * kinEnergy) / ball.MASS);
        
        
        return newVelocity;
    }
}
