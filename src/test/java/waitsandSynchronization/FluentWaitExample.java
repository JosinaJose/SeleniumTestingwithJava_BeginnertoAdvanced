package waitsandSynchronization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait; // Import Selenium's FluentWait
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample { // Renamed class
    public static WebDriver driver;
    
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
    
    @Test
    public void testFluentWait() {
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

        WebElement element = fluentWait.until(driver -> {
            return driver.findElement(By.cssSelector("//select[@id='fruit-selects']"));
        });
        
        // Do something with the element
        System.out.println("Element found: " + element.getText());
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}