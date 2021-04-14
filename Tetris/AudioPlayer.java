package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {

    private String soundsFolder = "sounds" + File.separator;
    private String clearLinePath = soundsFolder + "line.wav";
    private String gameoverPath = soundsFolder + "gameover.wav";
    private String tetrisSongPath = soundsFolder + "Tetris Game Boy OST full soundtrack.wav";

    private Clip clearLineSound, gameoverSound, tetrisSongSound;

    /**
     * retrieving the audio from the file.
     * checking for exceptions.
     */
    public AudioPlayer(){

        try { 
            gameoverSound  = AudioSystem.getClip();
            clearLineSound = AudioSystem.getClip();
            tetrisSongSound = AudioSystem.getClip();
            
            
            gameoverSound.open(AudioSystem.getAudioInputStream(new File(gameoverPath).getAbsoluteFile()));
            clearLineSound.open(AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile()));
            tetrisSongSound.open(AudioSystem.getAudioInputStream(new File(tetrisSongPath).getAbsoluteFile()));

        }
        catch(LineUnavailableException ex) { 
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedAudioFileException ex) { 
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IOException ex) { 
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * plays the clear line audio.
     */
    public void playClearLine() {
        clearLineSound.setFramePosition(0);
        clearLineSound.start();
                
    }

    /**
     * plays the game over audio.
     */
    public void playGameOver() {
    gameoverSound.setFramePosition(0);
    gameoverSound.start();
    }
    
    /**
     * plays the Tetris theme song.
     */
    public void playTetrisSong() {
    tetrisSongSound.setFramePosition(0);
    tetrisSongSound.start();
    }
    
    public void pleaseStop(){
    tetrisSongSound.stop();
    }
    
}
