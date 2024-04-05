package acoeLogics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			driver.get("https://www.mappls.com/");;
			Thread.sleep(5000);
			// Capture screenshot of the element
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String mainImagePath = "C:\\Users\\Chandan\\Downloads\\sikuli\\screenshot.png";
			FileUtils.copyFile(screenshotFile, new File(mainImagePath));
			System.out.println("Main screenshot captured and saved.");

			String subImagePath = "C:\\Users\\Chandan\\Pictures\\Screenshots\\shopperStackResolution.png";

			// Load images using ImageIO
			BufferedImage mainImage = ImageIO.read(new File(mainImagePath));
			BufferedImage subImage = ImageIO.read(new File(subImagePath));

			// Check if the subImage is present within the mainImage
			WebElement subImageElement = findSubImageElement(driver, mainImage, subImage);
			if (subImageElement != null) {
				// Click on the sub-image element
				subImageElement.click();
				System.out.println("Clicked on the sub-image element.");
			} else {
				System.out.println("Sub-image is not found in the main image.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}

	private static WebElement findSubImageElement(WebDriver driver, BufferedImage mainImage, BufferedImage subImage) {
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
					// Assuming the sub-image is part of an <img> tag, you may need to modify this selector
					String xpath = String.format("//img[@src='%s']", driver.getCurrentUrl());
					return driver.findElement(By.xpath(xpath));
				}
			}
		}
		return null;
	}
}

