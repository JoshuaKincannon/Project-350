
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
    private String soundsFolder = "tetrissounds" + File.separator;
    private String clearLinePath = soundsFolder + "line";
    private String gameoverPath = soundsFolder + "gameover";

    private Clip clearLineSound, gameoverSound;
    
    
    public AudioPlayer(){

        try { 
            gameoverSound  = AudioSystem.getClip();
            clearLineSound = AudioSystem.getClip();
            
            gameoverSound.open( AudioSystem.getAudioInputStream(new File(gameoverPath).getAbsoluteFile() ) );
            clearLineSound.open( AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile() ) );
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
    
    public void playClearLine() {
        clearLineSound.setFramePosition(0);
        clearLineSound.start();
                
    }
    
    public void playGameover() {
    gameoverSound.setFramePosition(0);
    gameoverSound.start();
        
    }
    
}
