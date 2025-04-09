package handlingDiffrentWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {
	public static WebDriver driver;
	@BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
	 /*-----------------RadioButtons-----------------------------------------*/
	@Test
	public static void radioButton() {
    	 WebElement radioButton = driver.findElement(By.xpath("//input[@value='green']"));
    	 radioButton.click();
     }
	
	 @AfterClass
	    public static void tearDown() {
	        
	            driver.quit();
	 }   

}
