package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

public class GameObjectTest {
    @Test
    public void getXTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        long xValue = 10;
        long yValue = 10;
        Wall wall = new Wall(xValue, yValue, wallSprite);

        assertEquals(xValue, wall.getX(), "Incorrect value for variable x.");
    }

    @Test
    public void setXTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        long xValue = 10;
        long yValue = 10;
        Wall wall = new Wall(xValue, yValue, wallSprite);
        long newXValue = 20;
        wall.setX(newXValue);

        assertEquals(newXValue, wall.getX(), "Incorrect value for variable x.");
    }

    @Test
    public void getYTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        long xValue = 10;
        long yValue = 10;
        Wall wall = new Wall(xValue, yValue, wallSprite);

        assertEquals(yValue, wall.getY(), "Incorrect value for variable y.");
    }

    @Test
    public void setYTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        long xValue = 10;
        long yValue = 10;
        Wall wall = new Wall(xValue, yValue, wallSprite);
        long newYValue = 20;
        wall.setY(newYValue);

        assertEquals(newYValue, wall.getY(), "Incorrect value for variable y.");
    }

    @Test
    public void getSpriteTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        Wall wall = new Wall(10, 10, wallSprite);

        assertEquals(wallSprite, wall.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void setSpriteTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        Wall wall = new Wall(10, 10, wallSprite);

        PImage newWallSprite = app.loadImage(sourceLibrary + "vertical.png");
        wall.setSprite(newWallSprite);

        assertEquals(newWallSprite, wall.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void getSpriteWidthTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        Wall wall = new Wall(10, 10, wallSprite);
        long horizontalSpriteWidth = 16;

        assertEquals(horizontalSpriteWidth, wall.getWidth(), "Incorrect sprite width.");
    }

    @Test
    public void getSpriteHeightTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage wallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        Wall wall = new Wall(10, 10, wallSprite);
        long horizontalSpriteHeight = 16;

        assertEquals(horizontalSpriteHeight, wall.getHeight(), "Incorrect sprite height.");
    }
}
