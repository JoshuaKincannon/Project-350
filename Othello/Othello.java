package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//***************************************************
// Filename: Othello.java
// Date: 03.17.21
// Author(s): Ariana Sherrod-Cavanaugh
//***************************************************
public class Othello {

    /** 2D char-array of the Othello board. **/
    private static char[][] board;

    /** char representing the current player. **/
    private char currentPlayer;

    /** char representing the red player. **/
    private static char redPlayer;

    /** char representing the blue player. **/
    private static char bluePlayer;

    /** char representing an empty cell in the board. **/
    private static char emptyCell;

    /** int representing the red player's score. **/
    private static int redScore;

    /** int representing the blue player's score. **/
    private static int blueScore;

    /**
     * Constructor of an Othello Object.
     *
     * @param size           the size
     * @param startingPlayer the starting player
     */
    protected Othello(int size, char startingPlayer) {
        board = new char[size][size];
        redPlayer = 'R';
        bluePlayer = 'B';
        emptyCell = '-';
        setCurrentPlayer(startingPlayer);

        initializeBoard(size, board);
        updateScores();
    }

    /**
     * Initialize board.
     *
     * @param size  the size
     * @param board the board
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
        if (board[row][col] != emptyCell) {
            return false;
        }

        if (row != 0 && (board[row - 1][col] != disc
                && board[row - 1][col] != emptyCell)
                && (placeDiscRecursively(size, board,
                row - 1, col, disc, -1, 0))) {
            return true;
        }

        if (row != size - 1
            && (board[row + 1][col] != disc && board[row + 1][col] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col, disc, 1, 0))) {
            return true;
        }

        if (col != 0
            && (board[row][col - 1] != disc && board[row][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row, col - 1, disc, 0,  -1))) {
            return true;
        }

        if (col != size - 1
            && (board[row][col + 1] != disc && board[row][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row, col + 1, disc, 0, 1))) {
            return true;
        }

        if (row != 0 && col != 0
            && (board[row - 1][col - 1] != disc
                && board[row - 1][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row - 1, col - 1, disc,  -1,  -1))) {
            return true;
        }

        if (row != 0 && col != size - 1
            && (board[row - 1][col + 1] != disc
                && board[row - 1][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row - 1, col + 1, disc,  -1, 1))) {
            return true;
        }

        if (row != size - 1 && col != 0
            && (board[row + 1][col - 1] != disc
                && board[row + 1][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col - 1, disc, 1,  -1))) {
                    return true;
        }

        if (row != size - 1 && col != size - 1
            && (board[row + 1][col + 1] != disc
                && board[row + 1][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col + 1, disc, 1, 1))) {
            return true;
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
                || board[row][col] == emptyCell) {
            return false;
        }

        if (board[row][col] == disc) {
            return true;
        }

        return placeDiscRecursively(size, board, row + rowD, col + colD, disc, rowD, colD);
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

        board[row][col] = disc;

        if (row != 0
            && (board[row - 1][col] != disc && board[row - 1][col] != emptyCell
                && (placeDiscRecursively(size, board,
                row - 1, col, disc,  -1, 0)))) {
            r--;
            while (board[r][col] != disc && board[r][col] != emptyCell) {
                if (board[r - 1][col] != emptyCell) {
                    board[r][col] = disc;
                }
                r--;
            }
        }

        if (row != size - 1
            && (board[row + 1][col] != disc && board[row + 1][col] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col, disc, 1, 0))) {
            r = row;
            r++;
            while (board[r][col] != disc && board[r][col] != emptyCell) {
                if (board[r + 1][col] != emptyCell) {
                    board[r][col] = disc;
                }
                r++;
            }
        }

        if (col != 0
            && (board[row][col - 1] != disc && board[row][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row, col - 1, disc, 0,  -1))) {
            c--;
            while (board[row][c] != disc && board[row][c] != emptyCell) {
                if (board[row][c - 1] != emptyCell) {
                    board[row][c] = disc;
                }
                c--;
            }
        }

        if (col != size - 1
            && (board[row][col + 1] != disc && board[row][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row, col + 1, disc, 0, 1))) {
            c = col;
            c++;
            while (board[row][c] != disc && board[row][c] != emptyCell) {
                if (board[row][c + 1] != emptyCell) {
                    board[row][c] = disc;
                }
                c++;
            }
        }

        if (row != 0 && col != 0
            && (board[row - 1][col - 1] != disc
                && board[row - 1][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row - 1, col - 1, disc,  -1,  -1))) {
            r = row;
            c = col;
            r--;
            c--;
            while (board[r][c] != disc && board[r][c] != emptyCell) {
                if (board[r - 1][c - 1] != emptyCell) {
                    board[r][c] = disc;
                }
                r--;
                c--;
            }
        }

        if (row != 0 && col != size - 1
            && (board[row - 1][col + 1] != disc
                && board[row - 1][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row - 1, col + 1, disc,  -1, 1))) {
            r = row;
            c = col;
            r--;
            c++;
            while (board[r][c] != disc && board[r][c] != emptyCell) {
                if (board[r - 1][c + 1] != emptyCell) {
                    board[r][c] = disc;
                }
                r--;
                c++;
            }
        }

        if (row != size - 1 && col != 0
            && (board[row + 1][col - 1] != disc
                && board[row + 1][col - 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col - 1, disc, 1,  -1))) {
            r = row;
            c = col;
            r++;
            c--;
            while (board[r][c] != disc && board[r][c] != emptyCell) {
                if (board[r + 1][c - 1] != emptyCell) {
                    board[r][c] = disc;
                }
                r++;
                c--;
            }
        }

        if (row != size - 1 && col != size - 1
            && (board[row + 1][col + 1] != disc
                && board[row + 1][col + 1] != emptyCell)
            && (placeDiscRecursively(size, board,
                row + 1, col + 1, disc, 1, 1))){
            r = row;
            c = col;
            r++;
            c++;
            while (board[r][c] != disc && board[r][c] != emptyCell) {
                if (board[r + 1][c + 1] != emptyCell) {
                    board[r][c] = disc;
                }
                r++;
                c++;
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
                if (board[i][j] == emptyCell) {
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
     * Checks for the winner of the game by counting
     * the amounts of discs in the board array
     * for each player. The greater of the two discs
     * wins the game.
     *
     * @param size  the size
     * @param board the board
     * @return char char
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
     *
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
                int size = Character.getNumericValue(reader.read());
                if(size < 4) {
                    size = 10;
                    reader.read();
                }
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
     * Gets the score of the blue player.
     *
     * @param player the player
     * @return int blue's score
     */
    protected int getScore(char player) {
        if(player == redPlayer)
            return getRedScore();
        else
            return getBlueScore();
    }
}

