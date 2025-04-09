package SeleniumTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowManagement {
	
	@Test
	public static void browserWindowManagement() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		// Maximize window
		driver.manage().window().maximize();

		// Set size
		driver.manage().window().setSize(new Dimension(1366, 768));

		// Set position
		driver.manage().window().setPosition(new Point(0, 0));

		// Fullscreen
		driver.manage().window().fullscreen();

		// Get window info
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		driver.quit();
	}

}
