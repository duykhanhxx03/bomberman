package uet.oop.bomberman.controllers;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Objects;

public class Audio {
    private Clip clip;

    public Audio(String filename) {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInputStream
                    = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(getClass().getResourceAsStream("/sounds/" + filename + ".wav")));
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playBgm() {
        try {
            if (isPlaying()) {
                clip.setMicrosecondPosition(0);
            }
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBgm() {
        try {
            if (isPlaying()) {
                clip.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSoundEffect() {
        try {
            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }
    public void stop(){
        clip.stop();
    }
}
