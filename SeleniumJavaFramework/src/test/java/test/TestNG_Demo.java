package test;

import org.testng.annotations.Test;

import config.PropertiesFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.Log4jDemo;

public class TestNG_Demo {
	
	WebDriver driver = null;
	public static String browserName = null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		}
		
	}

	@Test
	public void googleSearch() {	
		//go to google.com
		driver.get("https://google.com");
		
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");				
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		driver.findElement(By.name("btnK")).click();
		System.out.println("clicking is successful");
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
	driver.close();
	// driver.quit();
		
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}
}
