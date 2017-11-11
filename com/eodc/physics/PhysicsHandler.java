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
    public static double[] calcDeflection(Ball ball) {
        double[] newVelocity = new double[2];
        double kinEnergy = 0.5 * ball.MASS * Math.pow(ball.getVelocity(), 2);
        double finVel = Math.sqrt((2 * kinEnergy) / ball.MASS);
        double newYVelocity = finVel * Math.sin(ball.getVelocityAngle());
        double newXVelocity = Math.sqrt(kinEnergy * kinEnergy - newYVelocity * newYVelocity);
        
        newVelocity[0] = newXVelocity;
        newVelocity[1] = newYVelocity;  
        return newVelocity;
    }
}
