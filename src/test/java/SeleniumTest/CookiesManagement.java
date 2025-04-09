package SeleniumTest;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesManagement {
	
	@Test
	public static void cookiesManagement() {
		WebDriverManager.chromedriver().setup();// Setup Chrome Driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		/*----------------------------Cookies Management-----------------------*/
	/*	
		Set<Cookie> cookies = driver.manage().getCookies();

		// Add cookie
		Cookie cookie = new Cookie("name", "value");
		driver.manage().addCookie(cookie);

		// Delete specific cookie
		driver.manage().deleteCookie(cookie);
		driver.manage().deleteCookieNamed("name");

		// Delete all cookies
		driver.manage().deleteAllCookies();*/
		
		 // Get initial cookies and verify site has cookies
        Set<Cookie> initialCookies = driver.manage().getCookies();
        System.out.println("Initial cookies count: " + initialCookies.size());
        // Some sites may not have initial cookies, so this assertion might need adjustment
        // Assert.assertFalse(initialCookies.isEmpty(), "Initial cookies should exist");
        
        // Add cookie and verify it was added
        Cookie testCookie = new Cookie("testName", "testValue");
        driver.manage().addCookie(testCookie);
        Cookie retrievedCookie = driver.manage().getCookieNamed("testName");
        Assert.assertNotNull(retrievedCookie, "Cookie should be added successfully");
        Assert.assertEquals(retrievedCookie.getValue(), "testValue", "Cookie value should match");
        
        // Delete specific cookie and verify deletion
        driver.manage().deleteCookie(testCookie);
        Assert.assertNull(driver.manage().getCookieNamed("testName"), 
                "Cookie should be deleted after deleteCookie()");
        
        // Add another cookie to test deletion by name
        driver.manage().addCookie(new Cookie("secondTest", "secondValue"));
        driver.manage().deleteCookieNamed("secondTest");
        Assert.assertNull(driver.manage().getCookieNamed("secondTest"), 
                "Cookie should be deleted after deleteCookieNamed()");
        
        // Delete all cookies and verify
        driver.manage().deleteAllCookies();
        Assert.assertTrue(driver.manage().getCookies().isEmpty(), 
                "All cookies should be deleted after deleteAllCookies()");
		
		driver.quit();
	}
		
		

}
