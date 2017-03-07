package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 1000;

    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

    }

    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
    }

}
