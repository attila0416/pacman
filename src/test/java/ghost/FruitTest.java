package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {
    @Test
    public void IsEatenFalseTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(10, 10, fruitSprite);
        assertFalse(fruit.isEaten(), "Incorrect boolean state for variable eaten.");
    }

    @Test
    public void IsEatenTrueTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(10, 10, fruitSprite);
        fruit.setEaten(true);
        assertTrue(fruit.isEaten(), "Incorrect boolean state for variable eaten.");
    }

    @Test
    public void IsCountedForFalseTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(10, 10, fruitSprite);
        assertFalse(fruit.isCountedFor(), "Incorrect boolean state for variable countedFor.");
    }

    @Test
    public void IsCountedForTrueTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(10, 10, fruitSprite);
        fruit.setCountedFor(true);
        assertTrue(fruit.isCountedFor(), "Incorrect boolean state for variable countedFor.");
    }
}
