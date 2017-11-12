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
    int p1Score = 0;
    int p2Score = 0;
    
    public void start(Stage stage) throws Exception {
        
        // Intialize all entities
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Platform player1 = new Platform(15);
        Platform player2 = new Platform(scene.getWidth() - 25);
        Random rand = new Random();
        Ball ball = new Ball();
        ball.setY(rand.nextInt(600) + 1);
        Button start = new Button("Start Game");
        // Set controls
        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                gameStarted = true;
                root.getChildren().add(ball.getObj());
                root.getChildren().remove(start);
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
                    ball.start();
                }
                if (oneGoUp)
                    player1.moveUp();
                if (oneGoDown)
                    player1.moveDown();
                if (twoGoUp)
                    player2.moveUp();
                if (twoGoDown)
                    player2.moveDown();
                if (ball.checkCollision(player1, 1)) {
                    ball.setX(player1.getX() + player1.WIDTH);
                    ball.handleCollision(player1);
                    gameStarted = false;
                } 
                if (ball.checkCollision(player2, 2)) {
                    ball.setX(player2.getX() - ball.WIDTH);
                    ball.handleCollision(player2);
                    gameStarted = false;
                }
                if (ball.getY() <= ball.MIN_POS) {
                    ball.setY(ball.MIN_POS);
                    ball.handleWallCollision();
                }
                if (ball.getY() + ball.HEIGHT >= ball.MAX_Y_POS) {
                    ball.setY(ball.MAX_Y_POS - ball.HEIGHT);
                    ball.handleWallCollision();
                }
                if (ball.getX() <= ball.MIN_POS) {
                    ball.setX(ball.MIN_POS);
                    p2Score++;
                    ball.stop();
                }
                if (ball.getX() + ball.WIDTH >= ball.MAX_X_POS) {
                    ball.setX(ball.MAX_X_POS - ball.WIDTH);
                    p1Score++;
                    ball.stop();
                }
                ball.move();
            }
        };
        timer.start();
        
        // Set window properties
        root.getChildren().addAll(player1.getObj(), player2.getObj(), start);
        stage.setTitle("JaPong");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
