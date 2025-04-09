package waitsandSynchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	public static WebDriver driver;
	@BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
	@Test
	public static void  explicitWait() {
		// Create a wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for an element to be clickable
	//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));

		// Wait for an element to be visible
	//	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loader")));

		// Wait for an element to disappear
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));

		// Wait for title
	//	wait.until(ExpectedConditions.titleContains("Home Page"));

		// Wait for URL
	//	wait.until(ExpectedConditions.urlContains("dashboard"));

		// Wait for alert
	//	wait.until(ExpectedConditions.alertIsPresent());
	}
	@AfterClass
    public static void tearDown() {
        
            driver.quit();
  } 

}
