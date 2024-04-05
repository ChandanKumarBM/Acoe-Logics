package acoeLogics;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class mobileWeb{
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Galaxy A13");
			options.setChromedriverExecutable("C:\\Users\\Chandan\\AppData\\Roaming\\fire-flink-client\\localnode\\chromedriver.exe");
			options.setCapability("browserName","Chrome"); 
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.shoppersstack.com/");

			System.out.println("Successfully launched the Mobile view for TravelRepublic");
		} catch (Exception e) {
			
			System.out.println("Failed to launch the Mobile view for TravelRepublic"+ e);

		}
	}
}

