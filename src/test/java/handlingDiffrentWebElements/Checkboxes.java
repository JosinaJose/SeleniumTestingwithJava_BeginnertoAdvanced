package handlingDiffrentWebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
    public static WebDriver driver;
    
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
    
    @Test
    public void testSpecificCheckbox() {
        /*------------------Check Specific Checkboxes by Values---------------------------------- */
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='option-1']"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox option-1 should be selected");
    }
    
    @Test
    public void testAllCheckboxes() {
        /*------------------ Find and Check All Matching Checkboxes---------------------------------- */
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    Assert.assertTrue(checkbox.isSelected(), "Checkbox wasn't selected after clicking");
                }
        }
        
    }

    @Test
    public void testCheckboxByIndex() {
        // Get all checkboxes
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Define which indices to select
        int[] indexesToSelect = {0, 2, 4};
        
        // Loop through indices
        for (int index : indexesToSelect) {
            if (index < allCheckboxes.size()) {
                WebElement checkbox = allCheckboxes.get(index);
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                Assert.assertTrue(checkbox.isSelected(), "Checkbox at index " + index + " should be selected");
            }
        }
    }
    
    @AfterClass
    public static void tearDown() {
       
            driver.quit();
        
    }
}