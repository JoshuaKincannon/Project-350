package tetris;

import tetris.TetrisBlock;
/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the Z shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class ZShape extends TetrisBlock {

    /**
     * Structures the Z block shape in a 2D array.
     */
    public ZShape() {
        super(new int[][]{{1, 1, 0},
                {0, 1, 1},

        });
    }
}

