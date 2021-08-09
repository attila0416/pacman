package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.*;

public class LifePointTest {
    @Test
    public void IsAliveTrueTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage lifePointSprite = app.loadImage(sourceLibrary + "playerRight.png");
        LifePoint lifePoint = new LifePoint(10, 10, lifePointSprite);

        assertTrue(lifePoint.isAlive(), "Incorrect boolean state for variable alive.");
    }

    @Test
    public void IsAliveFalseTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage lifePointSprite = app.loadImage(sourceLibrary + "playerRight.png");
        LifePoint lifePoint = new LifePoint(10, 10, lifePointSprite);
        lifePoint.setAlive(false);
        assertFalse(lifePoint.isAlive(), "Incorrect boolean state for variable alive.");
    }
}
