package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		//Start Report
		htmlReporter = new ExtentHtmlReporter("extent.html");

		//create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\ChromeDriver\\chromedriver1.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws Exception {
		
		
		ExtentTest test = extent.createTest("My FirstTest", "Sample description");
		driver.get("https://google.com");
		test.pass("It is navigated to Google");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		//test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}
		@Test
		public void test2() throws Exception {
			ExtentTest test = extent.createTest("My FirstTest", "Sample description");
			test.log(Status.INFO, "This step shows usage of log(status, details)");
			test.info("This step shows usage of info(details)");
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			
			//test with snapshot
			test.addScreenCaptureFromPath("screenshot.png");

	}
		@AfterTest
		public void tearDownTest() {
			driver.close();
			driver.quit();
			System.out.println("Test Completed Successfully");
		}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
