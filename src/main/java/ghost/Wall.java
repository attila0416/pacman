package ghost;

import processing.core.PImage;

/**
 * Represents Wall objects on the canvas.
 * Instances have variables x, y, and sprite.
 * Each Wall object is a GameObject.
 * Player object cannot go through wall objects.
 */
public class Wall extends GameObject {
    public Wall(long x, long y, PImage sprite) {
        super(x, y, sprite);
    }
}
