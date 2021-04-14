package tetris;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread {

    private GameArea ga;
    private GameForm gf;
    private NextBlock nb;
    private int score;
    private int level = 1; 
    private int scorePerLevel = 3; 
    private int pause = 1000;
    private int speedUpPerLevel = 100;



    /**
     * creating the game thread and updating the score
     * @param ga
     * @param gf
     */
    public GameThread(GameArea ga, GameForm gf) {
        this.ga = ga;
        this.gf = gf;
        
        gf.updateScore(score);
        gf.updateLevel(level);
        
        
    }
    /**
     * Increasing the level according the the score
     * Increasing the pace that the block drops according to the level
     */
    //moving a peice down every 1000 milliseconds.This is the main game loop
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
            if(ga.isBlockOutOfBounds()){
               Tetris.GameOver(score);
                break;
            }
            
            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);
            
            int lvl = score / scorePerLevel +1; 
            if(lvl > level)
            {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedUpPerLevel;
            }
  
        }
    }
}
