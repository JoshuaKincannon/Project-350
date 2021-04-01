import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JOptionPane;
/* @author: Chiamaka Ezuruonye

 */
public class TicTacToeGUI implements ActionListener {
    Random rand = new Random();
    JFrame gameFrame = new JFrame();
    JPanel title = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1turn;
    boolean winner = false;
    String playerName;
    boolean playervsplayer = false;
    boolean playervscpu = false;
    Scanner scan = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    String pl2 = "O";

    String player1Name = JOptionPane.showInputDialog(null, "Who is Player 1?",
            "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION);
    String pl1 = JOptionPane.showInputDialog(null, player1Name +
                    ", what letter/symbol would you like your game piece to be?",
            "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
    //TODO: specify what happens if enter something other than a word/symbol

    String player2Name = JOptionPane.showInputDialog(null, "Who is Player 2? " +
                    "If you wish to play against a CPU, please enter 'cpu' or 'CPU' below.",
            "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION);
    //TODO: specify a 10 char limit for names

    /*String pl2 = JOptionPane.showInputDialog(null, player2Name +
                    ", what letter/word/symbol would you like your piece to be?",
            "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);

     */

    TicTacToeGUI(){
        if(player2Name.equals("cpu") || player2Name.equals("CPU")){
            playervscpu = true;
            player2Name = "CPU";
        }
        else {
            playervsplayer = true;
            String pltwo = JOptionPane.showInputDialog(null, player2Name +
                            ", what letter/symbol would you like your game piece to be?",
                    "Tic Tac Toe", JOptionPane.QUESTION_MESSAGE);
            pl2 = pltwo;
        } //TODO: specify what happens if enter something other than a word/symbol

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(700, 700);
        gameFrame.getContentPane().setBackground(new Color(50, 50, 50));
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setVisible(true);
        textField.setBackground(new Color(6, 143, 84, 255)); //background color
        textField.setForeground(new Color(12, 10, 10)); //text color
        textField.setFont(new Font("Courier", Font.BOLD, 55));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("*Tic-Tac-Toe*");
        textField.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 100);
        title.add(textField);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(113, 79, 110));
        for(int i = 0; i < 9; i++){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO Auto-generated method stub
        Random ran = new Random();
        //ran.nextInt();
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (playervsplayer) {
                    if (player1turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 111, 206)); //text color
                            buttons[i].setText(pl1); //button text
                            player1turn = false;
                            textField.setText(player2Name + "'s Turn - " + pl2); //player 2 name
                            checkWinner();
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(80, 151, 255));
                            buttons[i].setText(pl2);
                            player1turn = true;
                            textField.setText(player1Name + "'s Turn - " + pl1); //player 1 name
                            checkWinner();
                        }
                    }
                }
            }

            if (playervscpu) { //TODO: FIX the overwriting problem with the CPU!!!!! -> DONE
                if (e.getSource() == buttons[i]) {
                    if (player1turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 111, 206)); //text color
                            buttons[i].setText(pl1); //button text
                            player1turn = false;
                            textField.setText(player2Name + "'s Turn - " + pl2); //set player 2 name
                            checkWinner();
                        }
                    }
                }
                else {
                     //   i = ran.nextInt(9) + 1;
                    if(!player1turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(80, 151, 255));
                            buttons[i].setText(pl2);
                            player1turn = true;
                            textField.setText(player1Name + "'s Turn - " + pl1); //set player 1 name
                            checkWinner();
                        } else {
                            // i++;
                            i = ran.nextInt(9);
                            while (buttons[i].getText() != "") {
                                i++;
                            }
                                buttons[i].setForeground(new Color(80, 151, 255));
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



        //play again?
        /*JOptionPane p = new JOptionPane();
        p.showMessageDialog(null,"Play Again?", "Tic Tac Toe",
                JOptionPane.YES_NO_OPTION);

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
       else if(playervscpu){ //TODO: add a pause in between turns from p1 to cpu
           if (rand.nextInt(2) == 0) {
               player1turn = true;
               textField.setText(player1Name + "'s Turn - " + pl1);
           }
           else{
               player1turn = false;
               int i = 0;
               buttons[i].setForeground(new Color(80, 151, 255));
               buttons[i].setText(pl2);
               player1turn = true;
               textField.setText(player1Name + "'s Turn - " + pl1);
           }
       }
    }

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

    public void xWins(int tic, int tac, int toe){
        buttons[tic].setBackground(Color.GREEN);
        buttons[tac].setBackground(Color.GREEN);
        buttons[toe].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText(player1Name + " Wins!");
    }

    public void oWins(int tic, int tac, int toe){
        buttons[tic].setBackground(Color.GREEN);
        buttons[tac].setBackground(Color.GREEN);
        buttons[toe].setBackground(Color.GREEN);
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText(player2Name + " Wins!");
    }

    public void tie(){
        if(buttons[0].getText() != "" && buttons[1].getText() != "" &&
                buttons[2].getText() != "" && buttons[3].getText() != "" &&
                buttons[4].getText() != "" && buttons[5].getText() != "" &&
                buttons[6].getText() != "" && buttons[7].getText() != "" &&
                buttons[8].getText() != "" && winner == false){
            for(int i = 0; i < 9; i++){
                buttons[i].setBackground(Color.GREEN);
                buttons[i].setEnabled(false);
            }
            textField.setText("It's A Tie!");
            //TODO: Add restart JOption at the end of the game + scores
            //TODO: add leaderboard/number of wins
        }
    }
}

