package acoeLogics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Scalar;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FetchColorCode {

	public static void main(String[] args) {
		// Replace these values with the actual coordinates of the pixel you want to check
		int xCoordinate = 60;
		int yCoordinate = 65;

		// Replace this path with the actual path to your local image
		String localImagePath = "C:\\Users\\Chandan\\Pictures\\Screenshots\\redbus.png";

		for(int i=0; i<10; i++) {
			fetchColorCodeFromCoordinate(localImagePath, xCoordinate, yCoordinate);
			xCoordinate=xCoordinate+35;
		}
	}

	private static void fetchColorCodeFromCoordinate(String localImagePath, int x, int y) {
		try {
			// Load the local image
			File imageFile = new File(localImagePath);
			BufferedImage image = ImageIO.read(imageFile);

			// Get color code from the specified coordinates
			Color pixelColor = new Color(image.getRGB(x, y));

			// Print RGB values
			System.out.println("Color code at coordinates (" + x + "," + y + "): " +
					"R=" + pixelColor.getRed() +
					", G=" + pixelColor.getGreen() +
					", B=" + pixelColor.getBlue());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



