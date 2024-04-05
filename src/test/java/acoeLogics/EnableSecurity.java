package acoeLogics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableSecurity {
public static void main(String[] args) {

     ChromeOptions options = new ChromeOptions();

     options.addArguments("--disable-extensions");

     options.addArguments("--site-per-process");

     options.addArguments("--disable-automatic-downloads");

     options.addArguments("--disable-save-password");

     WebDriver driver = new ChromeDriver(options);

     driver.quit();
}
}
