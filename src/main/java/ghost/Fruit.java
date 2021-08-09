package ghost;

import processing.core.PImage;


/**
 * Represents Fruit objects on the canvas.
 * Instances have variables x, y, and sprite.
 * Each Fruit object is a GameObject.
 * They can be eaten by the player.
 */
public class Fruit extends GameObject {
    private boolean eaten;
    private boolean countedFor;

    public Fruit(long x, long y, PImage sprite) {
        super(x, y, sprite);
        this.eaten = false;
        this.countedFor = false;
    }

    /**
     * @return Whether or not the Fruit object was eaten.
     */
    public boolean isEaten(){
        return this.eaten;
    }

    /**
     * Updates the boolean state of the variable eaten.
     */
    public void setEaten(boolean newState) {
        this.eaten = newState;
    }

    /**
     * @return Whether or not the Fruit object was counted.
     */
    public boolean isCountedFor(){
        return this.countedFor;
    }

    /**
     * Updates the boolean state of the variable countedFor.
     */
    public void setCountedFor(boolean newState) {
        this.countedFor = newState;
    }
}
