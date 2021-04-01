package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

//***************************************************
// Filename: OthelloGUI.java
// Date: 03.17.21
// Author(s): Ariana Sherrod-Cavanaugh
//***************************************************

public class OthelloGUI implements ActionListener{

    /** Othello object variable **/
    private Othello game;

    /** 2D char-array of the Othello board **/
    private char[][] board;

    /** Char of the computer's color **/
    private char ai;

    /** Size of the Othello board **/
    private int size;

    /** Othello JFrame **/
    private final JFrame othelloFrame;

    /** Othello JPanel **/
    private final JPanel othelloPanel;

    /** 2D JButton array of buttons on board **/
    private JButton[][] buttons;

    /** GridLayout of JFrame **/
    private GridLayout layout;

    /** ArrayLists of MenuItems in Menus **/
    private final ArrayList<JMenuItem> helpMenuItems;
    private final ArrayList<JMenuItem> exitMenuItems;

    /** MenuItems **/
    private final JMenuItem gameInstructMI;
    private final JMenuItem saveGameMI;
    private final JMenuItem loadGameMI;
    private final JMenuItem exitHomeScreenMI;
    private final JMenuItem exitProgMI;

    /** JLabel for Red's Score **/
    private final JLabel redPoints;

    /** JLabel for Blue's Score **/
    private final JLabel bluePoints;

    /** JLabel for Highest Score **/
    private final JLabel highScore;

    /** JLabel for the Current Player **/
    private final JLabel currentPlayer;

    /**
     * Constructor
     */
    public OthelloGUI() {
        //Asking for details of game
        //(multiplayer, size of board,
        //first player, etc.)
        gameSetup();

        //Creating the menu bar
        JMenuBar menu = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenu exitMenu = new JMenu("Exit");

        //Menu items of each menu in the menu bar
        gameInstructMI = new JMenuItem("Game Instructions");
        saveGameMI = new JMenuItem("Save Game");
        loadGameMI = new JMenuItem("Load Game");
        exitHomeScreenMI = new JMenuItem("Exit To Home Screen");
        exitProgMI = new JMenuItem("Exit Program");

        helpMenuItems = new ArrayList<>();
        exitMenuItems = new ArrayList<>();

        helpMenuItems.add(gameInstructMI);
        helpMenuItems.add(saveGameMI);
        helpMenuItems.add(loadGameMI);
        exitMenuItems.add(exitHomeScreenMI);
        exitMenuItems.add(exitProgMI);

        for (JMenuItem helpMenuItem : helpMenuItems)
            helpMenuItem.addActionListener(this);

        for (JMenuItem exitMenuItem : exitMenuItems)
            exitMenuItem.addActionListener(this);

        //Initializing JFrame, Panel, al, buttons array, layout, and multiplayer optionPane
        redPoints = new JLabel("Red Score: " + game.getRedScore() + "    ");
        bluePoints = new JLabel("Blue Score: " + game.getBlueScore() + "    ");
        highScore = new JLabel("High Score: " + getHighScore() + "    ");

        currentPlayer = new JLabel();
        othelloFrame = new JFrame();
        othelloPanel = new JPanel();

        buttons = new JButton[size][size];
        layout = new GridLayout(size, size);

        //Initializing values for othelloPanel
        othelloPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        othelloPanel.setLayout(layout);

        //Initializing values for othelloFrame
        othelloFrame.setJMenuBar(menu);
        othelloFrame.add(othelloPanel, BorderLayout.CENTER);
        othelloFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        othelloFrame.setTitle("OTHELLO");
        othelloFrame.setVisible(true);

        menu.setForeground(Color.WHITE);
        redPoints.setForeground(Color.WHITE);
        bluePoints.setForeground(Color.WHITE);
        highScore.setForeground(Color.WHITE);
        currentPlayer.setForeground(Color.WHITE);

        //Adding menu items to menus
        for (JMenuItem helpMenuItem : helpMenuItems)
            helpMenu.add(helpMenuItem);

        for (JMenuItem exitMenuItem : exitMenuItems)
            exitMenu.add(exitMenuItem);

        //Adding menus to menu bar
        menu.add(helpMenu);
        menu.add(exitMenu);
        menu.add(redPoints);
        menu.add(bluePoints);
        menu.add(highScore);
        menu.add(currentPlayer);

        //Initializing buttons for gameScreen
        createGameScreen();

        currentPlayer.setText("Current Player: " + game.getCurrentPlayer());

        othelloFrame.pack();
    }

    /**
     * Sets up basic functionality of the game.
     * Prompts user for single/multiplayer option,
     * game board size, difficulty level, etc.
     */
    private void gameSetup() {
        int players = 0;

        //Asking user how many players there will be in the game
        String[] options = { "Two-Player", "Single Player"};
        int i = JOptionPane.showOptionDialog(null, "Single-Player or Multi-Player?",
                "Start Game",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if(i == 0)
            players = 2;
        else if(i == 1)
            players = 1;
        else
            System.exit(1);

        int difficulty = 0;

        //If there is only one player (Computer option)
        if(players == 1) {
            //Difficulty of the game
            String[] diffOptions = {"Hard", "Medium", "Easy"};
            int d = JOptionPane.showOptionDialog(null, "Difficulty?",
                    "Start Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, diffOptions, diffOptions[2]);
            if(d == 0)
                difficulty = 3;
            else if (d == 1)
                difficulty = 2;
            else
                difficulty = 1;

            //Set the computer's color to red
            ai = 'R';

            //Ask user the size that the board should be
            size = 0;
            String[] sizeOptions = {"10", "8", "6", "4"};
            int s = JOptionPane.showOptionDialog(null, "What size (mxm) would you like the board?",
                    "Start Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, sizeOptions, sizeOptions[0]);
            size = Integer.parseInt(sizeOptions[s]);

            JOptionPane.showMessageDialog(othelloFrame, "You are the blue player. Blue player starts the game.");

            //Initialize game object
            game = new Othello(size,ai,difficulty);
        }

        //If there are going to be two players
        else {
            //Prompting players to choose colors
            String[] playerOptions = {"Red", "Blue"};
            int b = JOptionPane.showOptionDialog(null, "Who will play first?",
                    "Start Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, playerOptions, playerOptions[0]);
            char beginningPlayer;

            if (playerOptions[b].equals("Red"))
                beginningPlayer = 'R';
            else
                beginningPlayer = 'B';

            //Ask user the size that the board should be
            size = 0;
            String[] sizeOptions = {"10", "8", "6", "4"};
            int s = JOptionPane.showOptionDialog(null, "What size (mxm) would you like the board?",
                    "Start Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, sizeOptions, sizeOptions[0]);
            size = Integer.parseInt(sizeOptions[s]);

            //Initialize game object
            game = new Othello(size,' ',0);
            ai = game.getAI();
            difficulty = game.getDifficulty();
            game.setCurrentPlayer(beginningPlayer);
        }

        board = game.getBoard();
    }

    /**
     * Sets up the game screen with buttons
     * and their initial colors
     */
    private void createGameScreen() {
        //Adding buttons to intialize gamescreen
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);

                if(board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setOpaque(true);
                }
                else if(board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                    buttons[i][j].setOpaque(true);
                }
                othelloPanel.add(buttons[i][j]);
                layout.addLayoutComponent("testName", buttons[i][j]);
            }
        }
    }

    /**
     * Controls what happens when a button or menu
     * item is pressed in the GUI
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();

        //If menu item is pressed
        if(helpMenuItems.contains(pressed) || exitMenuItems.contains(pressed))
            menuItems(pressed);
        //If button in game is pressed
        else if (pressed == e.getSource()){
            buttons(pressed);
        }

        while(!game.isGameOver(size,board) && game.getCurrentPlayer() == ai) {
            if (!game.isValidMoveAvailable(board.length, board, game.getCurrentPlayer())) {
                JOptionPane.showMessageDialog(othelloFrame, "No valid moves available for player " + game.getCurrentPlayer() + "! " +
                        "You lose your turn.");
                game.nextPlayer();
                updateBoard();
            } else if (game.getCurrentPlayer() == ai) {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException ie) {
                    JOptionPane.showMessageDialog(othelloFrame, "It is the computer's turn to play.");
                }
                game.playAI();
                game.nextPlayer();
                updateBoard();
            }
        }
        if (!game.isValidMoveAvailable(board.length, board, game.getCurrentPlayer())) {
            JOptionPane.showMessageDialog(othelloFrame, "No valid moves available for player " + game.getCurrentPlayer() + "! " +
                    "You lose your turn.");
            game.nextPlayer();
            updateBoard();
        }
        checkGameOver();
    }

    /**
     * Controls what happens when a menu
     * item is pressed in the GUI
     * @param pressed
     */
    public void menuItems(Object pressed) {
        if (helpMenuItems.contains(pressed)) {
            pressed = helpMenuItems.get(helpMenuItems.indexOf(pressed));
            if (pressed == gameInstructMI) {
                System.out.print("Game Instructions");
                JOptionPane.showMessageDialog(othelloFrame, "How to play Othello: \n" +
                        "The goal of the game is to get the majority of color discs on the board at the end of the game. \n" +
                        "A move is made by placing a disc of the current player's color on the board in a position that \"out-flanks\" one or more of the opponent's discs. \n" +
                        "A disc or row of discs is outflanked when it is surrounded at the ends by discs of the opposite color. \n" +
                        "A disc may outflank any number of discs in one or more rows in any direction (horizontal, vertical, diagonal).\n" +
                        "All the discs which are outflanked will be flipped.\n" +
                        "If you can't outflank and flip at least one opposing disc, you lose your turn. However, if a move is available to you, you can't forfeit your turn.\n" +
                        "\n" +
                        "When it is no longer possible for either player to move or the board is full, the game is over.\n" +
                        "Good Luck!");
            }

            else if (pressed == saveGameMI) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
                while(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION && !game.saveGame(fc.getSelectedFile().getAbsolutePath())) {
                    if(fc.getSelectedFile().isDirectory())
                        JOptionPane.showMessageDialog(othelloFrame, "This is a directory! Please create a text file.");
                    else
                        JOptionPane.showMessageDialog(othelloFrame, "This file already exists! Please choose a new name.");
                }
                game.saveGame(fc.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(othelloFrame, "File Saved!");
            }
            else if (pressed == loadGameMI) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
                while(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION && !game.loadGame(fc.getSelectedFile().getAbsolutePath())) {
                        JOptionPane.showMessageDialog(othelloFrame, "Please choose a text file!");
                    }
                    resetBoard(size);
                    size = board.length;
                }
            }
        else if (exitMenuItems.contains(pressed)) {
            System.out.print("HERE");
            if(pressed == exitHomeScreenMI){
                System.out.print("exit to home screen");
            } else if (pressed == exitProgMI){
                System.exit(0);
            }
        }
    }

    /**
     * Controls what happens when a button
     * is pressed during gameplay
     * @param pressed
     */
    public void buttons(Object pressed){
        if((ai == 'R' || ai == 'B') && game.getCurrentPlayer() == ai){
            JOptionPane.showMessageDialog(othelloFrame, "It is the computer's turn to play.");
        } else if (!game.isGameOver(board.length, board)) {
            if (!game.isValidMoveAvailable(board.length, board, game.getCurrentPlayer())) {
                JOptionPane.showMessageDialog(othelloFrame, "No valid moves available for player " + game.getCurrentPlayer() + "! " +
                        "You lose your turn.");
                game.nextPlayer();
                updateBoard();
            }
            else {
                do {
                    for (int i = 0; i < buttons.length; i++) {
                        for (int j = 0; j < buttons[i].length; j++) {
                            if (pressed.equals(buttons[i][j])) {
                                if (!game.isValidMove(board.length, board, i, j, game.getCurrentPlayer())) {
                                    JOptionPane.showMessageDialog(othelloFrame, "Sorry that is not a valid move, please try again.");
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
    }

    /**
     * Controls what happens on screen
     * if the game is over.
     */
    public void checkGameOver(){
        if (game.isGameOver(board.length, board)) {
            if(game.isBoardFull(size,game.getBoard()) && game.checkWinner(board.length,board) != 'T') {
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! Player " + game.checkWinner(board.length, board) + " Wins!");
                saveScores();
            } else if(game.checkWinner(board.length,board) != 'T'){
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! No valid moves left. " +
                        "Player " + game.checkWinner(board.length, board) + " Wins!");
                saveScores();
            } else if(game.isBoardFull(size,game.getBoard()) && game.checkWinner(board.length,board) == 'T')
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! It's a tie!");
            else
                JOptionPane.showMessageDialog(othelloFrame, "Game over!!! No valid moves left. It's a tie!");


            //Restart or exit options
            String[] options = {"Restart", "Exit to Main Menu"};
            int x = JOptionPane.showOptionDialog(null, "Would you like to restart the game or exit to main menu?",
                    "Game Over",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            if(x == 0) {
                int initialSize = size;
                gameSetup();
                resetBoard(initialSize);
            }
            else if(x == 1) {}
            else if(x == JOptionPane.CLOSED_OPTION){
                initializeBoard();
            }
        }
    }

    /**
     *
     */
    public void initializeBoard(){
        game.initializeBoard(size,board);
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if(board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setOpaque(true);
                }
                else if(board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                    buttons[i][j].setOpaque(true);
                } else {
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setOpaque(true);
                }
            }
        }
        redPoints.setText("Red Score: " + game.getRedScore() + "    ");
        bluePoints.setText("Blue Score: " + game.getBlueScore() + "    ");
        currentPlayer.setText("Current Player: " + game.getCurrentPlayer());
    }

    /**
     *
     */
    public void updateBoard(){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (board[i][j] == 'R')
                    buttons[i][j].setBackground(Color.red);
                else if (board[i][j] == 'B')
                    buttons[i][j].setBackground(Color.blue);

                buttons[i][j].setOpaque(true);
            }
        }
        game.updateScores();
        redPoints.setText("Red Score: " + game.getRedScore() + "    ");
        bluePoints.setText("Blue Score: " + game.getBlueScore() + "    ");
        currentPlayer.setText("Current Player: " + game.getCurrentPlayer());
        highScore.setText("High Score: " + getHighScore() + "    ");
    }

    /**
     *
     * @param initialSize
     */
    public void resetBoard(int initialSize) {
        Container parent = buttons[0][0].getParent();
        for(int i = 0; i < initialSize; i++)
            for(int j = 0; j < initialSize; j++){
                parent.remove(buttons[i][j]);
                parent.revalidate();
                parent.repaint();
            }
        board = game.getBoard();
        buttons = new JButton[board.length][board.length];
        layout = new GridLayout(board.length,board.length);
        parent.setLayout(layout);

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++){
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);

                if(board[i][j] == 'R') {
                    buttons[i][j].setBackground(Color.red);
                    buttons[i][j].setOpaque(true);
                }
                else if(board[i][j] == 'B') {
                    buttons[i][j].setBackground(Color.blue);
                    buttons[i][j].setOpaque(true);
                }
                parent.add(buttons[i][j]);
                layout.addLayoutComponent("testName", buttons[i][j]);
                parent.revalidate();
                parent.repaint();
            }
        updateBoard();
    }

    /**
     *
     */
    public void saveScores() {
        File file = new File("highScores.txt");

        file.setWritable(true);

        try {
            FileWriter writer = new FileWriter(file);

            if(game.checkWinner(board.length, board) == game.redPlayer)
                writer.write(game.getRedScore() + '\n');
            else if(game.checkWinner(board.length, board) == game.bluePlayer)
                writer.write(game.getBlueScore() + '\n');

            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        file.setReadOnly();
    }

    /**
     *
     * @return
     */
    public int getHighScore() {
        File file = new File("highScores.txt");
        int highscore = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null) {
                try {
                    int score = Integer.parseInt(line.trim());
                    if(score > highscore)
                        highscore = score;
                } catch (NumberFormatException f) {

                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
//        file.setReadOnly();
        return highscore;
    }
}
