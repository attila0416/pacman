package ghost;

import processing.core.PApplet;

/**
 * Represents App object, which creates the application's canvas and continuously draws onto the canvas.
 * Instances have variables WIDTH, HEIGHT, TARGET_FRAMERATE, and gameInstance.
 * The App object extends PApplet, which used for creating the canvas.
 */
public class App extends PApplet {
    public final int WIDTH;
    public final int HEIGHT;
    public final int TARGET_FRAMERATE;
    public Game gameInstance;

    public App() {
        this.WIDTH = 448;
        this.HEIGHT = 576;
        this.TARGET_FRAMERATE = 60;
        this.gameInstance = new Game();
    }

    /**
     * Sets up the framerate of the app and sets up the game through the game instance variable.
     */
    public void setup() {
        frameRate((float) this.TARGET_FRAMERATE);
        gameInstance.setupGame(this);
    }

    /**
     * Sets up the canvas's size by initialising its width and height.
     */
    public void settings() {
        size(this.WIDTH, this.HEIGHT);
    }

    /**
     * Continuously draws the background and calls the draw method of the Game Object, which draws every
     * visual object to the canvas.
     */
    public void draw() {
        background(0, 0, 0);
        this.gameInstance.draw(this, keyCode, keyPressed, RIGHT, LEFT, DOWN, UP, TARGET_FRAMERATE);
    }

    /**
     * Main method of App Object classifies the main class for PApplet.
     */
    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }
}