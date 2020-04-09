package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

	//Step 5. Create object for page class
	//Step 6. Refer action methods
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		searchPageObj.setTextInSearchBox("A B C D");
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		searchPageObj.clickSearchButton();
		driver.close();
		System.out.println("Test Executed Succesfully");
		
	}
}
