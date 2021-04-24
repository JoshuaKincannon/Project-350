package tetris;

import javax.swing.JOptionPane;

/**
 * The main class that hosts the main method and will be called to run the program.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class Tetris {

    private static GameForm gf = new GameForm();
    private static StartupForm sf;
    private static LeaderboardForm lf;
    private static AudioPlayer audio = new AudioPlayer();

    /**
     * Starts the game.
     * Calls StartGame function and sets GameForm to visible.
     * Plays Tetris music.
     */
    public static void start() {

        gf.setVisible(true);
        gf.startGame();
        playSong();
    }

    /**
     * Launches the leaderboard.
     */
    public static void showLeaderBoard() {
        lf.setVisible(true);
    }

    /**
     * Launches the main.
     */
    public static void showStartup() {
        sf.setVisible(true);
    }

    /**
     * Game over screen to enter in your name for the leaderboard data.
     * @param score Score of the game.
     */
    public static void gameOver(int score) {
        stopSong();
        playOver();
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
        gf.setVisible(false);
        lf.addPlayer(playerName, score);

    }



    /**
     * Plays the clear line audio.
     */
    public static void playClear() {
        audio.playClearLine();
    }

    /**
     * Plays the game over audio.
     */
    public static void playOver() {
        audio.playGameOver();
    }

    /**
     * Plays song for Tetris.
     */
    public static void playSong() {
        audio.playTetrisSong();
    }

    /**
     * Stops the theme song.
     */
    public static void stopSong() {
        audio.pleaseStop();
    }

    /**
     * The main method.
     * @param args Generic parameter for main method.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                sf = new StartupForm();
                lf = new LeaderboardForm();
                gf = new GameForm();
                sf.setVisible(true);
            }
        });
    }
}
