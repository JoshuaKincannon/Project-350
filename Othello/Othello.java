package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//***************************************************
// Filename: Othello.java
// Date: 03.17.21
// Author(s): Ariana Sherrod-Cavanaugh
//***************************************************

/**
 * The type Othello.
 */
public class Othello {

    /** 2D char-array of the Othello board. **/
    private char[][] board;

    /** char representing the current player. **/
    private char currentPlayer;

    /** char representing the red player. **/
    private char redPlayer;

    /** char representing the blue player. **/
    private char bluePlayer;

    /** char representing an empty cell in the board. **/
    private char emptyCell;

    /** int representing the red player's score. **/
    private int redScore;

    /** int representing the blue player's score. **/
    private int blueScore;

    /** boolean representing computer play. **/
    private char ai;

    /** int representing difficulty. **/
    private int difficulty;

    /**
     * Constructor of an Othello Object.
     *
     * @param size the size
     */
    protected Othello(int size) {
        board = new char[size][size];
        redPlayer = 'R';
        bluePlayer = 'B';
        emptyCell = '-';
        currentPlayer = getCurrentPlayer();

        initializeBoard(size, board);
        updateScores();
    }

    /**
     * Constructor of an Othello Object.
     *
     * @param size the size
     * @param ai   the ai
     * @param diff the diff
     */
    protected Othello(int size, char ai, int diff) {
        board = new char[size][size];
        redPlayer = 'R';
        bluePlayer = 'B';
        ai = ai;
        difficulty = diff;
        emptyCell = '-';
        if (ai == redPlayer) {
            currentPlayer = bluePlayer;
        } else {
            currentPlayer = redPlayer;
        }
        initializeBoard(size, board);
        updateScores();
    }

    /**
     * Initialize board.
     * @param size  the size
     * @param board Initializes the 2D board array with start configuration of discs             according to the size of the board given.
     */
    protected void initializeBoard(int size, char[][] board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == (size / 2 - 1) && j == (size / 2 - 1)) {
                    board[i][j] = redPlayer;
                } else if (i == (size / 2 - 1) && j == size / 2) {
                    board[i][j] = bluePlayer;
                } else if (i == size / 2 && j == (size / 2 - 1)) {
                    board[i][j] = bluePlayer;
                } else if (i == size / 2 && j == size / 2) {
                board[i][j] = redPlayer;
                } else {
                    board[i][j] = emptyCell;
                }
            }
        }
    }

    /**
     * Is valid move boolean.
     *
     * @param size  the size
     * @param board the board
     * @param row   the row
     * @param col   the col
     * @param disc  the disc
     * @return true if move is valid, false if not
     */
    protected boolean isValidMove(int size, char[][] board,
                                  int row, int col, char disc) {
        if (board[row][col] != '-') {
            return false;
        }

        if (row != 0) {
            if (board[row - 1][col] != disc && board[row - 1][col] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col, disc, -1, 0)) {
                    return true;
                }
            }
        }
        if (row != size - 1) {
            if (board[row + 1][col] != disc && board[row + 1][col] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col, disc, 1, 0)) {
                    return true;
                }
            }
        }

        if (col != 0) {
            if (board[row][col - 1] != disc && board[row][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row, col - 1, disc, 0,  -1)) {
                    return true;
                }
            }
        }
        if (col != size - 1) {
            if (board[row][col + 1] != disc && board[row][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row, col + 1, disc, 0, 1)) {
                    return true;
                }
            }
        }

        if (row != 0 && col != 0) {
            if (board[row - 1][col - 1] != disc
                    && board[row - 1][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col - 1, disc,  -1,  -1)) {
                    return true;
                }
            }
        }
        if (row != 0 && col != size - 1) {
            if (board[row - 1][col + 1] != disc
                    && board[row - 1][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col + 1, disc,  -1, 1)) {
                    return true;
                }
            }
        }

        if (row != size - 1 && col != 0) {
            if (board[row + 1][col - 1] != disc
                    && board[row + 1][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col - 1, disc, 1,  -1)) {
                    return true;
                }
            }
        }
        if (row != size - 1 && col != size - 1) {
            if (board[row + 1][col + 1] != disc
                    && board[row + 1][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col + 1, disc, 1, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Place disc recursively boolean.
     *
     * @param size  the size
     * @param board the board
     * @param row   the row
     * @param col   the col
     * @param disc  the disc
     * @param rowD  the row d
     * @param colD  the col d
     * @return true if disc can succesfully be placed at location given, false if not
     */
    protected boolean placeDiscRecursively(int size, char[][] board,
                                           int row, int col, char disc,
                                           int rowD, int colD) {
        if (row == size || col == size
                || row < 0 || col < 0
                || board[row][col] == '-') {
            return false;
        }

        if (board[row][col] == disc) {
            return true;
        }

        if (board[row][col] != disc) {
            return placeDiscRecursively(size, board,
                    row + rowD, col + colD, disc, rowD, colD);
        }

        return false;
    }

    /**
     * Places the disc at location (row, col) in the
     * 2D board array and flips the opponent discs as needed using
     * the placeDiscRecursively() method.
     *
     * @param size  the size
     * @param board the board
     * @param row   the row
     * @param col   the col
     * @param disc  the disc
     */
    protected void placeDiscAt(int size, char[][] board,
                               int row, int col, char disc) {
        int r = row;
        int c = col;

        if (!isValidMove(size, board, row, col, disc)) {
            return;
        }

        board[row][col] = disc;

        if (row != 0) {
            if (board[row - 1][col] != disc && board[row - 1][col] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col, disc,  -1, 0)) {
                    r--;
                    while (board[r][col] != disc && board[r][col] != '-') {
                        if (board[r - 1][col] != '-') {
                            board[r][col] = disc;
                        }
                        r--;
                    }
                }
            }
        }
        if (row != size - 1) {
            if (board[row + 1][col] != disc && board[row + 1][col] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col, disc, 1, 0)) {
                    r = row;
                    r++;
                    while (board[r][col] != disc && board[r][col] != '-') {
                        if (board[r + 1][col] != '-') {
                            board[r][col] = disc;
                        }
                        r++;
                    }
                }
            }
        }

        if (col != 0) {
            if (board[row][col - 1] != disc && board[row][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row, col - 1, disc, 0,  -1)) {
                    c--;
                    while (board[row][c] != disc && board[row][c] != '-') {
                        if (board[row][c - 1] != '-') {
                            board[row][c] = disc;
                        }
                        c--;
                    }
                }
            }
        }
        if (col != size - 1) {
            if (board[row][col + 1] != disc && board[row][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row, col + 1, disc, 0, 1)) {
                    c = col;
                    c++;
                    while (board[row][c] != disc && board[row][c] != '-') {
                        if (board[row][c + 1] != '-') {
                            board[row][c] = disc;
                        }
                        c++;
                    }
                }
            }
        }

        if (row != 0 && col != 0) {
            if (board[row - 1][col - 1] != disc
                    && board[row - 1][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col - 1, disc,  -1,  -1)) {
                    r = row;
                    c = col;
                    r--;
                    c--;
                    while (board[r][c] != disc && board[r][c] != '-') {
                        if (board[r - 1][c - 1] != '-') {
                            board[r][c] = disc;
                        }
                        r--;
                        c--;
                    }
                }
            }
        }
        if (row != 0 && col != size - 1) {
            if (board[row - 1][col + 1] != disc
                    && board[row - 1][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row - 1, col + 1, disc,  -1, 1)) {
                    r = row;
                    c = col;
                    r--;
                    c++;
                    while (board[r][c] != disc && board[r][c] != '-') {
                        if (board[r - 1][c + 1] != '-') {
                            board[r][c] = disc;
                        }
                        r--;
                        c++;
                    }
                }
            }
        }

        if (row != size - 1 && col != 0) {
            if (board[row + 1][col - 1] != disc
                    && board[row + 1][col - 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col - 1, disc, 1,  -1)) {
                    r = row;
                    c = col;
                    r++;
                    c--;
                    while (board[r][c] != disc && board[r][c] != '-') {
                        if (board[r + 1][c - 1] != '-') {
                            board[r][c] = disc;
                        }
                        r++;
                        c--;
                    }
                }
            }
        }
        if (row != size - 1 && col != size - 1) {
            if (board[row + 1][col + 1] != disc
                    && board[row + 1][col + 1] != '-') {
                if (placeDiscRecursively(size, board,
                        row + 1, col + 1, disc, 1, 1)) {
                    r = row;
                    c = col;
                    r++;
                    c++;
                    while (board[r][c] != disc && board[r][c] != '-') {
                        if (board[r + 1][c + 1] != '-') {
                            board[r][c] = disc;
                        }
                        r++;
                        c++;
                    }
                }
            }
        }
    }

    /**
     * Checks if a valid move is available for the current player.
     *
     * @param size  the size
     * @param board the board
     * @param disc  the disc
     * @return true if there is a valid move for the current player, false if not
     */
    protected boolean isValidMoveAvailable(int size,
                                           char[][] board, char disc) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isValidMove(size, board, i, j, disc)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is completely full of discs.
     *
     * @param size  the size
     * @param board the board
     * @return true if there are no empty cells in the board false if there is at least one
     */
    protected boolean isBoardFull(int size, char[][] board) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the game is over by checking if the board is full
     * or if there are no valid moves for either player.
     *
     * @param size  the size
     * @param board the board
     * @return true if the game is over (board is full or no valid moves)
     */
    protected boolean isGameOver(int size, char[][] board) {
        boolean gameOver = false;

        if (isBoardFull(size, board)
                || (!isValidMoveAvailable(size, board, 'R')
                && !isValidMoveAvailable(size, board, 'B'))) {
            gameOver = true;
        }

        return gameOver;
    }

    /**
     * Count discs int.
     *
     * @param size  the size
     * @param board the board
     * @param row   the row
     * @param col   the col
     * @param disc  the disc
     * @param rowD  the row d
     * @param colD  the col d
     * @param discs the discs
     * @return the int
     */
    protected int countDiscs(int size, char[][] board, int row, int col, char disc, int rowD, int colD, int discs) {
        if (row == size || col == size
                || row < 0 || col < 0
                || board[row][col] == '-') {
            return 0;
        }

        if (board[row][col] == disc) {
            return discs;
        }

        if (board[row][col] != disc) {
            return 1 + countDiscs(size, board, row + rowD, col + colD, disc, rowD, colD, discs);
        }

        return 0;
    }

    /**
     * Play ai.
     */
    protected void playAI() {
        ArrayList<int[]> moves = new ArrayList<>();
        int discs;
        int col;
        if (ai == redPlayer || ai == bluePlayer) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    col = j;
                    discs = 0;
                    if (isValidMove(board.length, board, i, j, ai)) {
                        if (placeDiscRecursively(board.length, board,
                                i + 1, j, ai, 1, 0)) {
                            discs += countDiscs(board.length, board,
                                    i + 1, j, ai, 1, 0, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i - 1, j, ai,  -1, 0)) {
                            discs += countDiscs(board.length, board,
                                    i - 1, j, ai, -1, 0, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i, j + 1, ai, 0, 1)) {
                            discs += countDiscs(board.length, board,
                                    i, j + 1, ai, 0, 1, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i, j - 1, ai, 0,  -1)) {
                            discs += countDiscs(board.length, board,
                                    i, j - 1, ai, 0, -1, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i + 1, j + 1, ai, 1, 1)) {
                            discs += countDiscs(board.length, board,
                                    i + 1, j + 1, ai, 1, 1, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i - 1, j + 1, ai,  -1, 1)) {
                            discs += countDiscs(board.length, board,
                                    i - 1, j + 1, ai, -1, 1, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i + 1, j - 1, ai, 1,  -1)) {
                            discs += countDiscs(board.length, board,
                                    i + 1, j - 1, ai, 1, -1, 0);
                        }

                        if (placeDiscRecursively(board.length, board,
                                i - 1, j - 1, ai,  -1,  -1)) {
                            discs += countDiscs(board.length, board,
                                    i - 1, j - 1, ai, -1, -1, 0);
                        }
                    }
                    if (discs > 0) {
                        moves.add(new int[]{i, col, discs});
                    }
                }
            }
        }

        int[] max = moves.get(0);
        for (int i[]: moves){
            if (max[2] < i[2]) {
                max = i;
            }
        }

        int[] mid = moves.get(0);
        for (int i[]: moves){
            if (mid[2] < i[2] / 2) {
                mid = i;
            }
        }

        int[] min = moves.get(0);
        for (int i[]: moves){
            if (min[2] > i[2]) {
                min = i;
            }
        }

        if (difficulty == 1) {
            placeDiscAt(board.length, board, min[0], min[1], getAI());
        } else if (difficulty == 2) {
            placeDiscAt(board.length, board, mid[0], mid[1], getAI());
        } else if (difficulty == 3) {
            placeDiscAt(board.length, board, max[0], max[1], getAI());
        }
    }


    /**
     * Checks for the winner of the game by counting
     * the amounts of discs in the board array
     * for each player. The greater of the two discs
     * wins the game.
     *
     * @param size  the size
     * @param board the board
     * @return char
     */
    protected char checkWinner(int size, char[][] board) {
        if (!isGameOver(size, board)) {
            return 0;
        }
        updateScores();

        if (blueScore > redScore) {
            return bluePlayer;
        } else if (redScore > blueScore) {
            return redPlayer;
        }
        return 'T';
    }

    /**
     * Switches currentPlayer to the next player of the game.
     */
    protected void nextPlayer() {
        if (getCurrentPlayer() == redPlayer) {
            setCurrentPlayer(bluePlayer);
        } else {
            setCurrentPlayer(redPlayer);
        }
    }

    /**
     * Counts the number of cells with each
     * disc in the game to update the score.
     * Goes through the board array counting
     * the redPlayer discs and bluePlayer discs
     * to update the score of the game.
     */
    protected void updateScores() {
        int b = 0;
        int r = 0;

        for(char[] i: board) {
            for (char j : i) {
                if (j == bluePlayer) {
                    b++;
                }
                if (j == redPlayer) {
                    r++;
                }
            }
        }

        blueScore = b;
        redScore = r;
    }

    /**
     * Saves the board array to a text file.
     *
     * @param filename the filename
     * @return true if saves game successfully
     */
    protected boolean saveGame(String filename) {
        String filetype = ".txt";
        try {
            filetype = filename.substring(filename.lastIndexOf('.'));
        } catch (StringIndexOutOfBoundsException e) {
            filename += filetype;
        }

        if (!".txt".equals(filetype)) {
            filename = filename.substring(0,
                    filename.lastIndexOf('.')) + ".txt";
        }
        try {
            if (!new File(filename).exists()) {
                File file = new File(filename);
                FileWriter writer = new FileWriter(file);

                //The game is two player
                if (getDifficulty() == 0) {
                    writer.write("2" + " ");
                } else {
                    //The game is one player
                    writer.write("1" + " ");
                }
                writer.write(getBoard().length + " ");
                writer.write(getCurrentPlayer() + " ");

                for(char[] i: board) {
                    for (char j : i) {
                        writer.write(j + " ");
                    }
                }
                writer.close();
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Loads the game from a text files
     * @param filename the filename
     * @return true if load game works
     */
    protected boolean loadGame(String filename) {
        String filetype = ".txt";
        try {
            filetype = filename.substring(filename.lastIndexOf('.'));
        } catch (StringIndexOutOfBoundsException e) {
            filename += filetype;
        }

        if (!".txt".equals(filetype)) {
            return false;
        }

        File file = new File(filename);
        char[][] b;

        try {
            FileReader reader = new FileReader(file);
            if (file.exists()) {
                reader.read();
                int size = Character.getNumericValue(reader.read());
                reader.read();
                this.setCurrentPlayer((char) reader.read());
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
                board = b;
                updateScores();
                reader.close();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Sets the current player of the game.
     *
     * @param currentPlayer the current player
     */
    protected void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Gets the current player of the game.
     *
     * @return char currentPlayer
     */
    protected char getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gets the 2D char array of the board.
     *
     * @return 2D char array of the board
     */
    protected char[][] getBoard() {
        return board;
    }

    /**
     * Gets the score of the red player.
     *
     * @return int red's score
     */
    protected int getRedScore() {
        return redScore;
    }

    /**
     * Gets the score of the blue player.
     *
     * @return int blue's score
     */
    protected int getBlueScore() {
        return blueScore;
    }

    /**
     *
     * @return char of ai
     */
    public char getAI() {
        return ai;
    }

    /**
     * Gets difficulty.
     *
     * @return int difficulty of game
     */
    public int getDifficulty() {
        return difficulty;
    }
}
