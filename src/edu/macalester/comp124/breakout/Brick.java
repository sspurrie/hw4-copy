package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;
import comp124graphics.Rectangle;

import java.awt.*;

public class Brick extends Rectangle {
    public Color brickColor = new Color(201, 150,216, 55);

    public static final int NUM_LAYERS = 5;

    private Rectangle rect;
    public Brick(double x, double y, double width, double height) {
        super(x, y, width, height);
        createBrickDrawing();
        this.setFillColor(Color.BLACK);
    }

   private void createBrickDrawing() {
//        double curRadius = radius;
//        for(int i=0; i < NUM_LAYERS; i++) {
//            Rectangle rect = new Rectangle(width/2, length/2, 2*width, 2*length);
//            rect.setFillColor(Color.RED);
//            rect.setFilled(true);
//            rect.setStroked(false);
//            add(rect);
//            curRadius -= radius/NUM_LAYERS;
//        }
    }
}
