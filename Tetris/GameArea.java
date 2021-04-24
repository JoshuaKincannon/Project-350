package tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/**
 * Contains main logic for block functionality.
 * Creates block boundaries, limitations, and movements.
 * Paints the background of the game area and each block that is spawned.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class GameArea extends JPanel {

    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    /**
     * this background variable is public to test the clear line funcitons
     */
    public static Color[][] background;
    private TetrisBlock[] blocks;
    private TetrisBlock block;
    private TetrisBlock nextBlock;
    private TetrisBlock tempBlock;

    /**
     * This public variable is contains the shape of the block being held.
     * This variable will be set to null in the GameForm class after returning the the menu.
     */
    public TetrisBlock holdBlock;

    /**
     * This is the constructor for the Game Area.
     * This initializes the grid columns, cell size, blocks, and boundaries.
     * and rows
     *
     * @param placeholder The JPanel the content is displayed on.
     * @param columns     The number of Columns in the game area.
     */
    public GameArea(JPanel placeholder, int columns) {
//        super();
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());

        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;

        blocks = new TetrisBlock[]{

                new IShape(), new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()

        };

    }

    /**
     * Getter method to return columns.
     * @return gridColumns
     */
    public int getGridColumns() {
    return gridColumns;
    }

    /**
     * Getter method to return current block.
     * @return block
     */
    public TetrisBlock getBlock() {
        return block;
    }

    /**
     *Getter method to return row count.
     * @return gridRows
     */
    public int getRowCount() {
        return gridRows;
    }

    /**
     * Getter method to return game background.
     * @return background
     */
    public static Color[][] getBackgroundGame() {
        return background;
    }

    /**
     * Accessor method used to access the next block.
     *
     * @return The shape of the next block.
     */
    public TetrisBlock getNext() {
        return nextBlock;
    }

    /**
     * initializes the background of the game area.
     */
    public void initBackGroundArray() {
        background = new Color[gridRows][gridColumns];

    }

    /**
     * Spawns a new block.
     * Generates a random block for the next block.
     * Spawns the next block after the current block is placed.
     */
    public void spawnBlock() {

        Random r = new Random();

        if (nextBlock == null) {

            nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            nextBlock.setColor();


            block = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            block.setColor();


        } else {
            block = new TetrisBlock(nextBlock);
            block.setColorBlock(nextBlock.getColor());

            nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            nextBlock.setColor();


        }
        block.spawn(gridColumns);
        repaint();
    }

    /**
     * Checking if the player has lost the game.
     * Check if a block is placed above the game area.
     *
     * @return False if the block is not out of bounds.
     */
    public boolean isBlockOutOfBounds() {

        if (block.getY() < 0) {
            block = null;
            return true;
        }
            return false;

    }

    /**
     * Allows for the a current piece to be held and used later.
     * Allows the player to store a block, or replace it with another.
     */
    public void hold() {
        int x;
        int y;

        Random r = new Random();

        if (holdBlock == null) {

            holdBlock = new TetrisBlock(block);
            holdBlock.setColorBlock(block.getColor());

            x = block.getX();
            y = block.getY();

            block = new TetrisBlock(nextBlock);
            block.setColorBlock(nextBlock.getColor());
            block.setX(x);
            block.setY(y);

            nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            nextBlock.setColor();
            repaint();

        } else {

            tempBlock = new TetrisBlock(block);
            tempBlock.setColorBlock(block.getColor());

            x = block.getX();
            y = block.getY();

            block = new TetrisBlock(holdBlock);
            block.setColorBlock(holdBlock.getColor());
            block.setX(x);
            block.setY(y);

            holdBlock = new TetrisBlock(tempBlock);
            holdBlock.setColorBlock(tempBlock.getColor());
            repaint();
        }

    }


    /**
     * Checking if the block can move down and moves down by 1.
     *
     * @return True if the block has reached the bottom.
     */
    public boolean moveBlockDown() {

        if (!checkBottom()) {

            return false;
        }
            block.moveDown();
            repaint();

            return true;
    }

    /**
     * Moves the block right.
     * Also checks if the block is able to move right.
     */
    public void moveBlockRight() {

        if (block == null) {
            return;
        }

        if (!checkRight()) {
            return;

        }
        block.moveRight();
        repaint();

}

    /**
     * Moves the block right.
     * Also checks if the block is able to move right.
     */
    public void moveBlockLeft() {

        if (block == null) {
            return;
        }

        if (!checkLeft()) {
            return;
        }
            block.moveLeft();
            repaint();

    }

    /**
     * Drops the block.
     * Checks if the block is able to drop.
     */
    public void drop() {
        if (block == null) {
            return;
        }
        if (checkBottom()) {
            block.moveDown();
        }

        repaint();
    }

    /**
     * Rotates the block
     * Checks if the block is rotating out of bounds
     * Checks if the block is rotating into another block.
     */
    public void rotate() {

        if (block == null) {
            return;
        }

        block.rotate();
        int[][] shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();


        if (block.getLeftEdge() < 0) {
            block.setX(0);
        }

        if (block.getRightEdge() >= gridColumns) {
            block.setX(gridColumns - block.getWidth());
        }

        if (block.getBottomEdge() >= gridRows) {
            block.setY(gridRows - block.getHeight());
        }


        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX();
                    int y = row + block.getY();
                    if (y < 0) {
                        break;
                    }

                    if (background[y][x] != null) {
                        block.rotateBack();
                        repaint();
                        return;
                    }

                }
            }
        }

        repaint();

    }

    /**
     * Checking if the block has landed on a block.
     * Checks if the block has reached the bottom.
     * @return False if the block is at the bottom.
     * @return True is the block is not at the bottom.
     */
    private boolean checkBottom() {

        if (block.getBottomEdge() == gridRows) {
            return false;
        }

        int[][] shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int col = 0; col < w; col++) {
            for (int row = h - 1; row >= 0; row--) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX();
                    int y = row + block.getY() + 1;
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null)
                        return false;
                    break;

                }
            }
        }

        return true;
    }


    /**
     * Checking if the current block is hitting a block to the right.
     * Checking if the current block is going out of bounds to the right.
     * @return False if the block cannot move left.
     * @return True if the block can move left.
     */
    private boolean checkLeft() {
        if (block.getLeftEdge() == 0) {
            return false;
        }
        int[][] shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX() - 1;
                    int y = row + block.getY();
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null)
                        return false;
                        break;
                }
            }
        }
        return true;

    }

    /**
     * Checking if the current block is hitting a block to the left.
     * checking if the current block is going out of bound to the left.
     * @return True if there is nothing to the right of the block.
     * @return False if there is something to the right of the block.
     */
    private boolean checkRight() {
        if (block.getRightEdge() == gridColumns) {
            return false;
        }

        int[][] shape = block.getShape();
        int w = block.getWidth();
        int h = block.getHeight();

        for (int row = 0; row < h; row++) {
            for (int col = w - 1; col >= 0; col--) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX() + 1;
                    int y = row + block.getY();
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null)
                        return false;
                        break;

                }
            }
        }
        return true;
    }


    /**
     * Displays the block once it has spawned.
     * @param g Passes a graphics parameter for the paintComponent method.
     */
    private void drawBlock(Graphics g) {
        if(block == null) {
            return;
        }
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int[][] shape = block.getShape();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {

                    int x = (block.getX() + col) * gridCellSize;
                    int y = (block.getY() + row) * gridCellSize;

                    drawGridSquare(g, c, x, y);

                }
            }
        }

    }

    /**
     * Creates the background to the game.
     * @param g Passes a graphics parameter for the paintComponent method.
     */
    private void drawBackground(Graphics g) {
        Color color;

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridColumns; c++) {
                color = background[r][c];

                if (color != null) {
                    int x = c * gridCellSize;
                    int y = r * gridCellSize;

                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }

    /**
     * Clearing the lines and moving the background accordingly.
     * @return linesCleared The number of lines cleared.
     */
    public int clearLines() {

        boolean lineFilled;
        int linesCleared = 0;


        for (int r = gridRows - 1; r >= 0; r--) {
            lineFilled = true;
            for (int c = 0; c < gridColumns; c++) {

                if (background[r][c] == null) {
                    lineFilled = false;
                    break;
                }
            }

            if (lineFilled) {

                linesCleared++;
                clearLine(r);
                shiftDown(r);
                clearLine(0);

                r++;

                repaint();
            }
        }
        if (linesCleared > 0) {

            Tetris.playClear();

        }

        return linesCleared;
    }

    /**
     * Checking if there is a complete row that can be cleared.
     * @param r The rows that is being cleared.
     */
    private void clearLine(int r) {
        for (int i = 0; i < gridColumns; i++) {
            background[r][i] = null;
        }
    }


    /**
     * Shifting the background down according to how many lines were cleared.
     * @param r The rows that is being cleared.
     */
    private void shiftDown(int r) {
        for (int row = r; row > 0; row--) {
            for (int col = 0; col < gridColumns; col++) {
                background[row][col] = background[row - 1][col];
            }
        }
    }

    /**
     * Coloring the background of the game area according to the placement of the block.
     */
    public void moveBlockToBackground() {

        int[][] shape = block.getShape();

        int h = block.getHeight();
        int w = block.getWidth();

        int xPos = block.getX();
        int yPos = block.getY();

        Color color = block.getColor();

        for (int q = 0; q < h; q++) {
            for (int p = 0; p < w; p++) {
                if (shape[q][p] == 1) {
                    background[q + yPos][p + xPos] = color;
                }
            }
        }
    }

    /**
     * Creating the grid for the background.
     * @param g Passes a graphics parameter for the paintComponent method.
     * @param color Color of the block.
     * @param x X position of the block.
     * @param y Y position of the block.
     */
    public void drawGridSquare(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, gridCellSize, gridCellSize);

        g.setColor(Color.black);
        g.drawRect(x, y, gridCellSize, gridCellSize);
    }

    /**
     * Displaying the components onto the screen.
     * @param g Passes a graphics parameter for the paintComponent method.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawBlock(g);
    }
}
