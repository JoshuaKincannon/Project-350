import org.junit.Test;


/**
 *
 */
import static org.junit.Assert.*;
public class SnakeGameTest{

    public GameFrame snakeFrameTest = new GameFrame();
    public SnakeGame.GamePanel f;

    /*
        //Things I need to test for:
            -starts at score 0
            -can go through walls and come out of the opposite side
            -ends when you eat yourself
            -score increases by 1 when you eat your apple
            -snake starts at length 5
            -snake's size increases by 1 every apple you eat
            -cannot move the direction that the snake is moving

         */

    /**
     * @Test - This test checks for the starting length of the snake
     * to be 5
     */
    @Test
    public void checkStartLength() {
        assertTrue(SnakeGame.GamePanel.BODY_PARTS == 5);
    }

    /**
     * @Test - This test checks to make sure that once you eat
     * an apple that your body parts increase by 1 and that your
     * applesEaten score increases by 1 as well.
     */
    @Test
    public void checkEating(){
        f = new SnakeGame.GamePanel();
        f.appleY = 1;
        f.appleX = 1;
        f.x[0] = 1;
        f.y[0] = 1;
        f.checkApple();

        assertEquals(f.applesEaten, 1);
        assertEquals(f.BODY_PARTS, 6);
    }

    /**
     * This test checks to see whether or not you are
     * moving the proper base direction once the game has
     * started and that direction is Right
     */
    @Test
    public void checkStartDirections(){
        f = new SnakeGame.GamePanel();
        assertTrue(f.direction == 'R');
    }

    /**
     * @Test - This test checks to ensure that the player
     * starts with 0 apples.
     */
    @Test
    public void checkStartingApples(){
        assertTrue(SnakeGame.GamePanel.applesEaten == 0);
    }

    /**
     * @Test - this test checks to make sure that when you move to the right
     * that your entire body moves as it is supposed to.
     */
    @Test
    public void checkMoves(){
        f = new SnakeGame.GamePanel();
        f.direction = 'R';
        int piece = f.x[f.BODY_PARTS - 1];
        f.move();
        assertEquals(f.x[f.BODY_PARTS - 1], 0);
    }

    /**
     * @Test - This check to make sure that when you eat yourself the
     * timer has stopped, indicating that you have eaten yourself
     */
    @Test
    public void checkEatYourself(){
        f = new SnakeGame.GamePanel();
        f.BODY_PARTS = 16;
        f.x[0] = 1;
        f.y[0] = 1;
        f.x[7] = 1;
        f.y[7] = 1;
        f.checkCollisions();
        assertTrue(f.running == false);

    }

    /**
     * @Test - This test ensures that yoar starting gameFrame is at width
     * 600
     */
    @Test
    public void checkStartDimensions() {
        assertTrue(snakeFrameTest.getWidth() == 600);
    }


}


