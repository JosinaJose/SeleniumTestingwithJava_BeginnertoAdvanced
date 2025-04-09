package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RealativeLocator {
	@Test
	public static void webListelements() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
/*---------------------Using Relative path using tagName-----------------*/
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("davidmc");
		
		// Find element above another element
		WebElement element = driver.findElement(with(By.tagName("h2")).above(username));
        System.out.println(element.getText());
		
		driver.quit();
	}

}
