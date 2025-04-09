package handlingDiffrentWebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownMenu {
	public static WebDriver driver;
	@BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
	
	/*-----------------Drop down menu-----------------------------------------*/
	@Test
	public static void dropdown() {
	    // Find dropdown element
	    WebElement dropdownElement = driver.findElement(By.id("dropdowm-menu-1"));
	    
	    // Create Select object
	    Select dropdown = new Select(dropdownElement);

	    // Select by visible text
	  //  dropdown.selectByVisibleText("C#");
	    
	   
	    // Select by value
	  //  dropdown.selectByValue("c#");
	/*    
	    // Select by index
	    dropdown.selectByIndex(2);
	   
	    // Get selected option
	    WebElement selectedOption = dropdown.getFirstSelectedOption();
	    String selectedText = selectedOption.getText();
	    System.out.println("Selected option: " + selectedText);
	*/  
	    
	    // Get all options
	    List<WebElement> options = dropdown.getOptions();
	    System.out.println("All available options:");
	    for (WebElement option : options) {
	        System.out.println(option.getText());
	    }
  /*
	      // Multi-select dropdown (only if the dropdown supports multiple selections)
	    if (dropdown.isMultiple()) {
	        dropdown.selectByValue("US");
	        dropdown.selectByValue("CA");
	        
	        // Deselect specific option
	        dropdown.deselectByValue("CA");
	        
	        // Deselect all options
	        dropdown.deselectAll();
	    }*/
	
	}
	@AfterClass
    public static void tearDown() {
        
            driver.quit();
 }   


}
