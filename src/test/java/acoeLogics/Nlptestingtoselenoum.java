package acoeLogics;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;

public class Nlptestingtoselenoum {
	public static void ANIO_PressEnterKey(AppiumDriver driver) {
		Actions act =new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
}