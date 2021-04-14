package tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Panel;
import java.util.Random;
import tetrisBlocks.*;
import javax.swing.JComponent;

public class NextBlock extends JPanel {
    private GameArea ga;
    private TetrisBlock tb;
    private Color nextColor;
    private int nextGridColumns;
    private int nextGridRows;
    private int nextGridCellSize;
    private int holdGridColumns;
    private int holdGridRows;
    private int holdGridCellSize;
    private GameForm gf;
    private boolean form;
    
    TetrisBlock block;


    public NextBlock(JPanel placeholder, int columns, GameArea ga) {
//        this( placeholder,  columns,  ga);
//       System.out.println("This is the name " + placeholder.getName()); 


      if(placeholder.getName() == "NextPiece") {
          
        this.form = false;
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        this.ga = ga;

        this.nextGridColumns = columns;
        this.nextGridCellSize = this.getBounds().width / nextGridColumns;
        
        this.nextGridRows = columns;

//        this.nextGridRows = this.getBounds().height / nextGridCellSize;
      }
        
      
        
      if(placeholder.getName() == "HoldBlock") {
          
        this.form = true;
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());
        this.ga = ga;

        this.holdGridColumns = columns;
        this.holdGridCellSize = this.getBounds().width / holdGridColumns;
        this.holdGridRows = this.getBounds().height / holdGridCellSize;
//            
        }
     
       }

    
    


    public void drawBlock(Graphics g) {
        
        
        int h = ga.getNext().getHeight();
        int w = ga.getNext().getWidth();
        Color c = ga.getNext().getColor();
        
        int[][] shape = ga.getNext().getShape();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {

                    int x = (col+2) * nextGridCellSize;
                    int y = (row+2) * nextGridCellSize;
                    

                    ga.drawGridSquare(g, c, x, y);
                    

                }
            }
            
        }
        repaint();
    }

    

    private void drawBlocks(Graphics g){

        if(ga.getHold() != null){
        
        int h = ga.getHold().getHeight();
        int w = ga.getHold().getWidth();
        Color c = ga.getHold().getColor();
        
        int[][] shape = ga.getHold().getShape();

        for(int row = 0; row< h; row++){
            for(int col = 0; col < w; col++) {
                if(shape[row][col] == 1) {

                    int x = (col+2) * holdGridCellSize;
                    int y = (row+2) * holdGridCellSize;

                    ga.drawGridSquare(g, c, x, y);
                    
                }
            }
        }
        
    }
       repaint();
    }

 
    
    /**
     *
     * @param g
     */
        @Override
        protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(form == true) {
        drawBlocks(g);
        } else {
        drawBlock(g);
        }
        
    }
    
     
    
}
