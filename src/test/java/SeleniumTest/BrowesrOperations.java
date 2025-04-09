package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowesrOperations {
	
	@Test
	public static void browserOperations() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
/*-------------------------------Browser Operations-------------------*/
		
		// Navigate to a URL
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.navigate().to("https://www.parasoft.com/products/");

		// Navigate back
		driver.navigate().back();

		// Navigate forward
		driver.navigate().forward();

		// Refresh page
		driver.navigate().refresh();
	   driver.quit();
	}

}
