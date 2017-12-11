package com.eodc;

import com.eodc.physics.*;
import com.eodc.entities.*;
import java.io.File;
import java.net.MalformedURLException;
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
import javafx.scene.text.*;
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

    boolean oneGoUp, oneGoDown, twoGoUp, twoGoDown, oneScored, twoScored, gameStarted;
    int[] scores = new int[2];
    
    Group root;
    StackPane pane;
    Scene scene;
    Button start;
    Text[] scoreboard = new Text[2];
    
    public void start(Stage stage) throws Exception {
        
        setupUI(stage);
       
        // Create game entities
        Platform player1 = new Platform(15);
        Platform player2 = new Platform(scene.getWidth() - 25);
        Random rand = new Random();
        Ball ball = new Ball();
        ball.setY(rand.nextInt(400) + 1);
        
        // Set timer that checks if buttons are pressed and moves platforms if buttons are pressed
        AnimationTimer timer = new AnimationTimer() {
                public void handle(long now) {
                    if (gameStarted) {
                        ball.setXVelocity(-1000);
                        ball.start();
                        gameStarted = false;
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
                    } 
                    if (ball.checkCollision(player2, 2)) {
                        ball.setX(player2.getX() - ball.WIDTH);
                        ball.handleCollision(player2);
                    }
                    if (ball.getY() <= ball.MIN_Y_POS) {
                        ball.setY(ball.MIN_Y_POS);
                        ball.handleWallCollision();
                    }
                    if (ball.getY() + ball.HEIGHT >= ball.MAX_Y_POS) {
                        ball.setY(ball.MAX_Y_POS - ball.HEIGHT);
                        ball.handleWallCollision();
                    }
                    if (ball.getX() <= ball.MIN_X_POS) {
                        scores[1]++;
                        twoScored = true;
                        ball.reset(1);
                    }
                    if (ball.getX() + ball.WIDTH >= ball.MAX_X_POS) {
                        scores[0]++;
                        oneScored = true;
                        ball.reset(0);
                    }
                    if (oneScored) {
                        scoreboard[0].setText(String.valueOf(scores[0]));
                        if (scores[0] == 10) {
                            this.stop();
                        }
                        oneScored = false;
                    }
                    if (twoScored) {
                        scoreboard[1].setText(String.valueOf(scores[1]));
                        if (scores[1] == 10) {
                            this.stop();
                        }
                        twoScored = false;
                    }
                    ball.move();
                }
            };
            
        // Setup UI Functions
        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                gameStarted = true;
                root.getChildren().add(ball.getObj());
                pane.getChildren().remove(start);
                timer.start();
            }
        });
        // Set controls
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

        

        // Set window properties
        root.getChildren().addAll(player1.getObj(), player2.getObj());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void setupUI(Stage stage) {
        root = new Group();
        pane = new StackPane();
        scene = new Scene(root, 800, 600, Color.BLACK);
        start = new Button("Start Game");
        
        for (int i = 0; i < scoreboard.length; i++ ) {
            scoreboard[i] = new Text(String.valueOf(scores[i]));
            scoreboard[i].setFill(Color.WHITE);
            scoreboard[i].setFont(Font.loadFont("file:com/eodc/res/score.ttf", 50));
        }
        
        pane.setPrefSize(800, 600);
        pane.getChildren().addAll(start, scoreboard[0], scoreboard[1]);
        pane.setAlignment(start, Pos.CENTER);
        pane.setAlignment(scoreboard[0], Pos.TOP_CENTER);
        pane.setAlignment(scoreboard[1], Pos.TOP_CENTER);
        pane.setMargin(scoreboard[0], new Insets(8,100,0,0));
        pane.setMargin(scoreboard[1], new Insets(8,0,0,100));
        
        root.getChildren().addAll(pane);
        
        stage.setTitle(String.valueOf(scoreboard[0].getX()));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
