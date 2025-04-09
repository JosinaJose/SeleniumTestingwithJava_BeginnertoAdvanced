package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		
		//Browser Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start maximized");
		//options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
	    
		WebDriver driver = new ChromeDriver();  // Initialize Chrome Driver
		//WebDriver driver = new FirefoxDriver(); //Initialize Firefox driver
		//WebDriver driver = new EdgeDriver(); //Initialize Edge driver
		driver.manage().window().maximize();    //Maximize browser window
		driver.get("https://parabank.parasoft.com/parabank/index.htm"); //Navigate to website
		System.out.println("Title: "+ driver.getTitle());
		
		



		
		driver.quit(); // close browser
		
		

	}

}
