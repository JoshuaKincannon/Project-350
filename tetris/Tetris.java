package tetris;

import javax.swing.JOptionPane;

public class Tetris {

    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;
    private static AudioPlayer audio = new AudioPlayer();
    
    
    public static void start() {
        
        gf.setVisible(true);
        gf.startGame();
        
    }
    public static void showLeaderBoard() {
        lf.setVisible(true); 
        
    }
    
    public static void showStartup() { 
        sf.setVisible(true);
        
    }
        
    public static void GameOver( int score) {
        playGameover();
        
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
        gf.setVisible(false);
        lf.addPlayer(playerName, score);
        
   
    }
    
    
    public static void playClear() {
        
        audio.playClearLine();
        
    }
    
    public static void playGameover() {
        
        audio.playGameover();
    
    }
    
    
        
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