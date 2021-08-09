package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {
    @Test
    public void correctSpriteDisplayedTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        List<PImage> wallSprites = new ArrayList<>();
        String sourceLibrary = "src/main/resources/";
        PImage wallSprite1 = app.loadImage(sourceLibrary + "horizontal.png");
        PImage wallSprite2 = app.loadImage(sourceLibrary + "vertical.png");
        PImage wallSprite3 = app.loadImage(sourceLibrary + "upLeft.png");
        PImage wallSprite4 = app.loadImage(sourceLibrary + "upRight.png");
        PImage wallSprite5 = app.loadImage(sourceLibrary + "downLeft.png");
        PImage wallSprite6 = app.loadImage(sourceLibrary + "downRight.png");
        wallSprites.add(wallSprite1);
        wallSprites.add(wallSprite2);
        wallSprites.add(wallSprite3);
        wallSprites.add(wallSprite4);
        wallSprites.add(wallSprite5);
        wallSprites.add(wallSprite6);
        for (PImage wallSprite : wallSprites) {
            Wall wall = new Wall(10, 10, wallSprite);
            assertEquals(wallSprite, wall.getSprite(), "Incorrect sprite displayed.");
        }
    }
}
