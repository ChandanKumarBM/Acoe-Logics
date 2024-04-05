package acoeLogics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DecimalFormat {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://app.fireflink.com");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000)); // 5 seconds timeout
		// wait.until(ExpectedConditions.attributeToBe(By.tagName("body"), "cursor", "pointer"));
		 WebElement element= driver.findElement(By.xpath("//a[@class='fontPoppinsMediumMd']"));
		 String value=element.getCssValue("cursor");
		 System.out.println("value "+value);

		 
	    }
	}

