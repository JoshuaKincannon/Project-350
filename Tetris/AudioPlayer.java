package tetris;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Responsible for retrieving audio for the program.
 * Builds a filepath for the audio files. It creates the audio clip
 * and allows it to be used and called on.
 * @author Joshua Kincannon
 * @version 13.0.2
 */
public class AudioPlayer {

    private String soundsFolder = "sounds" + File.separator;
    private String clearLinePath = soundsFolder + "line.wav";
    private String gameoverPath = soundsFolder + "gameover.wav";
    private String tetrisSongPath = soundsFolder + "Tetris Game Boy OST full soundtrack.wav";
    private Clip clearLineSound;
    private Clip gameoverSound;
    private Clip tetrisSongSound;

    /**
     * retrieving the audio from the file.
     * checking for exceptions.
     * @throws LineUnavailableException Indicates that a line cannot be opened because it is unavailable.
     * @throws UnsupportedAudioFileException Indicates that an operation failed because a file did not contain valid data.
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     */
    public AudioPlayer() {

        try {
            gameoverSound  = AudioSystem.getClip();
            clearLineSound = AudioSystem.getClip();
            tetrisSongSound = AudioSystem.getClip();


            gameoverSound.open(AudioSystem.getAudioInputStream(new File(gameoverPath).getAbsoluteFile()));
            clearLineSound.open(AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile()));
            tetrisSongSound.open(AudioSystem.getAudioInputStream(new File(tetrisSongPath).getAbsoluteFile()));

        } catch (LineUnavailableException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * plays the clear line audio.
     * Starts the audio and plays it from the beginning.
     */
    public void playClearLine() {
        clearLineSound.setFramePosition(0);
        clearLineSound.start();

    }

    /**
     * plays the game over audio.
     * Starts the audio and plays it from the beginning.
     */
    public void playGameOver() {
        gameoverSound.setFramePosition(0);
        gameoverSound.start();
    }

    /**
     * plays the Tetris theme song.
     * Starts the audio and plays it from the beginning.
     */
    public void playTetrisSong() {
        tetrisSongSound.setFramePosition(0);
        tetrisSongSound.start();
    }

    /**
     * Stops the Tetris Song from being played.
     */
    public void pleaseStop() {
        tetrisSongSound.stop();
    }

}
