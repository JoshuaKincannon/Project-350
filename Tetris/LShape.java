package tetris;


/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the J shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class JShape extends TetrisBlock {
    /**
     * Structures the J block shape in a 2D array.
     */
    public JShape() {
        super(new int[][]{{0, 1},
                {0, 1},
                {1, 1},
        });
    }
}

