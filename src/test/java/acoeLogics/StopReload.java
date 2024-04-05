package acoeLogics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StopReload{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		Thread.sleep(3000);
		((JavascriptExecutor)driver).executeScript("window.stop();");
		System.out.println("stop reload");
		
		
		
	}
}