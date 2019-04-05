package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import comp124graphics.Rectangle;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 1000;
    int numBricks;
    double x = 385;
    double y = 600;
    double r = 15;
    double dx = 11;
    double dy = 7;
    double centerX;
    double centerY;
    double maxX;
    double maxY;

    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public void draw(){
        Ellipse ball = new Ellipse(x, y, 15, 15);
        ball.setFillColor(Color.black);
        add(ball);
    }

    public void updatePosition() {
        if ((x - r + dx < 0) || (x + r + dx < CANVAS_WIDTH)) {
            dx = -dx;
        }
        if ((y - r + dy < 0) || (y + r + dy < CANVAS_HEIGHT)) {
            dy = -dy;
        }
        x+=dx;
        y+=dy;
        draw();
    }



    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
        Rectangle paddle = new Rectangle(350, 900, 100, 20);
        prog.add(paddle);
        Ellipse ball = new Ellipse(385, 600, 15, 15);
        ball.setFillColor(Color.black);
        prog.add(ball);
        for(int x = 0; x<10; x++){
            for(int y = 0; y<10; y++) {
                    Rectangle brick = new Rectangle(y*80, 400+x*15, 80, 15);
                    if(x==0 || x ==1){
                        brick.setStrokeColor(Color.red);
                    }
                    if(x==2 || x ==3){
                        brick.setStrokeColor(Color.orange);
                    }
                    if(x==4 || x ==5){
                        brick.setStrokeColor(Color.yellow);
                    }
                    if(x==6 || x ==7){
                        brick.setStrokeColor(Color.green);
                    }
                    if(x==8 || x ==9){
                        brick.setStrokeColor(Color.blue);
                    }
                        prog.add(brick);
                    }
            }
//        boolean playing = true;
//        while(playing) {
//            prog.updatePosition();
//        }

    }

}
