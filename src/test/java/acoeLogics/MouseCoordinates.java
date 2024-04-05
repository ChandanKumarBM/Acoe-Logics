package acoeLogics;
import java.time.Duration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseCoordinates extends JFrame {

	public MouseCoordinates() {
		setTitle("Mouse Coordinates Tracker");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				showMouseCoordinates(e.getX(), e.getY());
			}
		});
	}

	private void showMouseCoordinates(int x, int y) {
		System.out.println("Mouse Coordinates - X: " + x + ", Y: " + y);
	}

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://app.fireflink.com");
		SwingUtilities.invokeLater(() -> {
			MouseCoordinates mouseCoordinatesTracker = new MouseCoordinates();
			mouseCoordinatesTracker.setVisible(true);
		});
	}
}



