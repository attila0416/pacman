package ghost;

import processing.core.PImage;

/**
 * Represents LifePoint objects on the canvas.
 * Instances have variables x, y, and sprite.
 * Each LifePoint object is a GameObject.
 * Player object has a list of LifePoint objects, which represent the player's health points.
 */
public class LifePoint extends GameObject {
    private boolean alive;

    public LifePoint(long x, long y, PImage sprite) {
        super(x, y, sprite);
        this.alive = true;
    }

    /**
     * Getter for variable alive.
     */
    public boolean isAlive(){
        return this.alive;
    }

    /**
     * Setter for variable alive.
     */
    public void setAlive(boolean newState) {
        this.alive = newState;
    }
}
