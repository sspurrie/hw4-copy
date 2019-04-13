package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import comp124graphics.GraphicsObject;
import comp124graphics.Rectangle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import javax.swing.*;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow implements MouseMotionListener {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 1000;
    private BrickManager brickManager;
    private Rectangle paddle;
    int numBricks = 100;
    double x = 385;
    double y = 600;
    double r = 15;
    Ball ball;
    Wall left;
    Wall top;
    Wall right;
    Wall bottom;
    Brick brick;


    public BreakoutGame() {
        super("BreakoutGame", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickManager = new BrickManager(this);
        paddle=new Paddle(350.0, 900.0, 100.0, 20.0).getPaddle();

        add(paddle);
        addMouseMotionListener(this);
    }

    public void run() {
        resetGame();
    }


    /**
     * Resets the canvas by removing everything and redrawing new bubbles and a new random placement for the cannon.
     */
    public void resetGame() {
        brickManager.removeAllBubbles();
        removeAll();
        brickManager.generateBricks();
//        createPaddle(350, 900, 100, 20);
    }


    public void draw() {
        Random rand = new Random();
        Double angle = rand.nextDouble() * 0.5*Math.PI + .25*Math.PI;
        ball = new Ball(x, y, 5, angle, CANVAS_WIDTH, CANVAS_HEIGHT);
        ball.setFillColor(Color.black);
        add(ball);
        right = new Wall(CANVAS_WIDTH,0,10,CANVAS_HEIGHT);
        add(right);
        top = new Wall(0,-10, CANVAS_WIDTH, 10);
        add(top);
        left = new Wall(-10,0,10,CANVAS_HEIGHT);
        add(left);
        bottom = new Wall(0,CANVAS_HEIGHT,CANVAS_WIDTH,10);
        add(bottom);
        for(int x = 0; x<10; x++){
            for(int y = 0; y<10; y++) {
                brick = new Brick(y*80, 300+x*15, 80, 15);
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
                add(brick);
            }
        }
    }

//    public void updatePosition() {
//        if ((x - r + dx < 0) || (x + r + dx < CANVAS_WIDTH)) {
//            dx = -dx;
//        }
//        if ((y - r + dy < 0) || (y + r + dy < CANVAS_HEIGHT)) {
//            dy = -dy;
//        }
//        x+=dx;
//        y+=dy;
//        draw();
//    }



    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
        prog.draw();
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                prog.eachFrame();
            }
        }, 0, 16);


//        boolean playing = true;
//        while(playing) {
//            prog.updatePosition();
//        }


    }

    public void collisionCheck(GraphicsObject obj){
        if (obj != null){
            if(obj.equals(bottom)){
                ball.flipDy();
            }
            if(obj.equals(right)){
                ball.flipDx();
            }
            if(obj.equals(left)){
                ball.flipDx();
            }
            if(obj.equals(top)){
                ball.flipDy();
            }
            if(obj.equals(paddle)){
                ball.flipDy();
            }
            if(obj.equals(brick)){
                remove(brick);
                numBricks -= 1;
            }
        }
    }

    public void eachFrame() {
        GraphicsObject obj1 = getElementAt(ball.getX(), ball.getY());
        GraphicsObject obj2 = getElementAt(ball.getX() + ball.getWidth(), ball.getY());
        GraphicsObject obj3 = getElementAt(ball.getX(), ball.getY() + ball.getHeight());
        GraphicsObject obj4 = getElementAt(ball.getX() + ball.getWidth(), ball.getY() + ball.getHeight());


        if (numBricks == 0) {

        }

        collisionCheck(obj1);
//        collisionCheck(obj2);
        collisionCheck(obj3);
//        collisionCheck(obj4);
        ball.updatePosition();
    }



    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        paddle.setPosition(e.getX(),900);
    }
}
