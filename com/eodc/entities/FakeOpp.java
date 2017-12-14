package com.eodc.entities;

/**
 * Write a description of class FakeOpp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FakeOpp
{
    private Platform plat;
    private boolean positioned;
    public FakeOpp (Platform plat) {
        this.plat = plat;
        positioned = false;
    }
    public static double[] getEndBallLoc(Ball ball) {
        return ball.getFinalPos();
    }
    public boolean isPositioned() {
        return positioned;
    }
    public void checkPositoned(Ball ball) {
        double[] ballEndPos = getEndBallLoc(ball);
        double platPos = plat.getY();
        positioned = ballEndPos[1] > platPos && ballEndPos[1] < platPos + plat.HEIGHT;
    }
    public void movePlat(Ball ball) {
        double platPos = plat.getY();
        double[] ballEndPos = getEndBallLoc(ball);
        if (ballEndPos[1] < platPos) {
            plat.moveUp();
        } else if (ballEndPos[1] > platPos + plat.HEIGHT) {
            plat.moveDown();
        }
    }
}
