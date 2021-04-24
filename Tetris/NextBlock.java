package tetris;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * GUI for drawing the next block and hold block.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class NextBlock extends JPanel {
    private GameArea ga;
    private int nextGridColumns;
    private int nextGridRows;
    private int nextGridCellSize;
    private int holdGridColumns;
    private int holdGridRows;
    private int holdGridCellSize;
    private boolean form;

    /**
     * Constructor for next block and hold block JFrames.
     * @param placeholder
     * @param columns
     * @param ga
     */
    public NextBlock(JPanel placeholder, int columns, GameArea ga) {
        super();
        if ("NextPiece".equals(placeholder.getName())) {

            this.form = false;
            this.setBounds(placeholder.getBounds());
            this.setBackground(placeholder.getBackground());
            this.setBorder(placeholder.getBorder());
            this.ga = ga;

            this.nextGridColumns = columns;
            this.nextGridCellSize = this.getBounds().width / nextGridColumns;

            this.nextGridRows = columns;
        }

        if ("HoldBlock".equals(placeholder.getName())) {

            this.form = true;
            this.setBounds(placeholder.getBounds());
            this.setBackground(placeholder.getBackground());
            this.setBorder(placeholder.getBorder());
            this.ga = ga;

            this.holdGridColumns = columns;
            this.holdGridCellSize = this.getBounds().width / holdGridColumns;
            this.holdGridRows = this.getBounds().height / holdGridCellSize;
        }
    }


    /**
     * Draws the next block.
     * @param g Passes a graphics parameter for the paintComponent method.
     */
    private void drawBlock(Graphics g) {

        int h = ga.getNext().getHeight();
        int w = ga.getNext().getWidth();
        Color c = ga.getNext().getColor();

        int[][] shape = ga.getNext().getShape();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {

                    int x = (col + 2) * nextGridCellSize;
                    int y = (row + 2) * nextGridCellSize;


                    ga.drawGridSquare(g, c, x, y);


                }
            }

        }
        repaint();
    }

    /**
     * Draws the hold block.
     * @param g Passes a graphics parameter for the paintComponent me
     */
    private void drawBlocks(Graphics g) {

        if (ga.holdBlock != null) {

            int h = ga.holdBlock.getHeight();
            int w = ga.holdBlock.getWidth();
            Color c = ga.holdBlock.getColor();

            int[][] shape = ga.holdBlock.getShape();

            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (shape[row][col] == 1) {

                        int x = (col + 2) * holdGridCellSize;
                        int y = (row + 2) * holdGridCellSize;

                        ga.drawGridSquare(g, c, x, y);

                    }
                }
            }

        }
        repaint();
    }

    /**
     * Displaying the components onto the screen.
     * @param g Passes a graphics parameter for the paintComponent me
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (form) {
            drawBlocks(g);
        } else {
            drawBlock(g);
        }

    }

}
