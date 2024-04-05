package acoeLogics;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class SpeechToText {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Replace these with your actual DeepSpeech paths and audio file path
		String deepSpeechPath = "C:\\Users\\Chandan\\Downloads\\deepspeech\\Scripts\\deepspeech.exe";
		String modelPath = "C:\\Users\\Chandan\\Downloads\\Deep Speech\\model\\deepspeech-0.9.3-models.pbmm";
		String scorerPath = "C:\\Users\\Chandan\\Downloads\\Deep Speech\\scorer\\deepspeech-0.9.3-models.scorer";
		String audioFilePath = "C:\\Users\\Chandan\\Downloads\\Hi Good morning.wav";

		ProcessBuilder processBuilder = new ProcessBuilder(
				deepSpeechPath,
				"--model", modelPath,
				"--scorer", scorerPath,
				"--audio", audioFilePath
				);

		processBuilder.redirectErrorStream(true);
		Process process = processBuilder.start();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				// Process the output as needed (transcribed text)
				System.out.println("the output file is "+line);
			}
		}

		// Wait for the DeepSpeech process to finish
		process.waitFor();
	}
}