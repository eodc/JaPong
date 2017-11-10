import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * Write a description of class Platform here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Platform
{
    private Rectangle rect;
    public final int WIDTH = 10;
    public final int HEIGHT = 100;
    public Platform(double startX) {
        rect = new Rectangle(WIDTH, HEIGHT, Color.WHITE);
        rect.setX(startX);
    }
    public Rectangle getRect() {
        return rect;
    }
    public double getX() {
        return rect.getX();
    }
    public double getY() {
        return rect.getY();
    }
    public void moveUp() {
        if (rect.getY() > 0) {
            rect.setY(rect.getY() - 10);
        }
    }
    public void moveDown(double stageHeight) {
        if (rect.getY() + 130 < stageHeight) {
            rect.setY(rect.getY() + 10);
        }
    }
}
