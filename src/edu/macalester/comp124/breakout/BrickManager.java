package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrickManager {
    private BreakoutGame canvas;
    private List<Brick> bricks;


    /**
     * Constructs a bubble manager for the specified window object.
     */
    public BrickManager(BreakoutGame canvas) {
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    /**
     * Generates a random number of bubbles placed randomly on the screen.
     */
    public void generateBricks() {
        for(int x = 0; x<10; x++){
            for(int y = 0; y<10; y++) {
                Brick brick = new Brick(y*80, 400+x*15, 80, 15);
//                if(x==0 || x ==1){
//                    brick.setStrokeColor(Color.red);
//                }
//                if(x==2 || x ==3){
//                    brick.setStrokeColor(Color.orange);
//                }
//                if(x==4 || x ==5){
//                    brick.setStrokeColor(Color.yellow);
//                }
//                if(x==6 || x ==7){
//                    brick.setStrokeColor(Color.green);
//                }
//                if(x==8 || x ==9){
//                    brick.setStrokeColor(Color.blue);
//                }
                canvas.add(brick);
                bricks.add(brick);
            }
        }
    }

    /**
     * Checks whether the cannonball hits any of the bubbles, popping the first intersecting bubble if so.
     *
     * @return true If a bubble has been destroyed
     */
//    public boolean testHit(Ball ball) {
//        // The following is java's syntax for a "for each" loop, i.e. "for each bubble b in the bubbles list, do..."
//        for(Brick b : bricks) {
//            if (b.intersects(ball)) {
//                removeBrick(b);
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * Destroys a bubble when it has been hit by a cannonball.
     */
    private void removeBrick(Brick b) {
        canvas.remove(b);
        bricks.remove(b);
    }

    /**
     * Removes all the bubbles from the canvas and the list.
     */
    public void removeAllBubbles() {
        // The following is java's syntax for a "for each" loop, i.e. "for each bubble, b, in the bubbles list do..."
        for(Brick b : bricks) {
            canvas.remove(b);
        }
        bricks.clear();
    }

    /**
     * Check for existing bubbles
     * @return true if bubbles still exist that have not been popped.
     */
    public boolean bricksStillExist() {
        return bricks.size() > 0;
    }

    public int getNumberOfBricks() {
        return bricks.size();
    }

}
