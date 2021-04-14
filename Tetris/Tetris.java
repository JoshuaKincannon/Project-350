package tetris;

import javax.swing.JOptionPane;


public class Tetris {

    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;
    private static AudioPlayer audio = new AudioPlayer();
    static boolean isStopped; 

    /**
     * This is what is called to launch the game
     */
    public static void start() {
        
        gf.setVisible(true);
        gf.startGame();
        playSong();
    }

    /**
     * This launches the leaderboard.
     */
    public static void showLeaderBoard() {
        lf.setVisible(true); 
    }

    /**
     * This launches the main .
     */
    public static void showStartup() { 
        sf.setVisible(true);
    }

    /**
     * Game over screen where you can enter in your name
     * for the leaderboards.
     * @param score
     */
    public static void GameOver( int score) {
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
     * Plays theme song for Tetris.
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
     * @param args
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