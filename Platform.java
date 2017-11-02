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
    public Platform(double startX) {
        rect = new Rectangle(10, 100, Color.WHITE);
        rect.setX(startX);
    }
    public Rectangle getRect(){
        return rect;
    }
    public void moveUp() {
        if (rect.getY() > 0) {
            rect.setY(rect.getY() - 10);
        }
    }
    public void moveDown(Stage stage) {
        if (rect.getY() + 130 < stage.getHeight()) {
            rect.setY(rect.getY() + 10);
        }
    }
}
