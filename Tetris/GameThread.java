package tetris;

/**
 * Creates the main tread for the program to run on.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class GameThread extends Thread {

    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    private int pause = 1000;
    private int speedUpPerLevel = 50;



    /**
     * Assigning parameter values equal to class variables and
     * calls methods responsible for updating the score and level.
     * @param ga
     * @param gf
     */
    public GameThread(GameArea ga, GameForm gf) {
        super();
        this.ga = ga;
        this.gf = gf;

        gf.updateScore(score);
        gf.updateLevel(level);

    }

    /**
     * Getter method to return score
     * @return
     */
    public int getScore(){
        return score;
    }

    /**
     * Getter method to return level
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Running the thread for the program.
     * Increases the level according the the score.
     * Increases the pace that the block drops according to the level.
     */
    @Override
    public void run() {

        while (true) {

            ga.spawnBlock();

            while (ga.moveBlockDown()) {

                try {

                    Thread.sleep(pause);

                } catch (InterruptedException ex) {
                    return;
                }
            }
            if (ga.isBlockOutOfBounds()) {
                Tetris.gameOver(score);
                break;
            }

            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);

            int lvl = score / scorePerLevel + 1;
            if (lvl > level) {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedUpPerLevel;
            }
        }
    }
}
