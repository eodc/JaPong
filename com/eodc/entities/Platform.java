package com.eodc.entities;

import com.eodc.physics.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * Write a description of class Platform here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Platform extends Entity
{
    public static final int WIDTH = 10;
    public static final int HEIGHT = 100;
    
    private Rectangle plat;
    public Platform(double startX) {
        super(WIDTH, HEIGHT);
        
        plat = getObj();
        plat.setX(startX);
    }
    public void moveUp() {
        if (plat.getY() > 0) {
            plat.setY(plat.getY() - 10);
        }
    }
    public void moveDown(double stageHeight) {
        if (plat.getY() + 130 < stageHeight) {
            plat.setY(plat.getY() + 10);
        }
    }
}
