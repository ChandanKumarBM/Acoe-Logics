package acoeLogics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProxyExample {

	public static void main(String[] args) {
		String proxy = "11.456.448.110:8080";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--proxy-server=" + proxy);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com");
		driver.quit();
	}
}
