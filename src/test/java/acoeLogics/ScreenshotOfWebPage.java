package acoeLogics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenshotOfWebPage {
	    public static void main(String[] args) {
	   WebDriver driver=new FirefoxDriver();
	   driver.get("https://www.google.com/maps");
	   File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String MainImage ="C:\\Users\\Chandan\\Downloads\\opencv\\mainimage.png";

       // Move the screenshot file to the specified destination
       try {
           FileUtils.moveFile(ts, new File(MainImage));
           System.out.println("Screenshot saved to: " + MainImage);
       } catch (IOException e) {
           e.printStackTrace();
       }
	    
	}


}







