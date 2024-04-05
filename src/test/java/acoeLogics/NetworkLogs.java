package acoeLogics;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class NetworkLogs {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
		options.setCapability( "goog:loggingPrefs", logPrefs );
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\.cache\\selenium\\chromedriver\\win64\\118.0.5993.70\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://app.fireflink.com/");
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("mohankumar@fireflink.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Asdf@1234");    		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();    
		Thread.sleep(6000);
		driver.navigate().refresh();
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
		List<String> message=new ArrayList<>(); 
		for (LogEntry entry : entries) {
		   message.add(entry.getMessage());
		 }
		System.out.println(message);
		
		
	}
}


