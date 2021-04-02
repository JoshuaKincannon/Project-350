package tetris;

import java.awt.Color;
import java.util.Random;

public class TetrisBlock {

    private int[][] shape;
    private Color color;
    private int x, y;
    private int[][][] shapes;
    public int currentRotation;
    private Color[] availableColors = {Color.green, Color.red, Color.blue};
    
    
    
    
    public TetrisBlock(int[][] shape) {

        this.shape = shape;

        initShapes();
        
    }

    //allowing each peice to rotate 
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

    
    //random spawning postitions as well as random rotations 
    //allows the block to begin falling above te game area and in the middle
    public void spawn(int gridWidth) {
        
        Random r = new Random();
        
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        
        y = -getHeight();
        x = r.nextInt(gridWidth - getWidth());
        
        color = availableColors[r.nextInt(availableColors.length)];
        
 
    }

    
    
    //Accessor methods for the block shape 
    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
     
     return shape.length;

    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }
    public void setX(int newX) {x = newX; }

    public int getY() {
        return y;
    }
     public void setY(int newY) { y = newY; }

    //moving the block left, right, down
    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }
    
    
    //cycling through the different rotations 
    public void rotate() {
        currentRotation++;
        if (currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }
    
     public void rotateBack() {
        currentRotation--;
        if (currentRotation < 0) {
            currentRotation = 3;
        }
        shape = shapes[currentRotation];
    }
    
    
    
    //returning the nottom edge of the block
    public int getBottomEdge() {
        return y + getHeight();
    }
    
    //returning the left edge of the block 
    public int getLeftEdge() {    
       
     return x;   
    }
    //returning the right edge of the block
    public int getRightEdge() {
        
        return x + getWidth();
    }
        
        
        
}
