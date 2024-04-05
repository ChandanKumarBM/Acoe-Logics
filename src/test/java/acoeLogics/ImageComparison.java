package acoeLogics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageComparison {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://fireflink.automated1.synergiq.net");
		Thread.sleep(10000);
		//WebElement element = driver.findElement(By.xpath("//form[contains(@class,'usersignin')]"));
		//WebElement element=driver.findElement(By.xpath("//div[@class='header']"));
		try {

			String mainImagePath = "C:\\Users\\Chandan\\Downloads\\sikuli\\screenshot.png";
			String subImagePath = "C:\\Users\\Chandan\\Pictures\\Screenshots\\shopperStackResolution.png";

			// Capture screenshot of the element
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(mainImagePath));
			//File elementScreenshot = element.getScreenshotAs(OutputType.FILE);

			// Save the element screenshot as a file
			//FileUtils.copyFile(elementScreenshot, new File(mainImagePath));
            System.out.println("Element screenshot captured and saved.");
			WebElement men=driver.findElement(By.xpath("//form[@name='loginbox']"));
			 int imageWidth = men.getSize().getWidth();
		     int imageHeight = men.getSize().getHeight();
		     System.out.println("Browser width: " + imageWidth + ", height: " + imageHeight);
//			File menScreenshot = men.getScreenshotAs(OutputType.FILE);

			// Save the element screenshot as a file
			//FileUtils.copyFile(menScreenshot, new File(subImagePath));
		
			
			try {
				// Load images using ImageIO
				BufferedImage mainImage = ImageIO.read(new File(mainImagePath));
				BufferedImage subImage = ImageIO.read(new File(subImagePath));
				

				// Check if the subImage is present within the mainImage
				boolean isSubImagePresent = isSubImageInImage(mainImage, subImage);
				if (isSubImagePresent) {
					System.out.println("Sub-image is present within the main image.");
				} else {
					System.out.println("Sub-image is not found in the main image.");
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static boolean isSubImageInImage(BufferedImage mainImage, BufferedImage subImage) {
		int width = mainImage.getWidth() - subImage.getWidth() + 1;
		int height = mainImage.getHeight() - subImage.getHeight() + 1;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				boolean isMatch = true;
				for (int j = 0; j < subImage.getHeight(); j++) {
					for (int i = 0; i < subImage.getWidth(); i++) {
						if (mainImage.getRGB(x + i, y + j) != subImage.getRGB(i, j)) {
							isMatch = false;
							break;
						}
					}
					if (!isMatch) {
						break;
					}
				}
				if (isMatch) {
					return true;
				}
			}
		}
		return false;
	}
}


