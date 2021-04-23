package com.company;

import org.junit.*;
import org.opentest4j.AssertionFailedError;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class OthelloTest {
    Othello g;
    OthelloGUI gui;

    /**
     * Requirement 1:
     * The system shall create a board size
     * based on user input when
     * the Othello game screen opens.
     */
    @Test
    public void testRequirement1Size4(){
        JOptionPane.showMessageDialog(null, "Test for size 4");
        gui = new OthelloGUI();
        JPanel testPanel = gui.getOthelloPanel();
        int size = 4;

        Component[] componentList = testPanel.getComponents();

        Assert.assertEquals(size*size,componentList.length);
    }

    /**
     * Requirement 1:
     * The system shall create a board size
     * based on user input when
     * the Othello game screen opens.
     */
    @Test
    public void testRequirement1Size6(){
        JOptionPane.showMessageDialog(null, "Test for size 6");

        gui = new OthelloGUI();
        JPanel testPanel = gui.getOthelloPanel();
        int size = 6;

        Component[] componentList = testPanel.getComponents();

        Assert.assertEquals(size*size,componentList.length);
    }

    /**
     * Requirement 1:
     * The system shall create a board size
     * based on user input when
     * the Othello game screen opens.
     */
    @Test
    public void testRequirement1Size8(){
        JOptionPane.showMessageDialog(null, "Test for size 8");

        gui = new OthelloGUI();
        JPanel testPanel = gui.getOthelloPanel();
        int size = 8;

        Component[] componentList = testPanel.getComponents();

        Assert.assertEquals(size*size,componentList.length);
    }

    /**
     * Requirement 1:
     * The system shall create a board size
     * based on user input when
     * the Othello game screen opens.
     */
    @Test
    public void testRequirement1Size10(){
        JOptionPane.showMessageDialog(null, "Test for size 10");

        gui = new OthelloGUI();
        JPanel testPanel = gui.getOthelloPanel();
        int size = 10;

        Component[] componentList = testPanel.getComponents();

        Assert.assertEquals(size*size,componentList.length);
    }

    /**
     * Requirement 2:
     * The system shall provide the user with
     * the ability to choose a color (blue or red)
     * when the Othello game screen opens.
     */
    @Test
    public void testRequirement2B(){
        JOptionPane.showMessageDialog(null, "Test for player B");

        char player = 'B';
        gui = new OthelloGUI();
        String cp = gui.getCurrentPlayer().getText();
        char cp1 = cp.charAt(cp.length()-1);

        Assert.assertEquals(player,cp1);
    }

    /**
     * Requirement 2:
     * The system shall provide the user with
     * the ability to choose a color (blue or red)
     * when the Othello game screen opens.
     */
    @Test
    public void testRequirement2R(){
        JOptionPane.showMessageDialog(null, "Test for player R");

        char player = 'R';
        gui = new OthelloGUI();
        String cp = gui.getCurrentPlayer().getText();
        char cp1 = cp.charAt(cp.length()-1);

        Assert.assertEquals(player,cp1);
    }

    /**
     * Requirement 3:
     * The system shall begin the game
     * with the default board when
     * gameplay begins.
     */
    @Test
    public void testRequirement3(){
        JOptionPane.showMessageDialog(null, "Test for default board");

        gui = new OthelloGUI();

        JButton[][] buttons = gui.getButtons();

        int size = buttons.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == (size / 2 - 1) && j == (size / 2 - 1)) {
                    Assert.assertTrue(buttons[i][j].getBackground().equals(Color.red));
                } else if (i == (size / 2 - 1) && j == size / 2) {
                    Assert.assertTrue(buttons[i][j].getBackground().equals(Color.blue));
                } else if (i == size / 2 && j == (size / 2 - 1)) {
                    Assert.assertTrue(buttons[i][j].getBackground().equals(Color.blue));
                } else if (i == size / 2 && j == size / 2) {
                    Assert.assertTrue(buttons[i][j].getBackground().equals(Color.red));
                } else {
                    Assert.assertTrue(buttons[i][j].getBackground().equals(Color.white));
                }
            }
        }
    }

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
    public void testRequirement4(){
        JOptionPane.showMessageDialog(null,
                "Test for next player\nSize: 4 CP: Blue");

        gui = new OthelloGUI();
        JButton[][] buttons = gui.getButtons();
        ActionEvent ae = new ActionEvent(buttons[1][0],ActionEvent.ACTION_PERFORMED,"");

        gui.actionPerformed(ae);
        char cp = gui.getCurrentPlayer().getText().charAt(gui.getCurrentPlayer().getText().length() - 1);
        Assert.assertEquals('R',cp);


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
     * Requirement 6:
     * The system shall place a disk at
     * the specified cell when the move
     * has been validated.
     */
    @Test
    public void testRequirement6B4(){
        JOptionPane.showMessageDialog(null,
                "Test for place disk: Size: 4 CP: Blue");


        gui = new OthelloGUI();
        char cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);
        Othello g2 = gui.getGame();

        g2.placeDiscAt(gui.getSize(),gui.getBoard(),1,0,cp);
        gui.updateBoard();

        JButton[][] buttons = gui.getButtons();

        Assert.assertTrue(buttons[1][0].getBackground().equals(Color.blue));
    }

    /**
     * Requirement 6:
     * The system shall place a disk at
     * the specified cell when the move
     * has been validated.
     */
    @Test
    public void testRequirement6B6(){
        JOptionPane.showMessageDialog(null,
                "Test for place disk: Size: 6 CP: Blue");


        gui = new OthelloGUI();
        char cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);
        Othello g2 = gui.getGame();

        g2.placeDiscAt(gui.getSize(),gui.getBoard(),2,1,cp);
        gui.updateBoard();

        JButton[][] buttons = gui.getButtons();

        Assert.assertTrue(buttons[2][1].getBackground().equals(Color.blue));
    }

    /**
     * Requirement 6:
     * The system shall place a disk at
     * the specified cell when the move
     * has been validated.
     */
    @Test
    public void testRequirement6B8(){
        JOptionPane.showMessageDialog(null,
                "Test for place disk: Size: 8 CP: Blue");


        gui = new OthelloGUI();
        char cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);
        Othello g2 = gui.getGame();

        g2.placeDiscAt(gui.getSize(),gui.getBoard(),3,2,cp);
        gui.updateBoard();

        JButton[][] buttons = gui.getButtons();

        Assert.assertTrue(buttons[3][2].getBackground().equals(Color.blue));
    }

    /**
     * Requirement 6:
     * The system shall place a disk at
     * the specified cell when the move
     * has been validated.
     */
    @Test
    public void testRequirement6B10(){
        JOptionPane.showMessageDialog(null,
                "Test for place disk: Size: 10 CP: Blue");


        gui = new OthelloGUI();
        char cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);
        Othello g2 = gui.getGame();

        g2.placeDiscAt(gui.getSize(),gui.getBoard(),4,3,cp);
        gui.updateBoard();

        JButton[][] buttons = gui.getButtons();

        Assert.assertTrue(buttons[4][3].getBackground().equals(Color.blue));
    }

    /**
     * Requirement 7:
     * The system shall switch turns to
     * the next player when the disk has
     * been placed and the current player’s
     * turn is over.
     */
    @Test
    public void testRequirement7B(){
        JOptionPane.showMessageDialog(null,
                "Test for next player functionality\nSize: 4 CP: Blue");

        gui = new OthelloGUI();
        Othello g2 = gui.getGame();

        char cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);

        g2.placeDiscAt(gui.getSize(),gui.getBoard(),1,0,cp);
        g2.nextPlayer();
        gui.updateBoard();

        cp = gui.getCurrentPlayer().getText().charAt(
                gui.getCurrentPlayer().getText().length()-1);

        Assert.assertEquals(cp,'R');
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
     * Requirement 12:
     * The system shall display the game
     * board of the game from the file
     * selected when the file has been validated.
     */
    @Test
    public void testRequirement12(){
        JOptionPane.showMessageDialog(null,
                "Test for Load Game functionality" +
                        "\nSize: 4 CP: B");

        gui = new OthelloGUI();
        Othello g2 = gui.getGame();
        char[][] initialboard = gui.getBoard();
        File file = new File("loadGameTest.txt");
        g2.saveGame(file.getName());

        g2.placeDiscAt(initialboard.length, gui.getBoard(),1,0,g2.getCurrentPlayer());
        g2.nextPlayer();
        g2.placeDiscAt(initialboard.length,gui.getBoard(),2,0,g2.getCurrentPlayer());

        g2.loadGame(file.getName());
        gui.updateBoard();
        char[][] newBoard = gui.getBoard();

        Assert.assertEquals(initialboard,newBoard);
        file.delete();
    }

    /**
     * Requirement 13:
     * The system shall display the game
     * board with the size given by the
     * user when the user has selected
     * the menu item “Restart Game”.
     */
    @Test
    public void testRequirement13Size4(){
        JOptionPane.showMessageDialog(null,
                "Test for Restart Game functionality\n" +
                        "RESTART W/ Size:4 CP: B");

        gui = new OthelloGUI();
        ActionEvent ae = new ActionEvent(gui.getRestartMI(),ActionEvent.ACTION_PERFORMED,"");

        gui.actionPerformed(ae);

        Assert.assertTrue(gui.getSize() == 4 && gui.getGame().getCurrentPlayer() == 'B');
    }

    /**
     * Requirement 13:
     * The system shall not switch
     * players when a move has been
     * determined invalid.
     */
    @Test
    public void testRequirement13GameOverNVM(){
        JOptionPane.showMessageDialog(null,
                "Test Restart Game Over Functionality" +
                "SIZE: 4 CP: B");

        gui = new OthelloGUI();
        g = gui.getGame();
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

        JOptionPane.showMessageDialog(null,
                "Restart with SIZE: 10 CP: R");

        //RESTART GAME SIZE: 10 CP: R
        gui.checkGameOver();

        Assert.assertTrue(gui.getSize() == 10 && gui.getGame().getCurrentPlayer() == 'R');
    }

    /**
     * Requirement 13:
     * The system shall not switch
     * players when a move has been
     * determined invalid.
     */
    @Test
    public void testRequirement13GameOverBF(){
        JOptionPane.showMessageDialog(null,
                "Test Restart Game Over Functionality\n" +
                        "SIZE: 4 CP: B");

        gui = new OthelloGUI();
        g = gui.getGame();
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

        JOptionPane.showMessageDialog(null,
                "Restart with SIZE: 10 CP: R");

        //RESTART GAME SIZE: 10 CP: R
        gui.checkGameOver();

        Assert.assertTrue(gui.getSize() == 10 && g.getCurrentPlayer() == 'R');
    }

    /**
     * Requirement 14:
     * The system shall switch to the next
     * player when the current player has
     * no available moves.
     */
    @Test
    public void testRequirement14Size4(){
        JOptionPane.showMessageDialog(null,
                "Test \n Size: 4 CP: B");

        gui = new OthelloGUI();
        JButton[][] buttons = gui.getButtons();
        ActionEvent[][] actionEvents = new ActionEvent[buttons.length][buttons.length];

        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons.length; j++){
                actionEvents[i][j] = new ActionEvent(buttons[i][j],ActionEvent.ACTION_PERFORMED,"");
            }
        }

        gui.actionPerformed(actionEvents[1][0]); //b
        gui.actionPerformed(actionEvents[2][0]); //r
        gui.actionPerformed(actionEvents[3][0]); //b
        gui.actionPerformed(actionEvents[0][2]); //r
        gui.actionPerformed(actionEvents[2][3]); //b
        gui.actionPerformed(actionEvents[3][2]); //r
        gui.actionPerformed(actionEvents[3][3]); //b

        Assert.assertEquals(gui.getCurrentPlayer().getText().charAt(gui.getCurrentPlayer().getText().length()-1),'B');
    }

    /**
     * Requirement 15:
     * The system shall not switch
     * players when a move has been
     * determined invalid.
     */
    @Test
    public void testRequirement15(){
        JOptionPane.showMessageDialog(null,
                "Test Invalid Move functionality\n" +
                        "Size: 4 CP: B");

        gui = new OthelloGUI();
        char initCP = gui.getCurrentPlayer().getText().
                charAt(gui.getCurrentPlayer().getText().length() - 1);
        JButton[][] buttons = gui.getButtons();
        ActionEvent[][] actionEvents = new ActionEvent[buttons.length][buttons.length];

        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons.length; j++){
                actionEvents[i][j] = new ActionEvent(buttons[i][j],ActionEvent.ACTION_PERFORMED,"");
            }
        }

        char newCP = gui.getCurrentPlayer().getText().
                charAt(gui.getCurrentPlayer().getText().length() - 1);
        gui.actionPerformed(actionEvents[1][1]); //invalid move

        Assert.assertEquals(initCP,newCP);
    }

    /**
     * Requirement 16:
     * The system shall display the new
     * player scores when a move has been
     * successfully made.
     */
    @Test
    public void testRequirement16(){
        JOptionPane.showMessageDialog(null,
                "Test Scores Functionality\n" +
                        "Size: 4 CP: B");

        gui = new OthelloGUI();
        JButton[][] buttons = gui.getButtons();
        ActionEvent[][] actionEvents = new ActionEvent[buttons.length][buttons.length];

        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons.length; j++){
                actionEvents[i][j] = new ActionEvent(buttons[i][j],ActionEvent.ACTION_PERFORMED,"");
            }
        }

        gui.actionPerformed(actionEvents[1][0]);

        int k = 0;
        String bluePoints = gui.getBluePoints().getText();
        while(!Character.isDigit(bluePoints.charAt(k)))
            k++;

        int bp = Integer.parseInt("" + bluePoints.charAt(k));

        k = 0;
        String redPoints = gui.getRedPoints().getText();
        while(!Character.isDigit(redPoints.charAt(k)))
            k++;

        int rp = Integer.parseInt("" + redPoints.charAt(k));

        Assert.assertTrue(bp == gui.getGame().getBlueScore() && rp == gui.getGame().getRedScore());
    }

    /**
     * Requirement 17:
     * The system shall display the leaderboard
     * when the user selects "Check Leaderboard".
     */
    @Test
    public void testRequirement17MenuItem(){
        JOptionPane.showMessageDialog(null,
                "Test Leader Board Functionality");

        gui = new OthelloGUI();

        ActionEvent actionEvent = new ActionEvent(gui.getLeaderboardMI(),ActionEvent.ACTION_PERFORMED,"");

        gui.actionPerformed(actionEvent);

        Assert.assertTrue(gui.getLeaderBoard().isShowing());
    }

    /**
     * Requirement 17:
     * The system shall display the leaderboard
     * when the user selects "Check Leaderboard".
     */
    @Test
    public void testRequirement17Gameover(){
        JOptionPane.showMessageDialog(null,
                "Test Leader Board Functionality");

        gui = new OthelloGUI();
        g = gui.getGame();
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

        JOptionPane.showMessageDialog(null,
                "SELECT LEADER BOARD");

        gui.checkGameOver();

        Assert.assertTrue(gui.getLeaderBoard().isShowing());
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
