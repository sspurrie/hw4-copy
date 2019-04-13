package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;
import comp124graphics.Rectangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Paddle extends GraphicsGroup  {
    private double x;

    private Rectangle rect;
    public Paddle(double x, double y, double width, double height){

        rect = new Rectangle(x,y,width, height);
        rect.setFillColor(Color.BLACK);

    }

    public Rectangle getPaddle()
    {
        return rect;
    }
    public void updatePaddle(){

    }

}
