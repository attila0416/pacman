package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static processing.core.PConstants.*;

public class GameTest {
    @Test
    public void checkForDefeatTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();
        player.getLifePoints().get(0).setAlive(false);
        player.getLifePoints().get(1).setAlive(false);
        player.getLifePoints().get(2).setAlive(false);

        assertTrue(game.checkForDefeat(), "Incorrect returned boolean value.");
    }

    @Test
    public void fullGameResetTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();
        player.getLifePoints().get(0).setAlive(false);
        player.getLifePoints().get(1).setAlive(false);
        player.getLifePoints().get(2).setAlive(false);

        game.setIsRunning(false);
        game.setGameWon(true);
        game.setTimerFrames(700);

        game.fullGameReset();

        assertTrue(game.getIsRunning(), "Incorrect returned boolean value.");
        assertFalse(game.getGameWon(), "Incorrect returned boolean value.");
        assertEquals(0, game.getTimerFrames(), "Incorrect value of variable timerFrames");

        player = game.getPlayer();
        assertTrue(player.getLifePoints().get(0).isAlive(), "Incorrect returned boolean value.");
        assertTrue(player.getLifePoints().get(1).isAlive(), "Incorrect returned boolean value.");
        assertTrue(player.getLifePoints().get(2).isAlive(), "Incorrect returned boolean value.");
    }

    @Test
    public void gameResetTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();
        player.getLifePoints().get(0).setAlive(true);
        player.getLifePoints().get(1).setAlive(false);
        player.getLifePoints().get(2).setAlive(false);

        game.setIsRunning(false);
        game.setGameWon(true);
        game.setTimerFrames(700);

        game.gameReset();

        assertTrue(game.getIsRunning(), "Incorrect returned boolean value.");
        assertFalse(game.getGameWon(), "Incorrect returned boolean value.");
        assertEquals(0, game.getTimerFrames(), "Incorrect value of variable timerFrames");

        player = game.getPlayer();
        assertTrue(player.getLifePoints().get(0).isAlive(), "Incorrect returned boolean value.");
        assertFalse(player.getLifePoints().get(1).isAlive(), "Incorrect returned boolean value.");
        assertFalse(player.getLifePoints().get(2).isAlive(), "Incorrect returned boolean value.");
    }

    @Test
    public void checkForLifeLostTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();
        player.getLifePoints().get(0).setAlive(true);
        player.getLifePoints().get(1).setAlive(false);
        player.getLifePoints().get(2).setAlive(false);
        player.setAlive(false);

        assertTrue(game.checkForLifeLost(), "Incorrect returned boolean value.");

        player = game.getPlayer();
        player.getLifePoints().get(0).setAlive(false);
        player.getLifePoints().get(1).setAlive(false);
        player.getLifePoints().get(2).setAlive(false);
        player.setAlive(false);
        assertFalse(game.checkForLifeLost(), "Incorrect returned boolean value.");
    }

    @Test
    public void checkForVictoryTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();

        assertFalse(game.checkForVictory(), "Incorrect returned boolean value.");

        game.setFruitCount(0);

        assertTrue(game.checkForVictory(), "Incorrect returned boolean value.");
    }

    @Test
    public void drawTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        Game game = new Game();
        game.setupGame(app);
        Player player = game.getPlayer();

        game.setIsRunning(false);
        game.setGameWon(true);
        game.setTimerFrames(10);
        game.draw(app, UP, true, RIGHT, LEFT, DOWN, UP, 1);
        assertFalse(game.getGameWon(), "Incorrect returned boolean value.");

        game.setTimerFrames(10);
        game.setIsRunning(false);
        game.setGameLost(true);
        game.draw(app, UP, true, RIGHT, LEFT, DOWN, UP, 1);
        assertFalse(game.getGameLost(), "Incorrect returned boolean value.");

        game.setIsRunning(false);
        game.setTimerFrames(1);
        game.setLifeLost(true);
        game.draw(app, UP, true, RIGHT, LEFT, DOWN, UP, 1);
        assertTrue(game.getIsRunning(), "Incorrect returned boolean value.");
    }
}
