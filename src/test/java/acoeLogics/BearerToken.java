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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class BearerToken {

	public static void main(String[] args) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
		options.setCapability( "goog:loggingPrefs", logPrefs );
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\.cache\\selenium\\chromedriver\\win64\\118.0.5993.70\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://digitalauthdev.olamnet.com/auth/realms/NCP_UAT/protocol/openid-connect/auth?client_id=ncpuat&redirect_uri=https%3A%2F%2Fncpuat.olamagri.com%2F%23%2Fpages&state=da91a558-c0c6-4f8d-8afc-1bb2ca900b5e&response_mode=fragment&response_type=code&scope=openid&nonce=a151cbdb-ca84-4c98-8ee0-84bda7f99dbd");
		driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("sanjeevkumar.c@mindsprint.org");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");    		
		driver.findElement(By.xpath("//div[@class=\"form-group toujourguest-submit\"]")).click();    
			Thread.sleep(10000);

	String token = getBearerToken(driver, "https://ncpuat.olamagri.com/");
	System.out.println(token);
		
	}
	private static String getBearerToken(WebDriver driver, String reqUrl) throws Exception
    {
        List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
        String message="";
        for (LogEntry entry : entries) {
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode jsonSessionPayload = objectMapper.readTree(entry.getMessage());
            String requestURL = jsonSessionPayload.path("message").path("params").path("request").path("url").asText();
            if(requestURL.contains(reqUrl)) {
                String authHeader = jsonSessionPayload.path("message").path("params").path("request").path("headers").path("Authorization").asText();
                if(authHeader.startsWith("Bearer")) {
                    message=authHeader;
                }
            }
        }
        return message;
    }	
}

