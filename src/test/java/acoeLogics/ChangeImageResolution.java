package acoeLogics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ChangeImageResolution {
	public static void main(String[] args) {
		try {
			// Load the original image
			File input = new File("C:\\Users\\Chandan\\Pictures\\Screenshots\\shopperStack.png");
			BufferedImage originalImage = ImageIO.read(input);

			// Set the desired width and height for the new image
			int newWidth = 466;
			int newHeight = 223;

			// Create a new BufferedImage with the desired resolution
			BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = resizedImage.createGraphics();

			// Resize the original image to the new resolution
			g.drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, newWidth, newHeight, null);
			g.dispose();

			// Save the resized image to a file
			File output = new File("C:\\Users\\Chandan\\Pictures\\Screenshots\\shopperStackResolution.png");
			ImageIO.write(resizedImage, "jpg", output);

			System.out.println("Image resized successfully.");
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}

