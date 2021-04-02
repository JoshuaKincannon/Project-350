import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    //Setting the dimensions of the panel on which the game will be drawn.
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;

    //these two arrays hold the body parts of the snake
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    //initial amount of body parts we want for the snake might make this an option on the launch menu
    int bodyParts = 5;
    int applesEaten;
    int appleX;
    int appleY;
    //R for right, D for down, L for left, and U for Up
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    /**********************************************************************
     *
     *********************************************************************/
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();


    }

    //This method starts the timer for the game that
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    //
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    //this draw method draws the gridlines, apples, snake body parts, and text graphics and colors of the game.
    public void draw(Graphics g) {

        if (running) {
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);

            }
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(random.nextInt(255),
                            random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }

                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                g.setFont(new Font("Magneto", Font.BOLD, 30));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("SCORE: " + applesEaten, (SCREEN_WIDTH -
                        metrics.stringWidth("SCORE: " + applesEaten)) / 2, g.getFont().getSize());

            }
        }else{
            gameOver(g);
        }
    }


    //Generate the coordinates of a new apple, everytime we start a game or eat an apple
    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;


    }

    //allows you to control your snake
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
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

    //This method is to see if your snake has moved through the same coordinates as the location of an apple and if so
    //will increase the size of your snake and increase your score by one.
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        //This checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        /**************
         * if head touches border cause it to overflow or udnerflow in appropriate direction so the snake will appear
         * on the other side of the screen. It gives the game more playability.
         */
        //This checks if head touches left border
        if (x[0] < 0) {
            x[0] = SCREEN_WIDTH;
        }
        //check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            x[0] = 0;
        }
        //CHECK TO SEE IF HEAD TOUCHES TOP BORDER
        if (y[0] < 0) {
            y[0] = SCREEN_HEIGHT;
        }
        //check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            y[0] = 0;
        }
        if (!running) {
            timer.stop();
        }

    }

    //when you accidentally eat yourself the game goes to a new screen.
    public void gameOver(Graphics g) {

        //game over text color and font that I have changed to a font that I found in a Swing text library
        g.setColor(Color.red);
        g.setFont(new Font("Magneto", Font.BOLD, 70));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT / 2);

        g.setColor(Color.red);
        g.setFont(new Font("Magneto", Font.BOLD, 30));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("SCORE: " + applesEaten, (SCREEN_WIDTH -
                metrics2.stringWidth("SCORE: " + applesEaten))/2, g.getFont().getSize());


    }
    //action event listener that allows the snake to move, registers apples being eaten or colliding into yourself
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    //This class is used to register key events when you  move your snake.
    public class MyKeyAdapter extends KeyAdapter {

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
