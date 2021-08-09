package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

public class GhostTest {
    @Test
    public void isFrightenedTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);

        assertFalse(ghost.isFrightened(), "Incorrect boolean state for variable frightened.");
    }

    @Test
    public void setFrightenedTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        ghost.setFrightened(true);

        assertTrue(ghost.isFrightened(), "Incorrect boolean state for variable frightened.");
    }

    @Test
    public void isEatenTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);

        assertFalse(ghost.isEaten(), "Incorrect boolean state for variable eaten.");
    }

    @Test
    public void setEatenTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        ghost.setEaten(true);

        assertTrue(ghost.isEaten(), "Incorrect boolean state for variable eaten.");
    }

    @Test
    public void spriteSwitchTestBefore5Seconds() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        int timerFrames = 60 * 4;
        ghost.setFrightened(true);
        ghost.spriteSwitch(timerFrames);

        assertEquals(ghostFrightenedSprite, ghost.getSprite(), "Incorrect sprite displayed.");
        ghost.setFrightened(false);
        ghost.spriteSwitch(timerFrames);
        assertEquals(ghostSprite, ghost.getSprite(), "Incorrect sprite displayed.");

    }

    @Test
    public void spriteSwitchTestAt5Seconds() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        int timerFrames = 300;
        ghost.setFrightened(true);
        ghost.spriteSwitch(timerFrames);

        assertEquals(ghostFrightenedSprite, ghost.getSprite(), "Incorrect sprite displayed.");
        ghost.setFrightened(false);
        ghost.spriteSwitch(timerFrames);
        assertEquals(ghostSprite, ghost.getSprite(), "Incorrect sprite displayed.");
        ghost.setFrightened(true);
        timerFrames = 350;
        ghost.spriteSwitch(timerFrames);
        assertEquals(ghostFrightenedSprite, ghost.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void spriteSwitchTestAfter5Seconds() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        int timerFrames = 500;
        ghost.setFrightened(true);
        ghost.spriteSwitch(timerFrames);

        assertEquals(ghostSprite, ghost.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void spriteSwitchTestAfterFrightenedMode() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(10, 10, ghostSprite, ghostFrightenedSprite, 1, 10);
        int timerFrames = 60 * 10;
        ghost.setFrightened(true);
        ghost.spriteSwitch(timerFrames);

        assertEquals(ghostSprite, ghost.getSprite(), "Incorrect sprite displayed.");
        assertFalse(ghost.isFrightened(), "Incorrect boolean state of variable frightened.");
        assertFalse(ghost.isEaten(), "Incorrect boolean state of variable eaten.");
    }
}
