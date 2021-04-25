import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlatform {
    public static class GridPanel extends JPanel implements ActionListener {

        private JButton[] buttons;

        private JButton tttButton;

        private JButton unoButton;

        private JButton tetrisButton;

        private JButton snakeButton;

        private JButton othelloButton;



        /**
         *
         */
        public GridPanel() {

            setLayout(new GridLayout (3, 2)); //columns, rows
            setBackground(Color.black);

            //initializing buttons for each Game
            tttButton = new JButton("TicTacToe ");
            unoButton = new JButton("Uno");
            snakeButton = new JButton("Snake");
            othelloButton = new JButton("Othello");
            tetrisButton = new JButton("Tetris");


            buttons = new JButton[]{tttButton,unoButton,snakeButton,othelloButton,tetrisButton};

            for(JButton i : buttons) {
                add(i);
                i.addActionListener(this);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object pressed = e.getSource();

            if(pressed == snakeButton){
                SnakeGame.GamePanel.applesEaten = 0;
                SnakeGame.GamePanel.BODY_PARTS = 5;
                new GameFrame();
            }
            if(pressed == othelloButton){
                new OthelloGUI();
            }
            if(e.getSource() == tetrisButton){
                if(e.getSource() == tetrisButton){
                    new Tetris().main(new String[]{"arg1", "arg2"});
                }
            }
            if(e.getSource() == unoButton){

            }
            if(e.getSource() == tttButton){
                new TicTacToeGUI();
            }
        }

        /**
         * Launches TicTacToe when button is pressed
         * @param e
         */
        /*

*/
    }



    /**
     * This will launch the Tetris game when tetrisbutton is pressed.
     *
     */
    /*

    }*/



    /**
     *
     * @param args
     */

}