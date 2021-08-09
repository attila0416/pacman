package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

public class SuperFruitTest {
    @Test
    public void changeSpriteTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        PImage superFruitSpriteLight = app.loadImage(sourceLibrary + "superFruitLight.png");
        int timerFrames = 20;
        SuperFruit superFruit = new SuperFruit(10, 10, superFruitSprite);
        superFruit.changeSprite(superFruitSprite, superFruitSpriteLight, timerFrames);
        assertEquals(superFruitSpriteLight, superFruit.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void changeSpriteTest2ndSprite() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        PImage superFruitSpriteLight = app.loadImage(sourceLibrary + "superFruitLight.png");
        int timerFrames = 21;
        SuperFruit superFruit = new SuperFruit(10, 10, superFruitSprite);
        superFruit.changeSprite(superFruitSprite, superFruitSpriteLight, timerFrames);
        assertEquals(superFruitSprite, superFruit.getSprite(), "Incorrect sprite displayed.");
    }
}
