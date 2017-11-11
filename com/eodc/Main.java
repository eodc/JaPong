package com.eodc;

import com.eodc.physics.*;
import com.eodc.entities.*;
import java.util.Random;
import javafx.application.Application;
import javafx.animation.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.*;
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
    
    boolean oneGoUp, oneGoDown, twoGoUp, twoGoDown;
    boolean gameStarted;
    
    public void start(Stage stage) throws Exception {
        
        // Intialize all entities
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Platform player1 = new Platform(15);
        Platform player2 = new Platform(scene.getWidth() - 25);
        Random rand = new Random();
        Ball ball = new Ball();
        ball.setY(rand.nextInt(600) + 1);
        
        // Set controls
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                gameStarted = true;
            }
        });
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                switch (ke.getCode()) {
                    case W:
                        oneGoUp = true;
                        break;
                    case S:
                        oneGoDown = true;
                        break;
                    case UP:
                        twoGoUp = true;
                        break;
                    case DOWN:
                        twoGoDown = true;
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                switch (ke.getCode()) {
                    case W:
                        oneGoUp = false;
                        break;
                    case S:
                        oneGoDown = false;
                        break;
                    case UP:
                        twoGoUp = false;
                        break;
                    case DOWN:
                        twoGoDown = false;
                        break;
                }
            }
        });

        // Set timer that checks if buttons are pressed and moves platforms if buttons are pressed
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                if (gameStarted) {
                    ball.moveLeft();
                }
                if (oneGoUp)
                    player1.moveUp();
                if (oneGoDown)
                    player1.moveDown(stage.getHeight());
                if (twoGoUp)
                    player2.moveUp();
                if (twoGoDown)
                    player2.moveDown(stage.getHeight());
                if (ball.checkCollision(player1)) {
                    double[] newVelocity = PhysicsHandler.calcDeflection(ball);
                    ball.setXVelocity(newVelocity[0]);
                    ball.setYVelocity(newVelocity[1]);
                } 
                if (ball.checkCollision(player2)) {
                    double[] newVelocity = PhysicsHandler.calcDeflection(ball);
                    ball.setXVelocity(newVelocity[0]);
                    ball.setYVelocity(newVelocity[1]);
                }
            }
        };
        timer.start();
        
        // Set window properties
        root.getChildren().add(player1.getObj());
        root.getChildren().add(player2.getObj());
        root.getChildren().add(ball.getObj());
        stage.setTitle("JaPong");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
