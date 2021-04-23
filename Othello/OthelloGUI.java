package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//***************************************************
// Filename: OthelloGUI.java
// Date: 03.17.21
// Author(s): Ariana Sherrod-Cavanaugh
//***************************************************

public class OthelloGUI implements ActionListener {
    /** Othello JFrame. **/
    protected JFrame othelloFrame;

    /** Othello JPanel. **/
    protected JPanel othelloPanel;

    /** 2D JButton array of buttons on board. **/
    protected JButton[][] buttons;

    /** GridLayout of JFrame. **/
    protected GridLayout layout;

    /** Menu Bar on JFrame. **/
    protected JMenuBar menu;

    /** Help menu JMenu on JMenuBar. **/
    protected JMenu helpMenu;

    /** Exit menu JMenu on JMenuBar. **/
    protected JMenu exitMenu;

    /** ArrayLists of MenuItems in Help Menu. **/
    protected ArrayList<JMenuItem> helpMenuItems;

    /** ArrayLists of MenuItems in Exit Menu. **/
    protected ArrayList<JMenuItem> exitMenuItems;

    /** MenuItems in Help Menu. **/
    protected JMenuItem gameInstructMI;

    /** MenuItems in Help Menu. **/
    protected JMenuItem saveGameMI;

    /** MenuItems in Help Menu. **/
    protected JMenuItem loadGameMI;

    /** MenuItems in Help Menu. **/
    protected JMenuItem leaderboardMI;

    /** MenuItems in Help Menu. **/
    protected JMenuItem restartMI;

    /** MenuItems in Exit Menu. **/
    protected JMenuItem exitHomeScreenMI;

    /** MenuItems in Exit Menu. **/
    protected JMenuItem exitProgMI;

    /** JLabel for Red's Score. **/
    protected JLabel redPoints;

    /** JLabel for Blue's Score. **/
    protected JLabel bluePoints;

    /** JLabel for the Current Player. **/
    protected JLabel currentPlayer;

    /** Othello object variable. **/
    protected Othello game;

    /** 2D char-array of the Othello board. **/
    protected char[][] board;

    /** Size of the Othello board. **/
    protected int size;

    protected OthelloLeaderBoard leaderBoard;

    /**
     * Constructor.
     */
    public OthelloGUI() {
        leaderBoard = new OthelloLeaderBoard("highscores.txt");

        //Asking for details of game
        //(multiplayer, size of board,
        //first player, etc.)
        gameSetup();

        //Initializing values
        currentPlayer = new JLabel();
        othelloFrame = new JFrame();
        othelloPanel = new JPanel();

        buttons = new JButton[size][size];
        layout = new GridLayout(size, size);

        //Creating MenuBar
        menu = new JMenuBar();
        helpMenu = new JMenu("Help");
        exitMenu = new JMenu("Exit");

        //Menu items of each menu in the menu bar
        gameInstructMI = new JMenuItem("Game Instructions");
        saveGameMI = new JMenuItem("Save Game");
        loadGameMI = new JMenuItem("Load Game");
        leaderboardMI = new JMenuItem("LeaderBoard");
        restartMI = new JMenuItem("Restart Game");

        exitHomeScreenMI = new JMenuItem("Exit To Home Screen");
        exitProgMI = new JMenuItem("Exit Program");

        helpMenuItems = new ArrayList<>();
        exitMenuItems = new ArrayList<>();

        redPoints = new JLabel(
                "Red Score: " + game.getRedScore() + "    ");
        bluePoints = new JLabel(
                "Blue Score: " + game.getBlueScore() + "    ");

        helpMenuItems.add(gameInstructMI);
        helpMenuItems.add(saveGameMI);
        helpMenuItems.add(loadGameMI);
        helpMenuItems.add(leaderboardMI);
        helpMenuItems.add(restartMI);
        exitMenuItems.add(exitHomeScreenMI);
        exitMenuItems.add(exitProgMI);

        for (JMenuItem helpMenuItem : helpMenuItems) {
            helpMenuItem.addActionListener(this);
        }

        for (JMenuItem exitMenuItem : exitMenuItems) {
            exitMenuItem.addActionListener(this);
        }

        //Initializing values for othelloPanel
        othelloPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        othelloPanel.setLayout(layout);

        //Initializing values for othelloFrame
        othelloFrame.setSize(800,500);
        othelloFrame.setJMenuBar(menu);
        othelloFrame.add(othelloPanel, BorderLayout.CENTER);
        othelloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        othelloFrame.setTitle("OTHELLO");
        othelloFrame.setVisible(true);

        menu.setForeground(Color.WHITE);
        redPoints.setForeground(Color.WHITE);
        bluePoints.setForeground(Color.WHITE);
        currentPlayer.setForeground(Color.WHITE);

        //Adding menu items to menus
        for (JMenuItem helpMenuItem : helpMenuItems) {
            helpMenu.add(helpMenuItem);
        }

        for (JMenuItem exitMenuItem : exitMenuItems) {
            exitMenu.add(exitMenuItem);
        }

        //Adding menus to menu bar
        menu.add(helpMenu);
        menu.add(exitMenu);
        menu.add(redPoints);
        menu.add(bluePoints);
        menu.add(currentPlayer);

        //Initializing buttons for gameScreen
        createGameScreen();

        currentPlayer.setText("Current Player: " + game.getCurrentPlayer());
    }

    /**
     * Sets up basic functionality of the game.
     * Prompts user for single/multiplayer option,
     * game board size, difficulty level, etc.
     */
    protected void gameSetup() {
        //Ask user the size that the board should be
        String[] sizeOptions = {"10", "8", "6", "4"};
        int s = JOptionPane.showOptionDialog(null,
                "What size (mxm) would you like the board?",
                "Start Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, sizeOptions, sizeOptions[0]);
        size = Integer.parseInt(sizeOptions[s]);

        //Prompting players to choose colors
        String[] playerOptions = {"Red", "Blue"};
        int b = JOptionPane.showOptionDialog(null, "Who will play first?",
                "Start Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, playerOptions, playerOptions[0]);

        char beginningPlayer;

        if ("Red".equals(playerOptions[b])) {
            beginningPlayer = 'R';
        } else {
            beginningPlayer = 'B';
        }

        game = new Othello(size, beginningPlayer);
        game.updateScores();
        board = game.getBoard();
    }

    /**
     * Sets up the game screen with buttons
     * and their initial colors.
     */
    protected void createGameScreen() {
        //Adding buttons to initialize game screen
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);

                if (board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                } else if (board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                } else {
                    buttons[i][j].setBackground(Color.white);
                }
                buttons[i][j].setOpaque(true);
                othelloPanel.add(buttons[i][j]);
                layout.addLayoutComponent("testName", buttons[i][j]);
            }
        }
    }

    /**
     * Controls what happens when a button or menu
     * item is pressed in the GUI.
     * @param e
     */
    @Override
    public void actionPerformed (ActionEvent e) {
        Object pressed = e.getSource();

        //If menu item is pressed
        if (helpMenuItems.contains(pressed)
                || exitMenuItems.contains(pressed)) {
            menuItems(pressed);
            //If button in game is pressed
        } else if (pressed == e.getSource()) {
            buttons(pressed);
            if (!game.isValidMoveAvailable(board.length, board, game.getCurrentPlayer()) && !game.isGameOver(board.length,board)) {
                JOptionPane.showMessageDialog(othelloFrame,
                        "No valid moves available for player "
                                + game.getCurrentPlayer() + "! "
                                + "You lose your turn.");
                game.nextPlayer();
                updateBoard();
            }
            checkGameOver();
        }
    }

    /**
     * Controls what happens when a menu
     * item is pressed in the GUI.
     * @param pressed
     */
    protected void menuItems(Object pressed) {
        if (helpMenuItems.contains(pressed)) {
            pressed = helpMenuItems.get(helpMenuItems.indexOf(pressed));
            if (pressed == gameInstructMI) { //Display Game instructions
                JOptionPane.showMessageDialog(othelloFrame,
                        "How to play Othello: \n"
                                + "The goal of the game is to get the "
                                + "majority of color discs on the board  "
                                + "at the end of the game. \n A move is "
                                + "made by placing a disc of the current "
                                + "player's color on the board in a position "
                                + "that \"out-flanks\" one or more of "
                                + "the opponent's discs. \nA disc or "
                                + "row of discs is outflanked when it is "
                                + "surrounded at the ends by discs of the"
                                + " opposite color. \nA disc may outflank "
                                + "any number of discs in one or more rows "
                                + "in any direction (horizontal, vertical, "
                                + "diagonal).\nAll the discs which are "
                                + "outflanked will be flipped.\n If you can't "
                                + "outflank and flip at least one "
                                + "opposing disc, you lose your turn. "
                                + "However, if a move is available to you, "
                                + "you can't forfeit your turn.\nWhen it "
                                + "is no longer possible for either player "
                                + "to move or the board is full, the "
                                + "game is over.\n Good Luck!");
            } else if (pressed == saveGameMI) { //Save Game
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                while (fc.showSaveDialog(othelloFrame)
                        == JFileChooser.APPROVE_OPTION
                        && !game.saveGame(fc.
                        getSelectedFile().getAbsolutePath())) {
                    if (fc.getSelectedFile().isDirectory()) {
                        JOptionPane.showMessageDialog(othelloFrame,
                                "This is a directory! "
                                        + "Please create a text file.");
                    } else {
                        JOptionPane.showMessageDialog(othelloFrame,
                                "This file already exists! "
                                        + "Please choose a new name.");
                    }
                }
                game.saveGame(fc.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(othelloFrame, "File Saved!");

            } else if (pressed == loadGameMI) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                while (fc.showOpenDialog(null)
                        == JFileChooser.APPROVE_OPTION
                        && !game.loadGame(fc.
                        getSelectedFile().getAbsolutePath())) {
                    JOptionPane.showMessageDialog(othelloFrame,
                            "Please choose a text file!");
                }
                resetBoard(size);
                size = board.length;
            } else if (pressed == leaderboardMI){
                leaderBoard.displayLeaderBoard();
            } else if (pressed == restartMI) {
                int s = JOptionPane.showConfirmDialog(null,"Are you sure you'd like to restart?\n" +
                        "Your progress may not be saved.");
                if (s == JOptionPane.YES_OPTION) {
                    int initialSize = size;
                    gameSetup();
                    resetBoard(initialSize);
                }
            }

        } else if (exitMenuItems.contains(pressed)) {
            if (pressed == exitHomeScreenMI) {
                othelloFrame.setVisible(false);
            } else if (pressed == exitProgMI) {
                System.exit(0);
            }
        }
    }

    /**
     * Controls what happens when a button
     * is pressed during gameplay.
     * @param pressed
     */
    protected void buttons(Object pressed) {
        if (!game.isGameOver(board.length, board)) {
            do {
                for (int i = 0; i < buttons.length; i++) {
                    for (int j = 0; j < buttons[i].length; j++) {
                        if (pressed.equals(buttons[i][j])) {
                            if (!game.isValidMove(board.length,
                                    board, i, j, game.getCurrentPlayer())) {
                                JOptionPane.showMessageDialog(othelloFrame,
                                        "Sorry! That is not a "
                                                + "valid move, please try again.");
                                break;
                            } else {
                                game.placeDiscAt(board.length, board, i, j, game.getCurrentPlayer());
                                game.nextPlayer();
                                updateBoard();
                            }
                        }
                    }
                }
                break;
            } while (true);
        }
    }

    /**
     * Controls what happens on screen
     * if the game is over.
     */
    protected void checkGameOver() {
        if (game.isGameOver(board.length, board)) {
            char winner = game.checkWinner(board.length, board);
            if(winner != 'T') {
                if (game.isBoardFull(size, game.getBoard())) {
                    JOptionPane.showMessageDialog(othelloFrame, "Game over!!! \nPlayer " + winner + " Wins!");
                } else {
                    JOptionPane.showMessageDialog(othelloFrame, "Game over!!! \nNo valid moves left. \n"
                            + game.checkWinner(board.length, board) + " Wins!");
                }
            } else if (game.isBoardFull(size, game.getBoard())) {
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! \nIt's a tie!");
            } else {
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! \nNo valid moves left. \nIt's a tie!");
            }

            //Save high score?
            if(leaderBoard.checkHighScore(game.getScore(winner))){
                if(JOptionPane.showConfirmDialog(othelloFrame, "Would you like to save this high score?")
                        == JOptionPane.YES_OPTION){
                    String playerName = JOptionPane.showInputDialog(othelloFrame, "Alright!\nWhat's your name?");
                    leaderBoard.saveHighScore(game.getScore(winner),playerName);
                    JOptionPane.showMessageDialog(othelloFrame, "High Score Saved :)");
                }
            }

            //Restart or exit options
            String[] options = {"Exit to Main Menu", "Exit Program", "Check Leader Board", "Restart"};

            int x = JOptionPane.showOptionDialog(null, "Would you like to restart the game or exit?",
                    "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, null);
            if (x == 0) {
                othelloFrame.setVisible(false);
            } else if (x == 1 || x == JOptionPane.CLOSED_OPTION) {
                System.exit(1);
            } else if (x == 2) {
                leaderBoard.displayLeaderBoard();
            } else if (x == 3){
                int initialSize = size;
                gameSetup();
                resetBoard(initialSize);
            }
        }
    }

    /**
     * Updates the board after a turn has been
     * taken.
     */
    protected void updateBoard() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                } else if (board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                }
                buttons[i][j].setOpaque(true);
            }
        }
        game.updateScores();
        redPoints.setText("Red Score: " + game.getRedScore() + "    ");
        bluePoints.setText("Blue Score: " + game.getBlueScore() + "    ");
        currentPlayer.setText("Current Player: " + game.getCurrentPlayer());
    }

    /**
     * Resets the board when a game is being
     * loaded or the game is being restarted
     * with a new configuration.
     * @param initialSize
     */
    protected void resetBoard(int initialSize) {
        Container parent = buttons[0][0].getParent();
        for (int i = 0; i < initialSize; i++) {
            for (int j = 0; j < initialSize; j++) {
                parent.remove(buttons[i][j]);
                parent.revalidate();
                parent.repaint();
            }
        }
        board = game.getBoard();
        buttons = new JButton[board.length][board.length];
        layout = new GridLayout(board.length, board.length);
        parent.setLayout(layout);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);

                if (board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setOpaque(true);
                } else if (board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                    buttons[i][j].setOpaque(true);
                }
                parent.add(buttons[i][j]);
                layout.addLayoutComponent("testName", buttons[i][j]);
                parent.revalidate();
                parent.repaint();
            }
        }
        updateBoard();
    }

    /**
     * Gets the Othello JPanel
     * @return
     */
    public JPanel getOthelloPanel() {
        return othelloPanel;
    }

    /**
     * Gets the 2D array of JButtons
     * @return
     */
    public JButton[][] getButtons() {
        return buttons;
    }

    /**
     * Gets the restart MenuItem
     * @return
     */
    public JMenuItem getRestartMI() {
        return restartMI;
    }

    /**
     * Gets the leaderboard MenuItem
     * @return
     */
    public JMenuItem getLeaderboardMI() {
        return leaderboardMI;
    }

    /**
     * Gets the red points JLabel
     * @return
     */
    public JLabel getRedPoints() {
        return redPoints;
    }

    /**
     * Gets the blue points JLabel
     * @return
     */
    public JLabel getBluePoints() {
        return bluePoints;
    }

    /**
     * Gets the current player JLabel
     * @return
     */
    public JLabel getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the Othello object
     * associated with the GUI
     * @return
     */
    public Othello getGame() {
        return game;
    }

    /**
     * Gets the 2D char array
     * of the board.
     * @return
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Gets the size of the board
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the leaderboard associated
     * with the GUI
     * @return
     */
    public OthelloLeaderBoard getLeaderBoard() {
        return leaderBoard;
    }
}
