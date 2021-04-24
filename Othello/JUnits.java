package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.opentest4j.AssertionFailedError;

import java.io.*;
import java.util.ArrayList;

public class JUnits {
    OthelloGUI gui;
    Othello g;

    /**
     * Requirement 3:
     * The system shall begin the game with
     * the default board (10) when gameplay begins.
     */
    @Test
    public void requirement3Size10(){
        g = new Othello(10,'B');
        char[][] defaultBoard = new char[g.getBoard().length][g.getBoard().length];

        for (int i = 0; i < g.getBoard().length; i++) {
            for (int j = 0; j < g.getBoard().length; j++) {
                if (i == (g.getBoard().length / 2 - 1) && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'R';
                } else if (i == (g.getBoard().length / 2 - 1) && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'R';
                } else {
                    defaultBoard[i][j] = '-';
                }
            }
        }

        Assert.assertEquals(g.getBoard(),defaultBoard);
    }

    /**
     * Requirement 3:
     * The system shall begin the game with
     * the default board (8) when gameplay begins.
     */
    @Test
    public void requirement3Size8(){
        g = new Othello(8,'B');
        char[][] defaultBoard = new char[g.getBoard().length][g.getBoard().length];

        for (int i = 0; i < g.getBoard().length; i++) {
            for (int j = 0; j < g.getBoard().length; j++) {
                if (i == (g.getBoard().length / 2 - 1) && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'R';
                } else if (i == (g.getBoard().length / 2 - 1) && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'R';
                } else {
                    defaultBoard[i][j] = '-';
                }
            }
        }

        Assert.assertEquals(g.getBoard(),defaultBoard);
    }

    /**
     * Requirement 3:
     * The system shall begin the game with
     * the default board (6) when gameplay begins.
     */
    @Test
    public void requirement3Size6(){
        g = new Othello(6,'B');
        char[][] defaultBoard = new char[g.getBoard().length][g.getBoard().length];

        for (int i = 0; i < g.getBoard().length; i++) {
            for (int j = 0; j < g.getBoard().length; j++) {
                if (i == (g.getBoard().length / 2 - 1) && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'R';
                } else if (i == (g.getBoard().length / 2 - 1) && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'R';
                } else {
                    defaultBoard[i][j] = '-';
                }
            }
        }

        Assert.assertEquals(g.getBoard(),defaultBoard);
    }

    /**
     * Requirement 3:
     * The system shall begin the game with
     * the default board (4) when gameplay begins.
     */
    @Test
    public void requirement3Size4(){
        g = new Othello(4,'B');
        char[][] defaultBoard = new char[g.getBoard().length][g.getBoard().length];

        for (int i = 0; i < g.getBoard().length; i++) {
            for (int j = 0; j < g.getBoard().length; j++) {
                if (i == (g.getBoard().length / 2 - 1) && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'R';
                } else if (i == (g.getBoard().length / 2 - 1) && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == (g.getBoard().length / 2 - 1)) {
                    defaultBoard[i][j] = 'B';
                } else if (i == g.getBoard().length / 2 && j == g.getBoard().length / 2) {
                    defaultBoard[i][j] = 'R';
                } else {
                    defaultBoard[i][j] = '-';
                }
            }
        }

        Assert.assertEquals(g.getBoard(),defaultBoard);
    }

    /**
     * Requirement 4:
     * The system shall check if a move is
     * available for the current player
     * when the previous player’s turn is complete.
     */
    @Test
    public void requirement4(){
        g = new Othello(4,'B');
        g.placeDiscAt(4,g.getBoard(),1,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,3, g.getCurrentPlayer());
        g.nextPlayer();
        Assert.assertFalse(g.isValidMoveAvailable(4,g.getBoard(),'R'));
    }

    /**
     * Requirement 5:
     * The system shall check if a move
     * is valid when the user has selected a cell.
     */
    @Test
    public void requirement5False() {
        g = new Othello(4,'B');
        Assert.assertFalse(g.isValidMove(g.getBoard().length,g.getBoard(),
                2,2,g.getCurrentPlayer()));
    }

    /**
     * Requirement 5:
     * The system shall check if a move
     * is valid when the user has selected a cell.
     */
    @Test
    public void requirement5True() {
        g = new Othello(4,'B');
        Assert.assertTrue(g.isValidMove(g.getBoard().length,g.getBoard(),
                1,0,g.getCurrentPlayer()));
    }

    /**
     * Requirement 8:
     * The system shall end the game
     * when the board is full or there
     * are no valid moves available for
     * either player.
     */
    @Test
    public void requirement8NoValidMoves() {
        g = new Othello(4,'B');

        g.placeDiscAt(4,g.getBoard(),1,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,3, g.getCurrentPlayer());
        g.placeDiscAt(4,g.getBoard(),3,1, g.getCurrentPlayer());
        g.placeDiscAt(4,g.getBoard(),1,3, g.getCurrentPlayer());

        Assert.assertTrue(g.isGameOver(g.getBoard().length,g.getBoard()));
    }

    /**
     * Requirement 8:
     * The system shall end the game
     * when the board is full or there
     * are no valid moves available for
     * either player.
     */
    @Test
    public void requirement8FullBoard() {
        g = new Othello(4,'B');
        g.placeDiscAt(4,g.getBoard(),2,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,0, g.getCurrentPlayer());
        Assert.assertTrue(g.isGameOver(g.getBoard().length,g.getBoard()));
    }

    /**
     * Requirement 10:
     * The system shall save progress of
     * the game to the file selected by
     * the user when the file has been
     * validated.
     */
    @Test
    public void requirement10saves(){
        g = new Othello(4,'B');
        File file = new File("hello.txt");
        Assert.assertTrue(g.saveGame(file.getName()));
        file.delete();
    }

    /**
     * Requirement 10:
     * The system shall save progress of
     * the game to the file selected by
     * the user when the file has been
     * validated.
     */
    @Test
    public void requirement10SavesCorrectly(){
        g = new Othello(4,'B');

        g.saveGame("hi.txt");

        File file = new File("hi.txt");
        char[][] b;

        try {
            FileReader reader = new FileReader(file);
            if (file.exists()) {
                int size = Character.getNumericValue(reader.read());
                if(size < 4) {
                    size = 10;
                    reader.read();
                }
                reader.read();
                g.setCurrentPlayer((char) reader.read());
                b = new char[size][size];
                char c;
                int k;
                for (int i = 0; i < size; i++) {
                    k = 0;
                    for (int j = 0; j < size * 2; j++) {
                        c = (char) reader.read();
                        if (c != ' ') {
                            b[i][k] = c;
                            k++;
                        }
                    }
                }
                Assert.assertEquals(g.getBoard(),b);
                file.delete();
                reader.close();
            }

        } catch (IOException e) {
            Assert.assertFalse(g.loadGame("hi.txt"));
        }

    }

    /**
     * Requirement 11/12:
     * The system shall display the game board
     * of the game from the file selected when
     * the file has been validated.
     */
    @Test
    public void requirement11Loads(){
        g = new Othello(4,'B');
        File file = new File("hello.txt");
        g.saveGame(file.getName());
        Assert.assertTrue(g.loadGame(file.getName()));
        file.delete();
    }

    /**
     * Requirement 11/12:
     * The system shall display the game board
     * of the game from the file selected when
     * the file has been validated.
     */
    @Test
    public void requirement11LoadsCorrectly(){
        g = new Othello(4,'B');
        g.placeDiscAt(g.getBoard().length,g.getBoard(),1,0,g.getCurrentPlayer());
        char[][] initialBoard = g.getBoard();

        File file = new File("bye.txt");
        g.saveGame(file.getName());

        g = new Othello(10,'R');

        g.loadGame(file.getName());

        Assert.assertEquals(initialBoard,g.getBoard());

        file.delete();
    }

    /**
     * Requirement 18:
     * The system shall check that a high
     * score is valid to save when a
     * game is over.
     */
    @Test
    public void testRequirement18(){
        g = new Othello(4,'B');
        g.placeDiscAt(4,g.getBoard(),2,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,0, g.getCurrentPlayer());

        char winner = g.checkWinner(g.getBoard().length,g.getBoard());

        Assert.assertTrue(new OthelloLeaderBoard("").checkHighScore(g.getScore(winner)));
    }

    /**
     * Requirement 18:
     * The system shall check that a high
     * score is valid to save when a
     * game is over.
     */
    @Test
    public void testRequirement18P2(){
        g = new Othello(4,'B');
        OthelloLeaderBoard lb = new OthelloLeaderBoard("");
        ArrayList<String[]> scores = new  ArrayList<String[]>(10);

        for(int i = 10; i > 0; i--){
            for(int j = 0; j < 1; j++){
                scores.add(new String[]{"Player: " + i,"" + i});
            }
        }

        lb.setScores(scores);

        g.placeDiscAt(4,g.getBoard(),2,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,3, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,2, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,1, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),3,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),2,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),1,0, g.getCurrentPlayer());
        g.nextPlayer();
        g.placeDiscAt(4,g.getBoard(),0,0, g.getCurrentPlayer());

        char winner = g.checkWinner(g.getBoard().length,g.getBoard());

        Assert.assertTrue(lb.checkHighScore(g.getScore(winner)));
    }

    /**
     * Requirement 18:
     * The system shall check that a high
     * score is valid to save when a
     * game is over.
     */
    @Test
    public void testRequirement18P3(){
        g = new Othello(4,'B');
        OthelloLeaderBoard lb = new OthelloLeaderBoard("leaderBoardTest.txt");
        boolean present = false;
        lb.saveHighScore(8,"jacqui");

        File highScores = new File("leaderBoardTest.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(highScores));
            String line = br.readLine();
            while(present == false && line != null) {
                if (line.contains("jacqui"))
                    present = true;
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            new AssertionFailedError();
        } catch (IOException e) {
            new AssertionFailedError();
        }

        Assert.assertTrue(present);

        highScores.delete();
    }
}
