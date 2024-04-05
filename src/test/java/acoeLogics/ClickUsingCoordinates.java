package acoeLogics;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickUsingCoordinates {
    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new FirefoxDriver();
        // Navigate to the desired webpage
        driver.get("https://www.google.com/maps/@12.9292093,77.5716529,17z?entry=ttu");
        try {
            // Create an instance of Robot
        	Thread.sleep(10000);
            Robot robot = new Robot();
            // Move the mouse to the specified coordinates (132, 482)
            robot.mouseMove(1136, 459);
            // Simulate a left mouse button click
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }	
    }
}

