package tetris;

import tetris.TetrisBlock;

/**
 *
 * Responsible for retrieving audio for the program.
 * Creates the I shaped block to be used in the TetrisBlock class.
 * @author Joshua Kincannon
 * @version 13.0.2
 *
 */
public class IShape extends TetrisBlock {
    /**
     * Structures the I block shape in a 2D array.
     */
    public IShape() {
        super(new int[][]{{1, 1, 1, 1}});
    }

}
