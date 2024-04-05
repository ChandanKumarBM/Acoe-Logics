package acoeLogics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class SoundwaveToBase64CodeToFile {
	public static void main(String[] args) throws LineUnavailableException {
		String wavFilePath = "C:\\Users\\Chandan\\Downloads\\Thank you for contac (1).wav";   // Replace with the path to your WAV file
		String imageFilePath = "C:\\Users\\Chandan\\Downloads\\Thankyou2\\Thankyou.png";     // Path to save the soundwave image
		String base64FilePath = "C:\\Users\\Chandan\\Downloads\\Thankyou2\\Thankyou.txt";   // Path to save the Base64-encoded string
		try {
		
			// Open the WAV file
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(wavFilePath));
			AudioFormat audioFormat = audioInputStream.getFormat();

			// Read audio data
			byte[] audioData = new byte[(int) audioInputStream.getFrameLength()];
			audioInputStream.read(audioData);

			// Create an image for visualization
			int imageWidth = 800;
			int imageHeight = 200;
			BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);

			// Create a custom JPanel for drawing the soundwave
			JPanel soundwavePanel = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					int width = getWidth();
					int height = getHeight();

					// Plot the soundwave as a line
					g.setColor(Color.BLUE);
					int step = audioData.length / width;
					for (int x = 0, i = 0; x < width && i < audioData.length; x++, i += step) {
						int sample = audioData[i] * 128;
						int y = height / 2 - sample;
						g.drawLine(x, height / 2, x, y);
					}
				}
			};
			soundwavePanel.setSize(imageWidth, imageHeight);
			soundwavePanel.paint(image.getGraphics());

			// Save the soundwave image to a byte array
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "PNG", byteArrayOutputStream);

			// Get the byte array
			byte[] imageBytes = byteArrayOutputStream.toByteArray();

			// Encode the byte array as Base64
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			// Save the Base64-encoded string to a file
			try (FileWriter writer = new FileWriter(base64FilePath)) {
				writer.write(base64Image);
			}

			// Save the soundwave image to a file
			ImageIO.write(image, "PNG", new File(imageFilePath));

			System.out.println("Soundwave image saved to: " + imageFilePath);
			System.out.println("Base64-encoded image saved to: " + base64FilePath);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
}
