package PriorityDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "E:\\JavaSelenium\\SeleniumJavaFramework\\Drivers\\ChromeDriver\\chromedriver1.exe");
		
		//Headless Chrome browser runs without showing any Browser and runs at the backend
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://www.google.com/");
		System.out.println("google page opened");
		driver.findElement(By.name("q")).sendKeys("Automation");
		/*
		 * Actions action = new Actions(driver); WebElement btn =
		 * driver.findElement(By.id("hplogo")); action.moveToElement(btn).perform();
		 * driver.findElement(By.name("btnK")).click();
		 */
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
		System.out.println("Completed");
		
		
	}

}
