package ghost;

import processing.core.PImage;

import java.util.List;

/**
 * Represents Player object, which is the main processing, calculations, loading, and setting up variables within the
 * application.
 */
public class Player extends GameObject {
    private final static int MOUTH_MOVEMENT_SPEED = 20;
    private final List<LifePoint> lifePoints;
    private final List<Fruit> fruits;
    private final List<SuperFruit> superFruits;
    private final List<Ghost> ghosts;
    private final List<Wall> walls;

    private long speed;
    private boolean alive;
    private int currentKey;
    private int nextKey;
    private boolean isValidMovement;

    public Player(long x, long y, PImage sprite, long speed, List<LifePoint> lifePoints, List<Fruit> fruits,
                  List<SuperFruit> superFruits, List<Ghost> ghosts, List<Wall> walls) {
        super(x, y, sprite);
        this.speed = speed;
        this.lifePoints = lifePoints;
        this.alive = true;
        this.fruits = fruits;
        this.superFruits = superFruits;
        this.ghosts = ghosts;
        this.walls = walls;
        this.currentKey = 0;
        this.nextKey = 0;
        this.isValidMovement = false;
    }

    /**
     * Processes all the possible actions of the Player object. The player can move up, down, right, left, right,
     * while continuously changing sprites, but it cannot go through Wall objects.
     * It stops when it comes in contact with a Wall object.
     * <p>
     * It also stores the next move, which is processed if the player is able to move in that given direction.
     */
    public void tick(int keyCode, boolean keyPressed,
                     PImage rightPlayerSprite, PImage leftPlayerSprite, PImage downPlayerSprite, PImage upPlayerSprite,
                     PImage closedPlayerSprite, int right, int left, int down, int up, long timerFrames) {
        checkCollideSuperFruit();
        checkCollideFruit();
        checkCollideGhost();

        if (keyPressed && (keyCode == right || keyCode == left || keyCode == up || keyCode == down)) {
            if (this.currentKey == 0) {
                this.currentKey = keyCode;
            } else {
                this.isValidMovement = checkIfValidMovement(keyCode, right, left, down, up, 5, 6);
                if (isValidMovement) {
                    this.currentKey = keyCode;
                } else {
                    this.nextKey = keyCode;
                }
            }
        }
        if (this.nextKey != 0) {
            this.isValidMovement = checkIfValidMovement(this.nextKey, right, left, down, up, 5, 6);
            if (isValidMovement) {
                this.currentKey = this.nextKey;
                this.nextKey = 0;
            }
        }
        this.isValidMovement = checkIfValidMovement(this.currentKey, right, left, down, up, 5, 8);
        if (isValidMovement) {
            this.speed = 1;
        } else {
            this.speed = 0;
        }

        if (this.currentKey == 0) {
            if (timerFrames < 60) {
                if (timerFrames % MOUTH_MOVEMENT_SPEED <= MOUTH_MOVEMENT_SPEED / 2) {
                    this.setSprite(leftPlayerSprite);
                } else {
                    this.setSprite(closedPlayerSprite);
                }
            } else {
                this.currentKey = left;
            }
        }
        if (this.currentKey != 0) {
            if (this.currentKey == right) {
                if (timerFrames % MOUTH_MOVEMENT_SPEED <= MOUTH_MOVEMENT_SPEED / 2) {
                    this.moveRight(rightPlayerSprite);
                } else {
                    this.moveRight(closedPlayerSprite);
                }
            } else if (this.currentKey == left) {
                if (timerFrames % MOUTH_MOVEMENT_SPEED <= MOUTH_MOVEMENT_SPEED / 2) {
                    this.moveLeft(leftPlayerSprite);
                } else {
                    this.moveLeft(closedPlayerSprite);
                }

            } else if (this.currentKey == down) {
                if (timerFrames % MOUTH_MOVEMENT_SPEED <= MOUTH_MOVEMENT_SPEED / 2) {
                    this.moveDown(downPlayerSprite);
                } else {
                    this.moveDown(closedPlayerSprite);
                }
            } else {
                if (timerFrames % MOUTH_MOVEMENT_SPEED <= MOUTH_MOVEMENT_SPEED / 2) {
                    this.moveUp(upPlayerSprite);
                } else {
                    this.moveUp(closedPlayerSprite);
                }
            }
        }
    }

    /**
     * Draws the Player object to the canvas.
     */
    public void draw(App app) {
        // Handling graphics
        app.image(this.getSprite(), this.getX(), this.getY());
    }

    /**
     * Changes sprite to look upwards and the player moves in an upward direction.
     */
    public void moveUp(PImage newSprite) {
        this.setSprite(newSprite);
        this.setY(this.getY() - this.speed);
    }

    /**
     * Changes sprite to look downwards and the player moves in a downward direction.
     */
    public void moveDown(PImage newSprite) {
        this.setSprite(newSprite);
        this.setY(this.getY() + this.speed);
    }

    /**
     * Changes sprite to look to the left and the player moves in the left direction.
     */
    public void moveLeft(PImage newSprite) {
        this.setSprite(newSprite);
        this.setX(this.getX() - this.speed);
    }

    /**
     * Changes sprite to look to the right and the player moves in the right direction.
     */
    public void moveRight(PImage newSprite) {
        this.setSprite(newSprite);
        this.setX(this.getX() + this.speed);
    }

    /**
     * @return A List of LifePoint objects that represent the health of the Player object.
     */
    public List<LifePoint> getLifePoints() {
        return this.lifePoints;
    }

    /**
     * @return The boolean state of the variable alive.
     */
    public boolean isAlive() {
        return this.alive;
    }

    /**
     * Changes the boolean state of the variable alive.
     */
    public void setAlive(boolean newState) {
        this.alive = newState;
    }

    /**
     * Checks whether or not the Player object has collided with a Fruit object and based on that it updates
     * the Fruit object's boolean variable eaten.
     */
    public void checkCollideFruit() {
        long adjustment = 7;
        for (Fruit fruit : this.fruits) {
            long fruitLeft = fruit.getX();
            long fruitRight = fruit.getX() + fruit.getWidth();
            long fruitTop = fruit.getY();
            long fruitBottom = fruit.getY() + fruit.getHeight();

            long playerLeft = this.getX() + adjustment;
            long playerRight = this.getX() - adjustment + this.getWidth();
            long playerTop = this.getY() + adjustment;
            long playerBottom = this.getY() - adjustment + this.getHeight();

            if (playerRight > fruitLeft && playerLeft < fruitRight &&
                    playerBottom > fruitTop && playerTop < fruitBottom) {
                fruit.setEaten(true);
            }
        }
    }

    /**
     * Checks whether or not the Player object has collided with a SuperFruit object and based on that it updates
     * the Fruit object's boolean variable eaten and the Ghost objects' boolean variable frightened.
     */
    public void checkCollideSuperFruit() {
        long adjustment = 7;
        for (SuperFruit superFruit : this.superFruits) {
            long superFruitLeft = superFruit.getX();
            long superFruitRight = superFruit.getX() + superFruit.getWidth();
            long superFruitTop = superFruit.getY();
            long superFruitBottom = superFruit.getY() + superFruit.getHeight();

            long playerLeft = this.getX() + adjustment;
            long playerRight = this.getX() - adjustment + this.getWidth();
            long playerTop = this.getY() + adjustment;
            long playerBottom = this.getY() - adjustment + this.getHeight();

            if (playerRight > superFruitLeft && playerLeft < superFruitRight &&
                    playerBottom > superFruitTop && playerTop < superFruitBottom) {
                if (!superFruit.isEaten()) {
                    for (Ghost ghost : this.ghosts) {
                        ghost.setFrightened(true);
                    }
                }
                superFruit.setEaten(true);
            }
        }
    }

    /**
     * Checks whether or not the Player object has collided with a Ghost object.
     * If the Ghost object is frightened then the Player Object is able to eat it, otherwise the Player object dies
     * when it comes in contact with a Ghost object.
     */
    public void checkCollideGhost() {
        for (Ghost ghost : this.ghosts) {
            long ghostLeft = ghost.getX();
            long ghostRight = ghost.getX() + ghost.getWidth();
            long ghostTop = ghost.getY();
            long ghostBottom = ghost.getY() + ghost.getHeight();

            long playerLeft = this.getX();
            long playerRight = this.getX() + this.getWidth();
            long playerTop = this.getY();
            long playerBottom = this.getY() + this.getHeight();

            if (playerRight > ghostLeft && playerLeft < ghostRight &&
                    playerBottom > ghostTop && playerTop < ghostBottom) {
                if (ghost.isFrightened()) {
                    ghost.setEaten(true);
                } else {
                    this.alive = false;
                }
            }
        }
    }

    /**
     * @return Whether or not the Player object's next movement is valid by checking if it would collide with a
     * Wall object or not.
     */
    public boolean checkIfValidMovement(int keyCode, int right, int left, int down, int up, long adjustment,
                                        long positionCorrection) {
        for (Wall wall : this.walls) {
            long wallLeft = wall.getX();
            long wallRight = wall.getX() + wall.getWidth();
            long wallTop = wall.getY();
            long wallBottom = wall.getY() + wall.getHeight();

            long playerLeft = this.getX() + positionCorrection;
            long playerRight = this.getX() - positionCorrection + this.getWidth();
            long playerTop = this.getY() + positionCorrection;
            long playerBottom = this.getY() - positionCorrection + this.getHeight();

            if (keyCode == up) {
                playerTop -= adjustment;
                playerBottom -= adjustment;
            } else if (keyCode == down) {
                playerTop += adjustment;
                playerBottom += adjustment;
            } else if (keyCode == left) {
                playerLeft -= adjustment;
                playerRight -= adjustment;
            } else if (keyCode == right) {
                playerLeft += adjustment;
                playerRight += adjustment;
            }

            if (playerRight > wallLeft && playerLeft < wallRight &&
                    playerBottom > wallTop && playerTop < wallBottom) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return The current key, which is what the Player objects movement is based on.
     */
    public int getCurrentKey(){
        return this.currentKey;
    }

    /**
     * Updates the current key to a new key.
     */
    public void setCurrentKey(int newKey) {
        this.currentKey = newKey;
    }

    /**
     * @return The last key pressed.
     */
    public int getNextKey(){
        return this.nextKey;
    }

    /**
     * Updates the last key pressed.
     */
    public void setNextKey(int newKey) {
        this.nextKey = newKey;
    }
}
