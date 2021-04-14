package tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetrisBlocks.*;


public class GameArea extends JPanel {

    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private Color[][] background; 
    private TetrisBlock[] blocks;
    private TetrisBlock block;
    private TetrisBlock nextBlock;
    private GameThread gt;
    private StartupForm sf;
    private TetrisBlock tempBlock;
    private GameForm gf;
    private NextBlock nb;
    private Color color;
   
    public TetrisBlock holdBlock;
  

    /**
     * creating the JPanel for the game
     * also initializes the grid columns, size,
     * and rows
     * @param placeholder
     * @param columns
     */
    //creating the JPael for the game and initializing grid coloumns, size, and rows
    public GameArea(JPanel placeholder, int columns){

        
        this.setBounds(placeholder.getBounds() );
        this.setBackground(placeholder.getBackground() );
        this.setBorder(placeholder.getBorder());
        
        gridColumns = columns; 
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
      
        blocks = new TetrisBlock[] { new IShape(), new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()};
//        nextBlock = blocks[1];
    }
    
     
    
    public TetrisBlock getNext() {
       return nextBlock;
        }
    
    
    public TetrisBlock getHold() {
       return holdBlock;
        }


    /**
     * initializes the background
     */
    public void initBackGroundArray() {
        background = new Color[gridRows][gridColumns];

    }
    
//    public void pause() {
//        
//        if(sf.isStopped == false){
//            try {
//                gt.sleep(Long.MAX_VALUE);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GameArea.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//        else{ 
//            if( sf.isStopped == true) {
//                gt.interrupt();
//            }
//        }
//        
//    }

    /**
     * randomly spawns a new block
     */
    public void spawnBlock() {

        Random r = new Random();

        if (nextBlock == null) {

            nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            nextBlock.setColor();
           

            block = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            block.setColor();
            

        }
            else{
                block = new TetrisBlock(nextBlock);
                block.setColor2(nextBlock.getColor());
                
                nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
                nextBlock.setColor();


        }
        block.spawn(gridColumns);
        repaint();
    }


    
     

    /**
     * checks if block is out of bounds
     * at the top of the GameArea
     * @return
     */
    //checking if you lose or the block is our of bounds at the top
    public boolean isBlockOutOfBounds() {
        
        if(block.getY() < 0){
            
            block = null; 
                return true;
                }
        return false;
        
    }
    
    /**
     * Allows for the a current piece to be held and used later.
     */
    public void hold() {
        int x;
        int y;
        Random r = new Random();
        
        if (holdBlock == null) {
            
            
            holdBlock = new TetrisBlock(block);
            holdBlock.setColor2(block.getColor());
            
            x = block.getX();
            y = block.getY();
            
            block = new TetrisBlock(nextBlock);
            block.setColor2(nextBlock.getColor());
            block.setX(x);
            block.setY(y);
            
            nextBlock = new TetrisBlock(blocks[r.nextInt(blocks.length)]);
            nextBlock.setColor();
            repaint();
            
        }
        
        else { 
            
            tempBlock = new TetrisBlock(block);
            tempBlock.setColor2(block.getColor());
            
            x = block.getX();
            y = block.getY();
            
            block = new TetrisBlock(holdBlock);
            block.setColor2(holdBlock.getColor());
            block.setX(x);
            block.setY(y);
            
            holdBlock = new TetrisBlock(tempBlock);
            holdBlock.setColor2(tempBlock.getColor());
            repaint();
        }
        
    }


    /**
     * Checking if the block can move down
     * @return
     */
    public boolean moveBlockDown() {
        
        if (checkBottom() == false) {
  
            return false;
        }
        
        block.moveDown();
        repaint();
        
        return true;
    }

    /**
     * Checks if the block can move right
     */
    //moving the block right 
    public void moveBlockRight() {
        
        if(block == null) 
            return;
        
        if(!checkRight()) {
            return;
        }
      
        block.moveRight();
        repaint(); 
    }

    /**
     * Checks if the block can move left
     */
    //moving the block left 
    public void moveBlockLeft() {
         if(block == null) 
             return;
         
        if(!checkLeft()) { 
            return; 
        }
        
        block.moveLeft();
        repaint();
    }

    /**
     * Drops the block
     */
    //dropping the block
    public void drop() {
        if(block == null) {
             return;
        }
        if(checkBottom()){
        block.moveDown();
        }
        
        repaint();
    }

    /**
     * Rotates the block
     * Checks if the block is rotating out of bounds
     * Checks if the block is rotating into another block.
     */
    //rotating the block and repaiting it on the screen
    public void rotate() {
        
        if(block == null) 
             return;
        
       block.rotate();
       int[][] shape = block.getShape();
       int w = block.getWidth();
       int h = block.getHeight();
        
        
        if(block.getLeftEdge() < 0) block.setX(0);
        if(block.getRightEdge() >= gridColumns) block.setX(gridColumns - block.getWidth() );
        if(block.getBottomEdge() >= gridRows) block.setY(gridRows - block.getHeight() );
       
        
         for(int row = 0; row < h; row++) {
           for( int col = 0; col < w; col++) {
               if(shape[row][col] != 0) {
                   int x = col + block.getX();
                   int y = row + block.getY();
                   if(y < 0)
                       break;
                   if(background[y][x] != null){
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
     * Checking if the block has landed on a block
     * Checks if the block has reached the bottom
     * @return
     */
    private boolean checkBottom() { 
      
        
       if(block.getBottomEdge() == gridRows){
        return false;
    }
       
       int[][] shape = block.getShape(); 
       int w = block.getWidth(); 
       int h = block.getHeight();
       
       for(int col = 0; col < w; col++) {
           for( int row = h -1; row >= 0; row--) {
               if(shape[row][col] != 0) {
                   int x = col + block.getX();
                   int y = row + block.getY() + 1;
                   if(y < 0)
                       break;
                   if(background[y][x] != null) 
                       return false; 
                       break;
                   
               }
           }
       }

        return true;
    }


    /**
     * Checking if the current block is hitting a block to the right
     * Checking if the current block is going out of bounds to the right
     * @return
     */
    //checking if there are is an edge or block to the left 
    private boolean checkLeft(){
        if(block.getLeftEdge() == 0) {
            return false;
        }
       int[][] shape = block.getShape(); 
       int w = block.getWidth(); 
       int h = block.getHeight();
       
       for(int row = 0; row < h; row++) {
           for( int col = 0; col < w; col++) {
               if(shape[row][col] != 0) {
                   int x = col + block.getX() -1;
                   int y = row + block.getY();
                   if(y < 0)
                       break;
                   if(background[y][x] != null) 
                       return false; 
                       break;
                   
               }
           }
       }
        return true; 
               
    }

    /**
     * Checking if the current block is hitting a block to the left
     * checking if the current block is going out of bound to the left
     * @return
     */
    //checking if there is an edge or block to the right 
    private boolean checkRight() {
        if(block.getRightEdge() == gridColumns){
            return false; 
        }
        
       int[][] shape = block.getShape(); 
       int w = block.getWidth(); 
       int h = block.getHeight();
       
       for(int row = 0; row < h; row++) {
           
           for( int col = w -1; col >= 0; col--) {
               
               if(shape[row][col] != 0) {
                   
                   int x = col + block.getX() + 1;
                  
                   int y = row + block.getY();
                   if(y < 0)
                       break;
                   if(background[y][x] != null) 
                       return false; 
                       break;
                   
               }
           }
       }
        return true; 
    }


    /**
     * Drawing the newly spawned block on the GameArea
     * @param g
     */
    //drawing the tetris blocks or creating the foreground of the Tetris screen
    private void drawBlock(Graphics g){
        
        int h = block.getHeight();
        int w = block.getWidth();
        Color c = block.getColor();
        int[][] shape = block.getShape();
   
        for(int row = 0; row< h; row++){
         for(int col = 0; col < w; col++) {
                if(shape[row][col] == 1) {
                    
                int x = (block.getX() + col) * gridCellSize;
                int y = (block.getY() + row) * gridCellSize;
                
                drawGridSquare(g, c, x, y);

                }
                }
        }
        
    }

    /**
     * Creating the background of the game
     * @param g
     */
    //creating the structure of the blocks after it is placed 
    private void drawBackground(Graphics g) {
        Color color;
        
        for(int r = 0; r < gridRows; r++) { 
            for (int c = 0; c < gridColumns; c++) { 
                color = background [r][c]; 
                
                if(color != null) { 
                    int x = c * gridCellSize;
                    int y = r * gridCellSize;
                    
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }

    /**
     * Clearing the lines and moving the background accordingly
     * @return
     */
    //clearing lines when the row is complete
    public int clearLines() {
    
        boolean lineFilled;
        int linesCleared = 0;
        
        
        for (int r = gridRows - 1; r >= 0; r--) {
            lineFilled = true;
            for( int c = 0; c < gridColumns; c++) {
                
                if(background[r][c] == null) {
                    lineFilled = false;
                    break;
                }
            }
            
            if(lineFilled){
                
               linesCleared++;
               clearLine(r);
               shiftDown(r);
               clearLine(0);
               
               r++;
               
               repaint();
            }
        }
        if(linesCleared > 0) {
            
        Tetris.playClear();
        
        }
        
        return linesCleared;
    }

    /**
     * Checking if there is a complete row
     * @param r
     */
    //clearing lines after you completely filled a row
    private void clearLine(int r) {
         for ( int i =0; i < gridColumns; i++){
                    background[r][i] = null;
                }
    }


    /**
     * Shifting the background after a line is cleared
     */
    //shifting placed blocks down after clearing lines 
    private void shiftDown(int r) {
        for( int row = r; row > 0; row--) { 
            for(int col = 0; col < gridColumns; col++) {
                background[row][col] = background[row-1][col];
            }
        }
    }

    /**
     * Making the blocks part of the background after they have been placed
     */
    //making a block stay after being placed down
    public void moveBlockToBackground() { 
        
         int[][] shape = block.getShape();
         
         int h = block.getHeight();
         int w = block.getWidth(); 
         
         int XPos = block.getX();
         int YPos = block.getY();
         
         Color color = block.getColor();
          
         for (int q = 0; q < h; q++) { 
             for(int p = 0; p < w; p++) {
                 if(shape[q][p]==1) {
                     background[q + YPos] [p + XPos] = color;
                 }
             }
         }
    }

    /**
     * Creating the grid for the background
     * @param g
     * @param color
     * @param x
     * @param y
     */
    
    //drawing the outlines for the tetris peices 
    public void drawGridSquare(Graphics g, Color color, int x, int y) { 
                g.setColor(color);
                g.fillRect( x , y , gridCellSize, gridCellSize);
                g.setColor(Color.black);
                g.drawRect( x , y , gridCellSize, gridCellSize);
    }


    /**
     * displaying the components onto the screen
     * @param g
     */
        @Override
        protected void paintComponent (Graphics g){
        super.paintComponent(g);
        drawBackground(g);
        drawBlock(g);
//        nb.drawBlocks(g);
    }
}
