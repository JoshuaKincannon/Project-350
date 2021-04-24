package tetris;

import tetris.TetrisBlock;

/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the L shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class LShape extends TetrisBlock {

    /**
     * Structures the L block shape in a 2D array.
     */
    public LShape() {

        super(new int[][]{{1, 0},
                {1, 0},
                {1, 1},
        });
    }
}
