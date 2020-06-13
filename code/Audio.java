package code;
import  javax.sound.sampled.*;
import java.io.File;
public class Audio {
    public void runAudio(String path,boolean loop){
        try {
            File filename = new File(path);
            if (!filename.exists()){
                System.out.println("Can't find the file");

            }
            else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(filename);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
                if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
