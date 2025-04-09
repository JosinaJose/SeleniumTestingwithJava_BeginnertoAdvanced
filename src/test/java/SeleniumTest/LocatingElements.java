package SeleniumTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatingElements {
	
	@Test
	public static void webelements() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	/*	
	 * // ---------------------Locator Strategies -------------------------------------------//
		// By ID
		WebElement element = driver.findElement(By.id("username"));

		// By Name
		WebElement element = driver.findElement(By.name("password"));

		// By Class Name
		WebElement element = driver.findElement(By.className("login-button"));

		// By Tag Name
		WebElement element = driver.findElement(By.tagName("button"));

		// By Link Text
		WebElement element = driver.findElement(By.linkText("Forgot Password?"));

		// By Partial Link Text
		WebElement element = driver.findElement(By.partialLinkText("Forgot"));

		// By CSS Selector
		WebElement element = driver.findElement(By.cssSelector("input[name='username']"));
		WebElement element = driver.findElement(By.cssSelector(".login-form #username"));

		// By XPath
		WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
	*/
		
		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		register.click();
		
		WebElement firstName = driver.findElement(By.id("customer.firstName"));
		firstName.sendKeys("David");
		
		WebElement lastName = driver.findElement(By.name("customer.lastName"));
	    lastName.sendKeys("McDonald");
		
	    WebElement address = driver.findElement(By.cssSelector("input[id='customer.address.street']"));
	    address.sendKeys("Ruth Avenu");
	    
	    WebElement city = driver.findElement(By.id("customer.address.city"));
	    city.sendKeys("Toranto");
	    
	    WebElement state = driver.findElement(By.id("customer.address.state"));
	    state.sendKeys("Onatio");
	    
	    WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
	    zipCode.sendKeys("LSD145");
	    
	    WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
	    phone.sendKeys("789456123");
	    
	    WebElement ssn = driver.findElement(By.id("customer.ssn"));
	    state.sendKeys("789456123");
	    
	    WebElement username = driver.findElement(By.id("customer.username"));
	    username.sendKeys("davidmc");
	    
	    WebElement password = driver.findElement(By.id("customer.password"));
	    password.sendKeys("davidmc");
	    
	    WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
	    confirmPassword.sendKeys("davidmc");
	    
	    WebElement submit = driver.findElement(By.xpath("//input[@value='Register']"));
	    submit.sendKeys("davidmc");
	    
		
		driver.quit();

	}

}
