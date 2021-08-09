package ghost;

import processing.core.PImage;

/**
 * Represents GameObject abstract class that is used by each object drawn on the canvas.
 * Instances have variables x, y, and sprite.
 */
public abstract class GameObject {
    private long x;
    private long y;
    private PImage sprite;

    public GameObject(long x, long y, PImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    /**
     * Draws the GameObject to the canvas of the app.
     */
    public void draw(App app) {
        // Handling graphics
        app.image(this.sprite, this.x, this.y);
    }

    /**
     * Getter for variable x.
     */
    public long getX() {
        return this.x;
    }

    /**
     * Setter for variable x.
     */
    public void setX(long newX) {
        this.x = newX;
    }

    /**
     * Getter for variable y.
     */
    public long getY() {
        return this.y;
    }

    /**
     * Setter for variable y.
     */
    public void setY(long newY) {
        this.y = newY;
    }

    /**
     * Getter for variable sprite.
     */
    public PImage getSprite() {
        return this.sprite;
    }

    /**
     * Setter for variable sprite.
     */
    public void setSprite(PImage newSprite) {
        this.sprite = newSprite;
    }

    /**
     * Getter for variable sprite.width.
     */
    public int getWidth() {
        return this.sprite.width;
    }

    /**
     * Getter for variable sprite.height.
     */
    public int getHeight() {
        return this.sprite.height;
    }
}
