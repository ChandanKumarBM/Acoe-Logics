package AndroidLogics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class test {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("appPackage", "com.example.mybank");
		capabilities.setCapability("appActivity", "com.example.mybank.SplashScreenLayout");
		AndroidDriver driver=new AndroidDriver(new URL("http://localhost:4725/wd/hub"),capabilities);





	}
}
