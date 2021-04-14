
package tetrisBlocks;

import tetris.TetrisBlock;


public class TShape extends TetrisBlock {

    /**
     * Generates the T block shape.
     */
    public TShape() {
        super(new int [][]{ {1,1,1},
                            {0,1,0},
        });
    }
}

