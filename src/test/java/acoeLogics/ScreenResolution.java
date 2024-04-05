package acoeLogics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenResolution {
	public static void main(String[] args) throws InterruptedException {


		// Initialize ChromeDriver and open the browser
		WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
		// Navigate to a web page (for example, Google)
		driver.get("https://fireflink.automated1.synergiq.net");
		Thread.sleep(5000);

		// Get the window width and height using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long width = (long) js.executeScript("return window.innerWidth;");
		long height = (long) js.executeScript("return window.innerHeight;");

		// Print the width and height of the browser window
		System.out.println("Browser width: " + width + ", height: " + height);

		// Close the browser
		driver.quit();
	}
}
