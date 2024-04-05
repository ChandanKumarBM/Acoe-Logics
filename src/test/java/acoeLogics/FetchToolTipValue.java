package acoeLogics;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FetchToolTipValue {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/search?fromCityName=Nalasopara%20East,%20Mumbai&fromCityId=70551&srcCountry=IND&toCityName=Bangalore&toCityId=122&destCountry=IND&onward=17-Nov-2023&opId=0&busType=Any");
		Thread.sleep(15000);
		String subImagePath = "C:\\Users\\Chandan\\Pictures\\download copy.png";

		// Fetch the main image from the webpage
		WebElement mainImageElement = driver.findElement(By.xpath("//canvas[@data-type='lower']"));

		// Get the coordinates and size of the main image on the webpage
		int xCoordinate = mainImageElement.getLocation().getX();
		int yCoordinate = mainImageElement.getLocation().getY();
		int width = mainImageElement.getSize().getWidth();
		int height = mainImageElement.getSize().getHeight();

		// Capture a screenshot of the entire page
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			// Read the screenshot as BufferedImage
			BufferedImage fullImage = ImageIO.read(screenshot);

			// Crop the screenshot to get the main image
			BufferedImage mainImage = fullImage.getSubimage(xCoordinate, yCoordinate, width, height);

			// Load the sub-image from the local file
			BufferedImage subImage = ImageIO.read(new File(subImagePath));

			// Find the location of the sub-image within the main image
			int[] location = findImageLocation(mainImage, subImage);
			if (location != null) {
				int subImageX = location[0] + xCoordinate; // Adjust coordinates relative to the entire page
				int subImageY = location[1] + yCoordinate;

				System.out.println("Sub-image found at coordinates: (" + subImageX + ", " + subImageY + ")");
			} else {
				System.out.println("Sub-image not found in the main image.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Close the WebDriver
		driver.quit();
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
		int subWidth = subImage.getWidth();
		int subHeight = subImage.getHeight();

		if (x + subWidth > mainImage.getWidth() || y + subHeight > mainImage.getHeight()) {
			return false; // Check if sub-image exceeds the bounds of the main image
		}

		for (int j = 0; j < subHeight; j++) {
			for (int i = 0; i < subWidth; i++) {
				if (mainImage.getRGB(x + i, y + j) != subImage.getRGB(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
