package ghost;

import processing.core.PImage;

/**
 * Represents SuperFruit objects on the canvas.
 * Instances have variables x, y, originalSprite, frightenedSprite, speed, and frightenedTimeLength.
 * Each SuperFruit object is a GameObject.
 * They can be eaten by the player.
 * Ghost objects go into frightened mode for 10 seconds when a SuperFruit object is eaten by the player.
 */
public class SuperFruit extends Fruit {

    public SuperFruit(long x, long y, PImage originalSprite) {
        super(x, y, originalSprite);
    }

    /**
     * Changes sprites continuously to draw the attention of the person playing the game.
     */
    public void changeSprite(PImage superFruitSprite, PImage superFruitSpriteLight, int timerFrames) {
        if (timerFrames % 30 <= 20) {
            this.setSprite(superFruitSpriteLight);
        } else {
            this.setSprite(superFruitSprite);
        }
    }
}
