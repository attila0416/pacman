package ghost;

import org.junit.jupiter.api.Test;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static processing.core.PConstants.*;

public class PlayerTest {
    @Test
    public void moveUpTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage playerUpSprite = app.loadImage(sourceLibrary + "playerUp.png");

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");
        player.moveUp(playerUpSprite);
        assertEquals(playerUpSprite, player.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void moveRightTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage playerRightSprite = app.loadImage(sourceLibrary + "playerRight.png");

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");
        player.moveRight(playerRightSprite);
        assertEquals(playerRightSprite, player.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void moveDownTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage playerDownSprite = app.loadImage(sourceLibrary + "playerDown.png");

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");
        player.moveDown(playerDownSprite);
        assertEquals(playerDownSprite, player.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void moveLeftTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage playerLeftSprite = app.loadImage(sourceLibrary + "playerLeft.png");

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");
        player.moveLeft(playerLeftSprite);
        assertEquals(playerLeftSprite, player.getSprite(), "Incorrect sprite displayed.");
    }

    @Test
    public void getLifePointsTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertEquals(lifePoints, player.getLifePoints(), "Incorrect returned variable.");
    }

    @Test
    public void isAliveTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");
    }

    @Test
    public void setAliveTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.setAlive(false);
        assertFalse(player.isAlive(), "Incorrect boolean state of variable alive.");
    }

    @Test
    public void checkCollideFruitFalseTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(50, 10, fruitSprite);
        fruits.add(fruit);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideFruit();
        assertFalse(fruit.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideFruitTrueTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        Fruit fruit = new Fruit(10, 10, fruitSprite);
        fruits.add(fruit);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideFruit();
        assertTrue(fruit.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideSuperFruitFalseTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        SuperFruit superFruit = new SuperFruit(50, 10, superFruitSprite);
        superFruits.add(superFruit);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideSuperFruitTrueTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 10;
        long yValue = 10;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        SuperFruit superFruit = new SuperFruit(10, 10, superFruitSprite);
        superFruits.add(superFruit);
        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(100, 100, ghostSprite, ghostFrightenedSprite, 1, 10);
        ghosts.add(ghost);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");
        superFruit.setEaten(true);
        player.checkCollideSuperFruit();
        assertTrue(ghost.isFrightened(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideSuperFruitAllFalseTests() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        SuperFruit superFruit = new SuperFruit(50, 100, superFruitSprite);
        superFruits.add(superFruit);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(60);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(0);
        superFruit.setY(30);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(30);
        superFruit.setY(0);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(0);
        superFruit.setY(0);
        player.checkCollideSuperFruit();
        assertFalse(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideSuperFruitAllTrueTests() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        SuperFruit superFruit = new SuperFruit(50, 50, superFruitSprite);
        superFruits.add(superFruit);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setY(60);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(60);
        superFruit.setY(50);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(50);
        superFruit.setY(40);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");

        superFruit.setX(40);
        superFruit.setY(50);
        player.checkCollideSuperFruit();
        assertTrue(superFruit.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideGhostAllTrueTests() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(50, 50, ghostSprite, ghostFrightenedSprite, 1, 10);
        ghosts.add(ghost);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideGhost();
        assertFalse(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(60);
        player.checkCollideGhost();
        assertFalse(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(60);
        ghost.setY(50);
        player.checkCollideGhost();
        assertFalse(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(50);
        ghost.setY(40);
        player.checkCollideGhost();
        assertFalse(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(40);
        ghost.setY(50);
        player.checkCollideGhost();
        assertFalse(ghost.isEaten(), "Incorrect boolean state of variable alive.");


        ghost.setFrightened(true);
        ghost.setX(50);
        ghost.setY(60);
        player.checkCollideGhost();
        assertTrue(ghost.isEaten(), "Incorrect boolean state of variable eaten.");

        ghost.setX(60);
        ghost.setY(50);
        player.checkCollideGhost();
        assertTrue(ghost.isEaten(), "Incorrect boolean state of variable eaten.");

        ghost.setX(50);
        ghost.setY(40);
        player.checkCollideGhost();
        assertTrue(ghost.isEaten(), "Incorrect boolean state of variable eaten.");

        ghost.setX(40);
        ghost.setY(50);
        player.checkCollideGhost();
        assertTrue(ghost.isEaten(), "Incorrect boolean state of variable eaten.");
    }

    @Test
    public void checkCollideGhostAllFalseTests() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage ghostSprite = app.loadImage(sourceLibrary + "ghost.png");
        PImage ghostFrightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        Ghost ghost = new Ghost(100, 100, ghostSprite, ghostFrightenedSprite, 1, 10);
        ghosts.add(ghost);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(0);
        ghost.setY(0);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(0);
        ghost.setY(50);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(50);
        ghost.setY(0);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(100);
        ghost.setY(50);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");

        ghost.setX(50);
        ghost.setY(100);
        player.checkCollideGhost();
        assertTrue(player.isAlive(), "Incorrect boolean state of variable alive.");
    }

    @Test
    public void checkIfValidMovementUpTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 60;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 50, wallSprite);
        walls.add(wall);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);

        boolean actual = player.checkIfValidMovement(UP, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertFalse(actual, "Incorrect returned boolean value.");

        player.setX(50);
        player.setY(80);
        actual = player.checkIfValidMovement(UP, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertTrue(actual, "Incorrect returned boolean value.");
    }


    @Test
    public void checkIfValidMovementDownTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 50;
        long yValue = 40;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 50, wallSprite);
        walls.add(wall);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);

        boolean actual = player.checkIfValidMovement(DOWN, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertFalse(actual, "Incorrect returned boolean value.");

        player.setX(50);
        player.setY(20);
        actual = player.checkIfValidMovement(DOWN, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertTrue(actual, "Incorrect returned boolean value.");
    }

    @Test
    public void checkIfValidMovementRightTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 40;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 50, wallSprite);
        walls.add(wall);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);

        boolean actual = player.checkIfValidMovement(RIGHT, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertFalse(actual, "Incorrect returned boolean value.");

        player.setX(20);
        player.setY(50);
        actual = player.checkIfValidMovement(RIGHT, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertTrue(actual, "Incorrect returned boolean value.");
    }

    @Test
    public void checkIfValidMovementLeftTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();
        String sourceLibrary = "src/main/resources/";

        long xValue = 60;
        long yValue = 50;
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 50, wallSprite);
        walls.add(wall);

        Player player = new Player(xValue, yValue, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);

        boolean actual = player.checkIfValidMovement(LEFT, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertFalse(actual, "Incorrect returned boolean value.");

        player.setX(80);
        player.setY(50);
        actual = player.checkIfValidMovement(LEFT, RIGHT, LEFT, DOWN, UP, 0, 0);
        assertTrue(actual, "Incorrect returned boolean value.");
    }

    @Test
    public void tickTest() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 80, wallSprite);
        walls.add(wall);

        Player player = new Player(50, 50, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        PImage playerRightSprite = app.loadImage(sourceLibrary + "playerRight.png");
        PImage playerLeftSprite = app.loadImage(sourceLibrary + "playerLeft.png");
        PImage playerDownSprite = app.loadImage(sourceLibrary + "playerDown.png");
        PImage playerUpSprite = app.loadImage(sourceLibrary + "playerUp.png");

        player.setCurrentKey(0);
        player.tick(UP, true, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);

        assertEquals(UP, player.getCurrentKey(), "Incorrect value of variable currentKey.");

        player.setCurrentKey(DOWN);
        player.tick(LEFT, true, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(LEFT, player.getCurrentKey(), "Incorrect value of variable currentKey.");

        wall.setY(50);
        player.setCurrentKey(DOWN);
        player.tick(RIGHT, true, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(RIGHT, player.getNextKey(), "Incorrect value of variable nextKey.");

        wall.setY(80);
        player.setCurrentKey(RIGHT);
        player.setNextKey(DOWN);
        player.tick(DOWN, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(0, player.getNextKey(), "Incorrect value of variable nextKey.");

        player.setNextKey(RIGHT);
        player.tick(0, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(0, player.getNextKey(), "Incorrect value of variable nextKey.");

        player.setNextKey(RIGHT);
        player.tick(0, true, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(0, player.getNextKey(), "Incorrect value of variable nextKey.");

        player.setNextKey(DOWN);
        player.tick(DOWN, true, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 300);
        assertEquals(0, player.getNextKey(), "Incorrect value of variable nextKey.");
    }

    @Test
    public void tickTestCorrectSprites() {
        App app = new App();
        PApplet.runSketch(new String[]{"Test Sketch"}, app);
        app.settings();

        String sourceLibrary = "src/main/resources/";
        PImage playerClosedSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        long speed = 1;
        List<LifePoint> lifePoints = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<SuperFruit> superFruits = new ArrayList<>();
        List<Ghost> ghosts = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        PImage wallSprite = app.loadImage(sourceLibrary + "vertical.png");
        Wall wall = new Wall(50, 80, wallSprite);
        walls.add(wall);

        Player player = new Player(50, 50, playerClosedSprite, speed, lifePoints, fruits, superFruits, ghosts, walls);
        PImage playerRightSprite = app.loadImage(sourceLibrary + "playerRight.png");
        PImage playerLeftSprite = app.loadImage(sourceLibrary + "playerLeft.png");
        PImage playerDownSprite = app.loadImage(sourceLibrary + "playerDown.png");
        PImage playerUpSprite = app.loadImage(sourceLibrary + "playerUp.png");

        player.setCurrentKey(RIGHT);
        player.tick(RIGHT, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 1);

        assertEquals(playerRightSprite, player.getSprite(), "Incorrect sprite displayed.");

        player.setCurrentKey(RIGHT);
        player.tick(RIGHT, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 15);

        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");


        player.setCurrentKey(LEFT);
        player.tick(LEFT, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 1);

        assertEquals(playerLeftSprite, player.getSprite(), "Incorrect sprite displayed.");

        player.setCurrentKey(LEFT);
        player.tick(LEFT, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 15);

        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");


        player.setCurrentKey(UP);
        player.tick(UP, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 1);

        assertEquals(playerUpSprite, player.getSprite(), "Incorrect sprite displayed.");

        player.setCurrentKey(UP);
        player.tick(UP, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 15);

        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");


        player.setCurrentKey(DOWN);
        player.tick(DOWN, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 1);

        assertEquals(playerDownSprite, player.getSprite(), "Incorrect sprite displayed.");

        player.setCurrentKey(DOWN);
        player.tick(DOWN, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 15);

        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");


        player.setCurrentKey(DOWN);
        player.tick(DOWN, false, playerRightSprite, playerLeftSprite, playerDownSprite, playerUpSprite,
                playerClosedSprite, RIGHT, LEFT, DOWN, UP, 15);

        assertEquals(playerClosedSprite, player.getSprite(), "Incorrect sprite displayed.");
    }
}
