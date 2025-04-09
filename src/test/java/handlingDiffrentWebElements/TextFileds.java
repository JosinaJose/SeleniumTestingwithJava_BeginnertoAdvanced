package handlingDiffrentWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextFileds {
	@Test
	public static void TextFilds() {
		
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	
	    WebElement username = driver.findElement(By.name("username"));
	    username.clear();
	    username.sendKeys("davidmc");
	    
	    String value = username.getAttribute("value");
	    
	    WebElement password = driver.findElement(By.name("password"));
	    password.sendKeys("davidmc");
	     
	    WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
	    login.click();
	    
	    WebElement openNewAccount = driver.findElement(By.linkText("Open New Account"));
	    openNewAccount.click();
	    
	    driver.quit();
	    
	    
	}

}


