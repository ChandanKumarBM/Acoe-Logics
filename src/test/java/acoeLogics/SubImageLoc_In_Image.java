package acoeLogics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class SubImageLoc_In_Image {

    public static void main(String[] args) {
        // Replace these paths with your actual image paths
        String mainImagePath = "C:\\Users\\Chandan\\Downloads\\download (1).png";
        String subImagePath = "C:\\Users\\Chandan\\Pictures\\download copy.png";
        try {
            // Load images using ImageIO
            BufferedImage mainImage = ImageIO.read(new File(mainImagePath));
            BufferedImage subImage = ImageIO.read(new File(subImagePath));

            // Find the location of the subImage within the mainImage
            int[] location = findImageLocation(mainImage, subImage);
            if (location != null) {
                int x = location[0];
                int y = location[1];
                System.out.println("Sub-image found at coordinates: (" + x + ", " + y + ")");
            } else {
                System.out.println("Sub-image not found in the main image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] findImageLocation(BufferedImage mainImage, BufferedImage subImage) {
        int width = mainImage.getWidth() - subImage.getWidth() + 1;
        int height = mainImage.getHeight() - subImage.getHeight() + 1;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (isSubImageAtLocation(mainImage, subImage, x, y)) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    private static boolean isSubImageAtLocation(BufferedImage mainImage, BufferedImage subImage, int x, int y) {
        int width = subImage.getWidth();
        int height = subImage.getHeight();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (mainImage.getRGB(x + i, y + j) != subImage.getRGB(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

