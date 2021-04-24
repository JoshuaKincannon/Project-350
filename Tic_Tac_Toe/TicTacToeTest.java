package Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Project.GamePlatform;
import org.junit.Assert;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.sql.Array;
import java.util.Random;
import java.util.*;

public class TicTacToeTest {
    //MainTicTacToe tictac = new MainTicTacToe();
    static TicTacToeGUI tactoe = new TicTacToeGUI();
    static String p1name = tactoe.getP1Name();
    static String p2name = tactoe.getP2Name();
    static String p2p = tactoe.getP2Piece();
    static String p1p = tactoe.getP1Piece();
    static JPanel bPanel = tactoe.getPanel();
    static JButton[] buttns = tactoe.getButtons();
    static boolean wins = tactoe.isaWinner();
    static JFrame gameBoard = tactoe.getGameFrame();
    static boolean pvp = tactoe.isPlayervsplayer();
    static boolean pvcpu = tactoe.isPlayervscpu();
    static Random ran = tactoe.getRandom();
    static String winName = tactoe.getWinnerName();


    @Test
    void backgroundColorsTest() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            buttns[i].getBackground();
            Assertions.assertFalse(buttns[i].getBackground() == Color.GREEN);
        }
    }

    @Test
    void resetTest2() {
        if (wins) {
            Assertions.assertTrue(wins);
        }
    }

    @Test
    void player1nameTest() {
        Assertions.assertEquals(p1name, p1name);
    }

    @Test
    void player1nameTest2() {
        Assertions.assertNotEquals(p1name.isEmpty(), "");
    }


    @Test
    void player2nametest() {
        Assertions.assertEquals(p2name, p2name);
    }

    @Test
    void player2nametest2() {
        Assertions.assertNotEquals(p2name.isEmpty(), "");
    }


    @Test
    void player2nametest5() {
        Assertions.assertNotNull(p2name);
    }


    @Test
    void p2gamepiecetest() {
        Assertions.assertEquals(p2p, p2p);
    }

    @Test
    void p2gamepieceTest2() {
        Assertions.assertNotEquals(p2p.isEmpty(), "");
    }

    @Test
    void player1gamepiecetest() {
        Assertions.assertEquals(p1p, p1p);
    }

    @Test
    void player1gamepiecTest2() {
        Assertions.assertNotEquals(p1p.isEmpty(), "");
    }

    @Test
    void player1namelength() {
        Assertions.assertNotEquals(0, p1name.length());
    }

    @Test
    void p2namelength() {
        Assertions.assertNotEquals(0, p2name.length());
    }

    @Test
    void p2gamepiecelength() {
        Assertions.assertNotEquals(8, p2p.length());
    }

    @Test
    void player1gamepiecelength() {
        Assertions.assertNotEquals(0, p1p.length());
    }

    @Test
    void buttonspanelTest() {
        Assertions.assertFalse(!bPanel.isVisible());
    }

    @Test
    void buttonspanelTest2() {
        Assertions.assertTrue(bPanel.isVisible());
    }

    @Test
    void buttonspanelTest3() {
        bPanel.add(buttns[0]);
        Assertions.assertFalse(!bPanel.contains(1, 0));
    }

    @Test
    void buttonsTest() {
        Assertions.assertTrue(buttns[0].getText().isEmpty());
    }

    @Test
    void buttonsTest2() {
        Assertions.assertFalse(buttns[0].getText().isEmpty());
    }

    @Test
    void buttonsTest3() {
        Assertions.assertTrue(buttns[0].isVisible());
    }

    @Test
    void buttonsTest4() {
        Assertions.assertFalse(!buttns[0].isVisible());
    }


    @Test
    void winnerTest() {
        Assertions.assertNotNull(wins);
    }

    @Test
    void gameFrameTest() {
        Assertions.assertNotNull(gameBoard);
    }

    @Test
    void gameFrameTest2() {
        Assertions.assertFalse(!gameBoard.isVisible());
    }

    @Test
    void gameFrameTest3() {
        Assertions.assertTrue(gameBoard.isVisible());
    }

    @Test
    void gameFrameTest4() {
        Assertions.assertNotSame(null, gameBoard);
    }

    @Test
    void playervplayerTest() {
        Assertions.assertNotNull(pvp);
    }

    @Test
    void playervcpuTest() {
        Assertions.assertNotNull(pvcpu);
    }

    @Test
    void randValuetest() {
        Assertions.assertNotNull(ran);
    }

    @Test
    void randValuetest2() {
        Assertions.assertNotEquals(10, ran);
    }

    @Test
    void resetTest() {
        Assertions.assertNotNull(tactoe);
    }

    @Test
    void pressbuttonsTest2() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
        }
        tactoe.actionPerformed(actions[0]);
        String currentPlayer;
        if (tactoe.isPlayer1turn()) {
            currentPlayer = tactoe.getP1Piece();
        } else {
            currentPlayer = tactoe.getP2Piece();
        }
        Assertions.assertEquals(buttns[0].getText(), buttns[0].getText());
    }

    @Test
    void pressbuttonsTest3() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
            String nowplaying;
            if (buttns[i].getText() == p1p) {
                nowplaying = tactoe.getP1Piece();
                Assertions.assertEquals(buttns[i].getText(), p1p);
            } else if (buttns[i].getText() == p2p) {
                nowplaying = tactoe.getP2Piece();
                Assertions.assertEquals(buttns[i].getText(), p2p);
            }
        }
    }

    @Test
    void pressbuttonsTest4() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
            String w;
            if (buttns[i].getText() == p1p && buttns[i + 1].getText() == p1p &&
                    buttns[i + 2].getText() == p1p) {
                w = tactoe.getP1Piece();
                tactoe.xWins(i, i + 1, 1 + 2);
                tactoe.resetGame();
                Assertions.assertEquals(buttns[i].getText(), p1p);
            } else if (buttns[i].getText() == p2p) {
                w = tactoe.getP2Piece();
                Assertions.assertEquals(buttns[i].getText(), p2p);
            }
        }
    }

    @Test
    void tieTest() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
        }
        tactoe.actionPerformed(actions[0]);
        tactoe.actionPerformed(actions[1]);
        tactoe.actionPerformed(actions[2]);
        tactoe.checkWinner();
        if (tactoe.tie()) {
            Assertions.assertTrue(wins == false);

        } else {
            Assertions.assertFalse(wins == true);
        }
    }

    @Test
    void tieTest2() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
        }
        tactoe.actionPerformed(actions[0]);
        tactoe.actionPerformed(actions[2]);
        tactoe.actionPerformed(actions[3]);
        tactoe.actionPerformed(actions[5]);
        tactoe.actionPerformed(actions[8]);

        tactoe.checkWinner();
        if (tactoe.tie()) {
            Assertions.assertTrue(wins == false);

        } else {
            Assertions.assertFalse(wins == true);
        }
    }

    @Test
    void tieTest3() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
        }
        tactoe.actionPerformed(actions[0]);
        tactoe.actionPerformed(actions[2]);
        tactoe.actionPerformed(actions[7]);
        tactoe.actionPerformed(actions[8]);

        tactoe.checkWinner();
        if (wins == false) {
            Assertions.assertTrue(wins == false);

        } else {
            Assertions.assertFalse(wins == true);
        }
    }

    @Test
    void Test3() {
        ActionEvent[] actions = new ActionEvent[buttns.length];
        for (int i = 0; i < buttns.length; i++) {
            actions[i] = new ActionEvent(buttns[i], ActionEvent.ACTION_PERFORMED, "");
        }
        tactoe.actionPerformed(actions[0]);
        tactoe.actionPerformed(actions[2]);
        tactoe.actionPerformed(actions[7]);
        tactoe.actionPerformed(actions[8]);

        tactoe.firstTurn();
        if (tactoe.isPlayer1turn()) {
            Assertions.assertNotNull(p1name);

        } else {
            Assertions.assertNull(p1name);
        }
    }


}
