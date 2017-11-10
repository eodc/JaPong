import javafx.scene.shape.*;
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
}
