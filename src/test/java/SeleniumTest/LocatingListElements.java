package SeleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatingListElements {
	@Test()
	public static void webListelements() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
/*----------------------Display List of Web Elements------------------------*/		
		
		List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='leftmenu']"));
		for(WebElement element: elements) {
			System.out.println(element.getText());
		}
		driver.quit();
	}

}
