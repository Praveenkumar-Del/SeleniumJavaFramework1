package PriorityDemo;

import java.net.MalformedURLException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {
	
	public static final String UserName = System.getenv("Praveenkumar-del");
    public static final String AccessKey = System.getenv("076fe781-94f8-4993-aa55-e2c391176051");
    public static final String URL = "https://" +UserName+ ":" +AccessKey+ "@ondemand.saucelabs.com/wd/hub";
    
    public static void main(String[] args) throws MalformedURLException {
		
    	DesiredCapabilities caps= DesiredCapabilities.chrome();
    	caps.setCapability("platform", "windows 10");
    	caps.setCapability("version", "latest");
    	caps.setCapability("name", "google setup");
    	
    	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
    	
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "E:\\JavaSelenium\\SeleniumJavaFramework\\Drivers\\ChromeDriver\\chromedriver1.exe"
		 * ); WebDriver driver= new ChromeDriver();
		 */
		 
		
		driver.get("https://google.com/");
    	System.out.println(driver.getTitle());
		/*
		 * driver.findElement(By.name("q")).sendKeys("Automation Step by step"); Actions
		 * action = new Actions(driver); WebElement btn =
		 * driver.findElement(By.id("lga")); action.moveToElement(btn).perform();
		 */
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
    	
		driver.quit();
		System.out.println("Test completed");
    	
    	
  
}

}
