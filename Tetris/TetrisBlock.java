package tetris;

import java.awt.Color;
import java.util.Random;


public class TetrisBlock {

    private int[][] shape;
    private Color color;
    private int x, y;
    public int[][][] shapes;
    
    public int currentRotation;
    public Color[] availableColors = {Color.green, Color.red, Color.blue,Color.pink, Color.magenta, Color.yellow, Color.cyan};

    /**
     * Constructor that initializes the shape of the spawning block.
     * @param shape
     */
    public TetrisBlock(int[][] shape) {

        this.shape = shape;

        initShapes();

    }

    /**
     * Constructor that helps initialize the shape of the next block.
     * @param newBlock 
     */
    public TetrisBlock(TetrisBlock newBlock) {

        this.shape = newBlock.shape;

        initShapes();

    }

    /**
     * this allows each block to rotate a total of 4 times.
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
     * Randomly spawns the block in positions as well as random rotations.
     * Sets the starting pos of each spawned block
     * @param gridWidth
     */

    public void spawn(int gridWidth) {
        
        Random r = new Random();
        
    //currentRotation = r.nextInt(shapes.length);
    //shape = shapes[currentRotation];
        shape = shapes[0];
        
        y = -getHeight();
        x = gridWidth/2 - 1;
        
        

//        setColor();
//        color = availableColors[r.nextInt(availableColors.length)];

    }
    
    public Color setColor( ) {
        
        Random r = new Random();
        
        color = availableColors[r.nextInt(availableColors.length)];
        return color;
    }
    
    public Color setColor2(Color color) {
        
        this.color = color;
        return this.color; 
    }

    /**
     * Returns the shape of a block.
     * @return
     */

    public int[][] getShape() {
        return shape;
    }

    /**
     * return the color of a block.
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * returns the height of a block.
     * @return
     */
    public int getHeight() {
     
     return shape.length;

    }

    /**
     *returns the width of a block
     * @return
     */
    public int getWidth() {
        return shape[0].length;
    }

    /**
     *returns the x position of the block
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * returns the new set x position
     * @param newX
     */
    public void setX(int newX) {x = newX; }

    /**
     * returns the new set y position
     * @return
     */
    public int getY() {
        return y;
    }
     public void setY(int newY) { y = newY; }

    /**
     * Allows the block to move down
     */
    public void moveDown() {
        y++;
    }

    /**
     * Allows the block to move left
     */
    public void moveLeft() {
        x--;
    }

    /**
     * Allows the block to move right
     */
    public void moveRight() {
        x++;
    }

    /**
     * Responsible for cycling through different block rotations
     */
    //cycling through the different rotations 
    public void rotate() {
        currentRotation++;
        if (currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }

    /**
     * Rotates the block back to the previous position
     */
    public void rotateBack() {
        currentRotation--;
        if (currentRotation < 0) {
            currentRotation = 3;
        }
        shape = shapes[currentRotation];
    }


    /**
     * returns the bottom position of the block
     * @return
     */
    public int getBottomEdge() {
        return y + getHeight();
    }


    /**
     * returns the left edge of a block
     * @return
     */
    //returning the left edge of the block 
    public int getLeftEdge() {    
       
     return x;   
    }

    /**
     * returns the right edge of a block
     * @return
     */
    //returning the right edge of the block
    public int getRightEdge() {
        
        return x + getWidth();
    }

}