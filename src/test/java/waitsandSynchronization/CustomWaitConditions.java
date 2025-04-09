package waitsandSynchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaitConditions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    // Define the custom wait condition
    public static ExpectedCondition<Boolean> pageLoadComplete = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
        }
    };
    
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait
        
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        
        
        
    }
    
    @Test
    public void testAfterPageLoad() {
        
        System.out.println("Page title after load: " + driver.getTitle());
        
       
        wait.until(pageLoadComplete);
    }
    
   
    @Test
    public void testWithJQueryWait() {
        
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long)((JavascriptExecutor)driver)
                        .executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true; 
            }
        };
        
        
        try {
            wait.until(jQueryLoad);
            System.out.println("jQuery loading complete");
        } catch (Exception e) {
            System.out.println("jQuery wait failed or not applicable");
        }
    }
    
    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}