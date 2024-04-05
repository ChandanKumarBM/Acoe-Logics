package acoeLogics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensionInChrome {
	public static void main(String[] args) throws InterruptedException {
		String extensionPath = "C:\\Users\\Chandan\\Downloads\\XY coordinate";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=" + extensionPath);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		//driver.findElement(By.xpath("//*[@id='devMode']"));
		Thread.sleep(15000);
		driver.quit();
	}
}



