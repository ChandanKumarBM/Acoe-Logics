package acoeLogics;

import org.apache.commons.io.FileUtils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AudioToWAVConverter {
    public static void main(String[] args) {
    	String inputAudioFile = "C:\\Users\\Chandan\\Downloads\\Hi good morning (1).mp3";
		String wavOutputFile = "C:\\Users\\Chandan\\Downloads\\WavTest.wav"; //Specify the desired output WAV file

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(inputAudioFile));
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Ensure the audio format is in PCM_SIGNED encoding for WAV
            if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                AudioInputStream pcmAudioInputStream = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED, audioInputStream);
                audioInputStream = pcmAudioInputStream;
            }

            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            // Open a new output file for writing
            File outputFile = new File(wavOutputFile);
            AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
            AudioSystem.write(new AudioInputStream(audioInputStream, audioInputStream.getFormat(), audioInputStream.getFrameLength()), fileType, outputFile);

            System.out.println("Conversion to WAV complete.");
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}





