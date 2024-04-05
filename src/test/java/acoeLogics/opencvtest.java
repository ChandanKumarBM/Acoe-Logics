package acoeLogics;
import org.opencv.core.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class opencvtest {
	public static void main(String[] args) throws InterruptedException {
//		// Set the library path
//		System.setProperty("java.library.path", "C:\\Users\\Chandan\\Downloads\\OpenCv_exe\\opencv\\build\\java\\x64");
//
//		// Load the OpenCV library
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		System.out.println(Core.NATIVE_LIBRARY_NAME+""+Core.VERSION);
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(5000);
	driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
}


