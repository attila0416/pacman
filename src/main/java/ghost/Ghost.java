package ghost;

import processing.core.PImage;

/**
 * Represents Ghost objects on the canvas.
 * Instances have variables x, y, normalSprite, frightenedSprite, speed, and frightenedTimeLength.
 * Each Ghost object is a GameObject.
 * Player loses a LifePoint when hit by a ghost.
 * However, player can eat Ghost objects when they are frightened.
 */
public class Ghost extends GameObject {
    private final PImage normalSprite;
    private final PImage frightenedSprite;
    private final long frightenedTimeLength;

    private long speed;
    private boolean frightened;
    private boolean eaten;

    public Ghost(long x, long y, PImage normalSprite, PImage frightenedSprite, long speed, long frightenedTimeLength) {
        super(x, y, normalSprite);
        this.normalSprite = normalSprite;
        this.frightenedSprite = frightenedSprite;
        this.frightenedTimeLength = frightenedTimeLength;

        this.speed = speed;
        this.frightened = false;
        this.eaten = false;
    }

    /**
     * Getter for variable frightened.
     */
    public boolean isFrightened() {
        return this.frightened;
    }

    /**
     * Setter for variable frightened.
     */
    public void setFrightened(boolean newState) {
        this.frightened = newState;
    }

    /**
     * Getter for variable eaten.
     */
    public boolean isEaten(){
        return this.eaten;
    }

    /**
     * Setter for variable eaten.
     */
    public void setEaten(boolean newState) {
        this.eaten = newState;
    }

    /**
     * Switches sprites based on the variable frightened while also taking into consideration the time.
     */
    public void spriteSwitch(int timerFrames) {
        if (this.frightened && timerFrames < 60 * (this.frightenedTimeLength * 2 / 3)) {
            this.setSprite(this.frightenedSprite);
        } else {
            if (this.frightened && timerFrames % 30 <= 15) {
                this.setSprite(this.frightenedSprite);
            } else {
                this.setSprite(this.normalSprite);
            }
        }
        if (timerFrames == 60 * this.frightenedTimeLength) {
            this.setSprite(this.normalSprite);
            this.setFrightened(false);
            this.eaten = false;
        }
    }
}
