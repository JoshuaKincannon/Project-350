package tetris;

import tetris.TetrisBlock;

/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the T shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class TShape extends TetrisBlock {

    /**
     * Structures the T block shape in a 2D array.
     */
    public TShape() {
        super(new int[][]{{1, 1, 1},
                {0, 1, 0},
        });
    }
}

