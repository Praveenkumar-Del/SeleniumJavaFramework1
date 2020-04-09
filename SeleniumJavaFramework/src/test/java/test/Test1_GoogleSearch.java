package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {
	
	public static void main(String[] args) {
		googleSearch();
	}

	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		//go to google.com
		driver.get("https://google.com");
		
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		
		//driver.findElement(By.name("btnK")).click();
		//to enter by passing they keywords
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}
}
