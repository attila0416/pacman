package ghost;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import processing.core.PFont;
import processing.core.PImage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Represents Game object, which is the main processing, calculations, loading, and setting up variables within the application.
 */
public class Game {
    private final static int BLOCK_SIZE = 16;

    private Player player;
    private final List<Wall> walls;
    private final List<Fruit> fruits;
    private final List<SuperFruit> superFruits;
    private final List<LifePoint> lifePoints;
    private final List<Ghost> ghosts;

    private long defaultStartingXPosPlayer;
    private long defaultStartingYPosPlayer;
    private String defaultMapString;
    private long defaultNumberOfLives;
    private long defaultMovementSpeed;
    private long defaultFrightenedLength;
    private final List<Long> defaultModeLengthsArray;

    private PImage rightPlayerSprite;
    private PImage leftPlayerSprite;
    private PImage downPlayerSprite;
    private PImage upPlayerSprite;
    private PImage closedPlayerSprite;
    private PImage horizontalWallSprite;
    private PImage verticalWallSprite;
    private PImage upLeftWallSprite;
    private PImage upRightWallSprite;
    private PImage downLeftWallSprite;
    private PImage downRightWallSprite;
    private PImage fruitSprite;
    private PImage superFruitSprite;
    private PImage superFruitSpriteLight;
    private PImage frightenedSprite;
    private final List<PImage> ghostSprites;

    private List<String[]> mapStringGrid;
    private final HashMap<String, PImage> charactersOnMapLibrary;

    private PFont textFont;
    private int timerFrames;
    private int keyCode;


    private boolean isRunning;
    private int fruitCount;
    private boolean gameWon;
    private boolean lifeLost;
    private boolean gameLost;


    public Game() {
        this.player = null;
        this.ghosts = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.fruits = new ArrayList<>();
        this.superFruits = new ArrayList<>();
        this.lifePoints = new ArrayList<>();
        this.ghostSprites = new ArrayList<>();

        this.defaultMapString = null;
        this.defaultNumberOfLives = 0;
        this.defaultMovementSpeed = 0;
        this.defaultModeLengthsArray = new ArrayList<>();

        this.mapStringGrid = null;
        this.charactersOnMapLibrary = new HashMap<>();

        this.timerFrames = 0;

        this.isRunning = true;
        this.fruitCount = 0;
        this.gameWon = false;
        this.lifeLost = false;
        this.gameLost = false;
    }

    /**
     * Calls the draw method of each GameObject so that they are constantly drawn on the app's canvas.
     */
    public void draw(App app, int keyCode, boolean keyPressed, int right, int left, int down, int up, int targetFrameRate) {
        for (Wall wall : this.walls) {
            wall.draw(app);
        }
        for (Fruit fruit : this.fruits) {
            if (!fruit.isEaten()) {
                fruit.draw(app);
            }
        }
        for (SuperFruit superFruit : this.superFruits) {
            if (!superFruit.isEaten()) {
                superFruit.draw(app);
                superFruit.changeSprite(this.superFruitSprite, this.superFruitSpriteLight, this.timerFrames);
            } else if (superFruit.isEaten() && !superFruit.isCountedFor()) {
                this.timerFrames = 0;
            }
        }
        for (LifePoint lifePointElem : this.player.getLifePoints()) {
            if (lifePointElem.isAlive()) {
                lifePointElem.draw(app);
            }
        }

        if (this.isRunning) {
            if (keyPressed) {
                this.keyCode = keyCode;
            }
            gameWon = checkForVictory();
            lifeLost = checkForLifeLost();
            gameLost = checkForDefeat();

            for (Ghost ghost : this.ghosts) {
                if (!ghost.isEaten()) {
                    ghost.draw(app);
                }
                if (ghost.isFrightened()) {
                    ghost.spriteSwitch(this.timerFrames);
                }
            }
            this.player.tick(this.keyCode, keyPressed,
                    rightPlayerSprite, leftPlayerSprite, downPlayerSprite, upPlayerSprite, closedPlayerSprite,
                    right, left, down, up, this.timerFrames);
            this.player.draw(app);

        } else if (gameWon) {
            System.out.println(this.fruitCount);
            String victoryString = "YOU WIN";
            app.textFont(textFont);
            app.text(victoryString, 168, 338);
            if (this.timerFrames == 10 * targetFrameRate) {
                this.fullGameReset();
            }
        } else if (gameLost) {
            String victoryString = "GAME OVER";
            app.textFont(textFont);
            app.text(victoryString, 153, 338);
            if (this.timerFrames == 10 * targetFrameRate) {
                this.fullGameReset();
            }
        } else if (lifeLost) {
            if (this.timerFrames == targetFrameRate) {
                this.gameReset();
            }
        }

        this.timerFrames++;
    }

    /**
     * Sets up the game by calling all the necessary methods to initialise all variables used in the game.
     */
    public void setupGame(App app) {
        String path = "src/main/resources/PressStart2P-Regular.ttf";
        textFont = app.createFont(path, 16);

        boolean isLoaded = this.loadImages(app, "src/main/resources/");
        if (!isLoaded) {
            System.out.println("Could not load images");
            System.exit(0);
        } else {
            this.charactersOnMapLibrary.put("0", null);
            this.charactersOnMapLibrary.put("1", this.horizontalWallSprite);
            this.charactersOnMapLibrary.put("2", this.verticalWallSprite);
            this.charactersOnMapLibrary.put("3", this.upLeftWallSprite);
            this.charactersOnMapLibrary.put("4", this.upRightWallSprite);
            this.charactersOnMapLibrary.put("5", this.downLeftWallSprite);
            this.charactersOnMapLibrary.put("6", this.downRightWallSprite);
            this.charactersOnMapLibrary.put("7", this.fruitSprite);
            this.charactersOnMapLibrary.put("8", this.superFruitSprite);
            this.charactersOnMapLibrary.put("p", null);
            this.charactersOnMapLibrary.put("g", null);
        }
        boolean ableToReadFile = this.readFile("config.json");
        if (!ableToReadFile) {
            System.out.println("Was not able to read file");
            System.exit(0);
        }
        this.mapStringGrid = readInMap();

        this.setupMap();

        this.player = new Player(this.defaultStartingXPosPlayer, this.defaultStartingYPosPlayer, this.closedPlayerSprite,
                this.defaultMovementSpeed, this.lifePoints, this.fruits, this.superFruits, this.ghosts, this.walls);
    }

    /**
     * Reads in images that will be used as sprites for each GameObject.
     * @return Whether or not the images were successfully read in.
     */
    public boolean loadImages(App app, String sourceLibrary) {
        this.rightPlayerSprite = app.loadImage(sourceLibrary + "playerRight.png");
        this.leftPlayerSprite = app.loadImage(sourceLibrary + "playerLeft.png");
        this.downPlayerSprite = app.loadImage(sourceLibrary + "playerDown.png");
        this.upPlayerSprite = app.loadImage(sourceLibrary + "playerUp.png");
        this.closedPlayerSprite = app.loadImage(sourceLibrary + "playerClosed.png");
        this.horizontalWallSprite = app.loadImage(sourceLibrary + "horizontal.png");
        this.verticalWallSprite = app.loadImage(sourceLibrary + "vertical.png");
        this.upLeftWallSprite = app.loadImage(sourceLibrary + "upLeft.png");
        this.upRightWallSprite = app.loadImage(sourceLibrary + "upRight.png");
        this.downLeftWallSprite = app.loadImage(sourceLibrary + "downLeft.png");
        this.downRightWallSprite = app.loadImage(sourceLibrary + "downRight.png");
        this.fruitSprite = app.loadImage(sourceLibrary + "fruit.png");
        this.superFruitSprite = app.loadImage(sourceLibrary + "superFruit.png");
        this.superFruitSpriteLight = app.loadImage(sourceLibrary + "superFruitLight.png");
        PImage ambusherGhostSprite = app.loadImage(sourceLibrary + "ambusher.png");
        PImage chaserGhostSprite = app.loadImage(sourceLibrary + "chaser.png");
        PImage ignorantGhostSprite = app.loadImage(sourceLibrary + "ignorant.png");
        PImage whimGhostSprite = app.loadImage(sourceLibrary + "whim.png");
        this.frightenedSprite = app.loadImage(sourceLibrary + "frightened.png");
        this.ghostSprites.add(ambusherGhostSprite);
        this.ghostSprites.add(chaserGhostSprite);
        this.ghostSprites.add(ignorantGhostSprite);
        this.ghostSprites.add(whimGhostSprite);
        return this.rightPlayerSprite != null && this.leftPlayerSprite != null && this.downPlayerSprite != null &&
                this.upPlayerSprite != null && this.closedPlayerSprite != null && this.horizontalWallSprite != null &&
                this.verticalWallSprite != null && this.upLeftWallSprite != null && this.upRightWallSprite != null &&
                this.downLeftWallSprite != null && this.downRightWallSprite != null && this.fruitSprite != null &&
                this.superFruitSprite != null && chaserGhostSprite != null && ignorantGhostSprite != null &&
                whimGhostSprite != null && this.frightenedSprite != null;
    }

    /**
     * Reads in a JSON file that contains settings attributes needed for the game to fully function.
     * @return Whether or not the file was successfully read in.
     */
    public boolean readFile(String filename) {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(filename)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            this.defaultMapString = (String) jsonObject.get("map");
            this.defaultNumberOfLives = (long) jsonObject.get("lives");
            this.defaultMovementSpeed = (long) jsonObject.get("speed");
            this.defaultFrightenedLength = (long) jsonObject.get("frightenedLength");

            JSONArray modeLengthsJSONArray = (JSONArray) jsonObject.get("modeLengths");
            for (Object modeJSONObject : modeLengthsJSONArray) {
                this.defaultModeLengthsArray.add((Long) modeJSONObject);
            }

        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Reads in characters from a map text file.
     * @return A List of String arrays, which represent the lines of objects that will be displayed on the canvas.
     */
    public List<String[]> readInMap() {
        if (this.defaultMapString == null) {
            System.out.println("No map defined");
            System.exit(0);
        }
        File mapFile;
        Scanner scan = null;
        try {
            mapFile = new File(this.defaultMapString);
            scan = new Scanner(mapFile);
        } catch (FileNotFoundException e) {
            System.out.println("Map file not found");
            System.exit(0);
        }

        List<String[]> allElements = new ArrayList<>();
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            String[] elements = input.split("");
            allElements.add(elements);
        }
        return allElements;
    }

    /**
     * Sets up the Map by displaying every GameObject in their correct position.
     */
    public void setupMap() {
        long x = 0;
        long y = 0;
        boolean livesRowFound = false;

        int ghostCounter = 0;
        for (String[] row : mapStringGrid) {
            int isEmptyCounter = 0;
            for (String elem : row) {
                PImage currentSprite = this.charactersOnMapLibrary.get(elem);


                if (currentSprite == null) {
                    if (elem.equals("p")) {
                        this.defaultStartingXPosPlayer = x - 4;
                        this.defaultStartingYPosPlayer = y - 5;
                    } else if (elem.equals("g")) {
                        long startingXPosGhost = x - 5;
                        long startingYPosGhost = y - 6;
                        PImage currentGhostSprite = this.ghostSprites.get(ghostCounter);
                        Ghost ghost = new Ghost(startingXPosGhost, startingYPosGhost, currentGhostSprite,
                                this.frightenedSprite, this.defaultMovementSpeed, this.defaultFrightenedLength);
                        this.ghosts.add(ghost);
                        ghostCounter++;
                    }
                    isEmptyCounter++;
                } else {
                    if (elem.equals("7")) {
                        Fruit newFruit = new Fruit(x, y, currentSprite);
                        this.fruits.add(newFruit);
                        this.fruitCount += 1;
                    } else if (elem.equals("8")) {
                        SuperFruit newSuperFruit = new SuperFruit(x, y, currentSprite);
                        this.superFruits.add(newSuperFruit);
                        this.fruitCount += 1;
                    } else {
                        Wall newWall = new Wall(x, y, currentSprite);
                        walls.add(newWall);
                    }
                }
                x += BLOCK_SIZE;
            }
            if (this.defaultStartingXPosPlayer != 0 && !livesRowFound && isEmptyCounter == row.length) {
                livesRowFound = true;
                long tempX = 7;
                for (int i = 0; i < this.defaultNumberOfLives; i++) {
                    LifePoint newLife = new LifePoint(tempX, y, rightPlayerSprite);
                    this.lifePoints.add(newLife);
                    tempX += 30;
                }
            }
            y += BLOCK_SIZE;
            x = 0;
        }
    }

    /**
     * @return Whether or not the Player object has eaten all the Fruit and SuperFruit objects..
     */
    public boolean checkForVictory() {
        // check for win
        for (Fruit fruit : this.fruits) {
            if (fruit.isEaten() && !fruit.isCountedFor()) {
                this.fruitCount -= 1;
                fruit.setCountedFor(true);
            }
        }
        if (!this.superFruits.isEmpty()) {
            for (SuperFruit superFruit : this.superFruits) {
                if (superFruit.isEaten() && !superFruit.isCountedFor()) {
                    this.fruitCount -= 1;
                    superFruit.setCountedFor(true);
                }
            }
        }

        if (this.fruitCount == 0) {
            this.isRunning = false;
            this.timerFrames = 0;
            return true;
        }
        return false;
    }

    /**
     * @return Whether or not the Player object has lost a life.
     */
    public boolean checkForLifeLost() {
        if (!player.isAlive()) {
            for (int i = player.getLifePoints().size() - 1; i >= 0; i--) {
                boolean hasLifePoint = player.getLifePoints().get(i).isAlive();
                if (hasLifePoint) {
                    player.getLifePoints().get(i).setAlive(false);
                    this.isRunning = false;
                    this.timerFrames = 0;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return Whether or not the Player object has no more lives left.
     */
    public boolean checkForDefeat() {
        int lifePointCounter = 0;
        for (int i = 0; i < player.getLifePoints().size(); i++) {
            boolean hasLifePoint = player.getLifePoints().get(i).isAlive();
            if (hasLifePoint) {
                lifePointCounter++;
            }
        }
        return lifePointCounter == 0;
    }

    /**
     * Fulling resets the game with every variable reset to their original value and position.
     */
    public void fullGameReset() {
        this.keyCode = 0;
        for (Fruit fruit : this.fruits) {
            fruit.setEaten(false);
            fruit.setCountedFor(false);
            this.fruitCount += 1;
        }
        for (SuperFruit superFruit : this.superFruits) {
            superFruit.setEaten(false);
            superFruit.setCountedFor(false);
            this.fruitCount += 1;
        }
        for (Ghost ghost : this.ghosts) {
            ghost.setFrightened(false);
            ghost.setEaten(false);
            ghost.spriteSwitch(this.timerFrames);
        }
        this.player = new Player(this.defaultStartingXPosPlayer, this.defaultStartingYPosPlayer, this.closedPlayerSprite,
                this.defaultMovementSpeed, this.lifePoints, this.fruits, this.superFruits, this.ghosts, this.walls);
        for (int i = 0; i < player.getLifePoints().size(); i++) {
            player.getLifePoints().get(i).setAlive(true);
        }
        this.isRunning = true;
        this.gameWon = false;
        this.gameLost = false;
        this.timerFrames = 0;
    }

    /**
     * When the player dies, it resets the game without resetting the already eaten Fruit and SuperFruit objects and
     * not losing track of the lost lives.
     */
    public void gameReset() {
        this.keyCode = 0;
        player.setAlive(true);
        for (Ghost ghost : this.ghosts) {
            ghost.setFrightened(false);
        }
        this.player = new Player(this.defaultStartingXPosPlayer, this.defaultStartingYPosPlayer, this.closedPlayerSprite,
                this.defaultMovementSpeed, this.lifePoints, this.fruits, this.superFruits, this.ghosts, this.walls);

        this.isRunning = true;
        this.gameWon = false;

        this.timerFrames = 0;
    }

    /**
     * Getter for variable player.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Getter for variable isRunning.
     */
    public boolean getIsRunning() {
        return this.isRunning;
    }

    /**
     * Setter for variable isRunning.
     */
    public void setIsRunning(boolean newState) {
        this.isRunning = newState;
    }

    /**
     * Getter for variable gameWon.
     */
    public boolean getGameWon() {
        return this.gameWon;
    }

    /**
     * Setter for variable gameWon.
     */
    public void setGameWon(boolean newState) {
        this.gameWon = newState;
    }

    /**
     * Getter for variable timerFrames.
     */
    public int getTimerFrames() {
        return this.timerFrames;
    }

    /**
     * Setter for variable timerFrames.
     */
    public void setTimerFrames(int newTimerFrames) {
        this.timerFrames = newTimerFrames;
    }

    /**
     * Setter for variable fruitCount.
     */
    public void setFruitCount(int newFruitCount) {
        this.fruitCount = newFruitCount;
    }

    /**
     * Getter for variable gameLost.
     */
    public boolean getGameLost() {
        return this.gameLost;
    }

    /**
     * Setter for variable gameLost.
     */
    public void setGameLost(boolean newState) {
        this.gameLost = newState;
    }

    /**
     * Setter for variable lifeLost.
     */
    public void setLifeLost(boolean newState) {
        this.lifeLost = newState;
    }
}
