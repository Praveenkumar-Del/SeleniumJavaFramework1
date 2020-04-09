package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsbasicDemo {
	private static WebDriver driver = null;
	
	//Steps required to create and run Extent reports
	// 1. Add ExtentReports libraries in project
	// 2. Create references of ExtentReport functionality
	// 3. Use ExtentReport functionality (log, info, pass, fail etc)
	// 4. Run and Validate
	
	public static void main(String[] args) {
		
		// directory where output is to be printed
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		//create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google search Test one", "This is a test to validate google search functionality");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		test1.pass("Naviagated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		test1.pass("Entered text in Searchbox");
		
		Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.id("lga"));
        action.moveToElement(btn).perform();
		driver.findElement(By.name("btnK")).click();
		test1.pass("Pressed Google search Button");
		
		ExtentTest test2 = extent.createTest("Google search Test Two", "This is a test to validate google search functionality again");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		driver = new ChromeDriver();
		
		test2.log(Status.INFO, "Starting Test Case");
		
		driver.get("https://google.com");
		driver.manage().window().maximize();
		test2.pass("Naviagated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello Everyone");
		test2.pass("Entered text in Searchbox");
		
		Actions action1 = new Actions(driver);
        WebElement btn1 = driver.findElement(By.id("lga"));
        action1.moveToElement(btn1).perform();
		driver.findElement(By.name("btnK")).click();
		test2.fail("Pressed Google search Button");
		
		
		driver.close();
		
		driver.quit();
		test1.pass("Test completed Successfully");
		
		//calling flush writes everything to the log file
		extent.flush();
		
	}

}
