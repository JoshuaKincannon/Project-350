package tetris;

import tetris.TetrisBlock;

/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the S shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class SShape extends TetrisBlock {
    /**
     * Structures the S block shape in a 2D array.
     */
    public SShape() {
        super(new int[][]{{0, 1, 1},
                {1, 1, 0},
        });
    }
}
