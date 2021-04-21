package CIS350Project;

import javax.swing.*;

/**
 * Main method for TicTacToe
 */
public class MainTicTacToe {
    public static void main(String[] args) {
        //Game directions
        final int newttt = JOptionPane.showConfirmDialog(null, "Directions: \n" +
                        "Please enter your name and game piece," +
                        " then choose who you would like to play against.\n" +
                        "You can enter another person's name and " +
                        "choose a game piece or enter our CPU system (R2D2) and play!",
                "Tic Tac Toe", JOptionPane.PLAIN_MESSAGE);
        if(newttt == JOptionPane.CANCEL_OPTION || newttt == JOptionPane.CLOSED_OPTION){
            System.exit(0);
        }

        new TicTacToeGUI();
    }
}
