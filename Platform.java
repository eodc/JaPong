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
    private Vector vect;
    private final int MASS = 10;
    public Platform(double startX) {
        rect = new Rectangle(10, 100, Color.WHITE);
        vect = new Vector();
        rect.setX(startX);
    }
    public Rectangle getRect() {
        return rect;
    }
    public Vector getVect() {
        return vect;
    }
    public void moveUp() {
        if (rect.getY() > 0) {
            rect.setY(rect.getY() - 10);
            vect.setYComp(10);
            vect.setBearing(0);
        }
    }
    public void moveDown(Stage stage) {
        if (rect.getY() + 130 < stage.getHeight()) {
            rect.setY(rect.getY() + 10);
            vect.setYComp(10);
            vect.setBearing(180);
        }
    }
    public void resetVect() {
        vect.reset();
    }
}
