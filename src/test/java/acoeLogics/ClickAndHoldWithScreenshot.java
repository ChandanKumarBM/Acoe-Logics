package acoeLogics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ClickAndHoldWithScreenshot {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		// Navigate to a web page
		driver.get("https://www.fireflink.com");
		Thread.sleep(5000);
		// Find the element to click and hold
		WebElement elementToClickAndHold = driver.findElement(By.xpath("//a[text()='Start a Free Trial']"));

		// Create Actions instance
		Actions actions = new Actions(driver);

		// Click and hold the element
		actions.clickAndHold(elementToClickAndHold).perform();

		// Capture a screenshot
		captureScreenshot(driver);

		// Release the click after performing the desired actions
		actions.release().perform();

		// Close the browser
		driver.quit();
	}

	// Method to capture a screenshot
	private static void captureScreenshot(WebDriver driver) {
		try {
			// Convert the driver to TakesScreenshot
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Capture the screenshot as File
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Define the destination for the screenshot
			File destination = new File("C:\\Users\\Chandan\\Downloads\\sikuli\\screenshot.png");

			// Copy the screenshot to the destination
			FileUtils.copyFile(source, destination);

			System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

