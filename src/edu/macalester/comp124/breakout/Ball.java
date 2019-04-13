package edu.macalester.comp124.breakout;
import comp124graphics.Ellipse;

public class Ball extends Ellipse {
    public static final double BALL_RADIUS = 10;

    double maxX;
    double maxY;
    double dx;
    double dy;

    public Ball(double x, double y, double initialSpeed, double initialAngle, double maxX, double maxY) {
        super(x, y, BALL_RADIUS * 2, BALL_RADIUS * 2);

        dx = initialSpeed * Math.cos(initialAngle);
        dy = initialSpeed * Math.sin(initialAngle);


    }

    public void flipDx(){
        dx = -dx;
    }

    public void flipDy(){
        System.out.println("Collided");
        dy = -dy;
    }

    public void updatePosition() {
        double newX = dx + getBounds().x;
        double newY = dy + getBounds().y;
//        if((newX > 0 && newX < maxX)&&(newY > 0 && newY < maxY)){
        setPosition(newX, newY);
    }
}
