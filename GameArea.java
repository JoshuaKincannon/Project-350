package tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import tetrisBlocks.*;


public class GameArea extends JPanel {

    private int gridRows;
    private int gridColumns;
    private int gridCellSize;
    private Color[][] background; 
    private TetrisBlock[] blocks;
    
    private TetrisBlock block;
   
    
    
    //creating the JPael for the game and initializing grid coloumns, size, and rows
    public GameArea(JPanel placeholder, int columns ){

        
        this.setBounds(placeholder.getBounds() );
        this.setBackground(placeholder.getBackground() );
        this.setBorder(placeholder.getBorder());
        
        gridColumns = columns; 
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
      
        blocks = new TetrisBlock[] { new IShape(), new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()};
        
    }
    
    
    public void initBackGroundArray() {
        background = new Color[gridRows][gridColumns];
    
    }
    
    
    // spawing a new block
    public void spawnBlock(){ 
     
        Random r = new Random();
        
        block = blocks[ r.nextInt(blocks.length)];
        
        block.spawn(gridColumns);
     
        
    }
    
    //checking if you lose or the block is our of bounds at the top
    public boolean isBlockOutOfBounds() {
        
        if(block.getY() < 0){
            
            block = null; 
                return true;
                }
        return false;
        
    }
    
    
    
    
    //displays the block falling until it reaches bottom
    public boolean moveBlockDown() {
        
        if (checkBottom() == false) {
  
            return false;
        }
        
        block.moveDown();
        repaint();
        
        return true;
    }

    
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
    
    
    //checking if there is block or boundary at the bottom
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
    
    //clearing lines after you completely filled a row
    private void clearLine(int r) {
         for ( int i =0; i < gridColumns; i++){
                    background[r][i] = null;
                }
    }
    
    //shifting placed blocks down after clearing lines 
    private void shiftDown(int r) {
        for( int row = r; row > 0; row--) { 
            for(int col = 0; col < gridColumns; col++) {
                background[row][col] = background[row-1][col];
            }
        }
    }
    
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
    
    //drawing the outlines for the tetris peices 
    private void drawGridSquare(Graphics g, Color color, int x, int y) { 
                g.setColor(color);
                g.fillRect( x , y , gridCellSize, gridCellSize);
                g.setColor(Color.black);
                g.drawRect( x , y , gridCellSize, gridCellSize);
    }
    
  
        //drawing the contents on the screen
        @Override
        protected void paintComponent (Graphics g){
        super.paintComponent(g);
        drawBackground(g);
        drawBlock(g);
    }
}
