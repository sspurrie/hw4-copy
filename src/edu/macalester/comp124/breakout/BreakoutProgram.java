package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;

/**
 * Main program for the breakout game .
 *
 */
public class BreakoutProgram extends CanvasWindow {

    public BreakoutProgram() {
        super("Breakout!", 800, 1000);

    }

    public static void main(String[] args){
        BreakoutProgram prog = new BreakoutProgram();
    }

}
