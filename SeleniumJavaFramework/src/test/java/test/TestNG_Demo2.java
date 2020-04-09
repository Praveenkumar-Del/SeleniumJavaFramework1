package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearch() {	
		//go to google.com
		driver.get("https://google.com");
		
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");		
		//driver.findElement(By.name("btnK")).click();
		//to enter by passing they keywords
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		driver.findElement(By.name("btnK")).click();
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
	driver.close();
	driver.quit();
		
		System.out.println("Test Completed Successfully");
	}
}
