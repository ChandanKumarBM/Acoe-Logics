package acoeLogics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.selenium.Eyes;

public class AppliTools {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			Eyes eyes = new Eyes();
			eyes.setApiKey("5hjtBrOijEVnmME97oKhGkFT9NPuwaNrZWYuJL3sFJnQ110");
			eyes.open(driver, "Appli", "Baseline");
			driver.get("https://www.applitools.com/helloworld?diff2");	
			Thread.sleep(3000);
			eyes.checkWindow("Home Page");
			eyes.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}

	}

}
