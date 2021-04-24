package com.company;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class IntegrativeTests {
    OthelloGUI gui;
    Othello g;

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
}
