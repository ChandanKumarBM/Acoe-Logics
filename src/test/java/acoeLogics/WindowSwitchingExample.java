package acoeLogics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSwitchingExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.d1pzapv0x5iir7.amplifyapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("8044059883");
		driver.findElement(By.xpath("//span[text()='Continue to OTP']")).click();
		List<WebElement> Otps=driver.findElements(By.xpath("//input[@inputmode='decimal']"));
		for (WebElement otp : Otps) {
			otp.sendKeys("1");
		}
		driver.findElement(By.xpath("//span[text()='Verify OTP']")).click();
		driver.navigate().to("https://uat.d1pzapv0x5iir7.amplifyapp.com/dashboard");
		String parentWindow=driver.getWindowHandle();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Pay')]"))));
		driver.findElement(By.xpath("//span[contains(text(),'Pay')]")).click();
		WebElement frame=driver.findElement(By.xpath("//iframe[@allow='otp-credentials']"));
		driver.switchTo().frame(frame);
		WebElement bankTransfer=driver.findElement(By.xpath("//div[text()='Bank Transfer']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bankTransfer);
		Thread.sleep(8000);
		System.out.println("8000");
//		driver.findElement(By.xpath("//div[text()='Netbanking']")).click();
//		driver.findElement(By.xpath("//div[text()='Yes Bank']")).click();
		driver.findElement(By.xpath("//button[text()='Pay Now']")).click();
		driver.switchTo().parentFrame();
		Set<String> windowHandles=driver.getWindowHandles();

		String childWindowHandle = null;
		for (String handle : windowHandles) {
			if (!handle.equals(parentWindow)) {
				childWindowHandle = handle;
				driver.switchTo().window(childWindowHandle);
				break;
			}
		}

		if (childWindowHandle != null) {
			try {
				WebElement elementInChildWindow = driver.findElement(By.xpath("//button[text()='Success']"));
				elementInChildWindow.click();
			} catch (org.openqa.selenium.NoSuchWindowException e) {
				System.out.println("Child window has been closed.");
			} finally {
				// Switch back to the parent window (regardless of the exception)
				driver.switchTo().window(parentWindow);
				driver.switchTo().frame(frame);
				Thread.sleep(1000);
				//System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Payment successful')]")).isDisplayed());
				 System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Payment successful')]/../..//div[contains(@class,'amount')]")).getText());
				 driver.switchTo().parentFrame();
				Thread.sleep(20000);
				driver.findElement(By.xpath("//button[@class=\"Header_profileBtn__lfl0O Header_primary__JUuVf\"]")).click();
				
				
			}
		}
	}
}