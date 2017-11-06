import javafx.scene.shape.*;
/**
 * Write a description of class PhysicsHandler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhysicsHandler
{
    public static boolean hitOtherObject(Ball ball, Platform plat) {
        boolean result = false;
        if (ball.getBall().getX() == plat.getRect().getX() + plat.getRect().getWidth()) {
            result = true;
        }
        // TODO: Check if ball y value is the same as the platform y value
    }
}
