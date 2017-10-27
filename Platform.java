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
    public Platform() {
        rect = new Rectangle(10, 100, Color.WHITE);
        rect.setX(5);
    }
    public Rectangle getRect(){
        return rect;
    }
    public void moveUp(Stage stage) {
        // TODO: Figure out why the fuck it goes up when its supposed to go down
        if (rect.getY() > 0) {
            rect.setY(rect.getY() + 15);
        }
    }
    public void moveDown(Stage stage) {
        if (rect.getY() + 140 < stage.getHeight()) {
            rect.setY(rect.getY() + 15);
        }
    }
}
