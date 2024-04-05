package acoeLogics;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;
import org.openqa.selenium.devtools.v85.performance.model.Metrics;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCPAndLCPExample {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize Chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", false);

        // Initialize the WebDriver with Chrome DevTools Protocol
        WebDriver driver = new ChromeDriver(chromeOptions);
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network and performance domains
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Performance.enable(java.util.Optional.empty()));

        // Navigate to the web page
        driver.get("https://example.com");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("example.com"));

        // Capture performance metrics
        Metrics metrics = (Metrics) devTools.send(Performance.getMetrics());
        Metric fcpMetric = metrics.getMetrics().stream()
                .filter(metric -> metric.getName().equals("FirstContentfulPaint"))
                .findFirst()
                .orElse(null);
        Metric lcpMetric = metrics.getMetrics().stream()
                .filter(metric -> metric.getName().equals("LargestContentfulPaint"))
                .findFirst()
                .orElse(null);

        System.out.println("FCP (First Contentful Paint): " + fcpMetric.getValue());
        System.out.println("LCP (Largest Contentful Paint): " + lcpMetric.getValue());

        // Close the WebDriver and DevTools
        driver.quit();
    }
}
