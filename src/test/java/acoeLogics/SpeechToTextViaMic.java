package acoeLogics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class SpeechToTextViaMic {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Replace these with your actual DeepSpeech paths and audio file path
		String deepSpeechPath = "C:\\Users\\Chandan\\Downloads\\deepspeech\\Scripts\\deepspeech.exe";
		String modelPath = "C:\\Users\\Chandan\\Downloads\\Deep Speech\\model\\deepspeech-0.9.3-models.pbmm";
		String scorerPath = "C:\\Users\\Chandan\\Downloads\\Deep Speech\\scorer\\deepspeech-0.9.3-models.scorer";
		String audioFilePath = "C:\\Users\\Chandan\\Downloads\\Hi Good morning.wav";

		// Configure the audio format for recording
		AudioFormat format = new AudioFormat(16000, 16, 1, true, false);

		// Create a microphone audio input stream
		TargetDataLine audiofileLine;
		try {
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			audiofileLine = (TargetDataLine) AudioSystem.getLine(info);
			audiofileLine.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		}

		// Start capturing audio from the microphone
		audiofileLine.start();
		Thread.sleep(3000);

		// Create a ProcessBuilder for DeepSpeech
		ProcessBuilder processBuilder = new ProcessBuilder(
				deepSpeechPath,
				"--model", modelPath,
				"--scorer", scorerPath,
				"--audio", audioFilePath 
				);

		processBuilder.redirectErrorStream(true);
		Process process = processBuilder.start();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				AudioInputStream audioInputStream = new AudioInputStream(audiofileLine)) {

			byte[] buffer = new byte[4096];
			int bytesRead;

			while ((bytesRead = audioInputStream.read(buffer)) != -1) {
				// Send audio data to DeepSpeech in real-time
				process.getOutputStream().write(buffer, 0, bytesRead);
				process.getOutputStream().flush();

				// Print DeepSpeech output
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Stop recording and wait for the DeepSpeech process to finish
		audiofileLine.stop();
		audiofileLine.close();
		process.waitFor();
	}


}
