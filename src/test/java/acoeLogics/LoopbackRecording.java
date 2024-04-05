package acoeLogics;

import javax.sound.sampled.*;
import java.io.*;

public class LoopbackRecording {
    public static void main(String[] args) {
        try {
            // Define audio format for the captured audio
            AudioFormat audioFormat = new AudioFormat(44100, 16, 2, true, true);

            // Get the target data line for audio capture
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

            if (!AudioSystem.isLineSupported(Port.Info.SPEAKER)) {
                System.out.println("TargetDataLine is not supported on this system.");
                System.exit(1);
            }

            // Open and start the data line
            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            // Create an audio input stream for capturing audio
            AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);

            // Define the output file
            File outputFile = new File("C:\\Users\\Chandan\\Downloads\\SystemAudio.wav");

            // Create an audio file output stream
            AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
            AudioSystem.write(audioInputStream, fileType, outputFile);

            // Close the audio input stream and data line
            audioInputStream.close();
            targetDataLine.stop();
            targetDataLine.close();

            System.out.println("Loopback audio recording complete. Saved as 'loopback_audio.wav'");
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}


