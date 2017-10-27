import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.media.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.event.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main extends Application
{
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Platform player = new Platform();
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP: player.moveUp(stage);
                    break;
                    case DOWN: player.moveDown(stage);
                    break;
                }
            }
        });
        
        root.getChildren().add(player.getRect());
        stage.setTitle("JaPong");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
