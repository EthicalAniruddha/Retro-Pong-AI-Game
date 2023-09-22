package Audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    public static void playSound(String filePath) {

        File audio = new File(filePath);

        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audio);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }

        Clip clip;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }

        clip.start();
    }
}
