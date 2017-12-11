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
    public static boolean hitObject(Ball ball, Platform plat, int playerNum) {
        return ball.getY() + ball.HEIGHT >= plat.getY()
        && ball.getY() <= plat.getY() + plat.HEIGHT
        && (ball.getX() <= plat.getX() || ball.getX() >= plat.getX()) 
        && (Math.abs(plat.getX() + plat.WIDTH - ball.getX()) < 7.5
            || Math.abs(ball.getX() + ball.WIDTH - plat.getX()) < 7.5);
    }

    public static double[] calcDeflection(Ball ball, Platform plat) {
        double fXVelocity;
        if (ball.getX() < 400)
            fXVelocity = 1000;
        else
            fXVelocity = -1000;
        double pVelocity = Math.sqrt(fXVelocity * fXVelocity + ball.getYVelocity() * ball.getYVelocity());
        double fKinEnergy = 0.7 * (1/2.0 * ball.MASS * pVelocity * pVelocity);
        double fVelocity = Math.sqrt(2 * fKinEnergy / ball.MASS) + 200;
        double fYVelocity = Math.sqrt(fVelocity * fVelocity - fXVelocity * fXVelocity) - (ball.getY() / 2.5);
        if (ball.getY() < plat.getY() + plat.HEIGHT / 2)
            fYVelocity = -fYVelocity;

        double[] newVelocity = { fXVelocity, fYVelocity };
        return newVelocity;
    }
}
