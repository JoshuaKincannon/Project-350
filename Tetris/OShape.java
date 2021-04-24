package tetris;

import tetris.TetrisBlock;
/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the O shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */

public class OShape extends TetrisBlock {
    /**
     * Structures the O block shape in a 2D array.
     */
    public OShape() {
        super(new int[][]{{1, 1},
                {1, 1},
        });
    }
}
