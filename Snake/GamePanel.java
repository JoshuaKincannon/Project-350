import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    /**********************************************************************
    //Setting the dimensions of the panel on which the game will be drawn.
    */

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    static final int RANDOM_COLOR_BOUND = 255;
    //5 is a magic number except I cannot make it final due to needing
    //incrementation
    public static int BODY_PARTS = 5;
    public final int FONT_SIZE = 30;
    private final int FONT_SIZE_2 = 70;
    /**********************************************************************
     *these two arrays x and y hold the body parts of the snake.
     *********************************************************************/
    /**
     *
     */
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    /**********************************************************************
     *initial amount of body parts we want for the snake might make this
     * an option on the launch menu.
     *********************************************************************/


    int applesEaten;
    int appleX;
    int appleY;

    /**
     **/
    private char direction = 'R';
    boolean running = false;
    /**
     *
     */
    Timer timer;
    Random random;

    /**********************************************************************
     *Creates a game panel that is used to draw the snake game.
     *********************************************************************/
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();


    }
    /**********************************************************************
     *This method starts the timer for the game, creates an apple object,
     * and sets the running boolean to true which signals the game
     * to start drawing.
     *********************************************************************/
        public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     *
     * @param g - Graphics Object an exxtension of the object class.
     */
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    /**********************************************************************
     *    this draw method draws the gridlines, apples, snake body parts,
     *    and text graphics and colors of the game.
     *
     *
     *
     * @param g - An extension of the Object class that allows the game
     *      * to be drawn.
     */
    public void draw(Graphics g) {

        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);

            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


            for (int i = 0; i < BODY_PARTS; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(random.nextInt(RANDOM_COLOR_BOUND),
                            random.nextInt(RANDOM_COLOR_BOUND),
                            random.nextInt(RANDOM_COLOR_BOUND)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                /**********************************************************************
                 * Set the game objects color, Font, draws the score label.
                 * *******************************************************************/
                g.setColor(new Color(random.nextInt(RANDOM_COLOR_BOUND),
                        random.nextInt(RANDOM_COLOR_BOUND),
                 random.nextInt(RANDOM_COLOR_BOUND)));
                g.setFont(new Font("Magneto", Font.BOLD, FONT_SIZE));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("SCORE: " + applesEaten,
                        (SCREEN_WIDTH - metrics.stringWidth("SCORE: " + applesEaten)) / 2,
                         g.getFont().getSize());

            }
        } else {
            gameOver(g);
        }
    }

    /**********************************************************************
     *Generate the coordinates of a new apple, everytime we start a game
     * or eat an apple.
     ********************************************************************/
    /**
     *
     */
    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;


    }

    /**********************************************************************
     * The move function allows you to control your snake using the
     * up, down, right, and left keys.
     *********************************************************************/

    public void move() {
        for (int i = BODY_PARTS; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        //No default to be used since there is a default direction of right
        //decided elsewhere
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

        }

    }

    /**********************************************************************
     * This method is to see if your snake has moved through the same
     * coordinates as the location of an apple and if so will increase the
     * size of your snake and increase your score by one.
     *********************************************************************/
    //
    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            BODY_PARTS++;
            applesEaten++;
            newApple();
        }
    }

    /**
     * checkCollisions() - is Used to see if the head collides with the
     * body, ending game
     */
    public void checkCollisions() {
        //This checks if head collides with body
        for (int i = BODY_PARTS; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        /**********************************************************************
         * if head touches border cause it to overflow or udnerflow in
         * appropriate direction so the snake will appear
         * on the other side of the screen. It gives the game more playability.
         * CHANGED FEATURE
         *********************************************************************/

        if (x[0] < 0) {
            x[0] = SCREEN_WIDTH;
        }
        //check if enters touches right border
        if (x[0] > SCREEN_WIDTH) {
            x[0] = 0;
        }
        //CHECK TO SEE IF HEAD enters TOP BORDER
        if (y[0] < 0) {
            y[0] = SCREEN_HEIGHT;
        }
        //check if head enters bottom border
        if (y[0] > SCREEN_HEIGHT) {
            y[0] = 0;
        }
        if (!running) {
            timer.stop();
        }

    }

    //when you accidentally eat yourself the game goes to a new screen.

    /**
     *
     * @param g - Graphics object used to color the Font for the end of
     *          game.
     */
    public void gameOver(Graphics g) {
        //game over text color and font that I have changed to a
        //font that I found in a Swing text library
        g.setColor(Color.red);
        g.setFont(new Font("Magneto", Font.BOLD, FONT_SIZE_2));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH
                -
        metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        g.setColor(Color.red);
        g.setFont(new Font("Magneto", Font.BOLD, FONT_SIZE));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("SCORE: " + applesEaten, (SCREEN_WIDTH
                        -
                metrics2.stringWidth("SCORE: " + applesEaten)) / 2,
                g.getFont().getSize());


    }
    //action event listener that allows the snake to move, registers
    //apples being eaten or colliding into yourself

    /**
     *
     * @param e - The actionEvent object that monitors moving
     *          checking apples and collisions, and repainting
     *          as necessary.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }



    /**
     * *This class is used to register key events when you  move your snake.
     * * */
    public class MyKeyAdapter extends KeyAdapter {
        /**
         *
         * @param e - this object is over ridden for key events. It
         *          doesn't have to be but
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;

            }
        }
    }
}
