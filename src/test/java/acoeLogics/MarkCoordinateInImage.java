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

public class MarkCoordinateInImage {

    public static void main(String[] args) {
        // Replace these values with the actual coordinates of the pixel you want to mark
        int xCoordinate = 60;
        int yCoordinate = 30;

        // Replace this path with the actual path to your local image
        String localImagePath = "C:\\Users\\Chandan\\Pictures\\Screenshots\\redbus.png";

        // Replace this path with the desired output path
        String outputPath = "C:\\Users\\Chandan\\Pictures\\Screenshots\\redbus.png";

        // Replace this color with the desired mark color
        Color markColor = Color.blue;

        // Mark the specified coordinates in the local image
        for(int i =0; i<10; i++) {
        markCoordinateInImage(localImagePath, outputPath, xCoordinate, yCoordinate, markColor);
        xCoordinate=xCoordinate+35;
    
        }
    }

    private static void markCoordinateInImage(String localImagePath, String outputPath, int x, int y, Color markColor) {
        try {
            // Load the local image
            File imageFile = new File(localImagePath);
            BufferedImage image = ImageIO.read(imageFile);

            // Create a Graphics2D object to draw on the image
            Graphics2D g2d = image.createGraphics();

            // Set the mark color
            g2d.setColor(markColor);

            // Draw a mark (e.g., a filled circle) at the specified coordinates
            int markSize = 10; // Adjust the size of the mark as needed
            g2d.fillOval(x - markSize / 2, y - markSize / 2, markSize, markSize);

            // Dispose of the Graphics2D object
            g2d.dispose();

            // Save the marked image
            ImageIO.write(image, "png", new File(outputPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



