package Project;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Tic Tac Toe with GUI implementation using Java Swing
 * @author: Chiamaka Ezuruonye
 * Date: April 21nd 2021
 */

/**
 * Tic.TicTacToeGUI class, implements an action listener
 * Starts game by gathering names, game pieces
 * and building the game board
 */
public class TicTacToeGUI implements ActionListener {
    private static Random rand = new Random();
    private static JFrame gameFrame = new JFrame();
    private static JPanel title = new JPanel();
    private static JPanel buttonPanel = new JPanel();
    private static JLabel textField = new JLabel();
    private static JButton[] buttons = new JButton[9];
    private static boolean player1turn;
    private static boolean winner = false;
    private String player2Name;
    private String player1Name;
    private static boolean playervsplayer = false;
    private static boolean playervscpu = false;
    private String pl1;
    private String pl2 = "R2D2";
    private static String winnerName = "";

    /**
     * TicTacToeGUI method builds game board and inserts panels and buttons
     * It also adds the style and colors for background/foreground and font
     */
    TicTacToeGUI(){
        winnerName = "";
        whosePlaying();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 800);
        gameFrame.getContentPane().setBackground(new Color(50, 50, 50));
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setVisible(true);
        textField.setBackground(new Color(94, 143, 116, 255)); //background color
        textField.setForeground(new Color(45, 45, 45)); //text color
        textField.setFont(new Font("Courier", Font.BOLD, 55));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("*Tic-Tac-Toe*");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 100);
        title.add(textField);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(113, 79, 110));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Aerial", Font.BOLD, 80));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        gameFrame.add(title, BorderLayout.NORTH);
        gameFrame.add(buttonPanel);

        firstTurn();
        checkWinner();
    }

    public void whosePlaying(){
        //player 1 -  specify a 10 char limit for names no empty names - DONE
        player1Name = JOptionPane.showInputDialog(null, "Who is Player 1?",
                "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION);
        if (player1Name.length() > 10 || player1Name.length() == 0) {
            String newname = JOptionPane.showInputDialog(null, player1Name +
                            "The name given was invalid. " +
                            "Please enter a new name no longer than 10 characters.",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            player1Name = newname;
        }
        if(player1Name.equals(JOptionPane.CANCEL_OPTION) || player1Name.equals(JOptionPane.CLOSED_OPTION)){
            System.exit(0);
        }
        //player 1 game piece
        pl1 = JOptionPane.showInputDialog(null, player1Name +
                        ", what word/letter/symbol would you like your game piece to be?",
                "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
        //specify what happens if enter something greater than 5 characters,
        // no empty game pieces - DONE
        if (pl1.length() > 5 || pl1.length() == 0) {
            String newpiece = JOptionPane.showInputDialog(null, player1Name +
                            "The piece chosen for player 1 was invalid, please enter a new piece " +
                            "no longer than 5 characters.",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            pl1 = newpiece;
        }
        if(pl1.equals(JOptionPane.CANCEL_OPTION) || pl1.equals(JOptionPane.CLOSED_OPTION)){
            System.exit(0);
        }

        //player 2 -
        player2Name = JOptionPane.showInputDialog(null, "Who is Player 2? " +
                "If you wish to play against our CPU, R2D2, please enter " +
                "'r2/R2' or 'R2D2/r2d2' below.","Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION);
        //specify a 10 char limit for names no empty names - DONE
        //if not CPU but PvP game
        if (player2Name.length() > 10 || player2Name.length() == 0) {
            String newname = JOptionPane.showInputDialog(null, player2Name +
                            "The name given for player 2 was invalid, please enter a new name " +
                            "no longer than 10 characters.",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            player2Name = newname;
        }
        if(player2Name.equals(JOptionPane.CANCEL_OPTION) || player2Name.equals(JOptionPane.CLOSED_OPTION)){
            System.exit(0);
        }

        if (player2Name.equals("r2") || player2Name.equals("R2") || player2Name.equals("R2D2")
                || player2Name.equals("r2d2")) {
            playervscpu = true;
            player2Name = "R2";
        } else { //player 2 game piece
            playervsplayer = true;
            String pltwo = JOptionPane.showInputDialog(null, player2Name +
                            ", what word/letter/symbol would you like your game piece to be?",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            pl2 = pltwo;
        } //specify what happens if they enter something more than 5 or empty
        if (pl2.length() > 9 || pl1.length() == 0) {
            String newpiece = JOptionPane.showInputDialog(null, player2Name +
                            "The piece chosen for player 2 was invalid, please enter a new piece " +
                            "no longer than 5 characters.",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            pl2 = newpiece;
        }
        if(pl2.equals(JOptionPane.CANCEL_OPTION) || pl2.equals(JOptionPane.CLOSED_OPTION)){
            System.exit(0);
        }
    }

    /**
     * Returns boolean player 1 turn
     * @return player1turn
     */
    public boolean isPlayer1turn() {
        return player1turn;
    }

    /**
     * This method gets player 1's name and returns it
     * @return player1name
     */
    public String getP1Name(){
        return player1Name;
    }

    /**
     * This method gets player 2's name and returns it
     * @return player2name
     */
    public String getP2Name(){
        return player2Name;
    }

    /**
     * This method gets player 2's game piece and returns it
     * @return pl2 (player 2 game piece)
     */
    public String getP2Piece(){
        return pl2;
    }

    /**
     * This method gets player 1's game piece and returns it
     * @return  pl1 (player 1 game piece)
     */
    public String getP1Piece(){
        return pl1;
    }

    /**
     * This method returns the buttons array
     * @return buttons
     */
    public JButton[] getButtons(){
        return buttons;
    }

    /**
     * This method returns the panel array
     * @return buttonPanel
     */
    public JPanel getPanel(){
        return buttonPanel;
    }

    /**
     * This method returns the gameFrame
     * @return gameFrame
     */
    public JFrame getGameFrame(){
        return gameFrame;
    }

    /**
     *
     * @param e is an action event
     *          Uses action listener to get responses about
     *          which buttons have been pressed and acts accordingly
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Random ran = new Random();
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playervsplayer) {
                    if (player1turn) {
                        if (buttons[i].getText().equals("") ) {
                            buttons[i].setForeground(new Color(239, 155, 125)); //text color
                            buttons[i].setText(pl1); //button text
                            player1turn = false;
                            textField.setText(player2Name + "'s Turn - " + pl2); //player 2 name
                            checkWinner();
                        }
                    } else {
                        if (buttons[i].getText().equals("")) {
                            buttons[i].setForeground(new Color(166, 157, 222));
                            buttons[i].setText(pl2);
                            player1turn = true;
                            textField.setText(player1Name + "'s Turn - " + pl1); //player 1 name
                            checkWinner();
                        }
                    }
                }
            }

            if (playervscpu) {
                if (e.getSource() == buttons[i]) {
                    if (player1turn) {
                        if (buttons[i].getText().equals("")) {
                            buttons[i].setForeground(new Color(239, 155, 125)); //text color
                            buttons[i].setText(pl1); //button text
                            player1turn = false;
                            textField.setText(player2Name + "'s Turn - " + pl2); //set player 2 name
                            checkWinner();
                        }
                    }
                } else {
                    if (!player1turn) {
                        if (buttons[i].getText().equals("")) {
                            buttons[i].setForeground(new Color(53, 163, 250));
                            buttons[i].setText(pl2);
                            player1turn = true;
                            textField.setText(player1Name + "'s Turn - " + pl1); //set player 1 name
                            checkWinner();
                        } else {
                            i = ran.nextInt(9 - 1) + 1;
                            while (buttons[i].getText() != "") { //fixes Overwriting?
                                i++;
                                if(i == 8 && buttons[i].getText() != ""){
                                    i = 0;
                                }
                            }
                            buttons[i].setForeground(new Color(53, 163, 250));
                            buttons[i].setText(pl2);
                            player1turn = true;
                            textField.setText(player1Name + "'s Turn - " + pl1); //set player 1 name
                            checkWinner();
                        }
                    }
                }
            }
        }
    }

    /**
     * FirstTurn method uses random variable
     * to determine which player goes first
     * no parameters
     */
    public void firstTurn(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(playervsplayer) {
            if (rand.nextInt(2) == 0) {
                player1turn = true;
                textField.setText(player1Name + "'s Turn - " + pl1);
            } else {
                player1turn = false;
                textField.setText(player2Name + "'s Turn - " + pl2); //set player 2 name
            }
        }
        else if(playervscpu){
            if (rand.nextInt(2) == 0) {
                player1turn = true;
                textField.setText(player1Name + "'s Turn - " + pl1);
            }
            else{
                player1turn = false;
                int i = 0;
                buttons[i].setForeground(new Color(53, 163, 250));
                buttons[i].setText(pl2);
                player1turn = true;
                textField.setText(player1Name + "'s Turn - " + pl1);
            }
        }
    }

    /**
     * This method returns the random variable
     * @return rand
     */
    public Random getRandom(){
        return rand;
    }

    /**
     * Check Winner method uses the 'buttons' array
     * to check values for patterns and matches for a win
     * then sets the boolean 'winner' to true if true
     * and calls the 'tie' method
     * no parameters
     */
    public void checkWinner(){
        //check x winning conditions
        if((buttons[0].getText() == pl1) &&
                (buttons[1].getText() == pl1) &&
                (buttons[2].getText() == pl1)){
            xWins(0, 1, 2);
            winner = true;
        }

        if((buttons[3].getText() == pl1) &&
                (buttons[4].getText() == pl1) &&
                (buttons[5].getText() == pl1)){
            xWins(3, 4, 5);
            winner = true;
        }
        if((buttons[6].getText() == pl1) &&
                (buttons[7].getText() == pl1) &&
                (buttons[8].getText() == pl1)){
            xWins(6, 7, 8);
            winner = true;
        }
        if((buttons[0].getText() == pl1) &&
                (buttons[3].getText() == pl1) &&
                (buttons[6].getText() == pl1)){
            xWins(0, 3, 6);
            winner = true;
        }
        if((buttons[1].getText() == pl1) &&
                (buttons[4].getText() == pl1) &&
                (buttons[7].getText() == pl1)){
            xWins(1, 4, 7);
            winner = true;
        }
        if((buttons[2].getText() == pl1) &&
                (buttons[5].getText() == pl1) &&
                (buttons[8].getText() == pl1)){
            xWins(2, 5, 8);
            winner = true;
        }
        if((buttons[0].getText() == pl1) &&
                (buttons[4].getText() == pl1) &&
                (buttons[8].getText() == pl1)){
            xWins(0, 4, 8);
            winner = true;
        }
        if((buttons[2].getText() == pl1) &&
                (buttons[4].getText() == pl1) &&
                (buttons[6].getText() == pl1)){
            xWins(2, 4, 6);
            winner = true;
        }

        //check O winning conditions
        if((buttons[0].getText() == pl2) &&
                (buttons[1].getText() == pl2) &&
                (buttons[2].getText() == pl2)){
            oWins(0, 1, 2);
            winner = true;
        }
        if((buttons[3].getText() == pl2) &&
                (buttons[4].getText() == pl2) &&
                (buttons[5].getText() == pl2)){
            oWins(3, 4, 5);
            winner = true;
        }
        if((buttons[6].getText() == pl2) &&
                (buttons[7].getText() == pl2) &&
                (buttons[8].getText() == pl2)){
            oWins(6, 7, 8);
            winner = true;
        }
        if((buttons[0].getText() == pl2) &&
                (buttons[3].getText() == pl2) &&
                (buttons[6].getText() == pl2)){
            oWins(0, 3, 6);
            winner = true;
        }
        if((buttons[1].getText() == pl2) &&
                (buttons[4].getText() == pl2) &&
                (buttons[7].getText() == pl2)){
            oWins(1, 4, 7);
            winner = true;
        }
        if((buttons[2].getText() == pl2) &&
                (buttons[5].getText() == pl2) &&
                (buttons[8].getText() == pl2)){
            oWins(2, 5, 8);
            winner = true;
        }
        if((buttons[0].getText() == pl2) &&
                (buttons[4].getText() == pl2) &&
                (buttons[8].getText() == pl2)){
            oWins(0, 4, 8);
            winner = true;
        }
        if((buttons[2].getText() == pl2) &&
                (buttons[4].getText() == pl2) &&
                (buttons[6].getText() == pl2)){
            oWins(2, 4, 6);
            winner = true;
        }
        //check if there is a tie
        tie();
    }

    /**
     * This methodtakes in an int from a button and returns the
     * game piece at the button
     * @param b
     * @return button text
     */
    public String getbuttontext(int b){
        return buttons[b].getText();
    }

    /**
     * This method finds the winner and returns it
     * @return winner
     */
    public boolean isaWinner(){
        return winner;
    }

    /**
     * This method returns pvp boolean
     * @return playervscpu
     */
    public boolean isPlayervscpu() {
        return playervscpu;
    }

    /**
     * This method returns pvcpu boolean
     * @return playervscpu
     */
    public boolean isPlayervsplayer() {
        return playervsplayer;
    }

    /**
     * Checks if player one is the winner
     * then calls the reset method
     * @param tic is an int
     * @param tac is an int
     * @param toe ia an int
     */
    public boolean xWins(int tic, int tac, int toe){
        buttons[tic].setBackground(Color.GREEN);
        buttons[tac].setBackground(Color.GREEN);
        buttons[toe].setBackground(Color.GREEN);
        winner = true;
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
            buttonPanel.remove(buttons[i]);
        }
        textField.setText(player1Name + " Wins!");
        winnerName = player1Name;
        //reset
        resetGame();
        return true;
    }

    /**
     * Checks of player two is the winner
     * then calls the reset method
     * @param tic is an int
     * @param tac is an int
     * @param toe is an int
     */
    public boolean oWins(int tic, int tac, int toe){
        buttons[tic].setBackground(Color.GREEN);
        buttons[tac].setBackground(Color.GREEN);
        buttons[toe].setBackground(Color.GREEN);
        winner = true;
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
            buttonPanel.remove(buttons[i]);
        }
        textField.setText(player2Name + " Wins!");
        winnerName = player2Name;
        //reset
        resetGame();
        return true;
    }

    /**
     * Returns winner name
     * @return winnerName
     */
    public String getWinnerName(){
        return winnerName;
    }

    /**
     * tie method checks for a full board
     * with no wins and decides it is a tie
     * then calls the reset method
     * no parameters
     */
    public boolean tie(){
        if(buttons[0].getText() != "" && buttons[1].getText() != "" &&
                buttons[2].getText() != "" && buttons[3].getText() != "" &&
                buttons[4].getText() != "" && buttons[5].getText() != "" &&
                buttons[6].getText() != "" && buttons[7].getText() != "" &&
                buttons[8].getText() != "" && winner == false){
            for(int i = 0; i < 9; i++){
                buttons[i].setBackground(Color.GREEN);
                buttons[i].setEnabled(false);
                buttonPanel.remove(buttons[i]);
            }
            textField.setText("It's A Tie!");
            //TODO: Add restart JOption at the end of the game - DONE
            //reset
            resetGame();
            return true;
        }
        return false;
    }

    /**
     * Reset game method resets after winner is declared
     * uses a JOption Pane
     * no parameters
     */
    public void resetGame() {
        int newgame = JOptionPane.showConfirmDialog(null,
                "Would you like to play again?","New Game?", JOptionPane.YES_NO_OPTION);
        gameFrame.setVisible(false);
        if(newgame == JOptionPane.NO_OPTION || newgame == JOptionPane.CLOSED_OPTION){
            System.exit(0);
        }
        else {
             new TicTacToeGUI();
        }
    }
}
