import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ball
{   
    private Rectangle ball;
    public Ball() {
        ball = new Rectangle(10, 10, Color.WHITE);
        ball.setX(400);
        ball.setY(300);
    }
    public Rectangle getBall() {
        return ball;
    }
    public void moveLeft() {
        ball.setX(ball.getX() - 5);
    }
}
