package tetris;

import java.awt.Color;
import java.util.Random;

/**
 * Creates the blocks.
 * This hosts methods to spawn the block.
 * This hosts a verity of accessor methods for informaiton about the blocks.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class TetrisBlock {

    private int[][] shape;
    private Color color;
    private int x;
    private int y;
    private int[][][] shapes;

    /**
     * public varible to access the rotation
     */
    public int currentRotation;
    /**
     * public variable that accesses the colors of the Tetris blocks.
     */
    public Color[] availableColors = {Color.green, Color.red, Color.blue, Color.pink, Color.magenta, Color.yellow, Color.cyan};

    /**
     * Constructor that grabs the shape of the spawning block.
     * @param shape
     */
    public TetrisBlock(int[][] shape) {

        this.shape = shape;

        initShapes();

    }

    /**
     * Constructor that grabs the shape of the next block.
     * @param newBlock A block.
     */
    public TetrisBlock(TetrisBlock newBlock) {

        this.shape = newBlock.shape;

        initShapes();

    }

    /**
     * Rotates each shape.
     */
    public void initShapes() {
        shapes = new int[4][][];

        for (int i = 0; i < 4; i++) {
            int r = shape[0].length;
            int c = shape.length;

            shapes[i] = new int[r][c];

            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    shapes[i][y][x] = shape[c - x - 1][y];
                }
            }
            shape = shapes[i];
        }
    }


    /**
     * Spawns the block in the middle of the screen.
     * Sets the rotation of the block to the fist iteration.
     * @param gridWidth Columns of the grid.
     */
    public void spawn(int gridWidth) {
        shape = shapes[0];
        y = -getHeight();
        x = gridWidth / 2 - 1;

    }

    /**
     * This will set the color of a block.
     * @return Randomly chosen color.
     */
    public Color setColor() {

        Random r = new Random();

        color = availableColors[r.nextInt(availableColors.length)];
        return color;
    }
    /**
     * @return color is current color.
     */
    public Color setColorBlock(Color color) {

        this.color = color;
        return this.color;
    }

    /**
     * Accesses the shape of a block.
     * @return Shape The shape of the block.
     */
    public int[][] getShape() {
        return shape;
    }

    /**
     * Accesses the color of a block.
     * @return The color of the block.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Accesses the height of a block.
     * @return The height of the block.
     */
    public int getHeight() {

        return shape.length;

    }

    /**
     * Accesses the width of a block.
     * @return The width of the block.
     */
    public int getWidth() {
        return shape[0].length;
    }

    /**
     * Accesses the X position of the block.
     * @return The X position of the block.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x position of the block.
     * @param newX The desired X position of the block.
     */
    public void setX(int newX) {
        x = newX;
    }

    /**
     * Accesses the Y position of the block.
     * @return The Y position of the block.
     */
    public int getY() {

        return y;
    }

    /**
     * Sets the x position of the block.
     * @param newY The desired X position of the block.
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * Moves the block down.
     */
    public void moveDown() {

        y++;
    }

    /**
     * Moves the block left.
     */
    public void moveLeft() {

        x--;
    }

    /**
     * Moves the block right.
     */
    public void moveRight() {

        x++;
    }

    /**
     * Cycles to the next block rotation.
     */
    public void rotate() {
        currentRotation++;
        if (currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }

    /**
     * Cycles to the previous block rotation.
     */
    public void rotateBack() {
        currentRotation--;
        if (currentRotation < 0) {
            currentRotation = 3;
        }
        shape = shapes[currentRotation];
    }


    /**
     * Accesses the bottom position of the block
     * @return The bottom position of the block.
     */
    public int getBottomEdge() {

        return y + getHeight();
    }


    /**
     * Accesses the left edge of a block.
     * @return The left edge of a block.
     */
    public int getLeftEdge() {

        return x;
    }

    /**
     * Accesses the right edge of a block.
     * @return The right edge of a block.
     */
    public int getRightEdge() {
        return x + getWidth();
    }

}
